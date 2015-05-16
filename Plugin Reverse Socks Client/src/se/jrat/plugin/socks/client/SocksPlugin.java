package se.jrat.plugin.socks.client;

import iconlib.IconUtils;
import jrat.api.Plugin;
import jrat.api.ui.RATMenuItem;

public class SocksPlugin extends Plugin {
	
	public SocksPlugin() {
		super("Reverse SOCKS", "1.0", "Connect to internet through remote machine", "jRAT", IconUtils.getIcon("icon", SocksPlugin.class));
	
		RATMenuItem entry = new RATMenuItem(new MenuListener(), "Reverse SOCKS", IconUtils.getIcon("icon", SocksPlugin.class));
		RATMenuItem.addItem(entry);
	}

}

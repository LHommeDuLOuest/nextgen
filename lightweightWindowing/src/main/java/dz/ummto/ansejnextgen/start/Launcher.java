/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.start;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.template.Renderer;

/**
 * The <code>Launcher</code> class represents the entry of lightweight client.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class Launcher {

	private static final Log loggerrr = LogFactory.getLog(Launcher.class);

	public static void main(String[] args) {
		Runnable code = new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						loggerrr.info("--- Installed Look&Feel:-> "+info.getName());
						/* -- Nimbus&Metal -- */
						if ("Metal".equals(info.getName())) {
							loggerrr.info("--- Metal founded");
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (Exception e) {
					loggerrr.info(e.getMessage());
				}
				Renderer.render("login").setVisible(true);
			}
		};
		if (SwingUtilities.isEventDispatchThread()) {
			loggerrr.info("--- main: In the EDT");
			code.run();
		} else {
			loggerrr.info("--- main:Out of EDT");
			SwingUtilities.invokeLater(code);
		}
	}
}

package code13;

import javax.swing.JApplet;

import code.author.WindowUtilities;

public class PluginApplet extends JApplet {
	@Override
	public void init() {
		WindowUtilities.setNativeLookAndFeel();
		setContentPane(new TextPanel());
	}
}

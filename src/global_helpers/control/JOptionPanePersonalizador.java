package global_helpers.control;

import java.awt.Color;

import javax.swing.UIManager;

public class JOptionPanePersonalizador {
	public void Personalizar() {
		UIManager.put("OptionPane.background",new Color(0,0,0));
		UIManager.put("Panel.background", new Color(0,0,0));
		UIManager.put("OptionPane.messageForeground",new Color(250,250,250));
	}
}

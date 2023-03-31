package aplicaciones.tasaCambio.helpers.ventena.helpers;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class TCValidacionTxt {
	
	public void validarTecla(KeyEvent e,JTextField txtField) {
		String txt=txtField.getText().toString();
		if(e.getKeyChar()!='.' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(e.getKeyChar()=='.' && (txt.contains(".") || txt.equals(""))) e.consume();
		
		if(txt.toString().length()==15)e.consume();
		
		if(txtField.getSelectedText()!=null) {
			if(e.getKeyChar()=='.' && txtField.getSelectedText().toString().equals(txt)) e.consume();
		}
	}
}

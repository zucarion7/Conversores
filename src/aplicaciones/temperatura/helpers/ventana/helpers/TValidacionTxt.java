package aplicaciones.temperatura.helpers.ventana.helpers;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class TValidacionTxt {
	
	public void validarTecla(KeyEvent e,JTextField txtField) {
		String txt=txtField.getText().toString();
	
		if(e.getKeyChar()!='.' && e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(e.getKeyChar()=='.' && (txt.contains(".") || txt.equals(""))) e.consume();
		
		if(txt.contains("-") && txt.length()==16) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==15) {
			e.consume();
		}
		
		if(txtField.getSelectedText()!=null) {
			if(e.getKeyChar()=='.' && txtField.getSelectedText().toString().equals(txt)) e.consume();
			if(e.getKeyChar()=='-' && !txtField.getSelectedText().toString().equals(txt)) e.consume();
		}else {
			if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		}
	}
}
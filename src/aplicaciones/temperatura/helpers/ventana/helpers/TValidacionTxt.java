package aplicaciones.temperatura.helpers.ventana.helpers;

import java.awt.event.KeyEvent;

public class TValidacionTxt {
	
	public void validarTecla(KeyEvent e,String txt) {
	
		if(e.getKeyChar()!='.' && e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(e.getKeyChar()=='.' && (txt.contains(".") || txt.equals(""))) e.consume();
		
		if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		
		if(txt.contains("-") && txt.length()==16) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==15) {
			e.consume();
		};
	}
}
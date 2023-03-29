package aplicaciones.tasaCambio.helpers.ventena.helpers;

import java.awt.event.KeyEvent;

public class TCValidacionTxt {
	
	public void validarTecla(KeyEvent e,String txt) {
		if(e.getKeyChar()!='.' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(e.getKeyChar()=='.' && (txt.contains(".") || txt.equals(""))) e.consume();
		
		if(txt.length()==15)e.consume();
	}
}

package aplicaciones.sistemasNumericos.helpers.ventana.helpers;

import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class SNValidacionTxt {

	
	public void validarTecla(KeyEvent e,String txt,String sNumerico) {
		
		if(sNumerico.equals("Decimal")) {
			validacionDecimal(e,txt);
		}
		else if(sNumerico.equals("Binario")) {
			validacionBinario(e,txt);
		}
		else if(sNumerico.equals("Octal")) {
			validacionOctal(e,txt);
		}
		else if(sNumerico.equals("Hexadecimal")) {
			validacionHexadecimal(e,txt);
		}
		
	}

	private void validacionDecimal(KeyEvent e,String txt) {
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
	
		if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
	
		if(txt.contains("-") && txt.length()==19) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==18) {
			e.consume();
		};
	}
	
	private void validacionBinario(KeyEvent e,String txt) {
		
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(Character.isDigit(e.getKeyChar()) && e.getKeyChar()>='2') e.consume();
		
		if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		
		if(txt.contains("-") && txt.length()==20) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==19) {
			e.consume();
		};
	}
	
	private void validacionOctal(KeyEvent e,String txt) {
		
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(Character.isDigit(e.getKeyChar()) && e.getKeyChar()>='8') e.consume();
		
		if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		
		if(txt.contains("-") && txt.length()==20) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==19) {
			e.consume();
		};
	}
	
	private void validacionHexadecimal(KeyEvent e,String txt) {
		if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		
		if(!Character.isDigit(e.getKeyChar()) && !Pattern.matches("[A-F-]",Character.toString(e.getKeyChar()))) e.consume();
		
		if(txt.contains("-") && txt.length()==16) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==15) {
			e.consume();
		};
		
	}
}

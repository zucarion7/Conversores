package aplicaciones.sistemasNumericos.helpers.ventana.helpers;

import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class SNValidacionTxt {

	
	public void validarTecla(KeyEvent e,JTextField txtField,String sNumerico) {
		
		if(sNumerico.equals("Decimal")) {
			validacionDecimal(e,txtField);
		}
		else if(sNumerico.equals("Binario")) {
			validacionBinario(e,txtField);
		}
		else if(sNumerico.equals("Octal")) {
			validacionOctal(e,txtField);
		}
		else if(sNumerico.equals("Hexadecimal")) {
			validacionHexadecimal(e,txtField);
		}
	}

	private void validacionDecimal(KeyEvent e,JTextField txtField) {
		String txt=txtField.getText().toString();
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
	
		if(txt.contains("-") && txt.length()==19) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==18) {
			e.consume();
		};
		
		if(txtField.getSelectedText()!=null) {
			if(e.getKeyChar()=='-' && !txtField.getSelectedText().toString().equals(txt)) e.consume();
		}else {
			if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		}
	}
	
	private void validacionBinario(KeyEvent e,JTextField txtField) {
		String txt=txtField.getText().toString();
		
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(Character.isDigit(e.getKeyChar()) && e.getKeyChar()>='2') e.consume();
		
		if(txt.contains("-") && txt.length()==20) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==19) {
			e.consume();
		};
		
		if(txtField.getSelectedText()!=null) {
			if(e.getKeyChar()=='-' && !txtField.getSelectedText().toString().equals(txt)) e.consume();
		}else {
			if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		}
	}
	
	private void validacionOctal(KeyEvent e,JTextField txtField) {
		String txt=txtField.getText().toString();
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(Character.isDigit(e.getKeyChar()) && e.getKeyChar()>='8') e.consume();
		
		if(txt.contains("-") && txt.length()==20) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==19) {
			e.consume();
		};
		
		if(txtField.getSelectedText()!=null) {
			if(e.getKeyChar()=='-' && !txtField.getSelectedText().toString().equals(txt)) e.consume();
		}else {
			if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		}
	}
	
	private void validacionHexadecimal(KeyEvent e,JTextField txtField) {
		String txt=txtField.getText().toString();
		if(!Character.isDigit(e.getKeyChar()) && !Pattern.matches("[A-F-]",Character.toString(e.getKeyChar()))) e.consume();
		
		if(txt.contains("-") && txt.length()==16) {
			e.consume();
		}
		else if(!txt.contains("-") && txt.length()==15) {
			e.consume();
		};
		
		if(txtField.getSelectedText()!=null) {
			if(e.getKeyChar()=='-' && !txtField.getSelectedText().toString().equals(txt)) e.consume();
		}else {
			if(e.getKeyChar()=='-' && !txt.equals("")) e.consume();
		}
	}
}

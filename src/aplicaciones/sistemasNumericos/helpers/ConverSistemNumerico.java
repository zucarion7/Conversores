package aplicaciones.sistemasNumericos.helpers;

import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.Binario;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.Decimal;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.Hexadecimal;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.Octal;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.SistemaNumerico;

public class ConverSistemNumerico {
	private Decimal decimal;
	private Binario binario;
	private Octal octal;
	private Hexadecimal hexadecimal;
	public Decimal getDecimal() {
		return decimal;
	}
	public void setDecimal(SistemaNumerico sistemaNumerico) {
		this.decimal = (Decimal) sistemaNumerico;
	}
	public Binario getBinario() {
		return binario;
	}
	public void setBinario(SistemaNumerico sistemaNumerico) {
		this.binario = (Binario) sistemaNumerico;
	}
	public Octal getOctal() {
		return octal;
	}
	public void setOctal(SistemaNumerico sistemaNumerico) {
		this.octal = (Octal) sistemaNumerico;
	}
	public Hexadecimal getHexadecimal() {
		return hexadecimal;
	}
	public void setHexadecimal(SistemaNumerico sistemaNumerico) {
		this.hexadecimal = (Hexadecimal) sistemaNumerico;
	}
	
	public String realizarConversion(String snInicial, String snFinal) {
		String resultado="";
		if(snInicial.equals("Decimal")) {
			resultado=conversionDeDecimal(snFinal);
		}else if(snInicial.equals("Binario")) {
			resultado=conversionDeBinario(snFinal);
		}else if(snInicial.equals("Octal")) {
			resultado=conversionDeOctal(snFinal);
		}else if(snInicial.equals("Hexadecimal")) {
			resultado=conversionDeHexadecimal(snFinal);
		}
		return resultado;
	}
	
	private String conversionDeDecimal(String snFinal) {
		String resultado="";
		if(snFinal.equals("Decimal")) {
			resultado=this.decimal.getValue();
		}else if(snFinal.equals("Binario")) {
			resultado=decimal.convertir(binario.getBase());
		}else if(snFinal.equals("Octal")) {
			resultado=decimal.convertir(octal.getBase());
		}else if(snFinal.equals("Hexadecimal")) {
			resultado=decimal.AHexadecimal();
		}
		return resultado;
	}
	
	private String conversionDeBinario(String snFinal) {
		String resultado="";
		if(snFinal.equals("Decimal")) {
			resultado=binario.ADecimal();
		}else if(snFinal.equals("Binario")) {
			resultado=this.binario.getValue();
		}else if(snFinal.equals("Octal")) {
			resultado=binario.AOctal();
		}else if(snFinal.equals("Hexadecimal")) {
			resultado=binario.AHexadecimal();
		}
		return resultado;
	}
	
	private String conversionDeOctal(String snFinal) {
		String resultado="";
		if(snFinal.equals("Decimal")) {
			resultado=octal.ADecimal();
		}else if(snFinal.equals("Binario")) {
			resultado=octal.ABinario();
		}else if(snFinal.equals("Octal")) {
			resultado=this.octal.getValue();
		}else if(snFinal.equals("Hexadecimal")) {
			resultado=octal.AHexadecimal();
		}
		return resultado;
	}
	private String conversionDeHexadecimal(String snFinal) {
		String resultado="";
		if(snFinal.equals("Decimal")) {
			resultado=hexadecimal.ADecimal();
		}else if(snFinal.equals("Binario")) {
			resultado=hexadecimal.ABinario();
		}else if(snFinal.equals("Octal")) {
			resultado=hexadecimal.AOctal();
		}else if(snFinal.equals("Hexadecimal")) {
			resultado=this.hexadecimal.getValue();
		}
		return resultado;
	}
}

package aplicaciones.sistemasNumericos.helpers.ventana.helpers;

import java.util.ArrayList;

import aplicaciones.sistemasNumericos.helpers.conversion.ConverSistemNumerico;
import aplicaciones.sistemasNumericos.helpers.ventana.SNControlCombobox;
import aplicaciones.sistemasNumericos.helpers.ventana.SNControlTabla;

public class SNRecolectorResultados {
	
	private ConverSistemNumerico converSN;
	private SNControlCombobox controlCbx;
	private SNControlTabla controlTabla;
	
	public SNRecolectorResultados() {
		this.converSN=new ConverSistemNumerico();
	}
	
	public void setControlTabla(SNControlTabla controlTabla) {
		this.controlTabla=controlTabla;
	}
	
	public void setControlCbx(SNControlCombobox controlCbx) {
		this.controlCbx=controlCbx;
	}
	
	public ArrayList<String> recolectar() {
		ArrayList<String> resultados=new ArrayList<>();
		String resultado;
		for(int i=0;i<4;i++) {
			resultado=converSN.realizarConversion(controlCbx.getSelectedItemString(),controlTabla.getCeldaValue(i, 1));
			resultados.add(resultado);
		}
		return resultados;
	}
	
	public void setValueSN(String sistNumerico,String value) {
		if(sistNumerico.equals("Decimal")) {
			converSN.getDecimal().setValue(value);
		}
		else if(sistNumerico.equals("Binario")) {
			converSN.getBinario().setValue(value);
		}
		else if(sistNumerico.equals("Octal")) {
			converSN.getOctal().setValue(value);
		}
		else if(sistNumerico.equals("Hexadecimal")) {
			converSN.getHexadecimal().setValue(value);
		}
	}
}

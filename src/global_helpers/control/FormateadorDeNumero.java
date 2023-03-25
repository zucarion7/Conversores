package global_helpers.control;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FormateadorDeNumero {
	private DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	private DecimalFormat formateador;
	
	public FormateadorDeNumero() {
		simbolo.setDecimalSeparator('.');
	    simbolo.setGroupingSeparator(',');
	    formateador=new DecimalFormat("###,###.##",simbolo);
	}
	
	public String formatear(double number) {
		number=(double) Math.round(number*100)/100;
	    
		return formateador.format(number);
	}
}

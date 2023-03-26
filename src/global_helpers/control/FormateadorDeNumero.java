package global_helpers.control;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	
	public String formatear(String number) {
		BigDecimal formateado;
		formateado=new BigDecimal(number).multiply(new BigDecimal(100));
		formateado=formateado.divide(new BigDecimal(100),2,RoundingMode.HALF_UP);
		
		return formateador.format(formateado);
	}
}

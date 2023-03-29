package aplicaciones.temperatura.helpers.ventana.helpers;

import java.util.ArrayList;

import aplicaciones.temperatura.helpers.conversion.ConversorTemperatura;
import aplicaciones.temperatura.helpers.ventana.TControlCbx;
import aplicaciones.temperatura.helpers.ventana.TControlTabla;

public class TRecolectorResultados {

	private ConversorTemperatura converT;
	private TControlCbx controlCbx;
	private TControlTabla controlTabla;
	
	public TRecolectorResultados() {
		this.converT=new ConversorTemperatura();
	}
	
	public void setControlTabla(TControlTabla controlTabla) {
		this.controlTabla=controlTabla;
	}
	
	public void setControlCbx(TControlCbx controlCbx) {
		this.controlCbx=controlCbx;
	}
	
	public ArrayList<Double> recolectar() {
		ArrayList<Double> resultados=new ArrayList<>();
		double resultado;
		for(int i=0;i<3;i++) {
			resultado=converT.realizarConversion(controlCbx.getSelectedItemString(),controlTabla.getCeldaValue(i, 1));
			resultados.add(resultado);
		}
		return resultados;
	}
	
	public ArrayList<String> recolectarFormulas(){
		ArrayList<String> resultados=new ArrayList<>();
		String resultado;
		for(int i=0;i<3;i++) {
			resultado=converT.getFormula(controlCbx.getSelectedItemString(), controlTabla.getCeldaValue(i, 1));
			resultados.add(resultado);
		}
		return resultados;
	}
	
	public void setValueTemp(String escala, double value) {
		if(escala.equals("Celsius")) {
			converT.getCelsius().setValue(value);
		}
		else if(escala.equals("Fahrenheit")) {
			converT.getFahrenheit().setValue(value);
		}
		else if(escala.equals("Kelvin")) {
			converT.getKelvin().setValue(value);
		}
	}
}

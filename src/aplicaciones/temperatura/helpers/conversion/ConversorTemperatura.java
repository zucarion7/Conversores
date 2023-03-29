package aplicaciones.temperatura.helpers.conversion;

import aplicaciones.temperatura.helpers.escalas.Celsius;
import aplicaciones.temperatura.helpers.escalas.Fahrenheit;
import aplicaciones.temperatura.helpers.escalas.Kelvin;
import aplicaciones.temperatura.helpers.escalas.Temperatura;

public class ConversorTemperatura {
	private Celsius celsius;
	private Kelvin kelvin;
	private Fahrenheit fahrenheit;
	
	public ConversorTemperatura() {
		this.celsius=new Celsius();
		this.kelvin=new Kelvin();
		this.fahrenheit=new Fahrenheit();
	}
	
	//setters y getters
	public Celsius getCelsius() {
		return celsius;
	}

	public void setCelsius(Temperatura temperatura) {
		this.celsius = (Celsius) temperatura;
	}

	public Kelvin getKelvin() {
		return kelvin;
	}

	public void setKelvin(Temperatura temperatura) {
		this.kelvin = (Kelvin) temperatura;
	}

	public Fahrenheit getFahrenheit() {
		return fahrenheit;
	}

	public void setFahrenheit(Temperatura temperatura) {
		this.fahrenheit = (Fahrenheit) temperatura;
	}
	
	
	public double realizarConversion(String escalaInicial,String escalaFinal) {
		double resultado=0;
		if(escalaInicial.equals(escalaFinal)) {
			if(escalaInicial.equals(this.celsius.getNombre())){
				resultado=this.celsius.getValue();
			}
			else if(escalaInicial.equals(this.fahrenheit.getNombre())) {
				resultado=this.fahrenheit.getValue();
			}
			else if(escalaInicial.equals(this.kelvin.getNombre())) {
				resultado=this.kelvin.getValue();
			}
		}
		else if(escalaInicial.equals("Celsius") && escalaFinal.equals("Fahrenheit")) {
			resultado= this.celsius.getValue()*1.8+32; //"ºF=ºC*1.8+32"
		}
		else if(escalaInicial.equals("Celsius") && escalaFinal.equals("Kelvin")) {
			resultado= this.celsius.getValue()+273.15; //"K=ºC+273.15"
		}
		else if(escalaInicial.equals("Fahrenheit") && escalaFinal.equals("Celsius")) {
			resultado= (this.fahrenheit.getValue()-32)/1.8; //"ºC=(ºF-32)÷1.8"
		}
		else if(escalaInicial.equals("Fahrenheit") && escalaFinal.equals("Kelvin")) {
			resultado=(this.fahrenheit.getValue()-32)*(5.0/9.0)+273.15; //"K=(5/9)(ºF–32)+273.15"
		}
		else if(escalaInicial.equals("Kelvin") && escalaFinal.equals("Celsius")) {
			resultado= this.kelvin.getValue()-273.15; //"ºC=K–273.15"
		}
		else if(escalaInicial.equals("Kelvin") && escalaFinal.equals("Fahrenheit")) {
			resultado=(1.8)*(this.kelvin.getValue()-273.15)+32; //"ºF=(1.8)(K–273.15)+32"
		}
		return resultado;
	}
	
	//retorno de formula
	public String getFormula(String escalaInicial,String escalaFinal) {
		String formula="";
		if(escalaInicial.equals("Celsius") && escalaFinal.equals("Fahrenheit")) {
			formula="ºF=ºC*1.8+32";
		}
		else if(escalaInicial.equals("Celsius") && escalaFinal.equals("Kelvin")) {
			formula="K=ºC+273.15";
		}
		else if(escalaInicial.equals("Fahrenheit") && escalaFinal.equals("Celsius")) {
			formula="ºC=(ºF-32)÷1.8";
		}
		else if(escalaInicial.equals("Fahrenheit") && escalaFinal.equals("Kelvin")) {
			formula="K=(5/9)(ºF–32)+273.15";
		}
		else if(escalaInicial.equals("Kelvin") && escalaFinal.equals("Celsius")) {
			formula="ºC=K–273.15";
		}
		else if(escalaInicial.equals("Kelvin") && escalaFinal.equals("Fahrenheit")) {
			formula="ºF=(1.8)(K–273.15)+32";
		}
		return formula;
	}
	
}

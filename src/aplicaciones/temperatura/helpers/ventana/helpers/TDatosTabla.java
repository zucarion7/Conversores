package aplicaciones.temperatura.helpers.ventana.helpers;

import java.util.ArrayList;

import aplicaciones.temperatura.helpers.escalas.Celsius;
import aplicaciones.temperatura.helpers.escalas.Fahrenheit;
import aplicaciones.temperatura.helpers.escalas.Kelvin;
import aplicaciones.temperatura.helpers.escalas.Temperatura;

public class TDatosTabla {
	private String [] encabezado;
	private ArrayList<Integer> tamanoColumnas;
	private ArrayList<Temperatura> options=new ArrayList<>();
	private ArrayList<String> optionsString=new ArrayList<>();
	
	public TDatosTabla() {
		init();
	}
	private void setEncabezado() {
		encabezado[0]="#";
		encabezado[1]="Escala";
		encabezado[2]="Simbolo";
		encabezado[3]="Formula";
		encabezado[4]="Resultado";
	}

	public Object[] filasTabla() {
		return new Object[]{"","","","",""};
	}
	
	public String[] getEncabezado() {
		return encabezado;
	}
	
	public ArrayList<Integer> getTamanoColumnas(){
		return tamanoColumnas;
	}
	
	public void setTamanoEncabezado() {
		tamanoColumnas.add(30);
		tamanoColumnas.add(100);
		tamanoColumnas.add(70);
		tamanoColumnas.add(110);
		tamanoColumnas.add(110);
	}
	
	private void llenarOptions() {
		options.add(new Celsius());
		options.add(new Fahrenheit());
		options.add(new Kelvin());
		
		optionsString.add(options.get(0).getNombre());
		optionsString.add(options.get(1).getNombre());
		optionsString.add(options.get(2).getNombre());
	}
	
	public ArrayList<Temperatura> getOptions(){
		return this.options;
	}
	
	public ArrayList<String> getOptionsString(){
		return this.optionsString;
	}
	
	private void init(){
		encabezado=new String[5];
		setEncabezado();
		
		tamanoColumnas=new ArrayList<Integer>();
		setTamanoEncabezado();
		
		llenarOptions();
	}
}

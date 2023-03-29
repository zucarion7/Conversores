package aplicaciones.sistemasNumericos.helpers.ventana.helpers;

import java.util.ArrayList;

import aplicaciones.sistemasNumericos.helpers.conversion.ConverSistemNumerico;

public class SNDatosTabla {
	private String [] encabezado;
	private ArrayList<Integer> tamanoColumnas;
	private String [][] datos;
	private ArrayList<String> options=new ArrayList<>();
	
	public SNDatosTabla() {
		init();
	}
	
	private void initEncabezado() {
		encabezado[0]="#";
		encabezado[1]="Sistema numérico";
		encabezado[2]="Base";
		encabezado[3]="Resultado";
	}

	public Object[] filasTabla() {
		return new Object[]{"","","",""};
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
	}
	
	public void setDatos() {
		ConverSistemNumerico conversor=new ConverSistemNumerico();
		datos[0][0]=conversor.getDecimal().getNombre();
		datos[0][1]=Integer.toString(conversor.getDecimal().getBase());
		
		datos[1][0]=conversor.getBinario().getNombre();
		datos[1][1]=Integer.toString(conversor.getBinario().getBase());
		
		datos[2][0]=conversor.getOctal().getNombre();
		datos[2][1]=Integer.toString(conversor.getOctal().getBase());
		
		datos[3][0]=conversor.getHexadecimal().getNombre();
		datos[3][1]=Integer.toString(conversor.getHexadecimal().getBase());
	}
	
	public String[][] getDatos(){
		return this.datos;
	}
	
	private void llenarOptions() {
		options.add("Decimal");
		options.add("Binario");
		options.add("Octal");
		options.add("Hexadecimal");
	}
	
	public ArrayList<String> getOptions(){
		return this.options;
	}
	
	private void init(){
		encabezado=new String[4];
		initEncabezado();
		
		tamanoColumnas=new ArrayList<Integer>();
		setTamanoEncabezado();
		
		llenarOptions();
		
		datos=new String[4][2];
		setDatos();
	}
	
}
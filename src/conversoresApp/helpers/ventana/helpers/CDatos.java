package conversoresApp.helpers.ventana.helpers;

import java.util.ArrayList;

public class CDatos {
	
	private ArrayList<String> options=new ArrayList<>();
	
	public CDatos() {
		 init();
	}
	
	public ArrayList<String> getOptions(){
		return this.options;
	}
	
	private void init() {
		llenarOptions();
	}

	private void llenarOptions() {
		options.add("Tasa de cambio de divisas");
		options.add("Conversor de temperatura");
		options.add("Conversor de sistemas numéricos");
	}
}

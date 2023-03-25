package aplicaciones.temperatura.helpers;

public class Fahrenheit extends Temperatura{
	public Fahrenheit() {
		init();
	}
	
	private void init() {
		setNombre("Fahrenheit");
		setSimbolo("°F");
	}
}

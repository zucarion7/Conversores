package aplicaciones.tasaCambio.helpers;

public class TasaCambio {
	private Moneda base;
	private Moneda divisa;
	private double baseUser;
	
	public TasaCambio() {
		this.base=new Moneda();
		this.divisa=new Moneda();
	}
	
	public void setBase(Moneda value) {
		this.base=value;
	}

	public Moneda getBase() {
		return this.base;
	}
	
	public void setDivisa(Moneda value) {
		this.divisa=value;
	}

	public Moneda getDivisa() {
		return this.divisa;
	}
	
	public void setBaseUser(double value) {
		this.baseUser=value;
	}

	public double getBaseUser() {
		return this.baseUser;
	}
	
	public double calcularDivisaResult() {
		return baseUser*this.divisa.getValor()/this.base.getValor();
	}
}

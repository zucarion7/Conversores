package aplicaciones.tasaCambio.helpers.conversion;

import java.math.BigDecimal;

import aplicaciones.tasaCambio.helpers.Moneda;

public class TasaCambio {
	private Moneda base;
	private Moneda divisa;
	private BigDecimal baseUser;
	
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
	
	public void setBaseUser(BigDecimal value) {
		this.baseUser=value;
	}

	public BigDecimal getBaseUser() {
		return this.baseUser;
	}
	
	public BigDecimal calcularDivisaResult() {
		double baseUsuario=baseUser.doubleValue();
		double divi=divisa.getValor().doubleValue();
		double bas=base.getValor().doubleValue();
		return new BigDecimal(Double.toString(baseUsuario*divi/bas));
	}
}

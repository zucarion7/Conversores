package aplicaciones.tasaCambio.helpers;

import java.math.BigDecimal;

public class Moneda implements Comparable<Moneda> {
	private String nombre;
	private String codigo;
	private BigDecimal valor;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return this.codigo;
	}
	@Override
	public int compareTo(Moneda m) {
		return codigo.compareTo(m.getCodigo());
	}
}

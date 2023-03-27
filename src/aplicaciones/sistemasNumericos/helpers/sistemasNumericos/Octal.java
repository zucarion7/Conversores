package aplicaciones.sistemasNumericos.helpers.sistemasNumericos;

import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.equivalencias.TablasDeConversion;

public class Octal extends SistemaNumerico{
	
	private TablasDeConversion converTabla;
	
	public Octal() {
		init();
	}

	private void init() {
		setNombre("Octal");
		setBase(8);
		converTabla=new TablasDeConversion();
	}
	
	public String ADecimal() {
		long resultado=0;
		long num=Long.parseLong(this.getValue());
		for(int i=0;i<this.getValue().length();i++) {
			resultado=(long) (num%10*Math.pow(this.getBase(), i)+resultado);
			num=num/10;
		}
		return Long.toString(resultado);
	}
	
	public String ABinario() {
		String resultado="";
		String auxiliar=this.getValue().contains("-")? this.getValue().substring(1,this.getValue().length()):this.getValue();
		while(auxiliar!=""){
			resultado=converTabla.tablaOctalABinario(auxiliar.substring(auxiliar.length()-1,auxiliar.length()))+resultado;
			auxiliar=auxiliar.substring(0,auxiliar.length()-1);
		}
		while(resultado.substring(0,1).equals("0")) {
			resultado=resultado.substring(1,resultado.length());
		}
		if(this.getValue().contains("-"))resultado="-"+resultado;
		return resultado;
	}
	
	public String AHexadecimal() {
		Binario Binario=new Binario();
		Binario.setValue(ABinario());
		return Binario.AHexadecimal();
	}
}

package aplicaciones.sistemasNumericos.helpers.sistemasNumericos;

import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.equivalencias.TablasDeConversion;

public class Hexadecimal extends SistemaNumerico {
	
	private TablasDeConversion converTabla;
	
	public Hexadecimal() {
		init();
	}

	private void init() {
		setNombre("Hexadecimal");
		setBase(16);
		converTabla=new TablasDeConversion();
	}
	
	public String ADecimal() {
		long resultado = 0;
		int auxiliar=0;
		int length=this.getValue().length();
		String num;
		if(this.getValue().contains("-")) {
			num=this.getValue().substring(1,this.getValue().length());
			length--;
		}else {
			num=this.getValue();
		}
		for(int i=0;i<length;i++) {
			if(num.substring(num.length()-1).equals("A")) {
				auxiliar=10;
			}
			else if(num.substring(num.length()-1).equals("B")) {
				auxiliar=11;
			}
			else if(num.substring(num.length()-1).equals("C")) {
				auxiliar=12;
			}
			else if(num.substring(num.length()-1).equals("D")) {
				auxiliar=13;
			}
			else if(num.substring(num.length()-1).equals("E")) {
				auxiliar=14;
			}
			else if(num.substring(num.length()-1).equals("F")) {
				auxiliar=15;
			}else {
				auxiliar=Integer.parseInt(num.substring(num.length()-1));
			}
			resultado=(long) (auxiliar*Math.pow(this.getBase(), i)+resultado);
			num=num.substring(0, num.length()-1);
		}
		if(this.getValue().contains("-")) resultado=resultado*(-1);
		return Long.toString(resultado);
	}
	
	public String ABinario() {
		String resultado="";
		String auxiliar=this.getValue().contains("-")? this.getValue().substring(1,this.getValue().length()):this.getValue();
		while(auxiliar!=""){
			resultado=converTabla.tablaABinario(auxiliar.substring(auxiliar.length()-1,auxiliar.length()))+resultado;
			auxiliar=auxiliar.substring(0,auxiliar.length()-1);
		}
		while(resultado.substring(0,1).equals("0")) {
			resultado=resultado.substring(1,resultado.length());
		}
		if(this.getValue().contains("-"))resultado="-"+resultado;
		return resultado;
	}
	
	public String AOctal() {
		Binario Binario=new Binario();
		Binario.setValue(ABinario());
		return Binario.AOctal();
	}
}

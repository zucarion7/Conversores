package aplicaciones.sistemasNumericos.helpers.sistemasNumericos;

import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.equivalencias.TablasDeConversion;

public class Binario extends SistemaNumerico {
	
	private TablasDeConversion converTabla;
	
	public Binario() {
		init();
	}

	private void init() {
		setNombre("Binario");
		setBase(2);
		converTabla=new TablasDeConversion();
	}
	
	public String ADecimal() {
		int resultado=0;
		int num=Integer.parseInt(this.getValue());
		for(int i=0;i<this.getValue().length();i++) {
			resultado=(int) (num%10*Math.pow(this.getBase(), i)+resultado);
			num=num/10;
		}
		return Integer.toString(resultado);
	}
	
	public String AOctal() {
		return octalOHexadecimal(3);
	}
	
	public String AHexadecimal() {
		return octalOHexadecimal(4);
	}
	
	public String octalOHexadecimal(int columns) {
		String resultado="";
		String auxiliar=this.getValue().contains("-")? this.getValue().substring(1,this.getValue().length()):this.getValue();
		while(auxiliar!=""){
			while(auxiliar.length()<columns) {
				auxiliar="0"+auxiliar;
			}
			if(columns==3) {
				resultado=converTabla.tablaBinarioAOctal(auxiliar.substring(auxiliar.length()-columns,auxiliar.length()))+resultado;
			}else if(columns==4) {
				resultado=converTabla.tablaBinarioAHexadecimal(auxiliar.substring(auxiliar.length()-columns,auxiliar.length()))+resultado;
			}
			auxiliar=auxiliar.substring(0,auxiliar.length()-columns);
		}
		if(this.getValue().contains("-"))resultado="-"+resultado;
		return resultado;
	}
}

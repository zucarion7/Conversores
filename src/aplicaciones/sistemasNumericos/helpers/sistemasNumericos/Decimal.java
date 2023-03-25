package aplicaciones.sistemasNumericos.helpers.sistemasNumericos;

public class Decimal extends SistemaNumerico {
	public Decimal() {
		init();
	}

	private void init() {
		setNombre("Decimal");
		setBase(10);
	}
	
	public String convertir(int base) {
		String resultado="";
		String num;
		num=this.getValue().contains("-")?this.getValue().substring(1,this.getValue().length()):this.getValue();
		resultado=division(Integer.parseInt(num),base);
		if(this.getValue().contains("-")) resultado="-"+resultado;
		return resultado;
	}
	
	public String division(int numero,int base) {
		String resultado = "";
		if(numero/base!=0) {
			resultado=division(numero/base,base)+numero%base+resultado;
		}else {
			resultado=numero%base+resultado;
		}
		return resultado;
	}

	public String AHexadecimal() {
		String resultado="";
		int num;
		num=this.getValue().contains("-")? Integer.parseInt(this.getValue())*(-1):Integer.parseInt(this.getValue());
		do{
			if(num%16==10) {
				resultado="A"+resultado;
			}
			else if(num%16==11) {
				resultado="B"+resultado;
			}
			else if(num%16==12) {
				resultado="C"+resultado;
			}
			else if(num%16==13) {
				resultado="D"+resultado;
			}
			else if(num%16==14) {
				resultado="E"+resultado;
			}
			else if(num%16==15) {
				resultado="F"+resultado;
			}else {
				resultado=num%16+resultado;
			}
			num=num/16;
		}while(num!=0);
		if(this.getValue().contains("-"))resultado="-"+resultado;
		return resultado;
	}
	
}

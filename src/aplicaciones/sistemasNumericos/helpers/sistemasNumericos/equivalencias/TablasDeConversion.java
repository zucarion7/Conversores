package aplicaciones.sistemasNumericos.helpers.sistemasNumericos.equivalencias;

public class TablasDeConversion {

	public String tablaBinarioAOctal(String num) {
		String resultado="";
		if(num.equals("000")) {
			resultado="0";
		}
		else if(num.equals("001")) {
			resultado="1";
		}
		else if(num.equals("010")) {
			resultado="2";
		}
		else if(num.equals("011")) {
			resultado="3";
		}
		else if(num.equals("100")) {
			resultado="4";
		}
		else if(num.equals("101")) {
			resultado="5";
		}
		else if(num.equals("110")) {
			resultado="6";
		}
		else if(num.equals("111")) {
			resultado="7";
		}
		return resultado;
	}
	
	public String tablaBinarioAHexadecimal(String num) {
		String resultado="";
		if(num.equals("0000")) {
			resultado="0";
		}
		else if(num.equals("0001")) {
			resultado="1";
		}
		else if(num.equals("0010")) {
			resultado="2";
		}
		else if(num.equals("0011")) {
			resultado="3";
		}
		else if(num.equals("0100")) {
			resultado="4";
		}
		else if(num.equals("0101")) {
			resultado="5";
		}
		else if(num.equals("0110")) {
			resultado="6";
		}
		else if(num.equals("0111")) {
			resultado="7";
		}
		else if(num.equals("1000")) {
			resultado="8";
		}
		else if(num.equals("1001")) {
			resultado="9";
		}
		else if(num.equals("1010")) {
			resultado="A";
		}
		else if(num.equals("1011")) {
			resultado="B";
		}
		else if(num.equals("1100")) {
			resultado="C";
		}
		else if(num.equals("1101")) {
			resultado="D";
		}
		else if(num.equals("1110")) {
			resultado="E";
		}
		else if(num.equals("1111")) {
			resultado="F";
		}
		return resultado;
	}
	
	public String tablaOctalABinario(String num) {
		String resultado="";
		if(num.equals("0")) {
			resultado="000";
		}
		else if(num.equals("1")) {
			resultado="001";
		}
		else if(num.equals("2")) {
			resultado="010";
		}
		else if(num.equals("3")) {
			resultado="011";
		}
		else if(num.equals("4")) {
			resultado="100";
		}
		else if(num.equals("5")) {
			resultado="101";
		}
		else if(num.equals("6")) {
			resultado="110";
		}
		else if(num.equals("7")) {
			resultado="111";
		}
		return resultado;
	}
	
	public String tablaABinario(String num) {
		String resultado="";
		if(num.equals("0")) {
			resultado="0000";
		}
		else if(num.equals("1")) {
			resultado="0001";
		}
		else if(num.equals("2")) {
			resultado="0010";
		}
		else if(num.equals("3")) {
			resultado="0011";
		}
		else if(num.equals("4")) {
			resultado="0100";
		}
		else if(num.equals("5")) {
			resultado="0101";
		}
		else if(num.equals("6")) {
			resultado="0110";
		}
		else if(num.equals("7")) {
			resultado="0111";
		}
		else if(num.equals("8")) {
			resultado="1000";
		}
		else if(num.equals("9")) {
			resultado="1001";
		}
		else if(num.equals("A")) {
			resultado="1010";
		}
		else if(num.equals("B")) {
			resultado="1011";
		}
		else if(num.equals("C")) {
			resultado="1100";
		}
		else if(num.equals("D")) {
			resultado="1101";
		}
		else if(num.equals("E")) {
			resultado="1110";
		}
		else if(num.equals("F")) {
			resultado="1111";
		}
		return resultado;
	}
}

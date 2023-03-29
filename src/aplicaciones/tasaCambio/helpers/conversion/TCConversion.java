package aplicaciones.tasaCambio.helpers.conversion;

import java.math.BigDecimal;

import aplicaciones.tasaCambio.helpers.Moneda;
import aplicaciones.tasaCambio.helpers.TCDatos;
import aplicaciones.tasaCambio.helpers.ventena.TCControlCbx;
import aplicaciones.tasaCambio.helpers.ventena.TCControlTabla;
import aplicaciones.tasaCambio.helpers.ventena.TCControlTxt;
import global_helpers.control.FormateadorDeNumero;

public class TCConversion {
	
	private TasaCambio tasaCambio;
	private TCControlCbx controlCbx;
	private TCControlTxt controlTxt;
	private TCControlTabla controlTabla;
	private TCDatos datos;
	
	private FormateadorDeNumero formateador;
	
	public void setControlCbx(TCControlCbx controlCbx) {
		this.controlCbx = controlCbx;
	}

	public void setControlTxt(TCControlTxt controlTxt) {
		this.controlTxt = controlTxt;
	}

	public void setControlTabla(TCControlTabla controlTabla) {
		this.controlTabla = controlTabla;
	}

	public void setDatos(TCDatos datos) {
		this.datos = datos;
	}

	public void setFormateador(FormateadorDeNumero formateador) {
		this.formateador = formateador;
	}
	
	public void iniciar() {
		tasaCambio=new TasaCambio();
	}

	public BigDecimal calcularConversion(String codName,BigDecimal baseUser) {
		Moneda moneda=new Moneda();
		moneda=datos.buscarMonedaInfo(controlCbx.getCbxBaseString());
		tasaCambio.setBase(moneda);
		moneda=datos.buscarMonedaInfo(codName);
		tasaCambio.setDivisa(moneda);
		tasaCambio.setBaseUser(baseUser);
		return tasaCambio.calcularDivisaResult();
	}
	
	public void realizarConversiones() {
		BigDecimal resultado=calcularConversion(controlCbx.getCbxDivisaString(),new BigDecimal(controlTxt.getBaseValueString()));
		controlTxt.setDivisaTxtField(formateador.formatear(resultado.toString()));
		controlTabla.setResultadoTabla(new BigDecimal(controlTxt.getBaseValueString()),4);
	}
}

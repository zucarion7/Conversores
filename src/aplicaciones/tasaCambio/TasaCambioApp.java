package aplicaciones.tasaCambio;

import java.math.BigDecimal;

import aplicaciones.tasaCambio.helpers.TCDatos;
import aplicaciones.tasaCambio.helpers.conversion.TCConversion;
import aplicaciones.tasaCambio.helpers.ventena.TCControlBtnChange;
import aplicaciones.tasaCambio.helpers.ventena.TCControlCbx;
import aplicaciones.tasaCambio.helpers.ventena.TCControlLblPosicion;
import aplicaciones.tasaCambio.helpers.ventena.TCControlTabla;
import aplicaciones.tasaCambio.helpers.ventena.TCControlTxt;
import aplicaciones.tasaCambio.helpers.ventena.TCControlVentana;
import aplicaciones.tasaCambio.vista.TasaCambioForm;
import conversoresApp.conversoresVista.ConversoresForm;
import global_helpers.control.FormateadorDeNumero;
import global_helpers.control.JOptionPanePersonalizador;

public class TasaCambioApp {
	
	private TCControlVentana controlVentana;
	private TCControlBtnChange controlBtnChange;
	private TCControlCbx controlCbx;
	private TCControlLblPosicion controlLblPos;
	private TCControlTabla controlTabla;
	private TCControlTxt controlTxt;
	
	private TCDatos controlDatos;
	private TCConversion conversor;
	
	private TasaCambioForm ventana;
	
	private FormateadorDeNumero formateador;
	private JOptionPanePersonalizador JOPanePers;
	
	private ConversoresForm ventanaPrincipal;
	
	public void setPadre(ConversoresForm v) {
		this.ventanaPrincipal=v;
	}
	
	public void setControlDatos(TCDatos controlDatos) {
		this.controlDatos=controlDatos;
	}
	
	public void iniciar() {
		//inicializamos la ventana
		ventana=new TasaCambioForm();
				
		//inicializamos los controles
		controlVentana=new TCControlVentana(ventana,ventanaPrincipal);
		controlBtnChange=new TCControlBtnChange(ventana.getConversionTC().getBtnChange());
		controlCbx=new TCControlCbx(ventana.getConversionTC().getCBXBase(),ventana.getConversionTC().getCBXDivisa());
		controlLblPos=new TCControlLblPosicion(ventana.getConversionTC().getLblBaseID(),ventana.getConversionTC().getLblDivisaID());
		controlTabla=new TCControlTabla(ventana.getTabla());
		controlTxt=new TCControlTxt(ventana.getConversionTC().getTXTBase(),ventana.getConversionTC().getTXTDivisa());
		
		conversor=new TCConversion();
		
		formateador=new FormateadorDeNumero();
		JOPanePers=new  JOptionPanePersonalizador();
		
		setearControles();
		iniciarControles();
		
		init();
	}
	
	private void setearControles() {
		controlTxt.setControlTabla(controlTabla);
		controlTxt.setConversion(conversor);
		
		controlTabla.setConversor(conversor);
		controlTabla.setFormateador(formateador);
		controlTabla.setJOPanePers(JOPanePers);
		controlTabla.setControlTxt(controlTxt);
		controlTabla.setControlCombobox(controlCbx);
		
		controlCbx.setControlLblPos(controlLblPos);
		controlCbx.setControlTabla(controlTabla);
		controlCbx.setControlTxt(controlTxt);
		controlCbx.setConversor(conversor);
		
		controlBtnChange.setControlCbx(controlCbx);
		
		conversor.setControlCbx(controlCbx);
		conversor.setControlTabla(controlTabla);
		conversor.setControlTxt(controlTxt);
		conversor.setDatos(controlDatos);
		conversor.setFormateador(formateador);
	}

	private void iniciarControles() {
		conversor.iniciar();
		
		controlBtnChange.iniciar();
		controlTxt.iniciar();
		
		controlCbx.iniciar();
		controlCbx.llenarComboboxs("COP - Colombian Peso",
				"USD - United States Dollar",
				controlDatos.getOptions());
		
		controlTabla.inicir();
		controlTabla.setEncabezadoTabla(controlDatos.getEncabezado(), controlDatos.getTamanoEncabezado());
		controlTabla.llenarDatosTabla(controlDatos.getFilasTabla(), controlDatos.getMonedas());
		controlTabla.setResultadoTabla(new BigDecimal(1),3);
	}

	private void init() {
		controlVentana.iniciar();
	}
	
}
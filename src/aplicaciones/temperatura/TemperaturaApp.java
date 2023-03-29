package aplicaciones.temperatura;

import aplicaciones.temperatura.helpers.ventana.TControlCbx;
import aplicaciones.temperatura.helpers.ventana.TControlTabla;
import aplicaciones.temperatura.helpers.ventana.TControlTxt;
import aplicaciones.temperatura.helpers.ventana.TControlVentana;
import aplicaciones.temperatura.helpers.ventana.helpers.TDatosTabla;
import aplicaciones.temperatura.helpers.ventana.helpers.TRecolectorResultados;
import aplicaciones.temperatura.vista.TemperaturaForm;
import conversoresApp.conversoresVista.ConversoresForm;

public class TemperaturaApp{
	
	private TemperaturaForm ventana;
	private ConversoresForm ventanaPrincipal;
	
	private TControlVentana controlVentana;
	private TControlTxt controlTxt;
	private TControlTabla controlTabla;
	private TControlCbx controlCbx;
	
	private TRecolectorResultados controlResultados;
	private TDatosTabla datosTabla;
	
	public void iniciar() {
		//inicializamos la ventana
		ventana=new TemperaturaForm();
		
		//inicializamos los controles
		controlVentana=new TControlVentana(ventana,ventanaPrincipal);
		controlTxt=new TControlTxt(ventana.getTDP().getTxtTemperatura());
		controlTabla=new TControlTabla(ventana.getTDP().getTabla());
		controlCbx=new TControlCbx(ventana.getTDP().getCBXEscalas());
		
		controlResultados=new TRecolectorResultados();
		datosTabla=new TDatosTabla();
		
		setearControles();
		iniciarControles();
		init();
	}
	
	private void setearControles() {
		controlTxt.setControlTabla(controlTabla);
		controlTxt.setControlCombobox(controlCbx);
		controlTxt.setControlResultados(controlResultados);
		
		controlCbx.setControlTabla(controlTabla);
		controlCbx.setControlTxt(controlTxt);
		controlCbx.setControlResultados(controlResultados);
		
		controlResultados.setControlCbx(controlCbx);
		controlResultados.setControlTabla(controlTabla);
	}

	public void setPadre(ConversoresForm v) {
		this.ventanaPrincipal=v;
	}
	
	public void init() {
		controlVentana.iniciar();
	}
	
	private void iniciarControles() {
		controlTxt.iniciar();
		
		controlCbx.cargarComboboxs(datosTabla.getOptionsString());
		controlCbx.iniciar();
		
		controlTabla.setEncabezadoTabla(datosTabla.getEncabezado(), datosTabla.getTamanoColumnas());
		controlTabla.llenarDatosTabla(datosTabla.filasTabla(), datosTabla.getOptions());
		controlTabla.setFormulasTabla(controlResultados.recolectarFormulas());
		controlTabla.vaciarResultTabla(4);
		controlTabla.iniciar();
	}
}
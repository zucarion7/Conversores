package aplicaciones.sistemasNumericos;

import aplicaciones.sistemasNumericos.helpers.ventana.SNControlCombobox;
import aplicaciones.sistemasNumericos.helpers.ventana.SNControlTabla;
import aplicaciones.sistemasNumericos.helpers.ventana.SNControlTextField;
import aplicaciones.sistemasNumericos.helpers.ventana.SNControlVentana;
import aplicaciones.sistemasNumericos.helpers.ventana.helpers.SNDatosTabla;
import aplicaciones.sistemasNumericos.vista.SistemaNumericoForm;
import conversoresApp.conversoresVista.ConversoresForm;

public class SistemasNumericosApp {
	
	private SistemaNumericoForm ventana;
	private ConversoresForm ventanaPrincipal;
	
	private SNControlVentana controlVentana;
	private SNControlTextField controlTxt;
	private SNControlTabla controlTabla;
	private SNControlCombobox controlCbx;
	
	private SNDatosTabla datosTabla;

	public void iniciar() {
		//inicializamos la ventana
		ventana=new SistemaNumericoForm();
		
		//inicializamos los controles
		controlVentana=new SNControlVentana(ventana,ventanaPrincipal);
		controlTxt=new SNControlTextField(ventana.getSNDP().getTxtNumero());
		controlTabla=new SNControlTabla(ventana.getSNDP().getTabla());
		controlCbx=new SNControlCombobox(ventana.getSNDP().getCBXSNumericos());
		
		datosTabla=new SNDatosTabla();
		
		setearControles();
		iniciarControles();
		init();
	}
	
	private void setearControles() {
		controlTxt.setControlTabla(controlTabla);
		controlTxt.setControlCombobox(controlCbx);
		
		controlCbx.setControlTabla(controlTabla);
		
		controlCbx.setControlTxt(controlTxt);
		
	}

	public void setPadre(ConversoresForm v) {
		this.ventanaPrincipal=v;
	}
	
	public void init() {
		controlVentana.iniciar();
	}
	
	private void iniciarControles() {
		controlTxt.iniciar();
		
		controlCbx.cargarComboboxs(datosTabla.getOptions());
		controlCbx.iniciar();
		
		controlTabla.setEncabezadoTabla(datosTabla.getEncabezado(), datosTabla.getTamanoColumnas());
		controlTabla.llenarDatosTabla(datosTabla.filasTabla(), datosTabla.getDatos());
		controlTabla.vaciarResultTabla(3);
		controlTabla.iniciar();
	}
	
}
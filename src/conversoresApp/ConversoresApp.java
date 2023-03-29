package conversoresApp;

import conversoresApp.conversoresVista.ConversoresForm;
import conversoresApp.helpers.ventana.CControlBoton;
import conversoresApp.helpers.ventana.CControlCbx;
import conversoresApp.helpers.ventana.CControlVentana;
import conversoresApp.helpers.ventana.helpers.CControlLblFondo;
import conversoresApp.helpers.ventana.helpers.CControlSeleccion;
import conversoresApp.helpers.ventana.helpers.CDatos;

public class ConversoresApp{
	
	private ConversoresForm ventana;
	
	private CControlVentana controlVentana;
	private CControlBoton controlBoton;
	private CControlCbx controlCbx;
	private CControlLblFondo controlFondo;
	private CDatos controlDatos;
	private CControlSeleccion controlSeleccion;
	
	public ConversoresApp(ConversoresForm v) {
		this.ventana=v;
	}
	
	public void iniciar() {
		//inicializamos los controles
		controlVentana=new CControlVentana(ventana);
		controlBoton=new CControlBoton(ventana.getInteraccionPanel().getBtnSelect());
		controlCbx=new CControlCbx(ventana.getInteraccionPanel().getOpcionesCBX());
		controlFondo=new CControlLblFondo(ventana.getInteraccionPanel().getLblFondo());
		controlDatos=new CDatos();
		controlSeleccion=new CControlSeleccion();
		
		setearControles();
		iniciarControles();
		init();
	}
	
	private void setearControles() {
		controlBoton.setControlCbx(controlCbx);
		controlBoton.setControlSeleccion(controlSeleccion);
		
		controlCbx.setControlFondo(controlFondo);
		
		controlSeleccion.setControlVentana(controlVentana);
	}

	private void iniciarControles() {
		controlBoton.iniciar();
		controlCbx.iniciar();
		controlFondo.iniciar();
		
		controlCbx.cargarCombobox(controlDatos.getOptions());
	}

	private void init() {
		controlVentana.iniciar();
	}
}

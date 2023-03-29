package conversoresApp.helpers.ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import conversoresApp.helpers.ventana.helpers.CControlSeleccion;

public class CControlBoton {

	private JButton boton;
	private CControlSeleccion controlSeleccion;
	private CControlCbx controlCbx;
	
	public CControlBoton(JButton boton) {
		this.boton=boton;
	}
	
	public void setControlSeleccion(CControlSeleccion cs) {
		this.controlSeleccion=cs;
	}
	
	public void setControlCbx(CControlCbx controlCbx) {
		this.controlCbx=controlCbx;
	}
	
	public void iniciar() {
		addBotonClickEvent();
	}
	
	private void addBotonClickEvent(){
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlSeleccion.seleccionar(controlCbx.getItemValueString());
			}
		});
	}
}

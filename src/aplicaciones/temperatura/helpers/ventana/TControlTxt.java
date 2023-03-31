package aplicaciones.temperatura.helpers.ventana;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import aplicaciones.temperatura.helpers.ventana.helpers.TRecolectorResultados;
import aplicaciones.temperatura.helpers.ventana.helpers.TValidacionTxt;

public class TControlTxt {

	private JTextField txt;
	private TValidacionTxt validador;
	
	private TControlTabla controlTabla;
	private TControlCbx controlCbx;
	private TRecolectorResultados controlResultados;
	
	public TControlTxt(JTextField txt) {
		this.txt=txt;
	}
	
	public void setControlTabla(TControlTabla ct) {
		this.controlTabla=ct;
	}
	
	public void setControlCombobox(TControlCbx controlCbx) {
		this.controlCbx=controlCbx;
	}
	
	public void setControlResultados(TRecolectorResultados controlResultados) {
		this.controlResultados=controlResultados;
	}
	
	public void iniciar() {
		controlResultados.setControlCbx(controlCbx);
		controlResultados.setControlTabla(controlTabla);
		
		validador=new TValidacionTxt();
		
		addTxtKeyListener();
	}
	
	public void limpiarTxt() {
		this.txt.setText("");
	}
	
	public String getTxtValueString() {
		return txt.getText();
	}
	
	private void addTxtKeyListener() {
		txt.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				validador.validarTecla(e,txt);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(!txt.getText().equals("") && !txt.getText().equals("-")) {
					controlResultados.setValueTemp(controlCbx.getSelectedItemString(), Double.parseDouble(txt.getText().toString()));
					controlTabla.setResultadoTabla(controlResultados.recolectar());
				}
				else{
					controlTabla.vaciarResultTabla(4);
				}
			}
			
		});
	}
}

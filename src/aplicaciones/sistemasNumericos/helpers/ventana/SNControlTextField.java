package aplicaciones.sistemasNumericos.helpers.ventana;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import aplicaciones.sistemasNumericos.helpers.ventana.helpers.SNRecolectorResultados;
import aplicaciones.sistemasNumericos.helpers.ventana.helpers.SNValidacionTxt;

public class SNControlTextField {

	private JTextField txt;
	private SNValidacionTxt validador;
	private SNControlTabla controlTabla;
	private SNControlCombobox controlCbx;
	private SNRecolectorResultados controlResultados;
	
	public SNControlTextField(JTextField txt) {
		this.txt=txt;
	}
	
	public void setControlTabla(SNControlTabla controlTabla) {
		this.controlTabla=controlTabla;
	}
	
	public void setControlCombobox(SNControlCombobox controlCbx) {
		this.controlCbx=controlCbx;
	}
	
	public void iniciar() {
		controlResultados=new SNRecolectorResultados();
		controlResultados.setControlCbx(controlCbx);
		controlResultados.setControlTabla(controlTabla);
		
		validador=new SNValidacionTxt();
		
		addTxtKeyListener();
	}
	
	public void limpiarTxt() {
		this.txt.setText("");
	}
	
	private void addTxtKeyListener() {
		txt.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				validador.validarTecla(e,txt,controlCbx.getSelectedItemString());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(!txt.getText().equals("") && !txt.getText().equals("-")) {
					controlResultados.setValueSN(controlCbx.getSelectedItemString(), txt.getText().toString());
					controlTabla.setResultadoTabla(controlResultados.recolectar());
				}
				else{
					controlTabla.vaciarResultTabla(3);
				}
			}
			
		});
	}
}
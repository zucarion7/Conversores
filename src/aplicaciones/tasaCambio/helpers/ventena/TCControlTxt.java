package aplicaciones.tasaCambio.helpers.ventena;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import aplicaciones.tasaCambio.helpers.conversion.TCConversion;
import aplicaciones.tasaCambio.helpers.ventena.helpers.TCValidacionTxt;

public class TCControlTxt {

	private JTextField txtBase;
	private JTextField txtDivisa;
	private TCValidacionTxt validador;
	
	private TCControlTabla controlTabla;
	private TCConversion conversor;
	
	public TCControlTxt(JTextField txtBase,JTextField txtDivisa) {
		this.txtBase=txtBase;
		this.txtDivisa=txtDivisa;
	}
	
	public void setControlTabla(TCControlTabla ct) {
		this.controlTabla=ct;
	}
	
	public void setConversion(TCConversion conver) {
		this.conversor=conver;
	}
	
	public void iniciar() {
		validador=new TCValidacionTxt();
		addTxtKeyListener();
	}
	
	public String getBaseValueString() {
		return txtBase.getText().toString();
	}
	
	public void setDivisaTxtField(String resultado) {
		txtDivisa.setText(resultado);
	}
	
	private void addTxtKeyListener() {
		txtBase.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				validador.validarTecla(e,txtBase);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(!txtBase.getText().equals("")) {
					conversor.realizarConversiones();
				}
				else{
					txtDivisa.setText("");
					controlTabla.vaciarResultTabla();
				}
			}
			
		});
	}
}

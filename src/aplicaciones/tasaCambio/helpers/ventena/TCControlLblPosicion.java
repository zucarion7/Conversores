package aplicaciones.tasaCambio.helpers.ventena;

import javax.swing.JLabel;

public class TCControlLblPosicion {
	
	private JLabel lblPosBase;
	private JLabel lblPosDivisa;
	
	public TCControlLblPosicion(JLabel base,JLabel divisa) {
		this.lblPosBase=base;
		this.lblPosDivisa=divisa;
	}
	
	public JLabel getLblPosBase() {
		return this.lblPosBase;
	}
	
	public JLabel getLblPosDivisa() {
		return this.lblPosDivisa;
	}
	
	public void setMensajePosicion(JLabel lbl,int posicion) {
		lbl.setText("Posición: "+posicion);
	}
}

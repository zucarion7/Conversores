package aplicaciones.tasaCambio.helpers.ventena;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class TCControlBtnChange {
	
	private JButton change;
	private TCControlCbx controlCbx;
	
	public TCControlBtnChange(JButton boton) {
		this.change=boton;
	}
	
	public void setControlCbx(TCControlCbx controlCbx) {
		this.controlCbx=controlCbx;
	}
	
	public void iniciar() {
		addbtnChangeClick();
	}
	
	private void addbtnChangeClick() {
		change.addMouseListener(new MouseAdapter(){  
			public void mouseClicked(MouseEvent e){ 
				controlCbx.exchange();
			}  
		});
	}
}

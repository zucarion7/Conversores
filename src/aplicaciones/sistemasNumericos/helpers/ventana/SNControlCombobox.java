package aplicaciones.sistemasNumericos.helpers.ventana;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class SNControlCombobox {
	
	private JComboBox<String> cbx;
	private SNControlTextField controlTxt;
	private SNControlTabla controlTabla;
	
	public SNControlCombobox(JComboBox<String> cbx) {
		this.cbx=cbx;
	}
	
	public void setControlTabla(SNControlTabla controlTabla) {
		this.controlTabla=controlTabla;
	}
	
	public void setControlTxt(SNControlTextField controlTxt) {
		this.controlTxt=controlTxt;
	}
	
	public void iniciar() {
		addCbxChange();
	}
	
	public void cargarComboboxs(ArrayList<String> options) {
		for(int i=0;i<options.size();i++) {
			cbx.addItem(options.get(i));
		}
		cbx.setSelectedIndex(0);
	}
	
	public String getSelectedItemString() {
		return this.cbx.getSelectedItem().toString();
	}
	
	private void addCbxChange() {
		cbx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				controlTxt.limpiarTxt();
				controlTabla.vaciarResultTabla(3);
			}
		});
	}
}

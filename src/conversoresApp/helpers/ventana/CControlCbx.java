package conversoresApp.helpers.ventana;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import conversoresApp.helpers.ventana.helpers.CControlLblFondo;

public class CControlCbx {
	
	private JComboBox<String> cbx;
	private CControlLblFondo controlFondo;
	
	public CControlCbx(JComboBox<String> cbx) {
		this.cbx=cbx;
	}
	
	public void setControlFondo(CControlLblFondo cf) {
		this.controlFondo=cf;
	}
	
	public void iniciar() {
		addCbxChange();
	}
	
	public String getItemValueString() {
		return this.cbx.getSelectedItem().toString();
	}
	
	public void cargarCombobox(ArrayList<String> options) {
		for(int i=0;i<options.size();i++) {
			cbx.addItem(options.get(i));
		}
	}
	
	private void addCbxChange() {
		cbx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				controlFondo.cambiarFondo(getItemValueString());
			}
		});
	}
}

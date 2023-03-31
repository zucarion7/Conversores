package aplicaciones.temperatura.helpers.ventana;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import aplicaciones.temperatura.helpers.ventana.helpers.TRecolectorResultados;

public class TControlCbx {

	private JComboBox<String> cbx;
	private TControlTxt controlTxt; 
	private TControlTabla controlTabla;

	private TRecolectorResultados controlResultados;

	public TControlCbx(JComboBox<String> cbx) {
		this.cbx=cbx;
	}
	
	public void setControlTabla(TControlTabla controlTabla) {
		this.controlTabla=controlTabla;
	}
	
	public void setControlTxt(TControlTxt controlTxt) {
		this.controlTxt=controlTxt;
	}
	
	public void setControlResultados(TRecolectorResultados controlResultados) {
		this.controlResultados=controlResultados;
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
				controlTabla.setFormulasTabla(controlResultados.recolectarFormulas());
				if(!controlTxt.getTxtValueString().equals("") && !controlTxt.getTxtValueString().equals("-")) {
					controlResultados.setValueTemp(getSelectedItemString(), Double.parseDouble(controlTxt.getTxtValueString()));
					controlTabla.setResultadoTabla(controlResultados.recolectar());
				}
			}
		});
	}
}

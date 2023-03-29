package aplicaciones.tasaCambio.helpers.ventena;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JComboBox;

import aplicaciones.tasaCambio.helpers.conversion.TCConversion;

public class TCControlCbx {

	private JComboBox<String> cbxBase;
	private JComboBox<String> cbxDivisa;
	
	private TCControlTxt controlTxt;
	private TCControlTabla controlTabla;
	private TCControlLblPosicion controlLblPosicion;
	
	private TCConversion conversor;
	
	public TCControlCbx(JComboBox<String> cbxBase,JComboBox<String> cbxDivisa) {
		this.cbxBase=cbxBase;
		this.cbxDivisa=cbxDivisa;
	}
	
	public void setControlTxt(TCControlTxt controlTxt) {
		this.controlTxt=controlTxt;
	}
	
	public void setControlLblPos(TCControlLblPosicion cp) {
		this.controlLblPosicion=cp;
	}
	
	public void setControlTabla(TCControlTabla ct) {
		this.controlTabla=ct;
	}
	
	public void setConversor(TCConversion conver) {
		this.conversor=conver;
	}
	
	public void iniciar() {
		addCbxChange(cbxBase);
		addCbxChange(cbxDivisa);
	}
	
	public String getCbxBaseString() {
		return this.cbxBase.getSelectedItem().toString();
	}
	
	public String getCbxDivisaString() {
		return this.cbxDivisa.getSelectedItem().toString();
	}
	
	public void exchange() {
		String base,divisa;
		base=getCbxBaseString();
		divisa=getCbxDivisaString();
		    
		cbxBase.setSelectedItem(divisa);
		cbxDivisa.setSelectedItem(base);
	}
	
	public void llenarComboboxs(String base,String divisa,ArrayList<String> options) {
		cargarCombobox(cbxBase,options);
		cargarCombobox(cbxDivisa,options);
		cbxBase.setSelectedItem(base);
		cbxDivisa.setSelectedItem(divisa);
	}

	public void cargarCombobox(JComboBox<String> cbx,ArrayList<String> op) {
		for(int i=0;i<op.size();i++) {
			cbx.addItem(op.get(i));
		}
	}
	
	private void addCbxChange(JComboBox<String> cbx) {
		cbx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!controlTxt.getBaseValueString().equals("")) {
					conversor.realizarConversiones();
				}
				if(cbx==cbxBase) {
					controlTabla.setResultadoTabla(new BigDecimal(1),3);
					controlLblPosicion.setMensajePosicion(controlLblPosicion.getLblPosBase(), cbx.getSelectedIndex()+1);
				}else if(cbx==cbxDivisa) {
					controlLblPosicion.setMensajePosicion(controlLblPosicion.getLblPosDivisa(), cbx.getSelectedIndex()+1);
				}
			}
		});
	}
}

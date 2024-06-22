package aplicaciones.tasaCambio.helpers.ventena;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import aplicaciones.tasaCambio.helpers.Moneda;
import aplicaciones.tasaCambio.helpers.conversion.TCConversion;
import global_helpers.control.FormateadorDeNumero;
import global_helpers.control.JOptionPanePersonalizador;
import global_helpers.vista.Tabla;

public class TCControlTabla {

	private Tabla tabla;
	private TCControlCbx controlCbx;
	private TCControlTxt controlTxt;
	
	private TCConversion conversor;
	private JOptionPanePersonalizador JOPanePers;
	private FormateadorDeNumero formateador;
	
	public TCControlTabla(Tabla tabla) {
		this.tabla=tabla;
	}
	
	public void setControlCombobox(TCControlCbx controlCbx) {
		this.controlCbx=controlCbx;
	}
	
	public void setControlTxt(TCControlTxt controlTxt) {
		this.controlTxt=controlTxt;
	}
	
	public void setConversor(TCConversion conver) {
		this.conversor=conver;
	}
	
	public void setJOPanePers(JOptionPanePersonalizador JOPanePers) {
		this.JOPanePers=JOPanePers;
	}
	
	public void setFormateador(FormateadorDeNumero formater) {
		this.formateador=formater;
	}
	
	public void inicir() {
		addDoubleClickTablaE();
	}
	
	public void setEncabezadoTabla(String [] encabezado,ArrayList<Integer> tamanoColumnas) {
		tabla.setEncabezados(encabezado);
		tabla.setTamanoColumnas(tamanoColumnas);
	}
		
	public void llenarDatosTabla(Object[] fila,ArrayList<Moneda> monedas) {
		for(int i=0;i<monedas.size();i++) {
			tabla.getModelo().addRow(fila);
			tabla.getModelo().setValueAt(i+1, i, 0);
			tabla.getModelo().setValueAt(monedas.get(i).getNombre(), i, 1);
			tabla.getModelo().setValueAt(monedas.get(i).getCodigo(), i, 2);
		}
		vaciarResultTabla();
	}
	
	public void vaciarResultTabla() {
		for(int i=0;i<tabla.getRowCount();i++) {
			tabla.getModelo().setValueAt(0, i, 4);
		}
	}
	
	public void setResultadoTabla(BigDecimal base,int column) {
		BigDecimal resultado;
		for(int i=0;i<tabla.getModelo().getRowCount();i++) {
			String name=tabla.getModelo().getValueAt(i, 1).toString();
			String codigo=tabla.getModelo().getValueAt(i, 2).toString();
			resultado=conversor.calcularConversion(codigo+" - "+name,base);
			if(column==3) {
				tabla.getModelo().setValueAt(resultado, i, column);
			}else if(column==4) {
				tabla.getModelo().setValueAt(formateador.formatear(resultado.toString()), i, column);
			}
		}
	}
	
	private void addDoubleClickTablaE() {
		tabla.addMouseListener(new MouseAdapter(){  
			public void mouseClicked(MouseEvent e){ 
				if(e.getClickCount()==2) {
					JOPanePers.Personalizar();
					int row=tabla.getSelectedRow();
					String fila=tabla.getValueAt(row, 0).toString();
					String nombre=tabla.getValueAt(row, 1).toString();
					String codigo=tabla.getValueAt(row, 2).toString();
					String tasa=tabla.getValueAt(row, 3).toString();
					String resultado=tabla.getValueAt(row, 4).toString();

					String codigoMI=controlCbx.getCbxBaseString().substring(0, 3);
					String valorConvert=controlTxt.getBaseValueString();
					String monedaI="";
					int posicionMonedaI=0;
					for(int i=0;i<tabla.getRowCount();i++) {
						if(codigoMI.equals(tabla.getValueAt(i, 2))) {
							monedaI=tabla.getValueAt(i, 1).toString();
							posicionMonedaI=i+1;
						}
					};
					
					JOptionPane.showMessageDialog(null, "Información de la conversión\n"
							+"\nPosición moneda inicial: "+posicionMonedaI
							+"\nNombre moneda inicial: "+monedaI
							+"\nCódigo: "+codigoMI
							+"\nCantidad a convertir: "+valorConvert
							+"\n\nResultados\n"
							+ "\nFila: "+fila
							+"\nNombre moneda: "+nombre
							+"\nCódigo: "+codigo
							+"\nTasa de cambio: "+tasa
							+"\nResultado: "+resultado,"Tasa de cambio",1);
				}
			}
		});
	}
}

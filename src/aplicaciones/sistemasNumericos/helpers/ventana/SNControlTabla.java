package aplicaciones.sistemasNumericos.helpers.ventana;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import global_helpers.control.JOptionPanePersonalizador;
import global_helpers.vista.Tabla;

public class SNControlTabla {
	
	private Tabla tabla;
	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();
	
	public SNControlTabla(Tabla tabla) {
		this.tabla=tabla;
	}
	
	public void iniciar() {
		addDoubleClickTablaE();
	}
	
	//zona tabla
	public void setEncabezadoTabla(String [] encabezados,ArrayList<Integer> tamanoColumnas) {
		tabla.setEncabezados(encabezados);
		tabla.setTamanoColumnas(tamanoColumnas);
	}
				
	public void llenarDatosTabla(Object[] objects,String [][] datos) {
		for (int x=0; x < datos.length; x++) { 
			tabla.getModelo().addRow(objects);
			tabla.getModelo().setValueAt(x+1, x, 0);
			for (int y=0; y < datos[x].length; y++) {
				tabla.getModelo().setValueAt(datos[x][y], x, y+1);
			}
		}
	}
		
	public void vaciarResultTabla(int column) {
		for(int i=0;i<tabla.getRowCount();i++) {
			tabla.getModelo().setValueAt(0, i, column);
		}
	}
	
	public void setResultadoTabla(ArrayList<String> resultados) {
		for(int i=0;i<tabla.getRowCount();i++) {
			tabla.getModelo().setValueAt(resultados.get(i), i, 3);
		}
	}
		
	public String getCeldaValue(int row,int column) {
		return this.tabla.getValueAt(row, column).toString();
	}
		
	private void addDoubleClickTablaE() {
		tabla.addMouseListener(new MouseAdapter(){  
			public void mouseClicked(MouseEvent e){ 
				if(e.getClickCount()==2) {
					JOPanePers.Personalizar();
					int row=tabla.getSelectedRow();
					String num=tabla.getValueAt(row, 0).toString();
					String sistemNumer=tabla.getValueAt(row, 1).toString();
					String base=tabla.getValueAt(row, 2).toString();
					String resultado=tabla.getValueAt(row, 3).toString();
					JOptionPane.showMessageDialog(null, "Información de la moneda\n"
							+ "\nFila: "+num
							+"\nSistema numérico: "+sistemNumer
							+"\nBase: "+base
							+"\nResultado: "+resultado,"Sistema numérico",1);
				}
			}
		});
	}
}

package aplicaciones.temperatura.helpers.ventana;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import aplicaciones.temperatura.helpers.escalas.Temperatura;
import global_helpers.control.FormateadorDeNumero;
import global_helpers.control.JOptionPanePersonalizador;
import global_helpers.vista.Tabla;

public class TControlTabla {

	private Tabla tabla;
	
	private FormateadorDeNumero formateador;
	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();
	
	public TControlTabla(Tabla tabla) {
		this.tabla=tabla;
	}
	
	public void iniciar() {
		formateador=new FormateadorDeNumero();
		addDoubleClickTablaE();
	}
	
	//zona tabla
		public void setEncabezadoTabla(String [] encabezado,ArrayList<Integer> tamanoColumnas) {
			tabla.setEncabezados(encabezado);
			tabla.setTamanoColumnas(tamanoColumnas);
		}
		
		public void llenarDatosTabla(Object [] fila,ArrayList<Temperatura> options) {
			for(int i=0;i<options.size();i++) {
				tabla.getModelo().addRow(fila);
				tabla.getModelo().setValueAt(i+1, i, 0);
				tabla.getModelo().setValueAt(options.get(i).getNombre(), i, 1);
				tabla.getModelo().setValueAt(options.get(i).getSimbolo(), i, 2);
			}
		}
		
		public void setFormulasTabla(ArrayList<String> formulas) {
			for(int i=0;i<tabla.getRowCount();i++) {
				tabla.getModelo().setValueAt(formulas.get(i),i,3);
			}
		}

		public void vaciarResultTabla(int x) {
			for(int i=0;i<tabla.getRowCount();i++) {
				tabla.getModelo().setValueAt(0, i, x);
			}
		}
		
		public void setResultadoTabla(ArrayList<Double> resultados) {
			for(int i=0;i<tabla.getModelo().getRowCount();i++) {
				tabla.getModelo().setValueAt(formateador.formatear(Double.toString(resultados.get(i))), i, 4);
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
						String escala=tabla.getValueAt(row, 1).toString();
						String simbolo=tabla.getValueAt(row, 2).toString();
						String formula=tabla.getValueAt(row, 3).toString();
						String resultado=tabla.getValueAt(row, 4).toString();
						JOptionPane.showMessageDialog(null, "Información de la moneda\n"
								+ "\nFila: "+num
								+"\nEscala: "+escala
								+"\nSimbolo: "+simbolo
								+"\nFormula: "+formula
								+"\nResultado: "+resultado,"Escala",1);
					}
				}
			});
		}
}

package global_helpers.vista;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import global_helpers.control.RenderTabla;

@SuppressWarnings("serial")
public class Tabla extends JTable{
	
	private DefaultTableModel dtm;
	private RenderTabla render=new RenderTabla();
	
	public Tabla() {
		init();
	}

	public DefaultTableModel getModelo() {
		return this.dtm;
	}
	
	private void init() {
		dtm=new DefaultTableModel();
		setDefaultRenderer(Object.class, render);
		
		getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		getTableHeader().setForeground(new Color(0,250,0));
		getTableHeader().setOpaque(false);
		getTableHeader().setBackground(new Color(0,0,0));
		getTableHeader().setBorder(BorderFactory.createLineBorder(Color.blue));
		
		setSelectionBackground(new Color(100,100,100));
		setSelectionForeground(new Color(0,0,0));
		
		setBackground(new Color(53, 56, 61));
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Tahoma", Font.PLAIN, 14));
		setOpaque(false);
		
		setModel(dtm);
		setRowHeight(25);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void setEncabezados(String [] titulo) {
		dtm.setColumnIdentifiers(titulo);
		
	}
	
	public void setTamanoColumnas(ArrayList<Integer> list) {
		for(int i=0;i<list.size();i++) {
			this.getColumnModel().getColumn(i).setPreferredWidth(list.get(i));
//			this.getColumnModel().getColumn(i).setResizable(false);
		}
	}
	
	@Override
	public boolean isCellEditable(int i, int j) {
		return false;
	}
	
}

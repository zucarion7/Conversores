package aplicaciones.temperatura;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import aplicaciones.temperatura.helpers.Celsius;
import aplicaciones.temperatura.helpers.ConversorTemperatura;
import aplicaciones.temperatura.helpers.Fahrenheit;
import aplicaciones.temperatura.helpers.Kelvin;
import aplicaciones.temperatura.helpers.Temperatura;
import aplicaciones.temperatura.vista.TemperaturaForm;
import conversoresApp.conversoresVista.ConversoresForm;
import global_helpers.control.FormateadorDeNumero;
import global_helpers.control.JOptionPanePersonalizador;

public class TemperaturaApp{
	
	private TemperaturaForm ventana;
	private ConversorTemperatura converTemp;
	private ArrayList<Temperatura> options=new ArrayList<>();
	
	private FormateadorDeNumero formateador;
	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();;
	
	private ConversoresForm ventanaPrincipal;
	
	public TemperaturaApp() {
		init();
	}

	public void setPadre(ConversoresForm v) {
		this.ventanaPrincipal=v;
	}
	
	private void init() {
		ventanaPrincipal=new ConversoresForm();
		ventana=new TemperaturaForm();
		
		formateador=new FormateadorDeNumero();
		converTemp=new ConversorTemperatura();
		
		llenarOptions();

		activarListeners();
		
		setEncabezadoTabla();
		llenarDatosTabla();
		cargarComboboxs();
	}
	
	public void iniciar() {
		ventana.setVisible(true);
	}
	
	private void llenarOptions() {
		options.add(new Celsius());
		options.add(new Fahrenheit());
		options.add(new Kelvin());
		
		converTemp.setCelsius(options.get(0));
		converTemp.setFahrenheit(options.get(1));
		converTemp.setKelvin(options.get(2));
	}
	
	private void cargarComboboxs() {
		for(int i=0;i<options.size();i++) {
			ventana.getTDP().getCBXEscalas().addItem(options.get(i).getNombre());
		}
		ventana.getTDP().getCBXEscalas().setSelectedIndex(0);
	}
	
	//zona tabla
	public void setEncabezadoTabla() {
		String [] encabezados={"#","Escala","Simbolo","Formula","Resultado"};
		ventana.getTDP().getTabla().setEncabezados(encabezados);
		ArrayList<Integer> tamanoColumnas=new ArrayList<>();
		tamanoColumnas.add(30);
		tamanoColumnas.add(100);
		tamanoColumnas.add(70);
		tamanoColumnas.add(110);
		tamanoColumnas.add(110);
		ventana.getTDP().getTabla().setTamanoColumnas(tamanoColumnas);
	}
		
	public void llenarDatosTabla() {
		for(int i=0;i<options.size();i++) {
			ventana.getTDP().getTabla().getModelo().addRow(new Object[]{"","","","",""});
			ventana.getTDP().getTabla().getModelo().setValueAt(i+1, i, 0);
			ventana.getTDP().getTabla().getModelo().setValueAt(options.get(i).getNombre(), i, 1);
			ventana.getTDP().getTabla().getModelo().setValueAt(options.get(i).getSimbolo(), i, 2);
		}
		vaciarResultTabla();
	}
	
	private void setFormulasTabla() {
		String escalaSelect=ventana.getTDP().getCBXEscalas().getSelectedItem().toString();
		for(int i=0;i<options.size();i++) {
			ventana.getTDP().getTabla().getModelo().setValueAt(converTemp.getFormula(escalaSelect, options.get(i).getNombre()),i,3);
		}
	}

	public void vaciarResultTabla() {
		for(int i=0;i<options.size();i++) {
			ventana.getTDP().getTabla().getModelo().setValueAt(0, i, 4);
		}
	}
	
	public void setValueTemp() {
		String escala=ventana.getTDP().getCBXEscalas().getSelectedItem().toString();
		double value=Double.parseDouble(ventana.getTDP().getTxtTemperatura().getText().toString());
		if(escala.equals("Celsius")) {
			converTemp.getCelsius().setValue(value);
		}
		else if(escala.equals("Fahrenheit")) {
			converTemp.getFahrenheit().setValue(value);
		}
		else if(escala.equals("Kelvin")) {
			converTemp.getKelvin().setValue(value);
		}
	}
	
	public void setResultadoTabla() {
		setValueTemp();
		double resultado=0;
		for(int i=0;i<ventana.getTDP().getTabla().getModelo().getRowCount();i++) {
			resultado=converTemp.realizarConversion(ventana.getTDP().getCBXEscalas().getSelectedItem().toString(),ventana.getTDP().getTabla().getValueAt(i, 1).toString());
			ventana.getTDP().getTabla().getModelo().setValueAt(formateador.formatear(resultado), i, 4);
		}
	}
	
	private void activarListeners() {
		addDoubleClickTablaE();
		addCbxChange(ventana.getTDP().getCBXEscalas());
		addTxtKeyListener();
		addCloseVentanaEvent();
	}
	
	private void addCbxChange(JComboBox<String> cbx) {
		cbx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setFormulasTabla();
				if(!ventana.getTDP().getTxtTemperatura().getText().equals("")) {
					setResultadoTabla();
				}
			}
		});
	}

	private void validarTecla(KeyEvent e) {
		
		if(e.getKeyChar()!='.' && e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(e.getKeyChar()=='.' && (ventana.getTDP().getTxtTemperatura().getText().contains(".") || ventana.getTDP().getTxtTemperatura().getText().equals(""))) e.consume();
		
		if(e.getKeyChar()=='-' && !ventana.getTDP().getTxtTemperatura().getText().equals("")) e.consume();
	}
	
	private void addTxtKeyListener() {
		ventana.getTDP().getTxtTemperatura().addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				validarTecla(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//validar datos
				if(!ventana.getTDP().getTxtTemperatura().getText().equals("") && !ventana.getTDP().getTxtTemperatura().getText().equals("-")) {
					setResultadoTabla();
				}
				else{
					vaciarResultTabla();
				}
			}
			
		});
	}

	private void addDoubleClickTablaE() {
		JTable tabla=ventana.getTDP().getTabla();
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
					JOptionPane.showMessageDialog(ventana, "Información de la moneda\n"
							+ "\nFila: "+num
							+"\nEscala: "+escala
							+"\nSimbolo: "+simbolo
							+"\nFormula: "+formula
							+"\nResultado: "+resultado,"Escala",1);
				}
			}
		});
	}

	//agregamos todos los eventos
	private void addCloseVentanaEvent() {
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
			}
		});
	}
}
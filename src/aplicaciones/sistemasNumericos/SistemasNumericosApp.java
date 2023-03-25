package aplicaciones.sistemasNumericos;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import aplicaciones.sistemasNumericos.helpers.ConverSistemNumerico;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.Binario;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.Decimal;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.Hexadecimal;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.Octal;
import aplicaciones.sistemasNumericos.helpers.sistemasNumericos.SistemaNumerico;
import aplicaciones.sistemasNumericos.vista.SistemaNumericoForm;
import conversoresApp.conversoresVista.ConversoresForm;
import global_helpers.control.JOptionPanePersonalizador;

public class SistemasNumericosApp {
	
	private SistemaNumericoForm ventana;
	
	private ConverSistemNumerico converSN;
	private ArrayList<SistemaNumerico> options=new ArrayList<>();
	
	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();;
	
	private ConversoresForm ventanaPrincipal;
	
	public SistemasNumericosApp() {
		init();
	}

	private void init() {
		ventanaPrincipal=new ConversoresForm();
		ventana=new SistemaNumericoForm();
		
		converSN=new ConverSistemNumerico();
		
		llenarOptions();
		
		activarListeners();
		
		setEncabezadoTabla();
		llenarDatosTabla();
		cargarComboboxs();
	}
	
	public void setPadre(ConversoresForm v) {
		this.ventanaPrincipal=v;
	}
	
	public void iniciar() {
		ventana.setVisible(true);
	}
	
	private void llenarOptions() {
		options.add(new Decimal());
		options.add(new Binario());
		options.add(new Octal());
		options.add(new Hexadecimal());
		
		converSN.setDecimal(options.get(0));
		converSN.setBinario(options.get(1));
		converSN.setOctal(options.get(2));
		converSN.setHexadecimal(options.get(3));
	}
	
	private void cargarComboboxs() {
		for(int i=0;i<options.size();i++) {
			ventana.getSNDP().getCBXSNumericos().addItem(options.get(i).getNombre());
		}
		ventana.getSNDP().getCBXSNumericos().setSelectedIndex(0);
	}
	
	//zona tabla
	public void setEncabezadoTabla() {
		String [] encabezados={"#","Sistema numérico","Base","Resultado"};
		ventana.getSNDP().getTabla().setEncabezados(encabezados);
		ArrayList<Integer> tamanoColumnas=new ArrayList<>();
		tamanoColumnas.add(30);
		tamanoColumnas.add(100);
		tamanoColumnas.add(70);
		tamanoColumnas.add(110);
		ventana.getSNDP().getTabla().setTamanoColumnas(tamanoColumnas);
	}
			
	public void llenarDatosTabla() {
		for(int i=0;i<options.size();i++) {
			ventana.getSNDP().getTabla().getModelo().addRow(new Object[]{"","","",""});
			ventana.getSNDP().getTabla().getModelo().setValueAt(i+1, i, 0);
			ventana.getSNDP().getTabla().getModelo().setValueAt(options.get(i).getNombre(), i, 1);
			ventana.getSNDP().getTabla().getModelo().setValueAt(options.get(i).getBase(), i, 2);
		}
		vaciarResultTabla();
	}
	
	private void vaciarResultTabla() {
		for(int i=0;i<options.size();i++) {
			ventana.getSNDP().getTabla().getModelo().setValueAt(0, i, 3);
		}
	}
	
	private void setResultadoTabla() {
		setValueSN();
		String resultado;
		for(int i=0;i<ventana.getSNDP().getTabla().getModelo().getRowCount();i++) {
			resultado=converSN.realizarConversion(ventana.getSNDP().getCBXSNumericos().getSelectedItem().toString(),ventana.getSNDP().getTabla().getValueAt(i, 1).toString());
			ventana.getSNDP().getTabla().getModelo().setValueAt(resultado, i, 3);
		}
	}

	private void setValueSN() {
		String sNumerico=ventana.getSNDP().getCBXSNumericos().getSelectedItem().toString();
		String value=ventana.getSNDP().getTxtNumero().getText().toString();
		if(sNumerico.equals("Decimal")) {
			converSN.getDecimal().setValue(value);
		}
		else if(sNumerico.equals("Binario")) {
			converSN.getBinario().setValue(value);
		}
		else if(sNumerico.equals("Octal")) {
			converSN.getOctal().setValue(value);
		}
		else if(sNumerico.equals("Hexadecimal")) {
			converSN.getHexadecimal().setValue(value);
		}
	}

	private void activarListeners() {
		addDoubleClickTablaE();
		addTxtKeyListener();
		addCbxChange(ventana.getSNDP().getCBXSNumericos());
		addCloseVentanaEvent();
	}

	private void addCbxChange(JComboBox<String> cbx) {
		cbx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ventana.getSNDP().getTxtNumero().setText("");
				vaciarResultTabla();
			}
		});
	}
	
	private void validarTecla(KeyEvent e) {
		
		String sNumerico=ventana.getSNDP().getCBXSNumericos().getSelectedItem().toString();
		if(sNumerico.equals("Decimal")) {
			validacionDecimal(e);
		}
		else if(sNumerico.equals("Binario")) {
			validacionBinario(e);
		}
		else if(sNumerico.equals("Octal")) {
			validacionOctal(e);
		}
		else if(sNumerico.equals("Hexadecimal")) {
			validacionHexadecimal(e);
		}
		
	}
	

	private void validacionDecimal(KeyEvent e) {
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(e.getKeyChar()=='-' && !ventana.getSNDP().getTxtNumero().getText().equals("")) e.consume();
	}

	private void validacionBinario(KeyEvent e) {
		
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(Character.isDigit(e.getKeyChar()) && e.getKeyChar()>='2') e.consume();
		
		if(e.getKeyChar()=='-' && !ventana.getSNDP().getTxtNumero().getText().equals("")) e.consume();
	}

	private void validacionOctal(KeyEvent e) {
		
		if(e.getKeyChar()!='-' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(Character.isDigit(e.getKeyChar()) && e.getKeyChar()>='8') e.consume();
		
		if(e.getKeyChar()=='-' && !ventana.getSNDP().getTxtNumero().getText().equals("")) e.consume();
	}

	private void validacionHexadecimal(KeyEvent e) {
		if(e.getKeyChar()=='-' && !ventana.getSNDP().getTxtNumero().getText().equals("")) e.consume();
		
		if(!Character.isDigit(e.getKeyChar()) && !Pattern.matches("[A-F-]",Character.toString(e.getKeyChar()))) e.consume();
		
	}

	private void addTxtKeyListener() {
		ventana.getSNDP().getTxtNumero().addKeyListener(new KeyListener(){

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
				if(!ventana.getSNDP().getTxtNumero().getText().equals("") && !ventana.getSNDP().getTxtNumero().getText().equals("-")) {
					setResultadoTabla();
				}
				else{
					vaciarResultTabla();
				}
			}
			
		});
	}

	private void addDoubleClickTablaE() {
		JTable tabla=ventana.getSNDP().getTabla();
		tabla.addMouseListener(new MouseAdapter(){  
			public void mouseClicked(MouseEvent e){ 
				if(e.getClickCount()==2) {
					JOPanePers.Personalizar();
					int row=tabla.getSelectedRow();
					String num=tabla.getValueAt(row, 0).toString();
					String sistemNumer=tabla.getValueAt(row, 1).toString();
					String base=tabla.getValueAt(row, 2).toString();
					String resultado=tabla.getValueAt(row, 3).toString();
					JOptionPane.showMessageDialog(ventana, "Información de la moneda\n"
							+ "\nFila: "+num
							+"\nSistema numérico: "+sistemNumer
							+"\nBase: "+base
							+"\nResultado: "+resultado,"Sistema numérico",1);
				}
			}
		});
	}
	
	private void addCloseVentanaEvent() {
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
			}
		});		
	}
}

package aplicaciones.tasaCambio;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.json.JSONObject;

import aplicaciones.tasaCambio.helpers.API;
import aplicaciones.tasaCambio.helpers.API_Manejo;
import aplicaciones.tasaCambio.helpers.Moneda;
import aplicaciones.tasaCambio.helpers.TasaCambio;
import aplicaciones.tasaCambio.vista.TasaCambioForm;
import conversoresApp.conversoresVista.ConversoresForm;
import global_helpers.control.FormateadorDeNumero;
import global_helpers.control.JOptionPanePersonalizador;

public class TasaCambioApp {
	
	private API api_codigoMonedas;
	private API api_nombreMonedas;
	private TasaCambio tasaCambio=new TasaCambio();
	private TasaCambioForm ventana;
	private API_Manejo api_manejo;
	private ArrayList<Moneda> monedas=new ArrayList<>();
	private FormateadorDeNumero formateador;
	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();
	
	private ConversoresForm ventanaPrincipal;
	
	public TasaCambioApp() {
		this.api_codigoMonedas=new API("https://api.exchangerate-api.com/v4/latest/COP");
		JOPanePers.Personalizar();
		JOptionPane.showMessageDialog(null, "Esperar unos segundos respuesta de la API");
		this.api_codigoMonedas.consumoApi();
		if(this.api_codigoMonedas.getValidacion()) {
			api_nombreMonedas=new API("https://openexchangerates.org/api/currencies.json");
			api_nombreMonedas.consumoApi();
			if(this.api_nombreMonedas.getValidacion()) {
				initComponents();
			}
		}
	}
	
	public void setPadre(ConversoresForm v) {
		this.ventanaPrincipal=v;
	}
	
	private void initComponents() {
		formateador=new FormateadorDeNumero();
		this.ventanaPrincipal=new ConversoresForm();
		this.ventana=new TasaCambioForm();
		this.api_manejo=new API_Manejo((JSONObject) api_codigoMonedas.getJSONObject().get("rates"),api_nombreMonedas.getJSONObject());
		this.monedas=api_manejo.convertir_R_M();
		Collections.sort(monedas);
		
		activarListeners();
		llenarComboboxs("COP - Colombian Peso","USD - United States Dollar");
		
		setEncabezadoTabla();
		llenarDatosTabla();
	}

	public void iniciar() {
		ventana.setVisible(true);
	}
	
	public boolean validacionApis() {
		return !api_codigoMonedas.getValidacion() || !api_nombreMonedas.getValidacion()? false:true;
	}
	
	private void llenarComboboxs(String base,String divisa) {
		cargarCombobox(this.ventana.getConversionTC().getCBXBase(),monedas);
		ventana.getConversionTC().getCBXBase().setSelectedItem(base);
		cargarCombobox(this.ventana.getConversionTC().getCBXDivisa(),monedas);
		ventana.getConversionTC().getCBXDivisa().setSelectedItem(divisa);
	}

	private void cargarCombobox(JComboBox<String> cbx,ArrayList<Moneda> op) {
		for(int i=0;i<op.size();i++) {
			cbx.addItem(op.get(i).getCodigo()+" - "+op.get(i).getNombre());
		}
	}
	
	//zona tabla
	public void setEncabezadoTabla() {
		String [] encabezados={"#","Moneda","Código","Tasa","Resultado"};
		ventana.getTabla().setEncabezados(encabezados);
		ArrayList<Integer> tamanoColumnas=new ArrayList<>();
		tamanoColumnas.add(30);
		tamanoColumnas.add(220);
		tamanoColumnas.add(70);
		tamanoColumnas.add(110);
		tamanoColumnas.add(110);
		ventana.getTabla().setTamanoColumnas(tamanoColumnas);
	}
	
	public void llenarDatosTabla() {
		for(int i=0;i<monedas.size();i++) {
			ventana.getTabla().getModelo().addRow(new Object[]{"","","","",""});
			ventana.getTabla().getModelo().setValueAt(i+1, i, 0);
			ventana.getTabla().getModelo().setValueAt(monedas.get(i).getNombre(), i, 1);
			ventana.getTabla().getModelo().setValueAt(monedas.get(i).getCodigo(), i, 2);
		}
		setResultadoTabla(new BigDecimal(1),3);
		vaciarResultTabla();
	}
	
	public void vaciarResultTabla() {
		for(int i=0;i<monedas.size();i++) {
			ventana.getTabla().getModelo().setValueAt(0, i, 4);
		}
	}
	
	public void setResultadoTabla(BigDecimal base,int column) {
		BigDecimal resultado;
		for(int i=0;i<ventana.getTabla().getModelo().getRowCount();i++) {
			String name=ventana.getTabla().getModelo().getValueAt(i, 1).toString();
			String codigo=ventana.getTabla().getModelo().getValueAt(i, 2).toString();
			resultado=calcularConversion(codigo+" - "+name,base);
			if(column==3) {
				ventana.getTabla().getModelo().setValueAt(resultado, i, column);
			}else if(column==4) {
				ventana.getTabla().getModelo().setValueAt(formateador.formatear(resultado.toString()), i, column);
			}
		}
	}
	
	private Moneda buscarMonedaInfo(String codigoNombre) {
		for(int i=0;i<monedas.size();i++) {
			if(codigoNombre.equals(monedas.get(i).getCodigo()+" - "+monedas.get(i).getNombre())) {
				return monedas.get(i);
			}
		}
		return null;
	}
	
	private BigDecimal calcularConversion(String codName,BigDecimal baseUser) {
		Moneda moneda=new Moneda();
		moneda=buscarMonedaInfo(ventana.getConversionTC().getCBXBase().getSelectedItem().toString());
		tasaCambio.setBase(moneda);
		moneda=buscarMonedaInfo(codName);
		tasaCambio.setDivisa(moneda);
		tasaCambio.setBaseUser(baseUser);
		return tasaCambio.calcularDivisaResult();
	}
	
	private void realizarConversiones() {
		setDivisaTxtField();
		setResultadoTabla(new BigDecimal(ventana.getConversionTC().getTXTBase().getText()),4);
	}

	//acciones relacionadas con frame tasa de cambio
	
	public void setDivisaTxtField() {
		String resultado;
		resultado=formateador.formatear(calcularConversion(ventana.getConversionTC().getCBXDivisa().getSelectedItem().toString(),new BigDecimal(ventana.getConversionTC().getTXTBase().getText())).toString());
		ventana.getConversionTC().getTXTDivisa().setText(resultado);
	}
	
	private void activarListeners() {
		addbtnChangeClick();
		addTxtKeyListener();
		addCbxChange(ventana.getConversionTC().getCBXBase(),ventana.getConversionTC().getLblBaseID());
		addCbxChange(ventana.getConversionTC().getCBXDivisa(),ventana.getConversionTC().getLblDivisaID());
		addDoubleClickTablaE();
		addCloseVentanaEvent();
	}

	private void validarTecla(KeyEvent e) {
		
		if(e.getKeyChar()!='.' && !Character.isDigit(e.getKeyChar())) e.consume();
		
		if(e.getKeyChar()=='.' && (ventana.getConversionTC().getTXTBase().getText().contains(".") || ventana.getConversionTC().getTXTBase().getText().equals(""))) e.consume();
		
		if(ventana.getConversionTC().getTXTBase().getText().length()==15) {
			e.consume();
		};
	}
	
	private void addCloseVentanaEvent() {
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
			}
		});
	}
	
	private void addDoubleClickTablaE() {
		JTable tabla=ventana.getTabla();
		tabla.addMouseListener(new MouseAdapter(){  
			public void mouseClicked(MouseEvent e){ 
				if(e.getClickCount()==2) {
					JOPanePers.Personalizar();
					int row=tabla.getSelectedRow();
					String num=tabla.getValueAt(row, 0).toString();
					String nombre=tabla.getValueAt(row, 1).toString();
					String codigo=tabla.getValueAt(row, 2).toString();
					String tasa=tabla.getValueAt(row, 3).toString();
					String resultado=tabla.getValueAt(row, 4).toString();
					JOptionPane.showMessageDialog(ventana, "Información de la moneda\n"
							+ "\nFila: "+num
							+"\nNombre: "+nombre
							+"\nCódigo: "+codigo
							+"\nTasa: "+tasa
							+"\nResultado: "+resultado,"Moneda",1);
				}
			}
		});
	}
	
	private void addCbxChange(JComboBox<String> cbx,JLabel indice) {
		cbx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				indice.setText("Posición: "+ (cbx.getSelectedIndex()+1));
				if(!ventana.getConversionTC().getTXTBase().getText().equals("")) {
					realizarConversiones();
				}
				if(cbx==ventana.getConversionTC().getCBXBase()) {
					setResultadoTabla(new BigDecimal(1),3);
				}
			}
		});
	}
	
	private void addTxtKeyListener() {
		ventana.getConversionTC().getTXTBase().addKeyListener(new KeyListener(){

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
				if(!ventana.getConversionTC().getTXTBase().getText().equals("")) {
					realizarConversiones();
				}
				else{
					ventana.getConversionTC().getTXTDivisa().setText("");
					vaciarResultTabla();
				}
			}
			
		});
	}
	
	private void addbtnChangeClick() {
		ventana.getConversionTC().getBtnChange().addMouseListener(new MouseAdapter(){  
			public void mouseClicked(MouseEvent e){ 
			    String base,divisa;
			    
			    base=ventana.getConversionTC().getCBXBase().getSelectedItem().toString();
			    divisa=ventana.getConversionTC().getCBXDivisa().getSelectedItem().toString();
			    
			    ventana.getConversionTC().getCBXBase().setSelectedItem(divisa);
			    ventana.getConversionTC().getCBXDivisa().setSelectedItem(base);
			}  
		});
	}

}
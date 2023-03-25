package conversoresApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;

import aplicaciones.sistemasNumericos.SistemasNumericosApp;
import aplicaciones.tasaCambio.TasaCambioApp;
import aplicaciones.temperatura.TemperaturaApp;
import conversoresApp.conversoresVista.ConversoresForm;
import global_helpers.control.ImageSet;

public class ConversoresApp implements ActionListener {
	private ConversoresForm ventana;
	private ArrayList<String> options=new ArrayList<>();
	private ImageSet imageSet;
	
	public ConversoresApp(ConversoresForm v) {
		this.ventana=v;
		llenarOpciones();
	}
	
	public void iniciar() {
		imageSet=new ImageSet();
		activarListeners();
		cargarCombobox();
		ventana.getInteraccionPanel().getBtnSelect().addActionListener(this);
		ventana.setVisible(true);
	}
	
	private void llenarOpciones() {
		options.add("Tasa de cambio de divisas");
		options.add("Conversor de temperatura");
		options.add("Conversor de sistemas numéricos");
	}
	
	private void cargarCombobox() {
		for(int i=0;i<options.size();i++) {
			this.ventana.getInteraccionPanel().getOpcionesCBX().addItem(options.get(i));
		}
	}
	
	public void iniciarTasaCambioApp() {
		TasaCambioApp app=new TasaCambioApp();
		if(app.validacionApis()) {
			ventana.setVisible(false);
			app.iniciar();
			app.setPadre(ventana);
		}
	}
	
	public void iniciarTemperaturaApp() {
		TemperaturaApp app=new TemperaturaApp();
		ventana.setVisible(false);
		app.iniciar();
		app.setPadre(ventana);
	}
	
	public void iniciarSistemNumerApp() {
		SistemasNumericosApp app=new SistemasNumericosApp();
		ventana.setVisible(false);
		app.iniciar();
		app.setPadre(ventana);
	}
	
	private void activarListeners() {
		addCloseVentanaEvent();
		addCbxChange(ventana.getInteraccionPanel().getOpcionesCBX());
	}
	
	private void addCbxChange(JComboBox<String> cbx) {
		cbx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbx.getSelectedItem().toString().equals("Tasa de cambio de divisas")) {
					ventana.getInteraccionPanel().getLblFondo().setIcon(imageSet.getIcon("/aplicaciones/tasaCambio/imagenes/monedasWorld.jpg",500,150));;
				}
				else if(cbx.getSelectedItem().toString().equals("Conversor de temperatura")) {
					ventana.getInteraccionPanel().getLblFondo().setIcon(imageSet.getIcon("/aplicaciones/temperatura/imagenes/casa.jpg",500,150));;
				}
				else if(cbx.getSelectedItem().toString().equals("Conversor de sistemas numéricos")) {
					ventana.getInteraccionPanel().getLblFondo().setIcon(imageSet.getIcon("/aplicaciones/sistemasNumericos/imagenes/remolino_numeros.jpg",500,150));;
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ventana.getInteraccionPanel().getBtnSelect()) {
			int option=ventana.getInteraccionPanel().getOpcionesCBX().getSelectedIndex();
			switch(option) {
				case 0:
					iniciarTasaCambioApp();
				break;
				case 1:
					iniciarTemperaturaApp();
				break;
				case 2:
					iniciarSistemNumerApp();
				break;			
			}
		}
	}
	
	private void addCloseVentanaEvent() {
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0); 
			}
		});		
	}
	
}

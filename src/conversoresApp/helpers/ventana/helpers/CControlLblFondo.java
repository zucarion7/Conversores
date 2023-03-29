package conversoresApp.helpers.ventana.helpers;

import javax.swing.JLabel;

import global_helpers.control.ImageSet;

public class CControlLblFondo {

	private JLabel fondo;
	private ImageSet imageSet;
	
	public CControlLblFondo(JLabel fondo) {
		this.fondo=fondo;
	}
	
	public void iniciar() {
		imageSet=new ImageSet();
	}
	
	public void cambiarFondo(String seleccion) {
		
		switch(seleccion) {
			case "Tasa de cambio de divisas":
				fondo.setIcon(imageSet.getIcon("/aplicaciones/tasaCambio/imagenes/monedasWorld.jpg",500,150));;
			break;
			case "Conversor de temperatura":
				fondo.setIcon(imageSet.getIcon("/aplicaciones/temperatura/imagenes/casa.jpg",500,150));;
			break;
			case "Conversor de sistemas numéricos":
				fondo.setIcon(imageSet.getIcon("/aplicaciones/sistemasNumericos/imagenes/remolino_numeros.jpg",500,150));;
			break;			
		}
	}
}

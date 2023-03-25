package global_helpers.control;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageSet {

	
	public Icon getIcon(String url,int ancho,int alto) {
		ImageIcon icon=new ImageIcon(getClass().getResource(url));
		ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho,alto,Image.SCALE_DEFAULT));
		return (Icon) icono;
	}
}

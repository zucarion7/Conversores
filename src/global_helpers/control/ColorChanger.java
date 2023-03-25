package global_helpers.control;

import java.awt.BorderLayout;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;

import global_helpers.vista.ZFrame;

@SuppressWarnings("serial")
public class ColorChanger extends JDialog {
	
	private JColorChooser colorChooser;
	private ZFrame frame;
	
	public ColorChanger(ZFrame owner,boolean modal) {
		super(owner,modal);
		
		this.frame=owner;
		this.colorChooser=new JColorChooser();
		
		add(colorChooser,BorderLayout.CENTER);
		pack();

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		addBackgroundColor();
		
	}
	
	public void addBackgroundColor() {
		colorChooser.getSelectionModel().addChangeListener((ChangeEvent e)->{
			frame.setColorBackground(colorChooser.getColor());
		});
	}
}

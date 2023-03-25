package global_helpers.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import global_helpers.control.ImageSet;

@SuppressWarnings("serial")
public class Footer extends JPanel{
	private JPanel redesPanel;
	private JPanel copyPanel;
	private JButton gitHub;
	private JButton instagram;
	private JButton linkedin;
	private JLabel lblCopy;
	private ImageSet imageSet;
	
	public Footer() {
		initComponent();
	}
	
	public void initComponent() {
		
		imageSet=new ImageSet();

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.blue));
		setOpaque(false);
		setPreferredSize(new Dimension(0,170));

		redesPanel=new JPanel();
		redesPanel.setLayout(new FlowLayout());
		redesPanel.setOpaque(false);
		add(redesPanel,BorderLayout.CENTER);
		
		copyPanel=new JPanel();
		copyPanel.setLayout(new FlowLayout());
		copyPanel.setOpaque(false);
		add(copyPanel,BorderLayout.SOUTH);
		
		gitHub=new JButton();
		gitHub.setPreferredSize(new Dimension(40,40));
		gitHub.setOpaque(false);
		gitHub.setContentAreaFilled(false);
		gitHub.setIcon(imageSet.getIcon("/imagenes/github.png",60,60));
		addVinculo(gitHub,"https://github.com/zucarion7");
		redesPanel.add(gitHub);
		
		instagram=new JButton();
		instagram.setPreferredSize(new Dimension(40,40));
		instagram.setOpaque(false);
		instagram.setContentAreaFilled(false);
		instagram.setIcon(imageSet.getIcon("/imagenes/instagram.png",40,40));
		addVinculo(instagram,"https://www.instagram.com/zucarion7/");
		redesPanel.add(instagram);
		
		linkedin=new JButton();
		linkedin.setPreferredSize(new Dimension(40,40));
		linkedin.setOpaque(false);
		linkedin.setContentAreaFilled(false);
		linkedin.setIcon(imageSet.getIcon("/imagenes/linkedin.png",60,60));
		addVinculo(linkedin,"https://www.linkedin.com/in/zucarion7/");
		redesPanel.add(linkedin);
		
		lblCopy = new JLabel();
		lblCopy.setIcon(imageSet.getIcon("/imagenes/logoRedStyle.png",300,100));
		copyPanel.add(lblCopy);
	}

	public void addVinculo(JButton boton,String url) {
		boton.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e){ 
		    	try {
		    		java.awt.Desktop desktop=java.awt.Desktop.getDesktop();
		    		java.net.URI uri=new java.net.URI(url);
					desktop.browse(uri);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No fue posible abir la página");
				}
		    }  
		});
	}
	
}

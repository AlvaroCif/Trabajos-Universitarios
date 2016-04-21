package Modelodediseño.Presentacion.Vistas.Imp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenFondo extends JPanel
{
	ImageIcon imagen;
	
	public ImagenFondo(String nombre)
	{
		super();
		initialize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		this.setSize(imagen.getIconWidth(),imagen.getIconHeight());
		
	}
	
	protected void paintComponent(Graphics g) 
	{
		Dimension d = this.getSize();
		g.drawImage(imagen.getImage(),0,0,d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
	
	private void initialize() 
	{
		this.setSize(300,200);
		this.setLayout(new GridBagLayout());
	}
}

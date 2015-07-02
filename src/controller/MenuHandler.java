package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import util.FinalFile;
import view.Frame;

public class MenuHandler extends MouseAdapter{
     private Frame main;
     
	
    
	public MenuHandler(Frame main) {
		super();
		this.main = main;
	}


    @Override 
    public void mousePressed(MouseEvent arg0){
    	JButton button = (JButton)arg0.getSource();
    	if(button.getIcon()== FinalFile.HappyFace_ICON){
    		main.restart();
    	}
    }
	
}

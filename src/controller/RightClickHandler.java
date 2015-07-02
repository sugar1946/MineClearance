package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import model.ComputeModel;

import util.FinalFile;
import view.Frame;

public class RightClickHandler extends MouseAdapter{
	private Frame main;
	
	public RightClickHandler(Frame main) {
		super();
		this.main = main;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		// TODO Auto-generated method stub
		if(arg0.isPopupTrigger()) { //right click 
			
			
			JButton button = (JButton)arg0.getSource();
			if( ! (button.getBorder() == FinalFile.BOD_2)){
			if(button.getIcon()==null){
				if(Integer.parseInt(main.getBoom().getText())>0){
				button.setIcon(FinalFile.Flag_ICON);
				main.getBoom().setText(
		        		ComputeModel.formatNum(Integer.parseInt(main.getBoom().getText())-1)+"");
			}}
			else if(button.getIcon() == FinalFile.Flag_ICON){
				button.setIcon(FinalFile.questionMark_ICON);
		        main.getBoom().setText(
		        		ComputeModel.formatNum(Integer.parseInt(main.getBoom().getText())+1)+"");
			}
			else{button.setIcon(null);}}}
		if(ComputeModel.isEnded(main.getButton(), main.getBoomPosn(), main.getBoomNum(), main.getBwidth()))
		{main.Win();}
	
	}
			
		
	  
	

}

package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import model.ComputeModel;
import util.FinalFile;
import view.Frame;

public class BoomHandler implements ActionListener {
	
	private Frame main;
	private int row, col;
	
	public BoomHandler(Frame main, int row, int col){
		super();
		this.main = main;
		this.row = row;
		this.col = col;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		setType(row, col);
		if(ComputeModel.isEnded(main.getButton(), main.getBoomPosn(), main.getBoomNum(), main.getBwidth()))
		{main.Win();}
	
	}
	
	public void setType(int row, int col){
		
		// TODO Auto-generated method stub
		JButton button = main.getButton()[row][col];
		button.setBorder(FinalFile.BOD_2);
		System.out.println(ComputeModel.getPosn(row, col, main.getBwidth()));
		int boomCount = ComputeModel.getBoomCount(row, col, main.getBoomPosn(),main.getBwidth(), main.getBheight());
		if(ComputeModel.isBoom(row, col,main.getBoomPosn(),main.getBwidth())){
			button.setBackground(Color.RED);
			button.setOpaque(true);
			button.setBorder(FinalFile.BOD_2);
			showAll();
			main.Lost();
		}
		else if(boomCount != 0){
		   MouseListener[] ml = button.getMouseListeners();
		   button.setText(boomCount+"");
//		   for(MouseListener x : ml)
//		      {button.removeMouseListener(x);}
		   }
		else if(boomCount==0){
			int bounds[][] = ComputeModel.getSurroudingBoom(row, col);
			for(int i=0;i<bounds.length;i++){
				if(ComputeModel.isLegal(bounds[i][0], bounds[i][1], main.getBwidth(), main.getBheight())){
					       JButton recursiveButton = main.getButton()[bounds[i][0]][ bounds[i][1]];
					
						if(recursiveButton.getBorder() != FinalFile.BOD_2){
							setType(bounds[i][0],bounds[i][1]);}
				}
			}
		}
	}
	
	public void showAll(){
		JButton[][] button = main.getButton();
		for(int i=0;i<main.getBheight();i++){
			for(int j=0; j< main.getBwidth();j++){
				JButton but = button[i][j];
				int boomCount = ComputeModel.getBoomCount(i, j, main.getBoomPosn(),main.getBwidth(), main.getBheight());

			if(ComputeModel.isBoom(i, j,main.getBoomPosn(),main.getBwidth())){
				button[i][j].setBackground(Color.RED);
				button[i][j].setOpaque(true);
				button[i][j].setBorder(FinalFile.BOD_2);
			}
			
			else if(boomCount !=0){ but.setText(boomCount+"");but.setBorder(FinalFile.BOD_2);}
			else { but.setBorder(FinalFile.BOD_2);}
		}
	}
	
	}
	
}


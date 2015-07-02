package controller;

import javax.swing.JButton;

import model.ComputeModel;
import util.FinalFile;
import view.Frame;

public class TimeHandler extends Thread{
	private Frame main;
	private boolean isRunning = true;
	
	public TimeHandler(Frame main){
		this.main = main;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
				while(isRunning == true){
				main.getTime().setText(ComputeModel.formatNum(Integer.parseInt(main.getTime().getText())+1)+"");
				this.sleep(1000);}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
	
	public void kill(){
		isRunning = false;
	}
	
	public void restart(){
		isRunning = true;
		
	}
	
	
	
	
	
}

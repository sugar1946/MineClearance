package view;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import util.FinalFile;
import model.ComputeModel;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BoomHandler;
import controller.MenuHandler;
import controller.RightClickHandler;
import controller.TimeHandler;

public class Frame extends JFrame{
        private JButton button[][], start;
        private JPanel boomPanel,typePane;
        private JTextField time, boom;
        private int boomNum, bwidth, bheight;
        private int[] BoomPosn;
        private TimeHandler timer;
        
        
        public Frame(){
        	super("MineClearance");
        	boomNum = FinalFile.LEVEL_1_BOOM;
        	bwidth = FinalFile.LEVEL_1_WIDTH;
        	bheight = FinalFile.LEVEL_1_HEIGHT;
        	
        	//boom set
        	BoomPosn = ComputeModel.getRandomBoomPons(bwidth, bheight, boomNum);
        	for(int i=0;i<BoomPosn.length;i++){System.out.println("BoomPosn"+ BoomPosn[i]);};
        	
        	int size[] = ComputeModel.getWindowWidth(bwidth, bheight);
        	this.setBounds(200,200,size[0],size[1]);
        	this.setLayout(null);
        	
        	
        	// Menu Panel
        	typePane = new JPanel(new FlowLayout(FlowLayout.CENTER,20,2));
        	typePane.setBounds(5, 5, size[0]-8, FinalFile.GRIDWIDTH*2-8 );
        	typePane.setBorder(FinalFile.BOD_0);
        	this.add(typePane);
        	
        	// Boomb
        	boom = new JTextField("0"+boomNum );
        	time = new JTextField("000");
        	typePane.add(boom);
        	
        	start = new JButton(FinalFile.HappyFace_ICON);
        	start.setBorder(FinalFile.BOD_0);
        	start.addMouseListener(new MenuHandler(this));
        	typePane.add(start);
        	typePane.add(time);
        	
        	//Boom Panel
        	boomPanel = new JPanel(new GridLayout(bwidth,bheight));
        	boomPanel.setBounds(5,FinalFile.GRIDWIDTH*2-8+10, FinalFile.GRIDWIDTH * bwidth+8+2, FinalFile.GRIDWIDTH*bheight+2);
        	boomPanel.setBorder(FinalFile.BOD_1);
        	this.add(boomPanel);
        	
        	button = new JButton[bheight][bwidth];
        	for(int i = 0 ; i< bheight ; i++){
        		for(int j= 0; j < bwidth ; j++){
        			button[i][j] = new JButton();
        			boomPanel.add(button[i][j]);
        			button[i][j].setBorder(FinalFile.BOD_0);
        			button[i][j].setBackground(Color.LIGHT_GRAY);
        			button[i][j].addActionListener(new BoomHandler(this,i,j));
        			button[i][j].addMouseListener(new RightClickHandler(this));
        			
        		}
        	}
        	
        	this.setVisible(true);
        	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
        	//Start Timer
        	timer = new TimeHandler(this);
        	timer.run();
        	
        }


		public JButton[][] getButton() {
			return button;
		}


		public void setButton(JButton[][] button) {
			this.button = button;
		}


		public JButton getStart() {
			return start;
		}


		public void setStart(JButton start) {
			this.start = start;
		}


		public JPanel getBoomPanel() {
			return boomPanel;
		}


		public void setBoomPanel(JPanel boomPanel) {
			this.boomPanel = boomPanel;
		}


		public JPanel getTypePane() {
			return typePane;
		}


		public void setTypePane(JPanel typePane) {
			this.typePane = typePane;
		}


		public JTextField getTime() {
			return time;
		}


		public void setTime(JTextField time) {
			this.time = time;
		}


		public JTextField getBoom() {
			return boom;
		}


		public void setBoom(JTextField boom) {
			this.boom = boom;
		}


		public int getBoomNum() {
			return boomNum;
		}


		public void setBoomNum(int boomNum) {
			this.boomNum = boomNum;
		}


		public int getBwidth() {
			return bwidth;
		}


		public void setBwidth(int bwidth) {
			this.bwidth = bwidth;
		}


		public int getBheight() {
			return bheight;
		}


		public void setBheight(int bheight) {
			this.bheight = bheight;
		}


		public int[] getBoomPosn() {
			return BoomPosn;
		}


		public void setBoomPosn(int[] boomPosn) {
			BoomPosn = boomPosn;
		}
		
		public void restart(){
			
			timer.restart();
			timer.start();
			
			//boom set
        	BoomPosn = ComputeModel.getRandomBoomPons(bwidth, bheight, boomNum);
        	for(int i=0;i<BoomPosn.length;i++){System.out.println("BoomPosn"+ BoomPosn[i]);};
        	
        	// Menu Panel
        	
        	boom.setText("0"+boomNum );
        	time.setText("000");
        	
        	
        	//Boom Panel
        	boomPanel.removeAll();
        	boomPanel.setBounds(5,FinalFile.GRIDWIDTH*2-8+10, FinalFile.GRIDWIDTH * bwidth+8+2, FinalFile.GRIDWIDTH*bheight+2);
        	boomPanel.setBorder(FinalFile.BOD_1);
        	
        	button = new JButton[bheight][bwidth];
        	for(int i = 0 ; i< bheight ; i++){
        		for(int j= 0; j < bwidth ; j++){
        			button[i][j] = new JButton();
        			boomPanel.add(button[i][j]);
        			button[i][j].setBorder(FinalFile.BOD_0);
        			button[i][j].setBackground(Color.LIGHT_GRAY);
        			button[i][j].addActionListener(new BoomHandler(this,i,j));
        			button[i][j].addMouseListener(new RightClickHandler(this));
        			
        		}
        	}
        	
        	this.setVisible(true);
        	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //	timer.restart();
        }
		
		//Lose the game
		
		public void Lost(){
			for(int i = 0 ; i< bheight ; i++){
       		for(int j= 0; j < bwidth ; j++){
        			ActionListener[] al = button[i][j].getActionListeners();
        			MouseListener[] ml = button[i][j].getMouseListeners();
        		for(ActionListener x : al){
        			button[i][j].removeActionListener(x);}
        		for(MouseListener x : ml){
        			button[i][j].removeMouseListener(x);}

			boomPanel.validate();
		}
       		timer.kill();
			}}
		
		public void Win(){
			this.dispose();
		}
		
}

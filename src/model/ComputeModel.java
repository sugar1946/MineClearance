package model;

import java.text.DecimalFormat;

import javax.swing.JButton;

import util.FinalFile;

public class ComputeModel {
	// Computer the size of window
	public static int[] getWindowWidth(int bwight, int bheight){
		int width = util.FinalFile.GRIDWIDTH * bwight  + 10 + 8;
		int height = util.FinalFile.GRIDWIDTH * bheight + 10 + 8 + util.FinalFile.GRIDWIDTH *2 +10 +5;
		
		return new int[]{width,height};
	}

	//Random boom
	public static int[] getRandomBoomPons(int bwidth, int bheight, int boomNum){
		int[] posn = new int[boomNum];
		int maxPosn = bwidth*bheight;
		
		posn[0] = (int) (Math.random() * maxPosn) +1;
	    for(int i = 0; i<posn.length;){
	    	int temp = (int)(Math.random() * maxPosn) +1 ;
	    	boolean flag = true;  
	        for (int j=0 ;j<i;j++){
	        	if (temp == posn[j]) flag=false; break;}
	        
	    	if (flag){posn[i] = temp;i++;}
	    }
	     return posn;
}
	
    //Compute the posn of boom
	public static int getPosn(int row, int col, int bWidth){
		return row*bWidth + col+1;}
		
    //Determine if it is boom
	public static boolean isBoom(int row, int col, int[] boomPosn,int bWidth){
		int posn = getPosn(row,col,bWidth);
		for(int i = 0; i < boomPosn.length; i++){
			if (posn == boomPosn[i]){return true;}
		}
		return false;
	}
	
    // Compute the number around the boom
	public static int getBoomCount(int row, int col, int[] BoomPosn,int bwidth, int bheight){
		int count = 0;
		int[][] SurroudingBoom = getSurroudingBoom(row,col);
		for(int i = 0 ; i< SurroudingBoom.length;i++ ){
			if(isLegal(SurroudingBoom[i][0],SurroudingBoom[i][1],bwidth,bheight)){
				if(isBoom(SurroudingBoom[i][0],SurroudingBoom[i][1],BoomPosn,bwidth))
						{count++;}
		}}
		
		return count;
	}
	
	//compute the grid is legal or not
	public static boolean isLegal(int row,int col, int bwidth,int bheight){
		if(row<0||row >= bheight){return false;}
		if(col<0|| col>= bwidth){return false;}
		return true;
	}
	
	// compute the surrounding boom 
	public static int[][] getSurroudingBoom(int row,int col){
	   return new int[][] {{row-1,col-1},
			   			   {row-1, col},
	   						{row-1,col+1},
	   						{row,col-1},
	   						{row,col+1},
	   						{row+1,col-1},
	   						{row+1,col},
	   						{row+1,col+1}};
	}
	
	// formulate the number view
	public static String formatNum(int num){
		DecimalFormat df = new DecimalFormat("000");
		return df.format(num);
	}
	
	 public static boolean isWin(JButton[][] button, int[] BoomPosn, int BoomNum,int bwidth){
		    
			int boomNum = BoomNum;
		  for(int i = 0; i<button.length;i++){
				for(int j=0; j<button[i].length;j++){
					 if(ComputeModel.isBoom(i, j, BoomPosn, bwidth)){
						if(button[i][j].getIcon()==FinalFile.Flag_ICON){
							boomNum--;
							if(boomNum == 0 ){ return true;}}}}}
			
			return false;
			
	   }
	
		public static boolean isEnded(JButton[][] button, int[] BoomPosn, int BoomNum,int bwidth){
			
			for(int i = 0; i<button.length;i++){
				for(int j=0; j<button[i].length;j++){
					if((button[i][j].getBorder()==FinalFile.BOD_2)&&isWin(button,BoomPosn, BoomNum,bwidth)){return true;}
				}}
			return false;
			
			}
	

}

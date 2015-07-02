package util;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public interface FinalFile {
      //Level
	  // Level 1
	    int LEVEL_1_WIDTH = 9;
	    int LEVEL_1_HEIGHT = 9;
	    int LEVEL_1_BOOM = 10;
	  // Level 2S
	    int LEVEL_2_WIDTH = 16;
	    int LEVEL_2_HEIGHT = 16;
	    int lEVEL_2_BOOM = 40;
	  // Level 2
	    int LEVEL_3_WIDTH = 30;
	    int LEVEL_3_HEIGHT = 16;
	    int LEVEL_3_BOOM = 99;
	    
	 // Width of each grid
	    int GRIDWIDTH = 20;
	    
	 // Border
	    Border BOD_0 = BorderFactory.createBevelBorder(0); // Raise
	    Border BOD_1 = BorderFactory.createBevelBorder(1); // Lower
	    Border BOD_2 =  new LineBorder(Color.GRAY);
	//  Icon
	    Icon HappyFace_ICON = new ImageIcon("image/faceIcon.jpg");
	    Icon Flag_ICON = new ImageIcon("image/flag.jpg");
	    Icon Boomb_ICON = new ImageIcon("image/Boomb.jpg");
	    Icon questionMark_ICON = new ImageIcon("image/questionMark.jpg");
	    
}

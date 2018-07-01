////////////////////////////   |>>>>>>>  AHMED DONMEZ   <<<<<<<|  /////////////////////////////////////////////////////
/////////////////////////////////  |>>>>>>>    141024008     <<<<<<<|  ////////////////////////////////////////////////
/////////////////////////////////////  |>>>>>>>    BILGISAYAR MUHENDISLIGI   <<<<<<<|   ///////////////////////////////


import java.awt.*;
import javax.swing.*;

public class main {
	
	public static void main(String args[]) {
		
		SkylineProblem skyline = new SkylineProblem();  // just created an object to print output
                System.out.println("\n  Hocam outputdaki noktalari yanyana yazdirdigimdan terminal ekraninda parantezler asagi kayabiliyor \n ");
                System.out.println("\n ----------------- OUTPUT ------------------\n");
		skyline.printOutput();
		
		UserFace userface = new UserFace();  // to show rectangles and output on coordinate system, I create an instance of userFace
		JFrame frame = new JFrame("Skyline_Problem");
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		label1.setText("A - )  Original Problem Rectangles ");
		label1.setFont(new Font("Calibri", Font.BOLD, 18)); 
		label1.setBounds(45, 220, 350, 260);
		label1.setForeground(Color.BLACK);
		
		
		
		label2.setText(" B - )  After Skyline Problem Solution");
		label2.setFont(new Font("Calibri" , Font.BOLD, 18));
		label2.setBounds(510, 230, 555, 240);
		label2.setForeground(Color.BLACK);
		
		
		
		frame.setSize(1000, 500);	
		userface.setBackground(Color.white);
		frame.add(label1);  //just added all labels and userFace object
		frame.add(label2);
		frame.add(userface);
		
		frame.setVisible(true);  // to see it I made it visible
	
	
		
		
	}

}

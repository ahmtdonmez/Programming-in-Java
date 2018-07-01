////////////////////////////   |>>>>>>>  AHMED DONMEZ   <<<<<<<|  /////////////////////////////////////////////////////
/////////////////////////////////  |>>>>>>>    141024008     <<<<<<<|  ////////////////////////////////////////////////
/////////////////////////////////////  |>>>>>>>    BILGISAYAR MUHENDISLIGI   <<<<<<<|   ///////////////////////////////


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import javafx.util.Pair;

public class UserFace extends JPanel {
	
	private ArrayList<Color> colors;  // to keep colors that I will define with their RGB codes
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Pair<Integer,Integer>> output;

	public void paint(Graphics graphic) {
		super.paintComponent(graphic);
		
		SkylineProblem skyline= new SkylineProblem();  // I made an instance of SkylineProblem to get output
		ReadFile readfile = new ReadFile(); // created an object to get rectangleList
		output = new ArrayList<>();
		rectangleList = readfile.getAllRectangles();
		
		output = skyline.getOutput();
	
        setColors();
        
		this.setBackground(Color.white);
		
	    setCoordinate(graphic);
	    
	    drawOutput(graphic);
	    
	    drawRectangles(graphic);
		
		
	}
	
	private void setColors() {
		
        colors =new ArrayList<>();
        
        Color myColor = new Color(101, 128 ,187);  // I just defined good colors for graphic  I used RGB values
        colors.add(myColor);
        myColor = new Color(198,154,156);
        colors.add(myColor);
        myColor= new Color(253,178,111);
        colors.add(myColor);
        myColor = new Color(81,201,174);
        colors.add(myColor);
        myColor = new Color(81,155,174);
        colors.add(myColor);
        myColor = new Color(139,178,11);
        colors.add(myColor);
        myColor = new Color(189,140,206);
        colors.add(myColor);
        myColor= new Color(75,117,219);
        colors.add(myColor);
        myColor = new Color(75,172,179);
        colors.add(myColor);
        
		
	}
	
	private void setCoordinate(Graphics graphic) {  
		
		Graphics2D g2 = (Graphics2D) graphic;
		
		g2.setStroke(new BasicStroke(2));  // I increment thickness of line
		graphic.setColor(Color.BLACK);
		graphic.drawLine(20, 10, 20, 300);   // coordinate system for rectangles 
		graphic.drawLine(470, 10, 470, 300);  // coordinate system for output 
		g2.setStroke(new BasicStroke(2));
		graphic.drawLine(20, 300, 400, 300);
		graphic.drawLine(470, 300, 850, 300);
		
		
		
		
	}
	
	private void drawRectangles(Graphics graphic) { // it will draw rectangles
		
		int width = 0;
		int height = 0;
		int start = 0;
		int end = 0;
		int i = 0;
		int count = 0;
		
		while(i < rectangleList.size()) {
			
			start = rectangleList.get(i).getStartingPointOfX()*10 + 20 ; // I multiplied  with 10 like taking zoom and increment with 20 because my coordinate for rectangles starts with 20 
			end = rectangleList.get(i).getEndOfX()*10+20;  // same thing for end value
			width = end - start;
			height = 300 - rectangleList.get(i).getEndOfY()*20;  // I just make it more zoom and subtract from 300 because my coordinate system Y points end with 300 and I have to move back
			
			graphic.setColor(colors.get(count));
			graphic.fillRect(start, height, width, rectangleList.get(i).getEndOfY()*20);  // multiplied Y 20 to see better on screen
			graphic.drawRect(start, height, width, rectangleList.get(i).getEndOfY()*20);
		
			i++;
			
			count++;
			
			if(count >= colors.size())  // if rectangle count more then my color list size then I have to go back start
				count = 0;
		
		}
	
	}
	
	private void drawOutput(Graphics graphic) {
		
		int i = 0;

		while(i < output.size()) {
			// I did same thing like rectangles 
			output.set(i, new Pair<Integer, Integer>(output.get(i).getKey()*10,output.get(i).getValue()*20));
			output.set(i, new Pair<Integer, Integer>(output.get(i).getKey()+470, 300 - output.get(i).getValue()));
			//added 470 because my coordinate system for output will start that from that point
			//subtract from 300 because coordinate system ends with 300 
			i++;
		}
	
		i=0;
		
		while(i < output.size() -1) { // I just draw line between two points
		   graphic.setColor(Color.BLACK);
		   graphic.drawLine(output.get(i).getKey(), output.get(i).getValue(), output.get(i+1).getKey(), output.get(i+1).getValue());
		   i++;
		  
	
		}
	}

}

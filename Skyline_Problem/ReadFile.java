////////////////////////////   |>>>>>>>  AHMED DONMEZ   <<<<<<<|  /////////////////////////////////////////////////////
/////////////////////////////////  |>>>>>>>    141024008     <<<<<<<|  ////////////////////////////////////////////////
/////////////////////////////////////  |>>>>>>>    BILGISAYAR MUHENDISLIGI   <<<<<<<|   ///////////////////////////////


import java.io.*;
import java.util.*;

public class ReadFile {
	
	private Scanner sc;
	private ArrayList<Rectangle> rectangleList;  // it will keep all of rectangles which is defined in data.txt
	
	public ReadFile() {
		
		rectangleList = new ArrayList<>();
		openFile();
		setRectangles();  //I called my function to create rectangles depending on the file which is called data.txt
		sortRectangles();  // I just sort it here to use after creating object
		
	}
	
	private void openFile() {
		
		try {
			sc = new Scanner(new File("data.txt"));   // I just read all of data from file inside the try catch block
			
		}catch(Exception e) {
			
			System.out.println("can not find file");
		}
		
		
	}
	
	public ArrayList<Rectangle> getAllRectangles(){
		
		return rectangleList;
	}
	
	private void setRectangles() {
		
		int width = 0,height= 0, position = 0;
		openFile();
		
		Rectangle rectangle;
		
		while(sc.hasNext()) {
			
		    rectangle = new Rectangle();  // I set rectangle as a new one 
			
	        width = sc.nextInt();
	        
	        if(sc.hasNext())
	        	height = sc.nextInt();
	       
	        if(sc.hasNext())
	        	position = sc.nextInt();
	        
	        rectangle.setX(position, width);  // I set all of my rectangle information before adding list
	        rectangle.setY(position, height);
	        rectangle.setPosition(position);
	        
	        
	        rectangleList.add(rectangle);  // I added to list before rectangle is changed
	             
	        
		}
			
	}
	
	
	private void sortRectangles() {
		
		int i = 0;
		int j = 0;
		
		while(i < rectangleList.size()) {
			while(j < rectangleList.size()) {
				
				if(rectangleList.get(i).compareTo(rectangleList.get(j))) { //I used my compareTo function and see which one is small
					Rectangle temp = new Rectangle();  // to change order of rectangles I need a temporary rectangle
					temp = rectangleList.get(i);   // before change that object I get a copy 
					rectangleList.set(i, rectangleList.get(j));  //I change the order
					rectangleList.set(j, temp);
				}
				
				j++;
			}
			
			i++;
			j= 0;  // I just assigned it to zero to start comparing from the beginning
		}
		
	}
	
	
	
}




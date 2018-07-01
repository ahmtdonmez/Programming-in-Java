///////////////////////////////////////   |>>>>>>>  AHMED DONMEZ   <<<<<<<|  //////////////////////////////////////////////////////////////////
///////////////////////////////////////////////  |>>>>>>>    141024008     <<<<<<<|  //////////////////////////////////////////////////////////
/////////////////////////////////////////////////  |>>>>>>>    BILGISAYAR MUHENDISLIGI   <<<<<<<|   ///////////////////////////////////////////

import java.util.ArrayList;
import javafx.util.Pair;

public class SkylineProblem{
	
	private int startPoint;
    private int endPoint;
    private ArrayList<Pair<Integer, Integer>> output;
    private ArrayList<Rectangle> rectangleList;
    
    public SkylineProblem() {
    	
    	output = new ArrayList<>();
    	rectangleList = new ArrayList<>();
    	ReadFile file = new ReadFile();
    	rectangleList = file.getAllRectangles();
    	startPoint = rectangleList.get(0).getStartingPointOfX();  // I already sorted rectangles so first rectangle will keep first rectangle 
    	findEndOfX(); // to assign endPoint I just called my function
    	solveProblem();
    
    	
    }
    
    private void findEndOfX() {  //this function will find and assign bigger x value with the help of looking rectangles7

    	int max = 0;
    	
    	for(Rectangle list : rectangleList) 
    		if(max < list.getEndOfX())
    			max = list.getEndOfX();
    	
    
    	endPoint = max;
  
    }
    
  
    public ArrayList<Pair<Integer, Integer>> getOutput(){
    	
    	return output;
    }
    
    
    
	private boolean checkRect(int x_axis, int rectNo) {  // with this function I will check if any rectangle includes coming rectangle or not

		for(Rectangle list : rectangleList) {
			//now  checking if rectangles has that x_axis or not and if coming rectangular inside other rectangles than this condition will be right
    		if(list.checkByValue(x_axis) && rectangleList.get(rectNo).getEndOfY() > list.getEndOfY()) 
    				return false;
    		
    		if(rectangleList.get(rectNo).getStartingPointOfX() > list.getStartingPointOfX()) 
    			if(rectangleList.get(rectNo).getEndOfX() < list.getEndOfX() )  // one rectangle is includes one of rectangle totally then I am returning false
    				return false;
		}
		
		return true;  // if other conditions are wrong then no problem return true
		
	}
	
	
	private boolean getInfoForPoint(int x_axis , boolean choose) { 
		// Depending choose return value will be change 
		//if choose 1 I will check if any rectangle includes that point beside their start end end points and if it is then return will be true
		// if choose 2 then I will check if any rectangle starts with that point  and return false if any one starts
		 // this function will help to know if any rectangle ends and other rectangles starts with that point. And if there is a rectangle includes that point
		// beside their starting and ending point
		
    	for(Rectangle list : rectangleList) {
    		if(list.checkInRectangle(x_axis) && choose)
    			return false;
    		
    		if(x_axis == list.getStartingPointOfX())
    			return false;
    		
    	}
 	
		return true;
		
	}

	
	private int getBigger(int x_axis) {  //this function returns max Y value , it is looking x point in all of rectangles and finds max y point of them
		
		int max = 0;
		for(Rectangle list : rectangleList) 
			if(list.checkByValue(x_axis) && max < list.getEndOfY())
				max = list.getEndOfY();
			
	
		
		return max;
	}
	
	private void addToOutput(int x1, int y1 , int x2, int y2, boolean choose) {
		// its just adding coming points to my output ArrayList , I defined boolean choose to know adding one or two Pair to my output
		Pair<Integer,Integer> temp1 = new Pair<>(x1,y1);
		Pair<Integer, Integer> temp2 = new Pair<>(x2,y2);
		
		
		 if(!output.contains(temp1)) // I added in my ArrayList if it is not added before
		     output.add(temp1);
				
		 if(!output.contains(temp2) && choose)
			 output.add(temp2);
		
		
	}
	
	public void printOutput() {
		for(Pair<Integer,Integer> out: output)
			System.out.printf(" ( %d , %d ) , ", out.getKey(),out.getValue());
	}
    

	private void solveProblem() {  
    	//I created this function to check the x_axis one by one and check if there is a problem or not
    	
    	int count = 0, count2 = 0, count3 = 0;
    	int min = 0, max = 0, max2 = 0;
    	int height = 0;
    	boolean check = false;
    	
    	int bigger = getBigger(rectangleList.get(0).getStartingPointOfX()); //keeps the bigger Y value for the position that rectangles are start

    	addToOutput(rectangleList.get(0).getStartingPointOfX(),0,rectangleList.get(0).getStartingPointOfX(), bigger,true);
    	
    	for(int i = startPoint+1; i <= endPoint; i++) {  // I just take a loop to check starting point to end point
    	
    		while(count < rectangleList.size()) {   // i point can be inside more than one rectangle, to handle that I defined this loop to handle it
    			
    			if(i == rectangleList.get(count).getStartingPointOfX()) { // This condition defined to check if there is a higher Y value 
    				height = rectangleList.get(count).getEndOfY();  // and if it is I just keep that rectangle height before getting higher Y value
    	            int temp = getBigger(i+1);  //there is no rule for every start point will move on bigger Y value so if i+1 == height then I havent bigger start
    				for(int j = 0; j<count; j++) {  // Then I open another loop to check if any other rectangular consist i point.
    					
    			    	if(rectangleList.get(j).checkByValue(i)) { //I used my function to check it and if its right then I will define max of them
    					    if(max < rectangleList.get(j).getYForValue(i)) {  //I just check which one is bigger 
    						    max = rectangleList.get(j).getYForValue(i);   // I assigned it to max value before max value change
    						 
    					    }
    					  
    						
    						//height is keeps starting point of any rectangular that i point
    						//if there is any rectangular consist i point then max will keep max y axis value of them
    			    	}
    				}
    				//if temp != height then I have bigger value for i+1 point , that means start point continue with higher Y value
    				//to handle oppoiste of this situation I took temp == height condition
    				if((height>max || temp ==height ) && max!=0 )   // so I have to check if my height bigger then max beside opposite
    					 addToOutput(i,max,i,height,true);
    				 //  max value Y before getting another starting point should add first so I sent it as a first parameter
					 // as a another parameter sent starting point of that bigger rectangle
						
    			}
    			
    			// I implemented if there is higher started point inside any rectangle but what happen if I have small rectangle
    			// so I implemented another if statement down
    			
    			if(i == rectangleList.get(count).getEndOfX() && getInfoForPoint(i,false)) { //checking end point to get in loop getInfo function called to know 
    				//if I had a start for that point. if answer is true then I handled it before starting point condition.
    				
    				height = rectangleList.get(count).getEndOfY(); //before getting loop I assigned my height value for that rectangle
    				max2 = height;  //I will change that value to protect my height value I assigned max2 integer
    				min = max2;  // this integer assigned if there is more than one rectangle at the end point of other rectangles
    				count2 = 0;
    				count3 = 0;
    			
    				for(int j = 0; j<rectangleList.size(); j++) { // another loop to check all of rectangle
    					if(rectangleList.get(j).checkByValue(i)) {  // if that point consist other rectangle then I have to check max2 value
    						if(i != rectangleList.get(j).getEndOfX() ) {  // this condition necessary for my algorithm if I have end of that rectangle x than I have to change condition
    							
       					       if(checkRect(i, j))  {  
    						      if(max2 > rectangleList.get(j).getYForValue(i) ) 
    						          max2 = rectangleList.get(j).getYForValue(i);  // I am keeping max2 value small for others
       					    }
       					    
       					       else {
       					    	
       					          if(max2 < rectangleList.get(j).getYForValue(i) ) 
  						               max2 = rectangleList.get(j).getYForValue(i);  // I am keeping max2 value small for others
     					 
       					       }
       					     
    						}
    						
    						else {
    					       if(i == rectangleList.get(j).getEndOfX()) { // this condition checking if there is other rectangles ending with this point or not
    						 
    					    	   if(j != count ) { // being sure, not taking same rectangle
    					    		   check = true;  // to use later
    							 
    					    		   if(checkRect(i,j)) {
    					    		     if(min > rectangleList.get(j).getEndOfY())  // I am keeping higher rectangle y point because it is including other one
    					    			    min = rectangleList.get(j).getEndOfY();  // assigned it
    					    		   }
    					    		     
    					    		   else
      					    		     if(min < rectangleList.get(j).getEndOfY())  // I am keeping higher rectangle y point because it is including other one
      					    			    min = rectangleList.get(j).getEndOfY();  //
    							 
    					    	   }  
    					       }
    						}
    					}
    					
    					if(!rectangleList.get(j).checkByValue(i+1) ) 
    						count2++;
    	
    					//
    					if(i+1 == rectangleList.get(j).getStartingPointOfX() && getInfoForPoint(i,true)) 
    						count3++;
    					
    					// this condition will check if there is a rectangle ends with point i and after one or more point later other rectangles are starting
    				  // with this condition I increment count3 and if count3 != 0 then I have to add 0 points
    		
    				}
    				if(height>=max2 && max2!=0 && count3 == 0 && getInfoForPoint(i,false) ) { // Just like before I did take same condition  count3 should be zero if not there is a zero point to handle it
    				
    					if(!check )  // if this condition true then I haven't other rectangles that ending with that point
    						addToOutput(i,height,i,max2,true);  // so I just sent parameter considering with their order(two new pair will be add so thats why I sent true
    					 
    					else 
    						addToOutput(i,min,i,max2,true);  // this condition means there are other rectangles so I used min value (keeps bigger rectangle Y axis)
      		
    				}
    				
    				if(count3 != 0) {   // and now it means there are or there is zero point then I am adding points of rectangle that ending with that point before
    					int maxValue = getBigger(i+1);
    					int before = getBigger(i);  // after do that added next point
    					
    					
    					addToOutput(i,before,i,0,true);  //sending values to add output (Considering order) 
    					addToOutput(i+1,0,i+1,maxValue,true);	 //this points calculated on paper 
    					
    				}
    				
    			
    				if(count2 == rectangleList.size() && count3 == 0) {  // this condition will be true if I have spaces between rectangles
    					int point = i;
   					    boolean control3 = true;		
    					 
   					    addToOutput(i,0,0,0,false);
    				
    					 while(point<endPoint) {  // until any rectangle start , I am waiting in the loop and when start poit come I am adding it and getting out from loop
    						 for(int k = 0; k<rectangleList.size(); k++)
    							 if(point == rectangleList.get(k).getStartingPointOfX()) {
    						
    								 addToOutput(point,0,point,rectangleList.get(k).getEndOfY(),true);
    		    					 control3 = false;
    		    					 break;
    								 
    							 }
    						 
    						if(!control3)
    							break;
    						
    						 point++;
    					 }
    					 
    					 i = point; 
    				}
    				
    			}
    		
    	        count++;  // increasing count value not to getting infinite loop
 
    		}
    	
    		max = 0;  //setting values default
    		max2= 0;
    		check = false;
    		count = 0;
    
    	}
    	
    	addToOutput(endPoint,0,0,0,false);  //adding last point to output list
	
    }

}

    
     
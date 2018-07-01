////////////////////////////   |>>>>>>>  AHMED DONMEZ   <<<<<<<|  /////////////////////////////////////////////////////
/////////////////////////////////  |>>>>>>>    141024008     <<<<<<<|  ////////////////////////////////////////////////
/////////////////////////////////////  |>>>>>>>    BILGISAYAR MUHENDISLIGI   <<<<<<<|   ///////////////////////////////

public class Rectangle {
	
	private int start_x;   // keeps start point of x axis
	private int end_x;     //keeps end of x axis
	private int start_y;
	private int end_y;
        private int position;
	
	
	public Rectangle() {
		start_x = 0;
		end_x = 0;
		start_y = 0;  //always will be zero
		end_y = 0;
		position = 0;
	}
	
	
	public void setX(int position, int width) {
		
		start_x = position;
		end_x = width + start_x;
		
	}
	
	public void setY(int position, int height) {
		
		end_y = height;
		
	}
	
	public void setPosition(int position) {
		
		this.position = position;
	}
	
	public int getStartingPointOfX(){
		
		return start_x ;
		
	}
	
	public int getStartingPointOfY(){
		
		return start_y ;
		
	}
	
	public int getEndOfX(){
		
		return end_x ;
		
	}
	
	public int getEndOfY(){
		
		return end_y ;
		
	}
	
	public int getPosition() {
		
		return position;
	}

        public boolean checkInRectangle(int x_axis) {
		
              if(x_axis > start_x && x_axis < end_x)  // just returning true if point between start and end points
		 return true;
		
               return false;
		
        }

	
	public boolean checkByValue(int x_axis) {
		
		if(x_axis >= start_x && x_axis <= end_x)  //if the value is in my rectangle then it will return true else return false
			return true;
		
		return false;
	}
	
	public int getYForValue(int x_axis) {
		
		if(x_axis >= start_x && x_axis <= end_x)  //if the value is in my rectangle then it will return y value else return 0
			return end_y;
		
		return 0;
	}

	
	public boolean compareTo(final Rectangle other){
		
		if(this.getPosition() > other.getPosition())  // if other object position is less then base object position then I have to change order to do that I am returning false
			return false;          
		
		return true;	
		
	}
	
	

}

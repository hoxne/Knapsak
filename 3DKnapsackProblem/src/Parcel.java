
public class Parcel {
	
	public double width;
	public double heigth;
	public double length;
	public int value;
	public int type;
	public int[] coordinates; //the origin
	public int curr_rot;
	
	public Parcel(int type){
		switch(type){
			case 1:
				length = 1.0;
				width = 1.0;
				heigth = 2.0;
				this.value = 3;
				break;
			case 2:
				length = 1.0;
				width = 1.5;
				heigth = 2.0;
				this.value = 4;
				break;
			case 3:
				length = 1.5;
				width = 1.5;
				heigth = 1.5;
				this.value = 5;
				break;
		}
		coordinates = new int[3];
		coordinates[0] =1; 
		coordinates[1] =1; 
		coordinates[2] =1; 
		this.type = type;
		curr_rot=0;
		
		
	}
	public String toString(){
		return "Width: "+width+" Height: "+heigth+" Length:"+length+" Value: "+this.value;
	}
	public void setCoord(int x, int y, int z){
		coordinates[0]=x;
		coordinates[1]=y;
		coordinates[2]=z;
	}
	public int[] getCoord(){
		return coordinates;
		
	}
	public void rotate(){
		curr_rot +=1;
		curr_rot = curr_rot%3;
		double temp; 
		if(type == 1){
			temp = length;
			length = heigth;
			heigth = temp;
		}
		if(type == 2){
			if(curr_rot == 1){
				temp = length;
				length = heigth;
				heigth = temp;
			}
			if(curr_rot == 2){
				temp = width;
				width = heigth;
				heigth = temp;
			}
			if(curr_rot ==0){
				temp = length;
				length = width;
				width = heigth;
				heigth = temp;
			}
		}
	}
	

}


public class Parcel {
	
	public double width;
	public double heigth;
	public double length;
	public int value;
	public int[] coordinates; //the origin
	public boolean inside;
	
	public Parcel(int type, int value){
		switch(type){
			case 1:
				length = 1.0;
				width = 1.0;
				heigth = 2.0;
				break;
			case 2:
				length = 1.0;
				width = 1.5;
				heigth = 2.0;
				break;
			case 3:
				length = 1.5;
				width = 1.5;
				heigth = 1.5;
				break;
		}
		this.value = value;
		coordinates = new int[3];
		inside = false;
		
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

}

import java.awt.Color;
import java.util.ArrayList;

public class Load {
	
	public boolean availability(Truck truck1, ArrayList<Parcel> list1, int direction, int x, int y, int z){
		//basecase stop condition
		if(stop){
			System.out.println("No more packages can fit inside!");
			System.exit(0);
		}
		//direction cases
		if(direction == 1){
			x++;
		}
		if(direction == 2){
			z++;
		}
		if(direction == 3){
			y++;
		}
		//checking
		Parcel parcel = list1.get(0);
		
								
	}
	public void move(Parcel parcel,int axis){
		int coord[] = parcel.getCoord();
		switch(axis){
			case 1:
				parcel.setCoord(coord[0]+1, coord[1], coord[2]);
			case 2:
				parcel.setCoord(coord[0], coord[1]+1, coord[2]);
			case 3:
				parcel.setCoord(coord[0], coord[1], coord[2]+1);
		}
	}
	public boolean collide(Parcel parcel, Truck truck, int axis){
		int cX = parcel.coordinates[0];
		int cY = parcel.coordinates[0];
		int cZ = parcel.coordinates[0];
		double parcel_width = parcel.width * 2;
		double parcel_heigth = parcel.heigth * 2;
		double parcel_length = parcel.length * 2;
		
		switch(axis){
			case 1: 
					cX++;
					break;
			case 2: 
					cY++;
					break;
			case 3: 
					cZ++;
					break;
		}
		for(int i = cZ; i<=parcel_heigth;i++){
			for(int j = cY; j<=parcel_width;j++){
				for(int k = cX;k<=parcel_length;k++){
					if(truck.space[cX][cY][cZ]!= Color.WHITE)
						return true;
				}
			}
		}
		return false;
			
		
	}
	
}

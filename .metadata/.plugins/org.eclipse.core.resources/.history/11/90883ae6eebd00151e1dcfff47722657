import java.awt.Color;
import java.util.ArrayList;

public class Load {
	
	public void move(Parcel parcel,int axis){
		int coord[] = parcel.getCoord();
		switch(axis){
			case 1:
				parcel.setCoord(coord[0]+1, coord[1], coord[2]);
				break;
			case 2:
				parcel.setCoord(coord[0], coord[1]+1, coord[2]);
				break;
			case 3:
				parcel.setCoord(coord[0], coord[1], coord[2]+1);
				break;
		}
	}
	public boolean collide(Parcel parcel, Truck truck, int axis,int rotation){
		int cX = parcel.coordinates[0];
		int cY = parcel.coordinates[1];
		int cZ = parcel.coordinates[2];
		double parcel_width = parcel.width * 2;
		double parcel_heigth = parcel.heigth * 2;
		double parcel_length = parcel.length * 2;
		boolean statement = false;
		Parcel test = new Parcel(parcel.type);
		
		for(int i = 0; i<rotation; i++){
			test.rotate();
		}
		
		switch(axis){
			case 1: 
					cX+=parcel_length;
					for(int i = cZ; i<cZ+parcel_heigth;i++){
						for(int j = cY; j<cY+parcel_width;j++){
						if(truck.space[cX][i][j]!= Color.WHITE)
							return true;
						}
					}
					return false;
			case 2: 
					cY+=parcel_width;
					for(int i = cX; i<cX+parcel_length;i++){
						for(int j = cZ; j<cZ+parcel_heigth;j++){
						if(truck.space[i][j][cY]!= Color.WHITE)
							return true;
						}
					}
					return false;
					
			case 3: 
					cZ+=parcel_heigth;
					
					for(int i = cX; i<cX+parcel_length;i++){
						for(int j = cY; j<cY+parcel_width;j++){
							
								if(truck.space[i][cZ][j]!= Color.WHITE){
									
									return true;
								}
								
							}
					}
					return false;
			case 0: 

				for(int i = cX; i<cX+parcel_length;i++){
					for(int j = cZ; j<cY+parcel_heigth;j++){
						for(int k = cY; k<cZ+parcel_width;k++)
							if(truck.space[i][j][k]!= Color.WHITE){
								
								return true;
							}
							
						}
				}
				return false;
		}
		return statement;
		
			
		
	}
	
}

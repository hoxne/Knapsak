import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Truck {
	public Color[][][] space;
	//real dimensions of the truck
	public double width;
	public double heigth;
	public double length;
	//
	public List<Parcel> parcelList; //list of parcel that are inside
	
	public Truck(){
		//setting the real dimensions of the truck
		length = 16.5;
		width = 2.5;
		heigth = 4;	
		//inizializing the list of parcels 
		parcelList= new ArrayList<Parcel>();
		//setting up the space of the 3D array (1 cell correspond to 0.5m 
		space = new Color[(int)(length*2)+2][(int)(heigth*2)+2][(int)(width*2)+2];
		//inizializing the truck with colors (gray if it's a bound)
		for(int i = 0;i<space.length; i++){
			for(int j=0; j<space[0].length;j++){
				for(int k = 0; k<space[0][0].length; k++){
					if((i==0)||(j==0)||(k==0)||(i==space.length-1)||(j==space[0].length-1)||(k==space[0][0].length-1)){
						space[i][j][k]=Color.GRAY;
					}else{
						space[i][j][k]=Color.WHITE;
					}
				}
			}
		}
	}
	//it reinitialise the space
	public void reset(){
		for(int i = 0;i<space.length; i++){
			for(int j=0; j<space[0].length;j++){
				for(int k = 0; k<space[0][0].length; k++){
					if((i==0)||(j==0)||(k==0)||(i==space.length-1)||(j==space[0].length-1)||(k==space[0][0].length-1)){
						space[i][j][k]=Color.GRAY;
					}else{
						space[i][j][k]=Color.WHITE;
					}
				}
			}
		}		
	}
	//It adds a parcel to the list of inside parcels
	public void put(Parcel parcel){
		parcelList.add(parcel);
		build();
	}
	//it builds every time the new space with all the parcels inside
	public void build(){
		reset();
		int count = 0;
		for(Parcel parcel: parcelList){
			count++;
			double parcel_width = parcel.width * 2;
			double parcel_heigth = parcel.heigth * 2;
			double parcel_length = parcel.length * 2;
			int coordinates[] = parcel.coordinates;
			for(int i = coordinates[0]; i<coordinates[0]+parcel_length;i++){
				for(int j = coordinates[2]; j<coordinates[2]+parcel_heigth;j++){
					for(int k = coordinates[1];k<coordinates[1]+parcel_width;k++){
						if(count == parcelList.size()){
							space[i][j][k] = Color.BLUE;
						}else{
							space[i][j][k] = Color.RED;
						}
					}
				}
			}
			
		}
		
	}
	public void printTruck(){
		for(int i = 0; i<space.length;i++){
			for(int j = 0; j<space[0].length;j++){
				for(int k = 0;k<space[0][0].length;k++){
					if(space[i][j][k]== Color.RED){
						System.out.print("1");
					}else if(space[i][j][k]== Color.GRAY){
						System.out.print("|");
					}else if(space[i][j][k]== Color.BLUE){
						System.out.print("X");
					}else{
						System.out.print("0");
					}
					
				}
				System.out.println("");
			}
			System.out.println("");
			System.out.println("");
		}
	}
	
	

}

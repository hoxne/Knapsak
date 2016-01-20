import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Truck{
	public Color[][][] space;
	//real dimensions of the truck
	public double width;
	public double heigth;
	public double length;
	public int[] coordinates;
	//
	public ArrayList<Parcel> parcelList; //list of parcel that are inside
	
	public Truck(){
		//setting the real dimensions of the truck
		length = 16.5;
		width = 2.5;
		heigth = 4;	
		coordinates = new int[3];
		coordinates[0] = 1;
		coordinates[1] = 1;
		coordinates[2] = 1;
		//initialising the list of parcels 
		parcelList= new ArrayList<Parcel>();
		//setting up the space of the 3D array (1 cell correspond to 0.5m 
		space = new Color[(int)(length*2)+2][(int)(heigth*2)+2][(int)(width*2)+2];
		//initialising the truck with colors (gray if it's a bound)
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
	public void printValue(){
		int value=0;
		for(Parcel parcel: parcelList){
			value+=parcel.value;
		}
		System.out.println("The value is: "+value);
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
		printValue();
	}
	public int[][] getPoints(){
		int[][] points = new int[8][3];
		points[0][0]=coordinates[0]; points[0][1]=coordinates[1]; points[0][2]=coordinates[2]; 
		points[1][0]=(int)(coordinates[0]+length*2); points[1][1]=coordinates[1]; points[1][2]=coordinates[2]; 
		points[2][0]=coordinates[0]; points[2][1]=(int)(coordinates[1]+width*2); points[2][2]=coordinates[2]; 
		points[3][0]=coordinates[0]; points[3][1]=coordinates[1]; points[3][2]=(int)(coordinates[2]+heigth*2); 
		points[4][0]=(int)(coordinates[0]+length*2); points[4][1]=coordinates[1]; points[4][2]=(int)(coordinates[2]+heigth*2); 
		points[5][0]=coordinates[0]; points[5][1]=(int)(coordinates[1]+width*2); points[5][2]=(int)(coordinates[2]+heigth*2); 
		points[6][0]=(int)(coordinates[0]+length*2); points[6][1]=(int)(coordinates[1]+width*2); points[6][2]=coordinates[2]; 
		points[7][0]=(int)(coordinates[0]+length*2); points[7][1]=(int)(coordinates[1]+width*2); points[7][2]=(int)(coordinates[2]+heigth*2); 
		return points;
		
	}
	public int[][] getAdjia(){
		int[][] allPoints = getPoints();
		int[][] matrix = new int[allPoints.length][allPoints.length];
		int count;
		for(int i =0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				count=0;
				if(allPoints[i][0]==allPoints[j][0]){
					count++;
				}
				if(allPoints[i][1]==allPoints[j][1]){
					count++;
				}
				if(allPoints[i][2]==allPoints[j][2]){
					count++;
				}
				if(count==2){
					matrix[i][j]=1;
				}
				
			}
		}
		return matrix;
	}
	
	

}

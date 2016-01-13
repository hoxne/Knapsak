import java.awt.Color;

public class Truck {
	public Color[][][] space;
	public double width;
	public double heigth;
	public double length;
	
	public Truck(){
		length = 16.5;
		width = 2.5;
		heigth = 4;	
		
		space = new Color[(int)(length*2)+1][(int)(width*2)+1][(int)(heigth*2)+1];
		
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
	public void put(Parcel parcel){
		double parcel_width = parcel.width * 2;
		double parcel_heigth = parcel.heigth * 2;
		double parcel_length = parcel.length * 2;
		int coordinates[] = parcel.coordinates;
		
		for(int i = coordinates[2]; i<=parcel_heigth;i++){
			for(int j = coordinates[1]; j<=parcel_width;j++){
				for(int k = coordinates[0];k<=parcel_length;k++){
					space[i][j][k] = Color.RED;
				}
			}
		}
		for(int i = 0; i<space.length;i++){
			for(int j = 0; j<space[0].length;j++){
				for(int k = 0;k<space[0][0].length;k++){
					if(space[i][j][k]== Color.RED){
						System.out.print("1");
					}else if(space[i][j][k]== Color.GRAY){
						System.out.print("|");
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

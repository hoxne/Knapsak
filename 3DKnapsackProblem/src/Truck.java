
public class Truck {
	public boolean[][][] space;
	public double width;
	public double heigth;
	public double length;
	
	public Truck(){
		length = 16.5;
		width = 2.5;
		heigth = 4;	
		
		space = new boolean[(int)(length*2)][(int)(width*2)][(int)(heigth*2)];
		
		for(int i = 0;i<space.length; i++){
			for(int j=0; j<space[0].length;j++){
				for(int k = 0; k<space[0][0].length; k++){
					space[i][j][k] = false;
				}
			}
		}
	}
	public void put(Parcel parcel){
		double parcel_width = parcel.width * 2;
		double parcel_heigth = parcel.heigth * 2;
		double parcel_length = parcel.length * 2;
		int coordinates[] = parcel.coordinates;
		
		for(int i = coordinates[0]; i<parcel_length;i++){
			for(int j = coordinates[1]; j<parcel_width;j++){
				for(int k = coordinates[2];k<parcel_heigth;k++){
					space[i][j][k]= true;
				}
			}
		}
		for(int i = 0; i<space.length;i++){
			for(int j = 0; j<space[0].length;j++){
				for(int k = 0;k<space[0][0].length;k++){
					if(space[i][j][k]== true){
						System.out.print("1");
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

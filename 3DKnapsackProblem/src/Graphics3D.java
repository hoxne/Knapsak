import java.util.ArrayList;

public class Graphics3D {
	public ArrayList<Parcel> list;
	public int[][] points;
	public int[][] connections;
	public Graphics3D(ArrayList<Parcel> list){
		this.list=list;
	}
	public void allPoints(){
		points = new int[list.size()*8][3];
		int count=0;
		
		for(Parcel next: list){
			int[][] pointsBox = next.getPoints();

			for(int i=count*8; i<(count*8)+8;i++){
				for(int j = 0; j<3;j++){
					points[i][j]=pointsBox[i%8][j];
				}
			}
			count++;
		}
	}
	public void allConnections(){
		connections = new int[points.length][points.length];
		int count=0;
		for(Parcel next: list){
			int[][] pointsBox = next.getAdjia();
			
			for(int i =count*8;i<(count*8)+8;i++){
				for(int j=count*8;j<(count*8)+8;j++){
					connections[i][j] = pointsBox[i%8][j%8];                            
				}
			}
			count++;
		}
		

	}
}

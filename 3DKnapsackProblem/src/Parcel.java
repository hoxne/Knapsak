import java.awt.Point;

public class Parcel {
	
	public double width;
	public double heigth;
	public double length;
	public int value;
	public int type;
	public int[] coordinates; //the origin
	public int curr_rot;      //current rotation
	
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
		return "X:"+coordinates[0]+" Y: "+coordinates[1]+" Z:"+coordinates[2];
	}
	public void setCoord(int x, int y, int z){
		coordinates[0]=x;
		coordinates[1]=y;
		coordinates[2]=z;
	}
	public int[] getCoord(){
		return coordinates;
		
	}
	public float[][] getPoints(){
		System.out.println("Example Printing");
		float[][] points = new float[8][3];
		points[0][0]=coordinates[0]; points[0][1]=coordinates[1]; points[0][2]=coordinates[2]; 
		points[1][0]=(float)(coordinates[0]+length*2); points[1][1]=coordinates[1]; points[1][2]=coordinates[2]; 
		points[2][0]=coordinates[0]; points[2][1]=(float)(coordinates[1]+width*2); points[2][2]=coordinates[2]; 
		points[3][0]=coordinates[0]; points[3][1]=coordinates[1]; points[3][2]=(float)(coordinates[2]+heigth*2); 
		points[4][0]=(float)(coordinates[0]+length*2); points[4][1]=coordinates[1]; points[4][2]=(float)(coordinates[2]+heigth*2); 
		points[5][0]=coordinates[0]; points[5][1]=(float)(coordinates[1]+width*2); points[5][2]=(float)(coordinates[2]+heigth*2); 
		points[6][0]=(float)(coordinates[0]+length*2); points[6][1]=(float)(coordinates[1]+width*2); points[6][2]=coordinates[2]; 
		points[7][0]=(float)(coordinates[0]+length*2); points[7][1]=(float)(coordinates[1]+width*2); points[7][2]=(float)(coordinates[2]+heigth*2); 
		
		
		for(int i = 0; i<points.length;i++){
			for(int j = 0; j<points[0].length;j++){
				
				
				System.out.print(points[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println(points.length+"|"+points[0].length);
		
		
		return points;
		
	}
	public int[][] getAdjia(){
		float[][] allPoints = getPoints();
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

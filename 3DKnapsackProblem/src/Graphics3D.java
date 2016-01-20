import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphics3D extends JPanel{
	public Color[] color = {Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red,Color.magenta,Color.white,Color.darkGray,Color.lightGray,new Color(100, 100, 100)};
	public ArrayList<Parcel> list;
	public float[][] points;
	public float[][] points2D;
	public int[][] connections;
	public Perspective persp;
	public Truck truck1;
	public Graphics3D(ArrayList<Parcel> list){
		this.list=list;
		truck1 = new Truck();
		allPoints();
		allConnections();
	}
	
	public void allPoints(){
		points = new float[(list.size()+1)*8][3];
		int count=0;
		
		for(Parcel next: list){
			float[][] pointsBox = next.getPoints();

			for(int i=count*8; i<(count*8)+8;i++){
				for(int j = 0; j<3;j++){
					points[i][j]=pointsBox[i%8][j];
				}
			}
			count++;
		}
		int[][] pointsBox = truck1.getPoints();
		for(int i=count*8; i<(count*8)+8;i++){
			for(int j = 0; j<3;j++){
				points[i][j]=pointsBox[i%8][j];
			}
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
		int[][] pointsBox = truck1.getAdjia();
		for(int i=count*8; i<(count*8)+8;i++){
			for(int j=count*8;j<(count*8)+8;j++){
				connections[i][j]=pointsBox[i%8][j%8];
			}
		}

	}
	public void onto2D(float[] center){
		persp = new Perspective();
		points2D = persp.coordinatesFor2D(points, center, 2, 90, 1000);
		
	}
	public void printAll(){
		for(int i = 0; i<points.length;i++){
			for(int j = 0; j<points[0].length;j++){
				System.out.print(points[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i<connections.length;i++){
			for(int j = 0; j<connections[0].length;j++){
				System.out.print(connections[i][j]);
			}
			System.out.println();
		}
	}
	
	public void paintComponent(Graphics g){
		float minX = 1000;
		float minY = 1000;
		
		for(int i = 0; i<points2D.length;i++){
			if(-points2D[i][1]<minY){
				minY = -points2D[i][1]-1;
			}
			if(points2D[i][0]<minX){
				minX = points2D[i][0]-1;
			}
			
		}
		
		
		
		super.paintComponent(g);
		int count = 0;
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i = 0; i<connections.length;i++){
			if(count==8){
				g2.setColor(color[(int)(Math.random()*11)+1]);
				count =0;
			}
			
			for(int j = i+1; j<connections[0].length;j++){
				
				if(connections[i][j]==1){
					Shape l = new Line2D.Float((points2D[i][0])-minX, (-points2D[i][1])-minY,(points2D[j][0])-minX, (-points2D[j][1])-minY);
					System.out.println("("+((points2D[i][0])-minX)+","+((-points2D[i][1])-minY)+")&("+((points2D[j][0])-minX)+","+((-points2D[j][1])-minY)+")");
					g2.draw(l);
	
				}
			}
			count++;
		}
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	
		
	}
	
	
}

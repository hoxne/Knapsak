import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test3 extends JPanel {
	 Parcel parcel;
	 int[][] adjParc;
	 float[][] points;
	 float[][] points2d;
	 Perspective pers;
	 float[] coP = {100f,2f,10f};
	 float[][] array = {{-3.2f,-12.0f,-12f,-3.2f,0f,-6.67f,1.4f,-4.33f,4.6f,1,5.6f,2.67f,7.2f,5.33f,5.33f,7.2f},
						{-6f,-4.33f,-1f,1.4f,1.4f,-1f,2.6f,1f,2.6f,1f,1.4f,-1f,1.4f,-1f,-4.33f,-0.6f}};
	 float[][] array2 ={{-8.67f,-26f,-26f,-8.67f,-3.33f,-10f,-1f,-3f,4.33f,13f,6f,18f, 8.67f, 26f, 26f, 8.67f},
	 					{-2.67f,-8f,2f,0.67f, 0.67f, 2f, 2.67f, 8f, 2.67f, 8f ,0.67f, 2f, 0.67f, 2f, -8f,-2.67f}};
	 float[][] array3 = {{-6.5f,-6.5f,-6.5f,-6.5f,-2.5f,-2.5f,-0.75f,-0.75f,3.25f,3.35f,4.5f,4.5f,6.5f,6.5f,6.5f,6.5f},
			 			 {-2f,-2f,0.5f,0.5f,0.5f,0.5f,2f,2f,2f,2f,0.5f,0.5f,0.5f,0.5f,-2f,-2f},
			 			 {-2.5f,2.5f,2.5f,-2.5f,-2.5f,2.5f,-2.5f,2.5f,-2.5f,2.5f,-2.5f,2.5f,-2.5f,2.5f,2.5f,-2.5f}};
	 int[][] adj = {{0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
					{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
					{0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{1, 0, 1, 0, 1, 0, 0, 0, 0, 0 ,0 ,0, 0, 0, 0, 0},
					{0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0},
					{0, 0, 0, 0, 0, 0 ,0, 0, 0, 1, 1, 0, 0, 1, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0},
					{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
					{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0}};
	 
	 public Test3(){
		 parcel = new Parcel(3);
		 parcel.length = 10.0;
		 parcel.width = 25.0;
		 parcel.heigth = 50.0;
		 points = parcel.getPoints();
		 adjParc = parcel.getAdjia();
		 pers = new Perspective();
		 float[][] TRANSPOSE = pers.getTranspose(points);
		 
		 
		 
		 points2d = pers.coordinatesFor2D(points, coP, 2, 145f, 200f);
		 for(int i = 0; i<points2d.length;i++){
				for(int j = 0; j<points2d[0].length;j++){
					
					points2d[i][j] = Math.round(points2d[i][j]*100.0f)/100.0f;
					System.out.print(points2d[i][j]);
					System.out.print("|");
				}
				System.out.println();
		 }
		 System.out.println();
		 System.out.println();
		 for(int i = 0; i<points2d[0].length;i++){
				for(int j = 0; j<points2d.length;j++){
					System.out.print(points2d[j][i]);
					System.out.print(",");
				}
				System.out.println();
		 }
		 
		 
		 
		 
	 }
	 
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			for(int i = 0; i<adjParc.length;i++){
				
				for(int j = i+1; j<adjParc.length;j++){
					
					if(adjParc[i][j]==1){
						Shape l = new Line2D.Double(300+(-points2d[0][i]), 300+(-points2d[1][i]), 300+(-points2d[0][j]), 300+(-points2d[1][j]));
						
						g2.draw(l);
		
					}
				}
			
			}
			
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
			
	}
	public static void main(String[] args){
		
		JFrame f = new JFrame();
		Test3 t = new Test3();
		f.add(t);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 400);
		f.setVisible(true);
	}
}

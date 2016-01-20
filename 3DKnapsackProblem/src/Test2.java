import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test2 extends JPanel{
    public Color[] color = {Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red,Color.magenta,Color.white,Color.darkGray,Color.lightGray,new Color(100, 100, 100)};
	public float[][] array;
	public int[][] array2;
	public float[][] array3;
	public Test2(){
		array = new float[16][3];
		array2 = new int[16][16];
		
		array[0][0]= -6.5f; array[0][1]= -2; array[0][2]= -2.5f;
		array[1][0]= -6.5f; array[1][1]= -2; array[1][2]= 2.5f;
		array[2][0]= -6.5f; array[2][1]= 0.5f; array[2][2]= 2.5f;
		array[3][0]= -6.5f; array[3][1]= 0.5f; array[3][2]= -2.5f;
		array[4][0]= -2.5f; array[4][1]= 0.5f; array[4][2]= -2.5f;
		array[5][0]= -2.5f; array[5][1]= 0.5f; array[5][2]= 2.5f;
		array[6][0]= -0.75f; array[6][1]= 2; array[6][2]= -2.5f;
		array[7][0]= -0.75f; array[7][1]= 2; array[7][2]= 2.5f;
		array[8][0]= 3.25f; array[8][1]= 2; array[8][2]= -2.5f;
		array[9][0]= 3.25f; array[9][1]= 2; array[9][2]= 2.5f;
		array[10][0]= 4.5f; array[10][1]= 0.5f; array[10][2]= -2.5f;
		array[11][0]= 4.5f; array[11][1]= 0.5f; array[11][2]= 2.5f;
		array[12][0]= 6.5f; array[12][1]= 0.5f; array[12][2]= -2.5f;
		array[13][0]= 6.5f; array[13][1]= 0.5f; array[13][2]= 2.5f;
		array[14][0]= 6.5f; array[14][1]= -2; array[14][2]= 2.5f;
		array[15][0]= 6.5f; array[15][1]= -2; array[15][2]= -2.5f;
		
		array2[0][0]= 0; array2[0][1]= 1; array2[0][2]= 0; array2[0][3]= 1; array2[0][4]= 0; array2[0][5]= 0;
		array2[0][6]= 0; array2[0][7]= 0; array2[0][8]= 0; array2[0][9]= 0; array2[0][10]= 0; array2[0][11]= 0;
		array2[0][12]= 0; array2[0][13]= 0; array2[0][14]= 0; array2[0][15]= 1; 
		
		array2[1][0]= 1; array2[1][1]= 0; array2[1][2]= 1; array2[1][3]= 0; array2[1][4]= 0; array2[1][5]= 0;
		array2[1][6]= 0; array2[1][7]= 0; array2[1][8]= 0; array2[1][9]= 0; array2[1][10]= 0; array2[1][11]= 0;
		array2[1][12]= 0; array2[1][13]= 0; array2[1][14]= 1; array2[1][15]= 0;
		
		array2[2][0]= 0; array2[2][1]= 1; array2[2][2]= 0; array2[2][3]= 1; array2[2][4]= 0; array2[2][5]= 1;
		array2[2][6]= 0; array2[2][7]= 0; array2[2][8]= 0; array2[2][9]= 0; array2[2][10]= 0; array2[2][11]= 0;
		array2[2][12]= 0; array2[2][13]= 0; array2[2][14]= 0; array2[2][15]= 0;
		
		array2[3][0]= 1; array2[3][1]= 0; array2[3][2]= 1; array2[3][3]= 0; array2[3][4]= 1; array2[3][5]= 0;
		array2[3][6]= 0; array2[3][7]= 0; array2[3][8]= 0; array2[3][9]= 0; array2[3][10]= 0; array2[3][11]= 0;
		array2[3][12]= 0; array2[3][13]= 0; array2[3][14]= 0; array2[3][15]= 0;
		
		array2[4][0]= 0; array2[4][1]= 0; array2[4][2]= 0; array2[4][3]= 1; array2[4][4]= 0; array2[4][5]= 1;
		array2[4][6]= 1; array2[4][7]= 0; array2[4][8]= 0; array2[4][9]= 0; array2[4][10]= 0; array2[4][11]= 0;
		array2[4][12]= 0; array2[4][13]= 0; array2[4][14]= 0; array2[4][15]= 0;
		
		array2[5][0]= 0; array2[5][1]= 0; array2[5][2]= 1; array2[5][3]= 0; array2[5][4]= 1; array2[5][5]= 0;
		array2[5][6]= 0; array2[5][7]= 1; array2[5][8]= 0; array2[5][9]= 0; array2[5][10]= 0; array2[5][11]= 0;
		array2[5][12]= 0; array2[5][13]= 0; array2[5][14]= 0; array2[5][15]= 0;
		
		array2[6][0]= 0; array2[6][1]= 0; array2[6][2]= 0; array2[6][3]= 0; array2[6][4]= 1; array2[6][5]= 0;
		array2[6][6]= 0; array2[6][7]= 1; array2[6][8]= 1; array2[6][9]= 0; array2[6][10]= 0; array2[6][11]= 0;
		array2[6][12]= 0; array2[6][13]= 0; array2[6][14]= 0; array2[6][15]= 0;
		
		array2[7][0]= 0; array2[7][1]= 0; array2[7][2]= 0; array2[7][3]= 0; array2[7][4]= 0; array2[7][5]= 1;
		array2[7][6]= 1; array2[7][7]= 0; array2[7][8]= 0; array2[7][9]= 1; array2[7][10]= 0; array2[7][11]= 0;
		array2[7][12]= 0; array2[7][13]= 0; array2[7][14]= 0; array2[7][15]= 0;
		
		array2[8][0]= 0; array2[8][1]= 0; array2[8][2]= 0; array2[8][3]= 0; array2[8][4]= 0; array2[8][5]= 0;
		array2[8][6]= 1; array2[8][7]= 0; array2[8][8]= 0; array2[8][9]= 1; array2[8][10]= 1; array2[8][11]= 0;
		array2[8][12]= 0; array2[8][13]= 0; array2[8][14]= 0; array2[8][15]= 0;
		
		array2[9][0]= 0; array2[9][1]= 0; array2[9][2]= 0; array2[9][3]= 0; array2[9][4]= 0; array2[9][5]= 0;
		array2[9][6]= 0; array2[9][7]= 1; array2[9][8]= 1; array2[9][9]= 0; array2[9][10]= 0; array2[9][11]= 1;
		array2[9][12]= 0; array2[9][13]= 0; array2[9][14]= 0; array2[9][15]= 0;
		
		array2[10][0]= 0; array2[10][1]= 0; array2[10][2]= 0; array2[10][3]= 0; array2[10][4]= 0; array2[10][5]= 0;
		array2[10][6]= 0; array2[10][7]= 0; array2[10][8]= 1; array2[10][9]= 0; array2[10][10]= 0; array2[10][11]= 1;
		array2[10][12]= 1; array2[10][13]= 0; array2[10][14]= 0; array2[10][15]= 0;
		
		array2[11][0]= 0; array2[11][1]= 0; array2[11][2]= 0; array2[11][3]= 0; array2[11][4]= 0; array2[11][5]= 0;
		array2[11][6]= 0; array2[11][7]= 0; array2[11][8]= 0; array2[11][9]= 1; array2[11][10]= 1; array2[11][11]= 0;
		array2[11][12]= 0; array2[11][13]= 1; array2[11][14]= 0; array2[11][15]= 0;
		
		array2[12][0]= 0; array2[12][1]= 0; array2[12][2]= 0; array2[12][3]= 0; array2[12][4]= 0; array2[12][5]= 0;
		array2[12][6]= 0; array2[12][7]= 0; array2[12][8]= 0; array2[12][9]= 0; array2[12][10]= 1; array2[12][11]= 0;
		array2[12][12]= 0; array2[12][13]= 1; array2[12][14]= 0; array2[12][15]= 1;
		
		array2[13][0]= 0; array2[13][1]= 0; array2[13][2]= 0; array2[13][3]= 0; array2[13][4]= 0; array2[13][5]= 0;
		array2[13][6]= 0; array2[13][7]= 0; array2[13][8]= 0; array2[13][9]= 0; array2[13][10]= 0; array2[13][11]= 1;
		array2[13][12]= 1; array2[13][13]= 0; array2[13][14]= 1; array2[13][15]= 0;
		
		array2[14][0]= 0; array2[14][1]= 1; array2[14][2]= 0; array2[14][3]= 0; array2[14][4]= 0; array2[14][5]= 0;
		array2[14][6]= 0; array2[14][7]= 0; array2[14][8]= 0; array2[14][9]= 0; array2[14][10]= 0; array2[14][11]= 0;
		array2[14][12]= 0; array2[14][13]= 1; array2[14][14]= 0; array2[14][15]= 1;
		
		array2[15][0]= 1; array2[15][1]= 0; array2[15][2]= 0; array2[15][3]= 0; array2[15][4]= 0; array2[15][5]= 0;
		array2[15][6]= 0; array2[15][7]= 0; array2[15][8]= 0; array2[15][9]= 0; array2[15][10]= 0; array2[15][11]= 0;
		array2[15][12]= 1; array2[15][13]= 0; array2[15][14]= 1; array2[15][15]= 0;
		
		exe();
	}
	
	public void exe(){
		Perspective pers = new Perspective();
		float[] view = {0,0,10};
		array3 = new float[16][2];
		array3 = pers.coordinatesFor2D(array, view, 0,0,500);
		for(int i = 0; i<array3.length;i++){
			for(int j = 0; j<array3[0].length;j++){
				System.out.print(array3[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	public void eachforEach(){
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i<array2.length;i++){
			for(int j = i+1; j<array2[0].length;j++){
				
				if(array2[i][j]==1){
					g2.setColor(color[(int)(Math.random()*11)+1]);
					Shape l = new Line2D.Double(300+array3[i][0],300+array3[i][1], 300+array3[j][0], 300+array3[j][1]);
					g2.draw(l);
					System.out.println("Point ("+array3[i][0]+","+array3[i][1]+") and ("+array3[j][0]+","+array3[j][1]+")");
					Scanner scan = new Scanner(System.in);
					int scan1 = scan.nextInt();
					
					
				}
			}
		}
	}
	
	
	public void paintComponent(Graphics g){
		
		
	}
	
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame();
		Test2 test = new Test2();
		frame.add(test);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
	
		
		
	}
}

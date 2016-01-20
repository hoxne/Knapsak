import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
	public static void main(String[] args){
		
		Truck truck1 = new Truck();
		Load load1 = new Load();
		RealGreedy algo = new RealGreedy(truck1, load1);
		algo.begin();
		truck1.printTruck();
		truck1.printValue();
		Perspective persp1 = new Perspective();
		Graphics3D graph = new Graphics3D(truck1.parcelList);
		JFrame frame = new JFrame();
		KeysT listener = new KeysT(persp1,graph);
		listener.init();
		frame.addKeyListener((KeyListener) listener);
		frame.add(graph);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		
	
		
		/*
		Parcel parcel2 = new Parcel(3);
		parcel2.setCoord(7, 1, 1);
		truck1.put(parcel2);
		Parcel parcel3 = new Parcel(3);
		parcel3.setCoord(14,1,1);
		truck1.put(parcel3);
	
		Graphics3D graph = new Graphics3D(truck1.parcelList);
		
		Perspective persp1 = new Perspective();
		double[] view = {100,0,-100};	
		graph.onto2D(view);
		JFrame frame = new JFrame();
		frame.add(graph);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
		truck1.printTruck();
		*/
	
		
	
	
	}
}

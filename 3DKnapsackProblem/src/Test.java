public class Test {
	public static void main(String[] args){
	/*	
	Truck truck1 = new Truck();
	Load load1 = new Load();
	GreedyAlgorithm algo = new GreedyAlgorithm(truck1, load1);
	algo.start(1);
	*/
	Parcel parcel1 = new Parcel(3);
	Truck truck1 = new Truck();
	truck1.put(parcel1);
	Parcel parcel2 = new Parcel(3);
	parcel2.setCoord(7, 1, 1);
	truck1.put(parcel2);
	Parcel parcel3 = new Parcel(3);
	parcel3.setCoord(14,1,1);
	truck1.put(parcel3);
	Graphics3D graph = new Graphics3D(truck1.parcelList);
	
	
	
	
	graph.allPoints();
	graph.allConnections();
	
	int[][] allP = graph.points;
	for(int i=0;i<allP.length;i++){
		for(int j=0;j<allP[0].length;j++){
			System.out.print(allP[i][j]);
			System.out.print("|");
		}
		System.out.println("");
	}
	System.out.println("");
	
	
	int[][] allC = graph.connections;
	for(int i=0;i<allC.length;i++){
		for(int j=0;j<allC[0].length;j++){
			System.out.print(allC[i][j]);
			System.out.print("|");
		}
		System.out.println("");
	}
	System.out.println("");
	}
	
}

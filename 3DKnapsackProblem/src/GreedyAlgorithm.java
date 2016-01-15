
public class GreedyAlgorithm{
	
	public Truck truck;
	public Load load;
	public Parcel parcel;

	
	public GreedyAlgorithm(Truck truck, Load load){
		this.truck = truck;
		this.load = load;
	}
	public void start(int path){
		switch(path){
			//new Parcel
			case 1:
				System.out.println("Inside 1 case, new parcel!");
				parcel = new Parcel(((int)(Math.random()*3))+1);
				
				start(2);
				break;
			//Check fits
			case 2:
				if(load.collide(parcel, truck, 0,0)){
					System.out.print("COLLISION FUUCK");
					switch(parcel.type){
						case 1: //if A
							if(load.collide(parcel, truck, 0, 1)){
								start(3);
							}else{
								parcel.rotate();
								start(2);
							}
							break;
						case 2: //if B
							if(load.collide(parcel, truck, 0, 1)){
								if(load.collide(parcel, truck, 0, 2)){
									start(3);
								}else{
									parcel.rotate();
									parcel.rotate();
									start(2);
								}
							}else{
								parcel.rotate();
								start(2);
							}
							break;
						case 3: //if C
							start(3);
							break;
					}
				}else{
					start(4);
				}
				break;
			//Move to right
			case 3:
				System.out.println("Inside 3 case moving right");
				load.move(parcel, 2);
				System.out.println(parcel.coordinates[1]+(parcel.width)*2);
				System.out.println(truck.space[0][0].length -1);
				if((parcel.coordinates[1]+(parcel.width)*2)>= ((truck.space[0][0].length)-1)){
					System.out.println("Inside 3 case LIMIT REACHED");
					int temp = parcel.coordinates[0];
					parcel.setCoord(temp+1, 1, 1);
					if((parcel.coordinates[0]+(parcel.length)*2)>= ((truck.space.length)-1)){
						
						start(7); //FINISH
					}else{
						start(2);
					}
				}else{
					start(2);
				}
				break;
			//Checking fits down
			case 4:
				if(!(load.collide(parcel, truck, 3, 0))){
					load.move(parcel, 3);
					start(4);
				}else{
					switch(parcel.type){
						case 1:
							if(load.collide(parcel, truck, 3, 1)){
								if(load.collide(parcel, truck, 3, 2)){
									start(5);
								}else{
									parcel.rotate();
									parcel.rotate();
									start(4);
								}
							}else{
								parcel.rotate();
								start(4);
							}
							break;
						case 2:
							if(load.collide(parcel, truck, 3, 1)){
								start(5);
							}else{
								parcel.rotate();
								start(4);
							}
							break;
						case 3:
							start(5);
							break;
					}
				}
			//Bound or box
			case 5:
				if((parcel.coordinates[2]+(parcel.heigth)*2)>=((truck.space[0].length)-1)){
					start(6);
				}else{
					if(load.collide(parcel, truck, 2, 0)){
						switch(parcel.type){
							case 1:
								if(load.collide(parcel, truck, 2, 1)){
									if(load.collide(parcel, truck, 2, 2)){
										start(6);
									}else{
										parcel.rotate();
										parcel.rotate();
										load.move(parcel, 2);
										start(4);
									}
								}else{
									parcel.rotate();
									load.move(parcel, 2);
									start(4);
								}
								break;
							case 2:
								if(load.collide(parcel, truck, 2, 1)){
									start(6);
								}else{
									parcel.rotate();
									start(4);
								}
								break;
							case 3:
								start(6);
								break;
						}
					}else{
						load.move(parcel, 2);
						start(4);
					}
				}
				break;
			//fix
			case 6:
				truck.put(parcel);
				truck.printTruck();
				System.out.println("_____________________________________________-");
				start(1);
				break;
			//finish
			case 7:
				System.out.println("OOUT!");
				break;

		}
	}
	
}

public class RealGreedy {
	public int x;
	public int y;
	public int z;
	public Truck truck;
	public Load load;
	public Parcel parcel;
	public int nextStep;
 	public RealGreedy(Truck truck, Load load){
 		
 		this.x = 1;
 		this.y = 1;
 		this.z = 8;
 		
 		this.truck = truck;
 		this.load = load;
 		nextStep = 1;
		
		
	}
 	
 	public void begin(){
 		parcel = new Parcel(1);
 		parcel.setCoord(1, 1, 5);
 		truck.put(parcel);
 		while(nextStep!=5){
	 		switch(nextStep){
	 			case 1:
	 				step1();
	 				break;
	 			case 2:
	 				step2();
	 				break;
	 			case 3:
	 				step3();
	 				break;
	 			case 4:
	 				step4();
	 				break;
	 			
	 		}
 		}
 		System.out.println("END");
 		
 	}
 	public void step1(){
 		parcel = new Parcel(1);
		parcel.setCoord(x, y, z);
		if(load.collide(parcel, truck, 0, 0)){
			if(load.collide(parcel, truck, 0, 1)){
				nextStep=2;
			}else{
				parcel.rotate();
				truck.put(parcel);
				nextStep=4;
			}
		}else{
			truck.put(parcel);
			
			nextStep=4;
		}
		
 	}
 	public void step2(){
 		parcel = new Parcel(2);
		parcel.setCoord(x, y, z);
		if(load.collide(parcel, truck, 0, 0)){
			if(load.collide(parcel, truck, 0, 1)){
				if(load.collide(parcel, truck, 0, 2)){
					nextStep=3;
	 			}else{
	 				parcel.rotate();
	 				parcel.rotate();
	 				truck.put(parcel);
	 				nextStep=4;
	 			}
		}else{
			parcel.rotate();
 				truck.put(parcel);
 				nextStep=4;
		}
		}else{
			truck.put(parcel);
			nextStep=4;
		}
 	}
 	public void step3(){
 		parcel = new Parcel(3);
		parcel.setCoord(x, y, z);
		if(load.collide(parcel, truck, 0, 0)){
			nextStep=4;
		}else{
			truck.put(parcel);
			nextStep=4;
		}
 	}
 	public void step4(){
 		y++;
		if(y>=6){
			y=1;
			z--;
			if(z<=0){
				z=8;
				x++;
				if(x>=34){
					//END
					nextStep=5;
				}else{
					nextStep=1;
				}
			}else{
				nextStep=1;
			}
		}else{
			nextStep=1;
		}
 	}
 	public void start(int path){
 		switch(path){
 			case 1: //Parcel A
	 			parcel = new Parcel(1);
	 			parcel.setCoord(x, y, z);
	 			if(load.collide(parcel, truck, 0, 0)){
	 				if(load.collide(parcel, truck, 0, 1)){
	 					start(2);
	 				}else{
	 					parcel.rotate();
	 					truck.put(parcel);
	 					start(4);
	 				}
	 			}else{
	 				truck.put(parcel);
	 				start(4);
	 			}
	 			break;
 			case 2: //Parcel B
 				parcel = new Parcel(2);
	 			parcel.setCoord(x, y, z);
	 			if(load.collide(parcel, truck, 0, 0)){
	 				if(load.collide(parcel, truck, 0, 1)){
	 					if(load.collide(parcel, truck, 0, 2)){
	 		 				start(3);
	 		 			}else{
	 		 				parcel.rotate();
	 		 				parcel.rotate();
	 		 				truck.put(parcel);
	 		 				start(4);
	 		 			}
		 			}else{
		 				parcel.rotate();
 		 				truck.put(parcel);
 		 				start(4);
		 			}
	 			}else{
	 				truck.put(parcel);
		 			start(4);
	 			}
 				break;
 			case 3: //Parcel C
 				parcel = new Parcel(3);
	 			parcel.setCoord(x, y, z);
	 			if(load.collide(parcel, truck, 0, 0)){
	 				start(4);
	 			}else{
	 				truck.put(parcel);
	 				start(4);
	 			}
 				break;
 			case 4:
 				y++;
 				if(y>=6){
 					
 					y=1;
 					z--;
 					if(z<=0){
 						
 						z=8;
 						x++;
 						
 						if(x>=34){
 							
 							//END
 							start(5);
 						}else{
 							System.out.println(x + "" + y + "" +z );
 							start(1);
 						}
 					}else{
						start(1);
					}
 				}else{
					start(1);
				}
 				break;
 			case 5:
 				System.out.println("END");
 				break;
 		}
 	}
}

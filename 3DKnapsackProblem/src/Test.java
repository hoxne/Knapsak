import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args){
		//Initialising a new list
		List<Parcel> myList = new ArrayList<Parcel>();
		Parcel[] prova = new Parcel[10]; 
		//Initialising randomly the parcels
		for(int i = 0; i<10; i++){
			prova[i] = new Parcel(((int)(Math.random()*3))+1,((int)(Math.random()*50))+1);
		}
		//Ordering by value
		for(int i = 0; i<10 ; i++){
			for(int j = i; j<10; j++){
				Parcel temp;
				if(prova[i].value<prova[j].value){
					temp = prova[i];
					prova[i] = prova[j];
					prova[j] = temp;
				}
			}
		}
		//Setting up the list with the parcels
		for(int i = 0; i<10; i++){
			myList.add(prova[i]);
		}
		for(Parcel next: myList){
			
			System.out.println(next.toString());
		}
		
		Truck truck1 = new Truck();
		
		truck1.put(myList.get(0));
		
	}

}
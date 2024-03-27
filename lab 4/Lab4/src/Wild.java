//TO DO: import all libraries that you use here

import java.util.ArrayList;

public class Wild {
	static final int MAXT = 3, MAXX=4, MAXY=2;

	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<>();

		//Populate Wilderness with Wolves and Deer
		int wolfCount = 0;
		int deerCount = 0;

		for (int i = 0; i < MAXX; i++){
			for (int j = 0; j < MAXY; j++){
				switch ((int) (Math.random()*2)){
					case 0 -> {
						animals.add(new Wolf(i,j,new int[]{MAXX, MAXY}, wolfCount));
						wolfCount++;
					}
					case 1 -> {
						animals.add(new Deer(i,j, new int[]{MAXX, MAXY}, deerCount));
						deerCount++;
					}
				}
			}
		}

		Wilderness w = new Wilderness(animals);

		System.out.println("Generation 0\n" + w.toString());

		for(int t=0; t < MAXT; t++) {
            w.doTimestep();
			System.out.println("\nGeneration "+(t+1)+"\n"+w.toString());
		}
	}
}

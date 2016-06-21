import java.util.Random;
public class CitySim9002 {
	public static void main(String[] args) {
		int seed=0;
		if (args.length!=1){
			System.out.println("Please enter one integer argument, seed");
			System.exit(0);
		}
		else{
			try{
				seed = Integer.parseInt(args[0]);
				System.out.println("Welcome to CitySim!  Your seed is " + seed);
			}
			catch (NumberFormatException e) {
				System.out.println("Please enter one integer argument, seed");
				System.exit(0);
			}
		}
		
	
		for (int i=1;i<6;i++){
			Visitor nv=new Visitor();
			nv.visitorchosen();
			System.out.println("Visitor " + i + " is a " + nv.visitorchosen() + "." );
			nv.preferences(i);
			System.out.println("***");

			}
		
	
				
	}


}

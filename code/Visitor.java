import java.util.Random;

public class Visitor {
	String vc,lc;
	int vx=0;
	String[] visitortype={"Student","Professor","Business Person","Blogger"};
	String[] location={"The Cathedral of Learning","Squirrel Hill","The Point","Downtown","left the city"};
	
	public int random(){
		Random rtemp = new Random();
		int visitornumber = Math.abs(rtemp.nextInt()%4);
//		System.out.println(visitornumber);
		return visitornumber;
	}
	public int ranloc(){
		Random ltemp = new Random();
		int locnumber = Math.abs(ltemp.nextInt()%5);
//		System.out.println(locnumber);
		return locnumber;
	}
	public String visitorchosen(){
		vc=visitortype[random()];
//		System.out.println(vc);
		return vc;
	}
	public String locationchosen(){
		lc=location[ranloc()];
//		System.out.println(lc);
		return lc;
	}
	public String preferences(int i){
		
//		String temploc=locationchosen();
		while(locationchosen()!=location[4]){
			String temploc=locationchosen();
			if(visitorchosen()=="Student" && temploc!="left the city"){
//				String temploc=locationchosen();
				if(temploc=="The Cathedral of Learning"){
					System.out.println("Visitor "+i+" is going to "+ temploc); 
					System.out.println("Visitor "+i+" did not like the "+temploc);
					String t="like";
					return t;
				}
				else{
					System.out.println("Visitor "+i+" is going to "+ temploc);
					System.out.println("Visitor "+i+" did like the "+temploc);
				}
					
			}
			else if(visitorchosen()=="Professor" && temploc!="left the city"){
//				String temploc=locationchosen();
				System.out.println("Visitor "+i+" is going to "+ temploc);
				System.out.println("Visitor "+i+" did like the "+temploc);
									
			}
			else if(visitorchosen()=="Business Person" && temploc!="left the city"){
//				String temploc=locationchosen();
				if(temploc=="Squirrel Hill" || temploc=="Downtown"){
					System.out.println("Visitor "+i+" is going to "+ temploc); 
					System.out.println("Visitor "+i+" did like the "+temploc);
				}
				else{
					System.out.println("Visitor "+i+" is going to "+ temploc);
					System.out.println("Visitor "+i+" did not like the "+temploc);
				}
					
			}
			else if(visitorchosen()=="Blogger" && temploc!="left the city"){
//				String temploc=locationchosen();
				System.out.println("Visitor "+i+" is going to "+ temploc);
				System.out.println("Visitor "+i+" did not like the "+temploc);
					
			}
			else if(visitorchosen()=="left the city"){
				break;
			}
			
		}
		System.out.println("Visitor "+i+" has left the city");
		return lc;
	}


}

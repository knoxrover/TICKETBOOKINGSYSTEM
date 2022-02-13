import java.util.*;


public class Test {
	public static void main (String[] args) throws customException11 {
		
		

		
//		Operations o = new Operations();
		Operations2 o = new Operations2();
		
		Scanner sc = new Scanner(System.in);
		boolean flag= true;
		while(flag){
			int choice =10;
			System.out.println("Enter your choice from below menu : -> ");
			System.out.println("1.New user - book ticket");
			System.out.println("2.Existing user - check status of ticket booking");
			System.out.println("3.Exit");
			
			String ch = sc.next();
			if(o.isValidInput(ch)) {
				 choice = Integer.valueOf(ch);
			}
			
			
			switch(choice) {
			case 1:
				System.out.println("Enter user name");
				String name = sc.next();
				if(o.isValidName(name)) {
				o.addUser(name);
				}else {
					System.out.println("Enter name length greater than 3");
					continue;
				}
				break;
			case 2:
				System.out.println("Enter reference Id");
				String refID = sc.next();
				o.getTicketStatus(refID);
				break;
			case 3 :
				System.out.println("Exiting....!");
				flag=false;
				break;
			default:
				System.out.println("Wrong choice please try again");
				break;
				
			}
		}
		
//		HashMap<Integer,Queue<Integer>> hm=new HashMap<>();
//		Queue<Integer> q=new LinkedList<>();
//		q.add(1);
//		q.add(2);
//		q.add(3);
//		hm.put(1, q);
//		
//		while(!hm.get(1).isEmpty()) {
//			int i=hm.get(1).poll();
//			System.out.println(i);
//		}
//		System.out.println(hm.get(1));
		
		
	}
}

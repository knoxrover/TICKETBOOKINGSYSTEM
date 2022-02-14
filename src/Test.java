import java.util.*;



public class Test {
	public static void main (String[] args)  {
		
		

		
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
				if(o.isValidName(name))
					o.addUser(name);
				else
					System.out.println("Please write valid name and try again...");
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
		
	}
}

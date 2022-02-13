
import java.util.*;

public class Operations {
	
	private static HashMap<Block,Queue<TicketBuyer>> ALL_BLOCK_DETAILS = new HashMap<>();
	private static HashMap<String,String> ticketPosition = new HashMap<>(); // for getting 
	//key will be ref_id and value will be 
	//1.if booked -> string value which block 2. if not booked - returns string value of position in which block ( ex -block 3, position 4)

	
	private static HashMap<Block,Integer> ticketPositionMap;
	static int noOfAvailableBlocks;
	private static int totalSeatsAvailable;
	
	public Operations(){
		totalSeatsAvailable=20;
		noOfAvailableBlocks=4;
		ticketPositionMap=new HashMap<>();
		initializeAllQueues();
		intializeTicketForQs(ticketPositionMap);
	}
	 
private void initializeAllQueues() {
		// TODO Auto-generated method stub
	Queue<TicketBuyer> Q1 = new LinkedList<>();
	Queue<TicketBuyer> Q2 = new LinkedList<>();
	Queue<TicketBuyer> Q3 = new LinkedList<>();
	Queue<TicketBuyer> Q4 = new LinkedList<>();
	
	ALL_BLOCK_DETAILS.put(Block.B1,Q1);
	ALL_BLOCK_DETAILS.put(Block.B2,Q2);
	ALL_BLOCK_DETAILS.put(Block.B3,Q3);
	ALL_BLOCK_DETAILS.put(Block.B4,Q4);
	
	}

//	private static HashMap<Zone,HashMap<Block,Queue<TicketBuyer>>> ALL_ZONES_DETAILS;
	
	public void addUser(String name) {
		
		
		if(totalSeatsAvailable>0) {
		
			String refId = Operations.genHash(name);
			System.out.println("refId : "+refId);
			int hcode = refId.hashCode();
			System.out.println("Hash code ->"+hcode);
			int alloc = hcode%4 + 1;
			System.out.println(alloc);
			TicketBuyer user = new TicketBuyer(name);
			user.setReferenceId(refId);
		
			Block allocatedBlock =null;
		
			switch(alloc) {
			case 1:
				allocatedBlock=Block.B1;
				break;
			case 2:
				allocatedBlock=Block.B2;
				break;
			case 3:
				allocatedBlock=Block.B3;
				break;
			case 4:
				allocatedBlock=Block.B4;
				break;	
			}
			qPMethod(allocatedBlock,user);
		}else {
			System.out.println("Tickets are sold out , please try for the next match!");
			System.exit(0);
		}
			
		// example - > method .... queueplacementmethod(block[alloc],user);		
	}
	
	
	public void qPMethod(Block block,TicketBuyer user) {
		
//		if(ALL_BLOCK_DETAILS.containsKey(block)) {
//			Queue<TicketBuyer> q=ALL_BLOCK_DETAILS.get(block);
//			q.add(user);
//			ALL_BLOCK_DETAILS.put(block, q);
//		}
//		else {
//			Queue<TicketBuyer> q=new LinkedList<>();
//			q.add(user);
//			ALL_BLOCK_DETAILS.put(block, q);
//		}
		
		if(ALL_BLOCK_DETAILS.containsKey(block)) {
		if(ticketPositionMap.get(block)>0) {
			Queue<TicketBuyer> q=ALL_BLOCK_DETAILS.get(block);
			q.add(user);
			ALL_BLOCK_DETAILS.put(block, q);
			int pos=6-ticketPositionMap.get(block);
			String sss = "User is placed at Block "+block+" and position in the queue is "+pos;
			ticketPosition.put(user.getReferenceId(),sss);
			int get=ticketPositionMap.get(block)-1;
			
			ticketPositionMap.put(block, get);
		}
		else{
			Queue<TicketBuyer> q=ALL_BLOCK_DETAILS.get(block);
			Operations.setBookedStatus(block);
			ALL_BLOCK_DETAILS.remove(block);
			noOfAvailableBlocks--;
			reAllocate(user);
		}
		}
		else {
			reAllocate(user);
		}
		
	}
	private static void setBookedStatus(Block block) {
		// TODO Auto-generated method stub
		Queue<TicketBuyer> q=ALL_BLOCK_DETAILS.get(block);
		while(q.size()>0)
		{
			TicketBuyer tb=q.poll();
			String b=null;
			switch (block) {
			case B1: 
				b="Your Ticket has been booked at Block1";
				break;
			case B2: 
				b="Your Ticket has been booked at Block2";
				break;
			case B3:
				b="Your Ticket has been booked at Block3";
				break;
			case B4:
				b="Your Ticket has been booked at Block4";
				break;
			}
			tb.setIs_book(true);
			ticketPosition.put(tb.getReferenceId(), b);
			totalSeatsAvailable--;
		}
	}



	private void reAllocate(TicketBuyer user) {
		System.out.println("Reallocated.....");
	}

	private static String genHash(String name) {
		Random r=new Random();
		name=name.substring(0,3);
		return "REF"+Integer.toString(r.nextInt(901)+101)+name;
	}
	
	
	
	static void intializeTicketForQs(HashMap<Block,Integer> ticketPositionMap) {
		ticketPositionMap.put(Block.B1,5);
		ticketPositionMap.put(Block.B2,5);
		ticketPositionMap.put(Block.B3,5);
		ticketPositionMap.put(Block.B4,5);
		}

	public void getTicketStatus(String refID) {
		if(ticketPosition.containsKey(refID)) {
		System.out.println("Getting your ticket status , please wait");
		System.out.println(ticketPosition.get(refID));
	}
	else {
		System.out.println("Entered reference Id is invalid. Please check again and try later.");
	}
	
}

	public boolean isValidInput(String ch) {
		if(ch.length()==1) {
		if(!Character.isDigit(ch.charAt(0))) return false; //a ch.size=1 
		else return true;
		}else {
			return false;
		}
		
	}
}

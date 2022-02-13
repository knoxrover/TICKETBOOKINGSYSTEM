
public class TicketBuyer {
	
	private String name;
	private String referenceId;
	private boolean booked;
	
	public TicketBuyer(String name) {
		this.name = name;
		booked=false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public boolean isIs_book() {
		return booked;
	}
	public void setIs_book(boolean booked) {
		this.booked = booked;
	}
	
}

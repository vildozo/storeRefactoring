package rf.store;

public class Customer {
	
    public String customerFirstName;
    public String customerLastName;
    private String contactPhoneNumber;
	private String contactName;

	
	
    public Customer(String firstName, String lastName, String phoneNumber)
    {
        this.customerFirstName = firstName;
        this.customerLastName = lastName;
        this.contactPhoneNumber=phoneNumber;
    }

	public String getFirstName() {
		return customerFirstName;
	}

	public String getFastName() {
		return customerLastName;
	}
	
	public String getPhoneNumber() {
		return contactPhoneNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public String formatPhone() {
		return String.format("CountryCode:%s - Citycode:%s - LocalNumber:%s", contactPhoneNumber.substring(0, 2), contactPhoneNumber.substring(2, 4), contactPhoneNumber.substring(4));
	}
}

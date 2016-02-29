package rf.store;

public class Customer {
	
    public String firstName;
    public String fastName;
    private String phoneNumber;
	private String contactName;

	
	
    public Customer(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.fastName = lastName;
        this.phoneNumber=phoneNumber;
    }

	public String getFirstName() {
		return firstName;
	}

	public String getFastName() {
		return fastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public String formatPhone() {
		return String.format("CountryCode:%s - Citycode:%s - LocalNumber:%s", phoneNumber.substring(0, 2), phoneNumber.substring(2, 4), phoneNumber.substring(4));
	}
}

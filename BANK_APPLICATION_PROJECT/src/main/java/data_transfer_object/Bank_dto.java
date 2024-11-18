package data_transfer_object;

public class Bank_dto {
	private String email;
    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private long phone;
    private int pin;
    private long adhar;
    private double balance;
    private long accNo;
    private String acctype;

    public Bank_dto(String email, String firstName, String lastName, String address, int age, long phone, int pin,long adhar, double balance, long accNo,String acctype) 
    {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.phone = phone;
		this.pin = pin;
		this.adhar = adhar;
		this.balance = balance;
		this.accNo = accNo;
		this.acctype=acctype;
	}

	// Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }

    public int getPin() 
    { 
    	return pin; 
    }
    public void setPin(int pin)
    { 
    	this.pin = pin; 
    }

    public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public long getAccNo() { return accNo; }
    public void setAccNo(long accNo) { this.accNo = accNo; }
	public void setPhone(String phoneNumber) {
		// TODO Auto-generated method stub
	}
	
	public long getAdhar() {
		return adhar;
	}
	public void setAdhar(long adhar) {
		this.adhar = adhar;
	}

	@Override
	public String toString() {
		return "AccountDTO [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", age=" + age + ", phone=" + phone + ", pin=" + pin + ", adhar=" + adhar + ", balance="
				+ balance + ", accNo=" + accNo + ", acctype=" + acctype + "]";
	}


}

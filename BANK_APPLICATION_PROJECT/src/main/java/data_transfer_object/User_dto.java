package data_transfer_object;

public class User_dto {
	
	private String firstname,lastname,email,pwd,gender,address,image;
	private int age;
	private long phone;
	public User_dto(String firstname, String lastname, String email, String pwd, String gender, String address,
			String image, int age, long phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.pwd = pwd;
		this.gender = gender;
		this.address = address;
		this.image = image;
		this.age = age;
		this.phone = phone;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User_Dto [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", pwd=" + pwd
				+ ", gender=" + gender + ", address=" + address + ", image=" + image + ", age=" + age + ", phone="
				+ phone + "]";
	}

}

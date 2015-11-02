
public class AddressBook {
	private static int TOTAL_ADDRESS = 0;
	private int id;
	private String name;
	private String mobile;
	private String email;
	private String department
	;
	
	public AddressBook(){}
	
	public AddressBook(String name,String mobile,
			String email,String department) {
		this.id = ++TOTAL_ADDRESS;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.department = department;
	}

	public int getId() {
		return Id;
	}

	public void setNo(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append("|");
		sb.append(name);
		sb.append("|");
		sb.append(mobile);
		sb.append("|");
		sb.append(email);
		sb.append("|");
		sb.append(department);
		
		return sb.toString();
	}
	
	public String toCSV() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(",");
		sb.append(mobile);
		sb.append(",");
		sb.append(email);
		sb.append(",");
		sb.append(department);
		
		return sb.toString();
	}
}


public class Student {
	private int id;
	private String name;
	private String phone;

public void StudentInfo(int id, String name, String phone){
	this.id = id;
	this.name = name;
	this.phone = phone;
	
	
}
public int getId() {
	return id;
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

public String getPhone() {
	return phone;
}

public void setMobile(String phone) {
	this.phone = phone;
}
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(id);
	sb.append("|");
	sb.append(name);
	sb.append("|");
	sb.append(phone);
	sb.append("|"); 
	
	return sb.toString();
}
public String toCSV() {
	StringBuilder sb = new StringBuilder();
	sb.append(id);
	sb.append(",");
	sb.append(name);
	sb.append(",");
	sb.append(phone);
	sb.append(",");
	
	return sb.toString();
}
}
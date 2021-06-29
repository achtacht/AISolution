
public class Customer {

	int age;
	String gender;
	String location;
	int time;
	String group;

	public Customer() {

	}

	public Customer(int age, String gender, String location, int time, String group) {
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.time = time;
		this.group = group;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}


	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return String.format("%s : \n [Age] :%21d	[Gender] :%18s \n [Location] :%16s	[Time Spent On Online] :%4d", 
				this.group, this.age, this.gender, this.location, this.time);
	}

}

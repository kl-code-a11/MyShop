package bean;

public class User {
	private int id;
	private String name;
	private String password;
	private double money;
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		
	}
	public User(int id, String name, String password, double money) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.money = money;
	}
	

}

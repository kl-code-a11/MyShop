package bean;

public class Goods {
	private int gid;
	private String name;
	private GoodsType gtype;
	public GoodsType getGtype() {
		return gtype;
	}
	public void setGtype(GoodsType gtype) {
		this.gtype = gtype;
	}

	private double price;
	private int num;
	private String address;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
public Goods(int gid, String name, int num) {
	this.gid = gid;
	this.name = name;
	this.num = num;
	// TODO 自动生成的构造函数存根
}
public Goods(int gid, String name, double price, int num) {
	this.gid = gid;
	this.name = name;
	this.price = price;
	this.num = num;

}

public Goods() {
	
}

}

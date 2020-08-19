package bean;

public class Car {
	private int carid;
	private User user;
	private Goods goods;
	private int carnum;
	private double total;//对应商品的总价
	
	public Car(){
		
}
	

	public Car(User user, Goods goods, double total) {
		super();
		this.user = user;
		this.goods = goods;
		this.total = total;
	}


	public int getCarnum() {
		return carnum;
	}


	public void setCarnum(int carnum) {
		this.carnum = carnum;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	

	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	@Override
	public String toString() {
		return "Car [carid=" + carid + ", user=" + user.getName() + ", goods=" + goods.getName() + ", carnum=" + carnum + ", total=" + total
				+ "]";
	}
	

}

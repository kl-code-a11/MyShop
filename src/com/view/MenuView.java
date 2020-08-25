package com.view;

import java.util.List;
import java.util.Scanner;

import com.dao.CarDao;
import com.dao.GoodsDao;
import com.dao.GoodsTypeDao;
import com.dao.UserDao;
import com.dao.impl.CarDaoImpl;
import com.dao.impl.GoodsDaoImpl;
import com.dao.impl.GoodsTypeDaoImpl;
import com.dao.impl.UerDaoImpl;

import bean.Car;
import bean.Goods;
import bean.GoodsType;
import bean.User;

public class MenuView {
	static User user=null;
	Scanner sc=new Scanner(System.in);
	GoodsTypeDao gtd=new GoodsTypeDaoImpl();
	GoodsDao gd=new GoodsDaoImpl();
	UserDao ud=new UerDaoImpl();
	CarDao cd=new CarDaoImpl();
	
	
	public void show() 
	{
		boolean flag=true;
		
		c:while(flag) {
			System.out.println("=============601=================");
			System.out.println("欢迎来到601");
			List<GoodsType> gts=gtd.findAll();
			for(GoodsType gt:gts) {
				System.out.println(gt.getTid()+".\t"+gt.getTname());
			}
			System.out.println("请选择:");
			comShow(sc.nextInt());
			System.out.println("是否购买商品? y/n");
			if(sc.next().equals("y")) {
				if(user==null) {
				System.out.println("请先登录...");
				login();
				}
				else {
				shopping(user);
				System.out.println("请问你要继续购物吗？y/n");
				if(!sc.next().equals("y")) {
					System.out.println("您的购物清单:");
					List<Car> cars=cd.findAll(user.getId());
					if(cars.size()<1) {
						System.out.println("您当前没有购买任何商品");
					}
			   else{
						double total=0;
						for(Car order:cars) {
							System.out.println(order);
							total+=order.getTotal();
						}
						System.out.println(String.format("本次购物共消费:￥S%f,请问您要现在支付吗?y/n",total));
						
						if(sc.next().equals("y")) {
							while(user.getMoney()<total) {
								System.out.println(String.format("亲，您的余额不足，还差￥%f，请问您要充值吗?y/n",total-user.getMoney()));
								if(sc.next().equals("y")) {
									System.out.println("请输入充值金额:");
									user.setMoney(user.getMoney()+sc.nextDouble());
									ud.updateUser(user);
								}else {
									break;
								}
							}
							System.out.println("确认付款吗?yes/no");
							if(sc.next().equals("y")) {
							user.setMoney(user.getMoney()-total);
							ud.updateUser(user);
							cd.deleteCar(user.getId());
							System.out.println("付款成功,欢迎下次光临！");
							flag=false;							
						
						
					}else{
						System.out.println("再见!");
							flag=false;		
						}
			}
		}
			
				}
			}
			}
		}
}

	private void shopping(User user) {
		boolean flag=true;
		while(flag) {
			System.out.println("请输入商品的编号:");
			Goods goods=gd.findById(sc.nextInt());	
		    Car car=new Car();
			do {
				System.out.println(String.format("您刚才选择了%s,请选择购买数量:",goods.getName()));
			int num=sc.nextInt();
		
			if(goods.getNum()>num) {
					car.setCarnum(num);
					break;
			}
			else {
				System.out.println("该商品库存不足！");
			}
			}while(true);			
			car.setUser(user);
			car.setGoods(goods);
		    car.setTotal(car.getCarnum()*goods.getPrice());
			cd.save(car);
			System.out.println("请问您要继续购买该类商品吗?y/n");
			if(!sc.next().equals("y")) {
				flag=false;
			}
		}
		
	}

	private void login() {
		boolean flag=true;
		while(flag) {
			System.out.println("=========================登录注册========================\n"
					+ "1.\t         登录\n"+
					   "2.\t         注册\n"
					   + "==============================================================\n");
		System.out.println("请选择:");
		if(sc.next().equals("1")) {
			System.out.println("=======================登录==============================\n");
			System.out.println("请输入用户名:");
			String username=sc.next();
			System.out.println("请输入密码:");
			String password=sc.next();
			user=ud.login(username,password);
			if(user!=null) 
				return;
			else 
				System.out.println("用户名或密码错误");
			
		}else {
			boolean f=true;
			while(f) {
				System.out.println("=======================注册==============================\n");
				System.out.println("请输入用户名:");
				String username=sc.next();
				boolean b=ud.findByName(username);
				if(b) {
					do 
					{
					System.out.println("请输入密码:");
					String password=sc.next();
					if(password.length()<6) {
						System.out.println("密码长度不得小于6位!");
					}else {
						User user=new User();
						user.setName(username);
						user.setPassword(password);
						System.out.println("请输入余额宝余额:");
						user.setMoney(sc.nextDouble());
						ud.register(user);
						
						break;
					}
				    }while(true);  
				  }else {
					System.out.println("用户名已存在！");
					continue;
				}
				f=false;
				System.out.println("注册成功!");
			}
		}
		}
	
	}

	private void comShow(int nextInt) {
	List<Goods> goodsList=gd.findByTid(nextInt);
		if(goodsList.size()<1) {
			System.out.println("查无此商品！");
		}
		else {
			System.out.println("编号            名称                  单价                                数量      			原产地 ");
			goodsList.forEach(i->System.out.println(String.format("%d\t\t%s\t\t%f\t\t%d\t\t%s\t\t",
					i.getGid(),
					i.getName(),
					i.getPrice(),
					i.getNum(),
					i.getAddress()
					)));
		}
	}

}

package test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hms.entity.Room;
import cn.hms.entity.Roomtype;
import cn.hms.service.RoomBiz;

public class TestRoom {

	@Test
	  public void testRoomNumber(){
		  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		  RoomBiz roomBiz = (RoomBiz) context.getBean("roomBiz");
		  List<Room> roomList = roomBiz.findNumberByType(3);
		  for (Room room : roomList) {
			System.out.println(room.getNumber());
		}
	 }
	@Test
	public void testRoomType(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoomBiz roomBiz = (RoomBiz) context.getBean("roomBiz");
		int k = roomBiz.findType("101");
		System.out.println(k);
	 }
	@Test
	public void testGetIdByifendId(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		RoomBiz roomBiz = (RoomBiz) context.getBean("roomBiz");
		List<Integer> list = roomBiz.findIdByifendId();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	@Test
	public void testUpdateifendId(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		RoomBiz roomBiz = (RoomBiz) context.getBean("roomBiz");
		roomBiz.updateifendId();
	}
	@Test
	public void testGetId(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		RoomBiz roomBiz = (RoomBiz) context.getBean("roomBiz");
		int k = roomBiz.findId("101");
		System.out.println(k);
	}
	@Test
	public void testGetCount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		RoomBiz roomBiz = (RoomBiz) context.getBean("roomBiz");
		int k = roomBiz.findRoomCount();
		System.out.println(k);
	}
	@Test
	public void testGetFenye(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		RoomBiz roomBiz = (RoomBiz) context.getBean("roomBiz");
		List<Object[]> list = roomBiz.findRoomByidfendId(2, 5);
		for (Object[] obj : list) {
			System.out.print(((Room)obj[0]).getTypename());
			//System.out.println(((Room)obj[0]).getNumber());

			System.out.println(((Roomtype)obj[1]).getDayPrice());
			
		}
	}
}

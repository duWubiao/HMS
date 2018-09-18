package test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hms.entity.Liverecord;
import cn.hms.service.LivereCordBiz;

public class TestLivereCord {

	@Test
	public void test() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 LivereCordBiz liveBiz = (LivereCordBiz) context.getBean("liveBiz");
		 Liverecord live = (Liverecord) context.getBean("live");
		 live.setRid(0);
		 live.setName("张三");
//		 Date d = new Date();//创建Date对象
//		 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		 String f = sf.format(d);
		 live.setRegtime(new Date());
		 //live.setAge(20);
		 live.setPhone("13653984562");
		 live.setRoomId(1);
		 live.setIfendId(0);
		 live.setPrice(500);
		 liveBiz.saveLive(live);
	}
	
	@Test
	public void testGetRoomIdByifendId(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LivereCordBiz liveBiz = (LivereCordBiz) context.getBean("liveBiz");
		List<Integer> list = liveBiz.findRoomIdByifendId();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	@Test
	public void testGetRoomIdByifendIdLike(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LivereCordBiz liveBiz = (LivereCordBiz) context.getBean("liveBiz");
		List<Liverecord> list = liveBiz.findLivesByifendIdLike("马", 1, 3);
		for (Liverecord liverecord : list) {
			System.out.println(liverecord.getName());
		}
	}	
	@Test
	public void testGetCountByLike(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LivereCordBiz liveBiz = (LivereCordBiz) context.getBean("liveBiz");
		int k = liveBiz.findCountByLike("马");
		System.out.println(k);
	}	
	@Test
	public void testDelete(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LivereCordBiz liveBiz = (LivereCordBiz) context.getBean("liveBiz");
		liveBiz.deleteLive(13);
	}
}

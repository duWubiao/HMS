package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hms.service.RoomTypeBiz;

public class TestRoomType {

	@Test
	public void test() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 RoomTypeBiz rtb = (RoomTypeBiz) context.getBean("roomTypeBiz");
		 int k = rtb.findPriceByType(1);
		 System.out.println(k);
	}

}

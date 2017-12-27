package part03_exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part03_exam/aop.xml");
		Service svc = (Service) context.getBean("svc");
		svc.prn();

		/*
		 * start:1495152607562 prn sum:887459712 stop:1495152607595
		 */
	}

}

package part12_listener;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("part12_listener/di.xml");
		Service svc = (Service) context.getBean("svc");
		svc.prn();
		context.destroy();

	} // end main()

} // end class

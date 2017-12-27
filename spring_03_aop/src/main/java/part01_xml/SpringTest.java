package part01_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part01_xml/aop.xml");
		Service svc = (Service) context.getBean("svc");
		svc.prn1();

	} // end main()

} // end class

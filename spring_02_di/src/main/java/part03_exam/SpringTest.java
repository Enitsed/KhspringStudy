package part03_exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part03_exam/di.xml");
		Service svc = (Service) context.getBean("svc");
		svc.prn();

		/*
		 * [출력 결과]
		 * kim a1234
		 */

	} // end main()

} // end class

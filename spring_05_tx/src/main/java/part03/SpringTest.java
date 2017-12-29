package part03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part03/tx.xml");
		Service svc = (Service) context.getBean("svc");

		// 트랜잭션이 설정된 메소드에서는 try~catch를 설정하면 안되고
		// 메소드를 호출하는 곳에서 try~catch를 설정한다.
		try {
			svc.insertProcess();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	} // end main()
} // end class

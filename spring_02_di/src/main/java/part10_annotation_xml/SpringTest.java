package part10_annotation_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		String sn = (String) context.getBean("sn");
		System.out.println("sn:" + sn);

		Integer it = (Integer) context.getBean("it");
		System.out.println("it:" + it);

		String str = (String) context.getBean("str");
		System.out.println("str:" + str);

	} // end main()

} // end class

package part01_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 컨테이너(container)가 생성되는 시점은 각각 다르다.
 * 1. BeanFactory - getBean()
 * 2. ApllicationContext - container 생성될 때
 * 3. WebApllicationContext - was(tomcat)가 실행 될 때 
 */
public class SpringTest {

	public static void main(String[] args) {
		// 환경설정(part01_basic/di.xml)에 선언된 Bean들을 생성하고 관리해주는 객체를 container라 한다.
		// 현재 사용되고 있는 container는 ApplicationContext이다.
		String path = "part01_basic/di.xml";
		// context 라는 컨테이너가 생성되면 di.xml에 선언되어 있는 Bean들이 컨테이너 안에 생성된다.
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		Service svc = (Service) context.getBean("svc");
		svc.prn();

	} // end main()

} // end class

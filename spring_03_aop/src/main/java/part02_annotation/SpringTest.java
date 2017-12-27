package part02_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * AOP(Aspect Oriented Programming)
 * 1. AOP는 문제를 바라보는 관점을 기준으로 프로그래밍하는 기법이다.
 * 2. AOP는 문제를 해결하기 위한 핵심 관심사항과 전체에 적용되는 공통 관심사항을 기준으로 프로그래밍 함으로써 공통 모듈을 여러코드에
 *	쉽게 적용할 수 있도록 해준다.
 */

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part02_annotation/aop.xml");
		Service svc = (Service) context.getBean("svc");
		svc.prn1();

		System.out.println("=====================");
		svc.prn1(10);

		System.out.println("=====================");
		svc.prn1(20, 30);

		System.out.println("=====================");
		svc.prn2();

		System.out.println("=====================");
		svc.prn3();

		System.out.println("=====================");
		try {
			svc.prn4();
		} catch (Exception e) {
		}

		System.out.println("=====================");
		svc.prn5();

	} // end main()

} // end class

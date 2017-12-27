package part02_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 공통 로직만 구현해놓은 클래스 - 공통관점
@Aspect
public class AspectCommon {
	public AspectCommon() {

	}

	@Before("execution(* part02_annotation.ServiceImp.prn1(..))")
	public void comm1() {
		System.out.println("before");
	}

	@After("execution(* part02_annotation.ServiceImp.prn2(..))")
	public void comm2() {
		System.out.println("after");
	}

	// 리턴값과 매개변수의 값 두개가 사용된다.
	@AfterReturning(value = "execution(* part02_annotation.ServiceImp.prn3(..))", returning = "name")
	public void comm3(String name) {
		System.out.println("comm3:" + name);
	}

	@AfterThrowing(value = "execution(* part02_annotation.ServiceImp.prn4(..))", throwing = "ex")
	public void comm4(Exception ex) {
		System.out.println("comm4");
		if (ex != null) {
			// 익셉션 발생시
			System.out.println(ex.toString());
		}
	}

	@Around("execution(* part02_annotation.ServiceImp.prn5(..))")
	public void comm5(ProceedingJoinPoint point) {
		System.out.println("comm5 start");

		// 핵심로직에 가서 실행하고 다시 돌아온다.
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("comm5 end");
	}

} // end class

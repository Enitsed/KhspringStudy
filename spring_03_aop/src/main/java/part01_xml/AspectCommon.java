package part01_xml;

import org.aspectj.lang.ProceedingJoinPoint;

// 공통 로직만 구현해놓은 클래스 - 공통관점
public class AspectCommon {
	public AspectCommon() {

	}

	public void comm1() {
		System.out.println("before");
	}

	public void comm2() {
		System.out.println("after");
	}

	public void comm3(String name) {
		System.out.println("comm3:" + name);
	}

	public void comm4(Exception ex) {
		System.out.println("comm4");
		if (ex != null) {
			// 익셉션 발생시
			System.out.println(ex.toString());
		}
	}

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

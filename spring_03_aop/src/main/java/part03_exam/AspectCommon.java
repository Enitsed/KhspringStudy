package part03_exam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectCommon {
	@Around("execution(* part03_exam.ServiceImp.prn(..))")
	public void prn(ProceedingJoinPoint point) {
		System.out.println("start:" + System.currentTimeMillis());

		// 핵심로직에 가서 실행하고 다시 돌아온다.
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("end:" + System.currentTimeMillis());
	}

}

package part03_exam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	private Log log = LogFactory.getLog(getClass());

	public void logging(ProceedingJoinPoint joinPoint) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		stopWatch.stop();
		System.out.println(joinPoint.getSignature().getName() + "_메서드 실행시간:" + stopWatch.getTotalTimeMillis());

	}// end logging()
}// end class

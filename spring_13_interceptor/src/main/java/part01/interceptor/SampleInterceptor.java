package part01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * preHandle() - 컨트롤러에 들어가기전 접근
 * postHandle() - 컨트롤러 접근 후 view 페이지 접근 전
 * afterCompletion() - 컨트롤러와 view 페이지 모두 접근 후
 */
public class SampleInterceptor extends HandlerInterceptorAdapter {

	// 인터셉터에서 제외시켜줄 컨트롤러를 등록한다.
	static final String[] EXCLUDE_URL_LIST = { "/write.do" };

	public SampleInterceptor() {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String reqUrl = request.getRequestURL().toString();
		System.out.println("reqUrl : " + reqUrl);

		for (String target : EXCLUDE_URL_LIST) {
			if (reqUrl.indexOf(target) > -1) {
				return true;
			}
		}

		System.out.println("pre handle...");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		String reqUrl = request.getRequestURL().toString();
		System.out.println("reqUrl : " + reqUrl);

		for (String target : EXCLUDE_URL_LIST) {
			if (reqUrl.indexOf(target) > -1) {
				return;
			}
		}
		System.out.println("post handle...");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		String reqUrl = request.getRequestURL().toString();
		System.out.println("reqUrl : " + reqUrl);

		for (String target : EXCLUDE_URL_LIST) {
			if (reqUrl.indexOf(target) > -1) {
				return;
			}
		}

		System.out.println("afterCompletion...");
	}

} // end class

package part04_ajax_daum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8090/myajax/daumForm.do
@Controller
public class SearchDaumController {
	public SearchDaumController() {

	}

	@RequestMapping("/daumForm.do")
	public String form() {
		return "part04_ajax_daum/daumForm";
	}

	/*
	 * curl -v -X GET "https://dapi.kakao.com/v2/search/book?target=title" \
	 * --data-urlencode "query=미움받을 용기" \ -H
	 * "Authorization: KakaoAK kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
	 */

	@RequestMapping(value = "/searchOpen.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String process(String search) throws MalformedURLException, IOException {
		String input = null;
		String total = "";
		String url = "https://dapi.kakao.com/v2/search/book?target=title";
		url += "&query=" + URLEncoder.encode(search, "UTF-8");

		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestProperty("Authorization", "KakaoAK 20ac9eeb2ad7facf067779804bf4ed6c");
		con.setRequestMethod("GET");

		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while ((input = reader.readLine()) != null) {
			total += input;
		}

		System.out.println(total);
		return total;

	}

} // end class

package part11_multi_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstConfig {
	@Bean
	public String sn() {
		return new String("spring");
	}

}

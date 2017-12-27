package part10_annotation_xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:part10_annotation_xml/di1.xml", "classpath:part10_annotation_xml/di2.xml" })
public class Config {

	@Bean
	public String str() {
		return new String("spring");
	}

} // end class

package part11_multi_annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ FirstConfig.class, SecondConfig.class })
public class MainConfig {

} // end class

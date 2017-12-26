package part07_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바코드에서 어노테이션을 이용한 스프링 환경설정
@Configuration
public class Config {
	public Config() {

	}

	// <bean id = "user" class="part07_annotation.User">
	// <constructor-arg value="kim" />
	// <constructor-arg value="a1234" />
	// </bean>

	public User user() {
		return new User("kim", "a1234");
	}

	// <bean id="svc" class="part07_annotation.ServiceImp" >
	// <constructor-arg ref="user" />
	// </bean>

	@Bean // @Bean을 선언할 때 이름속성을 지정하지 않으면 메소드명이 Bean ID가 된다.
	public ServiceImp svc() {
		return new ServiceImp(user());
	}

	// @Bean을 선언할 때 name 속성을 지정하면 name 속성의 값이 Bean ID가 된다.
	@Bean(name = "ss")
	public ServiceImp svc2() {
		return new ServiceImp(user());
	}

} // end class

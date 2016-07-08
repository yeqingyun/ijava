package cn.ilovejava;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan
@EnableTransactionManagement
@SpringBootApplication
@Log4j
public class IlovejavaStudyApplication {

	@Bean
	public Object testBean(PlatformTransactionManager platformTransactionManager){
		return new Object();
	}

	public static void main(String[] args) {
		SpringApplication.run(IlovejavaStudyApplication.class, args);
	}

	/*@Bean
	public ServletListenerRegistrationBean ServletListenerRegistrationBean(){
		return new ServletListenerRegistrationBean(new MySessionListener());
	}

	@Bean
	public HttpSessionListener httpSessionListener(){
		return new MySessionListener();
	}*/
}

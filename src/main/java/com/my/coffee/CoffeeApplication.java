package com.my.coffee;

import com.my.coffee.mycontroller.MyFilter;
import com.my.coffee.mycontroller.MyListener;
import com.my.coffee.mycontroller.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
@EnableCaching
@SpringBootApplication
public class CoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeApplication.class, args);
	}

	/**注册servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServlet(){

		return  new ServletRegistrationBean(new MyServlet(),"/uu");

	}

	/**注册filter,会在servlet前执行
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilter(){
		return new FilterRegistrationBean(new MyFilter(),getServlet());
	}

	/**注册Lister
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean getListener(){
		return new ServletListenerRegistrationBean(new MyListener());
	}
}

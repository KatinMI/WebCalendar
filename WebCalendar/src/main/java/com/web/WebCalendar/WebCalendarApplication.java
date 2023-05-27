package com.web.WebCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class WebCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebCalendarApplication.class, args);
	}

}

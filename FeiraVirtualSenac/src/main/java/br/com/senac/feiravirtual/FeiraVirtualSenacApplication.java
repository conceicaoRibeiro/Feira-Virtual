package br.com.senac.feiravirtual;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class FeiraVirtualSenacApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeiraVirtualSenacApplication.class, args);
	}
	
	 @Bean  
	   public LocaleResolver localeResolver(){  
	      return new FixedLocaleResolver(new Locale("pt", "BR"));  
	   }

}

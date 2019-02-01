package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.config;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.interceptors.LoggerInterceptor;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.interceptors.LoginInterceptor;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.interceptors.SessionTimerInterceptor;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.interceptors.UserInterceptor;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:log4j.properties")
@ComponentScan(basePackages = "com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql")
public class PersonWebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
		.addResourceLocations("/static/");
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		 messageSource.setBasename("/i18n/messages");
	     messageSource.setDefaultEncoding("UTF-8");
	     return messageSource;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    // mvc interceptors
		registry.addInterceptor(new LoginInterceptor());
	    registry.addInterceptor(new LoggerInterceptor());
	    registry.addInterceptor(new UserInterceptor());
	    registry.addInterceptor(new SessionTimerInterceptor());
	    
	    // internationalization or i18n interceptor
	    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("language");
	    registry.addInterceptor(interceptor);
	}
}

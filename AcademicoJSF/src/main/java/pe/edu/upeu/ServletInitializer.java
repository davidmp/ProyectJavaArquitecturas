package pe.edu.upeu;

import java.util.Collections;
import javax.faces.application.ProjectStage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.primefaces.util.Constants;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.faces.mvc.JsfView;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
@EnableAutoConfiguration //(exclude = { JpaConfig.class })
@ComponentScan
@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AcademicoJsfApplication.class);
	}
        
        @Bean
	public static CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.setScopes(Collections.<String, Object>singletonMap(FacesViewScope.NAME, new FacesViewScope()));
		return configurer;
	}

	@Bean
	public ServletContextInitializer servletContextCustomizer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext sc) throws ServletException {
				sc.setInitParameter(Constants.ContextParams.THEME, "start");
				sc.setInitParameter(Constants.ContextParams.FONT_AWESOME, "true");
				sc.setInitParameter(ProjectStage.PROJECT_STAGE_PARAM_NAME, ProjectStage.Development.name());
                                
			}
		};
	}

//	@Bean
//	public UrlBasedViewResolver setupViewResolver() {
//		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setViewClass(JsfView.class);
//                resolver.setPrefix("/WEB-INF/modulos/");
//		resolver.setSuffix(".xhtml");
//		
//		return resolver;
//	}
                
	@Bean
	public MessageSource messageSourceOther() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
                
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");		
                registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");               
	}        
}

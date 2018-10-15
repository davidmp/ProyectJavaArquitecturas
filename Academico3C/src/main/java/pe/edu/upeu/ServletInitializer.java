package pe.edu.upeu;


import java.util.Collections;


import javax.faces.application.ProjectStage;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.catalina.Context;

import javax.faces.webapp.FacesServlet;
//import java.util.EnumSet;
//import javax.servlet.DispatcherType;
//import org.ocpsoft.rewrite.servlet.RewriteFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.primefaces.util.Constants;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;


import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableAutoConfiguration(/*exclude = { JpaConfig.class }*/)
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Academico3CApplication.class);
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
				sc.setInitParameter(Constants.ContextParams.THEME, "sunny");
				sc.setInitParameter(Constants.ContextParams.FONT_AWESOME, "true");
				sc.setInitParameter(ProjectStage.PROJECT_STAGE_PARAM_NAME, ProjectStage.Development.name());
                                
			}
		};
	}

        @Bean
        public ServletRegistrationBean servletRegistrationBean() {
            FacesServlet servlet = new FacesServlet();
            ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
            return servletRegistrationBean;
        }
    
//        @Bean
//        public FilterRegistrationBean rewriteFilter() {
//            FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
//            rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
//                    DispatcherType.ASYNC, DispatcherType.ERROR));
//            rwFilter.addUrlPatterns("/*");
//            return rwFilter;
//        }	
        
      
//        @Bean
//        public ServletWebServerFactory servletContainer() {
//            TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//                @Override
//                protected void postProcessContext(Context context) {
//
//                    context.addWelcomeFile("index.jsf");
//
//                    context.addMimeMapping("eot", "application/vnd.ms-fontobject");
//                    context.addMimeMapping("ttf", "application/x-font-ttf");
//                    context.addMimeMapping("woff", "application/x-font-woff");                    
//
//                }
//            };            
//            return tomcat;
//        }

  

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

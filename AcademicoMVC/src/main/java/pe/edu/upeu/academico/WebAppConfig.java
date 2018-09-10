/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.academico;

/**
 *
 * @author davidmp
 */

import org.springframework.context.MessageSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan("pe.edu.upeu.academico")
@EnableWebMvc

public class WebAppConfig extends WebMvcConfigurerAdapter{
 

        @Bean
        public UrlBasedViewResolver tilesViewResolver(){
            UrlBasedViewResolver tilesViewResolver=new UrlBasedViewResolver();
            tilesViewResolver.setViewClass(TilesView.class);
            return tilesViewResolver;
        }
        
        @Bean
        public TilesConfigurer tilesConfigurer(){
            TilesConfigurer tconf=new TilesConfigurer();
            tconf.setDefinitions(new String[]{"/WEB-INF/tiles/tiles.xml"} );
            return tconf;
        }
    
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/upeu/modulos/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
        
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
        
        
        
        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        }        
}

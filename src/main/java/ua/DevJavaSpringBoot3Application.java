package ua;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
@ImportAutoConfiguration(classes=WebMvcAutoConfiguration.class)
public class DevJavaSpringBoot3Application extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(DevJavaSpringBoot3Application.class, args);

	}
	
	@Value("${file.path}")
	private String path;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setOneIndexedParameters(true);
		argumentResolvers.add(resolver);
		super.addArgumentResolvers(argumentResolvers);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/*").addResourceLocations("file:"+path+"/");
		registry.addResourceHandler("transporter/img/*").addResourceLocations("file:"+path+"/");
		registry.addResourceHandler("profile/img/*").addResourceLocations("file:"+path+"/");
		registry.addResourceHandler("/owner/img/*").addResourceLocations("file:"+path+"/");
		super.addResourceHandlers(registry);
	}
	
	
}

package com.kt.shopping.config;

import com.kt.common.interceptor.VisitStatInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {
	private final VisitStatInterceptor visitStatInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(visitStatInterceptor);
		// registry.addInterceptor(new VisitStatInterceptor());
	}
}

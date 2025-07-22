package com.springboot.main;

import java.util.List;
import java.util.Properties;

import org.egovframe.rte.ptl.mvc.filter.HTMLTagFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
public class EgovWebMvcConfiguration extends WebMvcConfigurationSupport {

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		Properties prop = new Properties();
		prop.setProperty("org.springframework.dao.DataAccessException", "cmmn/dataAccessFailure");
		prop.setProperty("org.springframework.transaction.TransactionException", "cmmn/transactionFailure");
		prop.setProperty("org.egovframe.rte.fdl.cmmn.exception.EgovBizException", "cmmn/egovError");
		prop.setProperty("org.springframework.security.AccessDeniedException", "cmmn/egovError");
		prop.setProperty("java.lang.Throwable", "/common/error");

		Properties statusCode = new Properties();
		statusCode.setProperty("/common/error", "400");
		statusCode.setProperty("/common/error", "500");

		SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();
		smer.setDefaultErrorView("cmmn/bizError");
		smer.setExceptionMappings(prop);
		smer.setStatusCodes(statusCode);
		exceptionResolvers.add(smer);
	}

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setOrder(1);
		urlBasedViewResolver.setViewClass(JstlView.class);
		urlBasedViewResolver.setPrefix("/WEB-INF/jsp/egovframework/example/");
		urlBasedViewResolver.setSuffix(".jsp");
		return urlBasedViewResolver;
	}

	@Bean
	public FilterRegistrationBean<CharacterEncodingFilter> encodingFilterBean() {
		FilterRegistrationBean<CharacterEncodingFilter> registrationBean = new FilterRegistrationBean<>();
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setForceEncoding(true);
		filter.setEncoding("UTF-8");
		registrationBean.setFilter(filter);
		registrationBean.addUrlPatterns("*.do");
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<HTMLTagFilter> htmlTagFilterBean() {
		FilterRegistrationBean<HTMLTagFilter> registrationBean = new FilterRegistrationBean<>();
		HTMLTagFilter filter = new HTMLTagFilter();
		registrationBean.setFilter(filter);
		registrationBean.addUrlPatterns("*.do");
		return registrationBean;
	}

}

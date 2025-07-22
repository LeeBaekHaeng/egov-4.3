package com.springboot.main;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 배치실행개발팀
 * @since 2021. 11.25
 * @version 1.0
 * @see
 *  <pre>
 *      개정이력(Modification Information)
 *
 *  수정일         수정자          수정내용
 *  ----------   -----------   ---------------------------
 *  2021.11.25   신용호          최초 생성
 *  2023.03.15   신용호          java Config 및 Annotation 적용
 *  
 *  </pre>
 */

@SpringBootApplication
@ComponentScan(basePackages="egovframework")
@Import(EgovBootInitialization.class)
@EnableBatchProcessing
public class EgovBootApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EgovBootApplication.class, args);

		System.out.println("##### EgovSampleBootApplication Start #####");

		ApplicationContext context = new SpringApplicationBuilder(EgovBootApplication.class)
                .headless(false)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
		/*
		SpringApplication springApplication = new SpringApplication(EgovBootApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.setLogStartupInfo(false);
		springApplication.run(args);
		*/
		System.out.println("##### EgovSampleBootApplication End #####");
	}
	
}

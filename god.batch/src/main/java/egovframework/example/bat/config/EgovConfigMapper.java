package egovframework.example.bat.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

@Configuration
public class EgovConfigMapper {

	@Bean(name = "egov.sqlSession")
	public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws IOException {
		PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean
				.setConfigLocation(pmrpr.getResource("classpath:/egovframework/mapper/config/mapper-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(
				pmrpr.getResources("classpath:/egovframework/mapper/example/bat/Egov_Example_SQL.xml"));
		/*
		 * classpath:/egovframework/mapper/example/bat/Egov_Example_SQL_altibase.xml
		 * classpath:/egovframework/mapper/example/bat/Egov_Example_SQL_cubrid.xml
		 * classpath:/egovframework/mapper/example/bat/Egov_Example_SQL_mysql.xml
		 * classpath:/egovframework/mapper/example/bat/Egov_Example_SQL_oracle.xml
		 * classpath:/egovframework/mapper/example/bat/Egov_Example_SQL_tibero.xml
		 */
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	public SqlSessionTemplate batchSqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
	}

	@Bean
	@Lazy
	public DefaultLobHandler lobHandler() {
		return new DefaultLobHandler();
	}

}

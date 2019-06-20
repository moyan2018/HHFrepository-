package com.pengfei.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class SpringMvcConfig {

    @Autowired
    private SpringMvcConfig springMvcConfig;

    @PostConstruct
    public void init(){
        System.out.println("*************************************************************************");
        System.out.println();
        System.out.println("                         spring mvc config init start                     ");
        System.out.println();
        System.out.println("*************************************************************************");
    }

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new com.alibaba.druid.pool.DruidDataSource();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "dataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource( dataSource );
        sqlSessionFactoryBean.setMapperLocations( resolver.getResources("classpath*:/mapper/vue/sqlserver/*.xml") );
        sqlSessionFactoryBean.setConfigLocation( new ClassPathResource("mybatis-config.xml") );
        sqlSessionFactoryBean.setTypeAliasesPackage("com.pengfei.model.material");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = "sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mScannerConfigurer = new MapperScannerConfigurer();
        mScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        mScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mScannerConfigurer.setBasePackage("com.pengfei.vue.mapper");
        return mScannerConfigurer;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier(value = "dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "txAdvice")
    public TransactionInterceptor txAdvice(@Qualifier(value = "transactionManager") PlatformTransactionManager transactionManager){
        Properties properties = new Properties();
        // 需要执行在事务之中的操作
        properties.setProperty("add*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("save*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("insert*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("delete*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("remove*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("clear*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("update*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("edit*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("put*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("set*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("exec*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("submit*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("confirm*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("cancel*", "PROPAGATION_REQUIRED,-Exception");
        // 重新开启事务，用于事务嵌套
        properties.setProperty("new*", "PROPAGATION_REQUIRES_NEW,-Exception");
        // 查询只读事务
        properties.setProperty("get*", "PROPAGATION_NOT_SUPPORTED,readOnly");
        properties.setProperty("query*", "PROPAGATION_NOT_SUPPORTED,readOnly");
        properties.setProperty("find*", "PROPAGATION_NOT_SUPPORTED,readOnly");
        properties.setProperty("list*", "PROPAGATION_NOT_SUPPORTED,readOnly");
        properties.setProperty("count*", "PROPAGATION_NOT_SUPPORTED,readOnly");
        properties.setProperty("search*", "PROPAGATION_NOT_SUPPORTED,readOnly");
        properties.setProperty("page*", "PROPAGATION_NOT_SUPPORTED,readOnly");
        properties.setProperty("is*", "PROPAGATION_NOT_SUPPORTED,readOnly");
        return new TransactionInterceptor(transactionManager, properties);
    }

    @Bean(name = "txAdviceAdvisor")
    public Advisor txAdviceAdvisor(@Qualifier(value = "txAdvice") TransactionInterceptor txAdvice){
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("(execution(* com.pengfei.*.service..*.*(..)) or execution(* com.pengfei.*.face..*.*(..)))");
        return new DefaultPointcutAdvisor(pointcut, txAdvice);
    }
}

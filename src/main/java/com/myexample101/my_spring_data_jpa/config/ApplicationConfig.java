package com.myexample101.my_spring_data_jpa.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//UserRepository
@EnableJpaRepositories(basePackages={"com.myexample101.my_spring_data_jpa.repository"})
@EnableTransactionManagement 
//UserService
@ComponentScan(basePackages = {"com.myexample101.my_spring_data_jpa.service"})
public class ApplicationConfig {

  @Bean
  public DataSource dataSource() {
//    HSQLDB
//    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//    return builder.setType(EmbeddedDatabaseType.HSQL).build();
	  
//    MySQL	  
	  BasicDataSource dataSource = new BasicDataSource();
	  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	  dataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8");
	  dataSource.setUsername("root");
	  dataSource.setPassword("123456");
	  dataSource.setInitialSize(5);
	 return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setShowSql(true);
    vendorAdapter.setGenerateDdl(true);
    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    //实体类包
    factory.setPackagesToScan("com.myexample101.my_spring_data_jpa.entity");
    factory.setDataSource(dataSource());
    return factory;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    //事务
    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return txManager;
  }
}


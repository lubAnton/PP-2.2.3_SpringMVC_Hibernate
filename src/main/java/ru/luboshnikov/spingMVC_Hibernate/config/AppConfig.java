package ru.luboshnikov.spingMVC_Hibernate.config;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = "ru.luboshnikov.spingMVC_Hibernate")
public class AppConfig {

   private Environment env;

   @Autowired
   public AppConfig(Environment env) {
      this.env = env;
   }

   @Bean
   public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getProperty("db.driver"));
      dataSource.setUrl(env.getProperty("db.url"));
      dataSource.setUsername(env.getProperty("db.username"));
      dataSource.setPassword(env.getProperty("db.password"));
      return dataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
      LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
      entityManager.setDataSource(getDataSource());
      entityManager.setPackagesToScan(env.getProperty("db.entity.package"));
      entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      entityManager.setJpaProperties(getHibernateProperties());
      return entityManager;
   }
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
   }

   private Properties getHibernateProperties() {
         Properties properties = new Properties();
         properties.setProperty("hibernate.hbm2ddl.auto", "update");
         properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
         properties.setProperty("hibernate.show_sql", "true");
         return properties;
   }
   @Bean
   public PlatformTransactionManager transactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

      return transactionManager;
   }
}

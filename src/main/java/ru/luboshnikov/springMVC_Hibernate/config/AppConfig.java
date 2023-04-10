package ru.luboshnikov.springMVC_Hibernate.config;




import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = "ru.luboshnikov.springMVC_Hibernate")
public class AppConfig {

   @Bean
   public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/spring_hiber?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC");
      dataSource.setUsername("root");
      dataSource.setPassword("luboshA1984!");
      return dataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
      LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
      entityManager.setDataSource(getDataSource());
      entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
      entityManager.setPackagesToScan("ru.luboshnikov.springMVC_Hibernate.model");
      entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      entityManager.setJpaProperties(getHibernateProperties());
      return entityManager;
   }
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
   }
   @Bean
   public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
      return new PersistenceAnnotationBeanPostProcessor();
   }

   private Properties getHibernateProperties() {
         Properties properties = new Properties();
         properties.setProperty("hibernate.hbm2ddl.auto", "create");
         properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
         properties.setProperty("hibernate.show_sql", "true");
         return properties;
   }
   @Bean
   public PlatformTransactionManager transactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

      return transactionManager;
   }
}

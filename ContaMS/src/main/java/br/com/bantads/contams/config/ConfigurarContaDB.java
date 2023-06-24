package br.com.bantads.contams.config;

import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import br.com.bantads.contams.model.ContaCud;


@Configuration
@EnableJpaRepositories(
  basePackages = "br.com.bantads.contams.repository.command",
  entityManagerFactoryRef = "contaCudEntityManagerFactory",
  transactionManagerRef= "contaCudTransactionManager"
)
public class ConfigurarContaDB {
	@Primary
	@Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties contaDataSourceProperties() {
        return new DataSourceProperties();
    }
	
	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource.configuration")
    public DataSource contaDataSource() {
        return contaDataSourceProperties().initializeDataSourceBuilder()
        		.type(HikariDataSource.class).build();
    }
	
	@Primary
	@Bean(name="contaCudEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean contaEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(contaDataSource())
				.packages(ContaCud.class).build();
	}

	@Primary
	@Bean(name="contaCudTransactionManager")
	public PlatformTransactionManager contaCudTransactionManager(
			final @Qualifier("contaCudEntityManagerFactory") LocalContainerEntityManagerFactoryBean
			contaEntityManagerFactory) {
		return new JpaTransactionManager(contaEntityManagerFactory.getObject());
	}
}
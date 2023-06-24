package br.com.bantads.contams.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import br.com.bantads.contams.model.ContaR;


@Configuration
@EnableJpaRepositories(
  basePackages = "br.com.bantads.contams.repository.read",
  entityManagerFactoryRef = "contaReadEntityManagerFactory",
  transactionManagerRef = "contaReadTransactionManager"
)
public class ConfigurarContaReadDB {
	@Bean(name="contaReadProperties")
    @ConfigurationProperties("spring.datasource.read")
    public DataSourceProperties contaReaddataSourceProperties() {
        return new DataSourceProperties();
    }

	@Bean(name="contaReadDataSource")
	@ConfigurationProperties("spring.datasource.read.configuration")
    public DataSource contaReadDataSource() {
        return contaReaddataSourceProperties().initializeDataSourceBuilder()
        		.type(HikariDataSource.class).build();
    }

	@Bean(name="contaReadEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean contaReadEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(contaReadDataSource())
				.packages(ContaR.class).build();
	}

	@Bean(name="contaReadTransactionManager")
	public PlatformTransactionManager contaReadTransactionManager(
			final @Qualifier("contaReadEntityManagerFactory") LocalContainerEntityManagerFactoryBean
			contaReadEntityManagerFactory) {
		return new JpaTransactionManager(contaReadEntityManagerFactory.getObject());
	}
}
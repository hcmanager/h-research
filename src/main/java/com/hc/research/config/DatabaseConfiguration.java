package com.hc.research.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.hc.research.repository",
        entityManagerFactoryRef = "hcEntityManagerFactory",
        transactionManagerRef = "hcTransactionManager"
)
@EnableJpaAuditing
public class DatabaseConfiguration {

    private final Logger LOG = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean("hcDataSource")
    @ConfigurationProperties("spring.datasource.hc")
    public DataSource hcDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "hcEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
                         @Qualifier("hcDataSource") DataSource dataSource) {


        return entityManagerFactoryBuilder.dataSource(dataSource).packages("com.hc.research.domain").build();
    }

    @Bean(name = "hcTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("hcEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }

}

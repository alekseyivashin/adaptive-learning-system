package ru.ifmo.alekseyivashin.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Creator: aleks
 * Date:    13.04.17.
 */

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EntityScan(basePackages = {"ru.ifmo.alekseyivashin.models"})
@EnableJpaRepositories(basePackages = {"ru.ifmo.alekseyivashin.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}

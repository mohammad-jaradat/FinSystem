package com.qu.finsys.config;

import com.qu.finsys.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.qu.finsys.*",
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class
)
public class RepositoryConfiguration {


}

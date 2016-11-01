package com.fahai.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by zhanghao on 16/8/3.
 */
@Configuration
public class Config {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(
            @Value("${redis.port}") int port,
            @Value("${redis.dbindex}") int dbIndex) {
        JedisConnectionFactory j = new JedisConnectionFactory();
        j.setDatabase(dbIndex);
        j.setPort(port);
        System.out.println("JedisConnectionFactory" + j);
        return j;
    }

    @Bean
    public DruidDataSource dataSource(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password,
            @Value("${spring.datasource.initialSize}") int initialSize,
            @Value("${spring.datasource.minIdle}") int minIdle,
            @Value("${spring.datasource.maxActive}") int maxActive,
            @Value("${spring.datasource.maxWait}") int maxWait,
            @Value("${spring.datasource.validationQuery}") String validationQuery,
            @Value("${spring.datasource.testOnBorrow}") boolean testOnBorrow,
            @Value("${spring.datasource.testWhileIdle}") boolean testWhileIdle,
            @Value("${spring.datasource.poolPreparedStatements}") boolean poolPreparedStatements
    ) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);//用户名
        dataSource.setPassword(password);//密码
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        return dataSource;
    }

    @Autowired
    private DruidDataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}

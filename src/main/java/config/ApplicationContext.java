package config;

import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.earner.info.common.Constant;

/**
 * Java based application context configuration class.
 *
 * @author satya
 * 
 */
@Configuration
@EnableTransactionManagement
@PropertySource(
        {
            "classpath:ips-main.properties"
        })
@ComponentScan(basePackages =
{
		"com.earner"
})

@EnableScheduling
public class ApplicationContext
{
    @Autowired
    private Environment env;

    @Bean
    @Autowired
    public DataSource dataSource()
    {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    
    @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DataSource dataSource)
    {
    	DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);
        return txManager;
    }
   
}

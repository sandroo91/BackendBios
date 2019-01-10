package bios.springframework.spring5webapp.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

//
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;




import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "bios.springframework.spring5webapp")
@PropertySource("classpath:application.properties")
public class AppConfig {
    // set up variable to hold the properties

    @Autowired
    private Environment env;

    // set up a logger for diagnostics

    private Logger logger = Logger.getLogger(getClass().getName());


    // define a bean for our security datasource

    @Bean
    public DataSource securityDataSource() {

        // create connection pool
        ComboPooledDataSource securityDataSource
                = new ComboPooledDataSource();

        // set the jdbc driver class

        try {
            securityDataSource.setDriverClass(env.getProperty("spring.datasource.driverClassName"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

//         log the connection props
//         for sanity's sake, log this info
//         just to make sure we are REALLY reading data from properties file

        logger.info(">>> jdbc:sqlserver://localhost:1433;databaseName=BioscoopData=" + env.getProperty("spring.datasource.url"));
        logger.info(">>> TestGebruiker=" + env.getProperty("spring.datasource.username"));


        // set database connection props

        securityDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        securityDataSource.setUser(env.getProperty("spring.datasource.username"));
        securityDataSource.setPassword(env.getProperty("spring.datasource.password"));

        // set connection pool props

        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize"));

        securityDataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize"));

        securityDataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize"));

        securityDataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    // need a helper method
    // read environment property and convert to int

    private int getIntProperty(String propName) {

        String propVal = env.getProperty(propName);

        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }
}
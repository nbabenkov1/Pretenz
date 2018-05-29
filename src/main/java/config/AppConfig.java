package config;

import org.springframework.context.annotation.*;

/**
 * Created by N.Babenkov on 25.04.2018.
 **/
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan({"Utils.DAO","Services", "SQl", "aspects"})
@Import(DBConfig.class)
@EnableAspectJAutoProxy
public class AppConfig {
}

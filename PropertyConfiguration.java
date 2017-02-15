

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by 542596 on 1/13/2017.
 */
@Configuration
public class PropertyConfiguration {

    @Bean
    @Profile("stg")
    public static PropertyPlaceholderConfigurer stPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource("/int/eca/apps/was/i1/properties/app-stg.properties"));
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

    @Bean
    @Profile("qat")
    public static PropertyPlaceholderConfigurer qaPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource("/dvl/eca/apps/was/i1/properties/app-qat.properties"));
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

    @Bean
    @Profile("dvl")
    public static PropertyPlaceholderConfigurer developmentPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource("/dvl/eca/apps/was/i1/properties/app-dvl.properties"));
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

    @Bean
    @Profile("local") @RefreshScope
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource("C:/Yogen/api/project/content-api/resources/app-local.properties"));
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }
}

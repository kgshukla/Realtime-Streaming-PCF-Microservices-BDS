package io.pivotal.data.eventservice;

import com.gemstone.gemfire.cache.GemFireCache;

import io.pivotal.data.eventservice.model.EventMetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by cq on 17/9/15.
 */
@SpringBootApplication
@EnableGemfireRepositories
@ImportResource("/gemfire-bean.xml")
@ActiveProfiles
@EnableDiscoveryClient
public class App {

    @Bean
    @Profile("local")
    CacheFactoryBean cacheFactoryBean() {
        return new CacheFactoryBean();
    }

    @Bean
    @Profile("local")
    LocalRegionFactoryBean<String, EventMetrics> localRegionFactory(final GemFireCache cache) {
        return new LocalRegionFactoryBean<String, EventMetrics>() {

            {
                setCache(cache);
                setName("ProcessData");
                setClose(false);
            }
        };
    }
    

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

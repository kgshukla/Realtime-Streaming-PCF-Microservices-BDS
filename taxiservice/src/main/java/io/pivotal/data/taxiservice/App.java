/**
 * 
 */
package io.pivotal.data.taxiservice;

import io.pivotal.data.taxiservice.models.TaxiRouteMetrics;

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

import com.gemstone.gemfire.cache.GemFireCache;

/**
 * @author shuklk2
 *
 */
@SpringBootApplication
@ImportResource("/gemfire-bean.xml")
@EnableGemfireRepositories
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
    LocalRegionFactoryBean<String, TaxiRouteMetrics> localRegionFactory(final GemFireCache cache) {
        return new LocalRegionFactoryBean<String, TaxiRouteMetrics>() {

            {
                setCache(cache);
                setName("TaxiData");
                setClose(false);
            }
        };
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}

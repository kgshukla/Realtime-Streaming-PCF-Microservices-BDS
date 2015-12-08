/**
 * 
 */
package io.pivotal.data.analyticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shuklk2
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}

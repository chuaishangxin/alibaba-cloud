package wpq.alibaba.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaDubboClient {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaDubboClient.class, args);
	}


}

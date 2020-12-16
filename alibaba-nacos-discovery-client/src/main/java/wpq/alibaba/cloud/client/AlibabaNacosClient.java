package wpq.alibaba.cloud.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosClient {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosClient.class, args);
	}

	/*==============   LoadBalancerClient 实现服务调用的负载均衡		==========================*/

//	@Slf4j
//	@RestController
//	static class TestController {
//
//		@Autowired
//		LoadBalancerClient loadBalancerClient;
//
//		@GetMapping("/test")
//		public String test() {
//			// 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
//			ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server");
//			String url = serviceInstance.getUri() + "/hello?name=" + "didi";
//			RestTemplate restTemplate = new RestTemplate();
//			String result = restTemplate.getForObject(url, String.class);
//			return "Invoke : " + url + ", return : " + result;
//		}
//	}

	/*==============   RestTemplate 实现服务调用的负载均衡		==========================*/

//	@Slf4j
//	@RestController
//	static class TestController {
//
//		@Autowired
//		RestTemplate restTemplate;
//
//		@GetMapping("/test")
//		public String test() {
//			String result = restTemplate.getForObject("http://alibaba-nacos-discovery-server/hello?name=didi", String.class);
//			return "Return : " + result;
//		}
//	}
//
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	/*==============   WebClient 实现服务调用的负载均衡		==========================*/

//	@Slf4j
//	@RestController
//	static class TestController {
//
//		@Autowired
//		private WebClient.Builder webClientBuilder;
//
//		@GetMapping("/test")
//		public Mono<String> test() {
//			Mono<String> result = webClientBuilder.build()
//					.get()
//					.uri("http://alibaba-nacos-discovery-server/hello?name=didi")
//					.retrieve()
//					.bodyToMono(String.class);
//			return result;
//		}
//	}
//
//	@Bean
//	@LoadBalanced
//	public WebClient.Builder loadBalancedWebClientBuilder() {
//		return WebClient.builder();
//	}

	/*==============   FeignClient 实现服务调用的负载均衡		==========================*/


	@Slf4j
	@RestController
	static class TestController {

		@Autowired
		Client client;

		@GetMapping("/test")
		public String test() {
			String result = client.hello("didi");
			return "Return : " + result;
		}
	}

	@FeignClient("alibaba-nacos-discovery-server")
	interface Client {

		@GetMapping("/hello")
		String hello(@RequestParam(name = "name") String name);

	}

}

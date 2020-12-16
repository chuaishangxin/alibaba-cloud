package wpq.alibaba.cloud.sentinel;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
public class AlibabaSentinel {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaSentinel.class, args);
	}

	// 注解支持的配置Bean
	@Bean
	public SentinelResourceAspect sentinelResourceAspect() {
		return new SentinelResourceAspect();
	}

	@Slf4j
	@RestController
	static class TestController {

		@Autowired
		private TestService testService;

		@GetMapping("/hello")
		public String hello() {
			testService.doSomeThing("hello " + LocalDateTime.now());
			return "didispace.com";
		}

	}

}

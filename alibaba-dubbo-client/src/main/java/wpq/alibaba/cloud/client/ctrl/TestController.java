package wpq.alibaba.cloud.client.ctrl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wpq.alibaba.cloud.api.server.HelloService;

/**
 * @author wangpq
 * @version 1.0
 * @className TestController
 * @description TODO
 * @date 2020/12/16 10:55
 */
@Slf4j
@RestController
public class TestController {

    @Reference(version = "1.0.0")
    HelloService helloService;

    @GetMapping("/test")
    public String test() {
        return helloService.hello("didispace.com");
    }
}

package wpq.alibaba.cloud.dubbo.impl;


import org.apache.dubbo.config.annotation.Service;
import wpq.alibaba.cloud.api.server.HelloService;

/**
 * @author wangpq
 * @version 1.0
 * @className HelloServiceImpl
 * @description TODO
 * @date 2020/12/16 10:05
 */

@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        return "hello " + name;
    }
}

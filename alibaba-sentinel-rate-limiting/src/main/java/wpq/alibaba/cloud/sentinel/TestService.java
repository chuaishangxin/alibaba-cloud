package wpq.alibaba.cloud.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangpq
 * @version 1.0
 * @className TestService
 * @description TODO
 * @date 2020/12/15 18:10
 */
@Slf4j
@Service
public class TestService {

    @SentinelResource(value = "doSomeThing", blockHandler =  "exceptionHandler")
    public void doSomeThing(String str) {
        log.info(str);
    }

    // 限流与阻塞处理
    public void exceptionHandler(String str, BlockException ex) {
        log.error( "blockHandler：" + str, ex);
    }
}

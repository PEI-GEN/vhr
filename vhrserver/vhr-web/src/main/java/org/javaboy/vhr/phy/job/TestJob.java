package org.javaboy.vhr.phy.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * XXLJob的测试类，需要继承IJobHandler类
 *
 * @author Promsing(张有博)
 * @version 1.0.0
 * @since 2021/11/14 - 19:51
 */
@Slf4j
@Component
@JobHandler(value = "TestJob") //与xxl-job上的jobHandler做对应
public class TestJob extends IJobHandler {
    /**
     * execute handler, invoked when executor receives a scheduling request
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String param)  {
        XxlJobLogger.log(this.getClass().getSimpleName() + "--start");
        try {
            System.out.println("业务代码1");
            System.out.println("业务代码2");
            System.out.println("业务代码3");
            System.out.println("业务代码4");
            System.out.println("业务代码5");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        XxlJobLogger.log(this.getClass().getSimpleName() + "--end");
        return ReturnT.SUCCESS;
    }
}
package com.heuman.activiti.example.listener.activiti;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @author heuman
 * @date 2019/3/3 13:56
 */
@Log4j2
public class TestListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("+++++++++++++++++++++++++++++++++=======================*********************");
    }

}

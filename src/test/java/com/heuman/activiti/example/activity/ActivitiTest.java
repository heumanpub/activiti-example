package com.heuman.activiti.example.activity;

import com.heuman.activiti.example.ActivitiExampleApplicationTest;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @author heuman
 * @date 2019/3/2 12:19
 */
public class ActivitiTest extends ActivitiExampleApplicationTest {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Test
    public void deployTest() {
        repositoryService.createDeployment()
                .addClasspathResource("process/basic.bpmn20.xml")
//                .addInputStream("工作流1", getClass().getResourceAsStream("/process/basic.bpmn20.xml"))
                .deploy();
    }

    @Test
    public void startProcessInstance() {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("myProcess1")
                .latestVersion()
                .singleResult();
        runtimeService.startProcessInstanceById(processDefinition.getId(), "myProcess1:23", new HashMap<>(0));
    }

}

package com.codurance.training.tasks.executors;

import com.codurance.training.tasks.models.Task;
import com.codurance.training.tasks.services.TaskService;

import java.util.List;
import java.util.Map;

public class CheckCommandExecutor extends CommandExecutor {

    private final TaskService taskService;
    public CheckCommandExecutor(Map<String, List<Task>> tasks, final TaskService taskService) {
        super(tasks);
        this.taskService = taskService;
    }

    @Override
    public boolean isApplicable(String commandLine) {
        return commandLine.split(" ")[0].equals("check");
    }

    @Override
    public void executeCommand(String commandLine) {
        String[] commandWithArgs = commandLine.split(" ");
        taskService.setDone(tasks, commandWithArgs[1], true);
    }
}

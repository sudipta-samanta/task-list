package com.codurance.training.tasks.executors;

import com.codurance.training.tasks.models.Task;
import com.codurance.training.tasks.services.ProjectService;
import com.codurance.training.tasks.services.TaskService;

import java.util.List;
import java.util.Map;

public class AddCommandExecutor extends CommandExecutor {
    private final TaskService taskService;
    private final ProjectService projectService;
    public AddCommandExecutor(Map<String, List<Task>> tasks, final TaskService taskService, final ProjectService projectService) {
        super(tasks);
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @Override
    public boolean isApplicable(String commandLine) {
        return commandLine.split(" ")[0].equals("add");
    }

    @Override
    public void executeCommand(String commandLine) {
        String[] commandWithArgs = commandLine.split(" ");
        if (commandWithArgs[1].equals("task")) {
            taskService.addTask(tasks, commandWithArgs[2], commandWithArgs[3]);
        } else if(commandWithArgs[1].equals("project")) {
            projectService.addProject(tasks, commandWithArgs[2]);
        }
    }
}

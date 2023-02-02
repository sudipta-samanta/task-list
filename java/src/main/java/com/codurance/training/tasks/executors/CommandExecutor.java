package com.codurance.training.tasks.executors;

import com.codurance.training.tasks.models.Task;

import java.util.List;
import java.util.Map;

public abstract class CommandExecutor {

    protected final Map<String, List<Task>> tasks;

    public CommandExecutor(Map<String, List<Task>> tasks) {
        this.tasks = tasks;
    }

    public abstract boolean isApplicable(String commandLine);
    public abstract void executeCommand(String commandLine);
}

package com.codurance.training.tasks.executors;

import com.codurance.training.tasks.models.Task;
import com.codurance.training.tasks.services.IPrinterService;

import java.util.List;
import java.util.Map;

public class ShowCommandExecutor extends CommandExecutor {

    private final IPrinterService printerService;
    public ShowCommandExecutor(Map<String, List<Task>> tasks, final IPrinterService printerService) {
        super(tasks);
        this.printerService = printerService;
    }

    @Override
    public boolean isApplicable(String commandLine) {
        return commandLine.split(" ")[0].equals("show");
    }

    @Override
    public void executeCommand(String commandLine) {
        printerService.show(tasks);
    }
}

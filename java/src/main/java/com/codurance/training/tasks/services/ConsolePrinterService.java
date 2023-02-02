package com.codurance.training.tasks.services;

import com.codurance.training.tasks.models.Task;

import java.util.List;
import java.util.Map;

public class ConsolePrinterService implements IPrinterService {
    @Override
    public void show(Map<String, List<Task>> tasks) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            System.out.println(project.getKey());
            for (Task task : project.getValue()) {
                System.out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            System.out.println();
        }
    }
}

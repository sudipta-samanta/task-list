package com.codurance.training.tasks.services;

import com.codurance.training.tasks.utils.IDGenerator;
import com.codurance.training.tasks.models.Task;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class TaskService {

    private final IDGenerator idGenerator;

    public TaskService(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public void addTask(final Map<String, List<Task>> tasks, String project, String description) {
        final List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(idGenerator.nextID(), description, false));
    }

    public void setDone(final Map<String, List<Task>> tasks, String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}

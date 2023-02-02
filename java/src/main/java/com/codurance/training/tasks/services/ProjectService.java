package com.codurance.training.tasks.services;

import com.codurance.training.tasks.models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProjectService {

    public void addProject(final Map<String, List<Task>> tasks, String name){
        tasks.put(name, new ArrayList<Task>());
    }
}

package com.codurance.training.tasks.Database;

import com.codurance.training.tasks.models.Task;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    public Map<String, List<Task>> getTasks() {
        return tasks;
    }
}

package com.codurance.training.tasks.services;

import com.codurance.training.tasks.models.Task;

import java.util.List;
import java.util.Map;

public interface IPrinterService {
    void show(final Map<String, List<Task>> tasks);
}

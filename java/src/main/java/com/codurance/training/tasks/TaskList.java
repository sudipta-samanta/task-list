package com.codurance.training.tasks;

import com.codurance.training.tasks.Database.Database;
import com.codurance.training.tasks.executors.*;
import com.codurance.training.tasks.models.Task;
import com.codurance.training.tasks.services.ConsolePrinterService;
import com.codurance.training.tasks.services.IPrinterService;
import com.codurance.training.tasks.services.ProjectService;
import com.codurance.training.tasks.services.TaskService;
import com.codurance.training.tasks.utils.HelperUtils;
import com.codurance.training.tasks.utils.IDGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;
    private final List<CommandExecutor> commandExecutors;


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        final Map<String, List<Task>> tasks = new Database().getTasks();

        final IDGenerator idGenerator = new IDGenerator();
        final IPrinterService printer = new ConsolePrinterService();
        final ProjectService projectService = new ProjectService();
        final TaskService taskService = new TaskService(idGenerator);


        final List<CommandExecutor> commandExecutorList = Arrays.asList(
                new AddCommandExecutor(tasks, taskService, projectService),
                new CheckCommandExecutor(tasks, taskService),
                new ShowCommandExecutor(tasks, printer),
                new UncheckCommandExecutor(tasks, taskService)
        );
        new TaskList(in, out, commandExecutorList).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer, List<CommandExecutor> commandExecutors) {
        this.in = reader;
        this.out = writer;
        this.commandExecutors = commandExecutors;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        boolean commandNotFound = true;
        for(CommandExecutor executor: commandExecutors) {
            if(executor.isApplicable(commandLine)) {
                commandNotFound = false;
                executor.executeCommand(commandLine);
                break;
            } else if (commandLine.equals("help")) {
                HelperUtils.help();
                commandNotFound = false;
                break;
            }

        }
        if(commandNotFound) HelperUtils.error(commandLine);
    }
}

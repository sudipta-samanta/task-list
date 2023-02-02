package com.codurance.training.tasks.utils;

import static java.lang.System.out;

public class HelperUtils {

    private HelperUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }

    public static void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}

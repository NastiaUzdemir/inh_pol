package ru.netology;

import java.util.Arrays;

public class Epic extends Task {
    protected int id;
    protected String[] subtasks;

    @Override
    public int getId() {
        return id;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public Epic(int id, String[] subtasks) {
        super(id, "Task 1");
        this.id = id;
        this.subtasks = new String[]{Arrays.toString(subtasks)};
    }

    @Override
    public boolean matches(String query) {
        if (super.matches(query)) {
            return true;
        }
        // Перебираем подзадачи и проверяем каждую через if
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }

}

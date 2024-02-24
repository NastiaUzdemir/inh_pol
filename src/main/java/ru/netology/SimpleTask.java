package ru.netology;

public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id, "Task 1"); // вызов родительского конструктора
        this.title = title; // заполнение своих полей
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        if (query == null) {
            return false;
        }
        if (title.contains(query)) {
            return true;
        }
        return false;
    }


}

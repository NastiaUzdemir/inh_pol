package ru.netology;
public class Meeting extends Task {
    protected int id;
    protected String topic;
    protected String project;

    @Override
    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    protected String start;


    public Meeting(int id, String project, String start, String topic) {
        super(id, "Task 1"); // вызов родительского конструктора
        this.id = id;
        this.project = project;
        this.start = start;
        this.topic = topic;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

}
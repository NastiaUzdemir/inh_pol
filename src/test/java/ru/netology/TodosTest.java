package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void meetingTestMatches() {
        Meeting meeting = new Meeting(
                5,
                "New Progect Test",
                "Приложение Нетологии",
                "Во вторник после обеда"
        );

        String query1 = "Во вторник";
        assertTrue(meeting.matches(query1));

        String query2 = "Test";
        assertTrue(meeting.matches(query2));

        String query3 = "версия приложения";
        Assertions.assertFalse(meeting.matches(query3));

    }

    @Test
    public void simpleTaskTestMatches() {
        SimpleTask simpleTask = new SimpleTask(12, "Выполнить дз к курсу");

        String query1 = "к";
        assertTrue(simpleTask.matches(query1));

        String query2 = "а";
        Assertions.assertFalse(simpleTask.matches(query2));

        String query3 = null;
        Assertions.assertFalse(simpleTask.matches(query3));

    }

    @Test
    public void epicTestMatches() {
        Epic epic = new Epic(111, new String[]{
                "Task1",
                "Task2",
                "Task3"
        });

        String query1 = "Task1";
        assertTrue(epic.matches(query1));

        String query2 = "Task2";
        assertTrue(epic.matches(query2));

        String query3 = "Task3";
        assertTrue(epic.matches(query3));

    }

    @Test
    public void testSearchWithMatchingQuery() {
        Todos todos = new Todos();
        Task task1 = new Task(123, "Task 1");
        Task task2 = new Task(124, "Task 2");
        Task task3 = new Task(125, "Task 3");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        // Вызываем метод search с поисковым запросом,
        // который должен совпадать с одной из задач
        Task[] result = todos.search("Task 2");

        // Проверяем, что результат содержит только одну задачу
        assertEquals(1, result.length);

        // Проверяем, что найденная задача та, которую мы ожидали
        Task[] expected = {task2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchWithNonMatchingQuery() {
        // Создаем объект Todos и добавляем в него задачи
        Todos todos = new Todos();
        Task task1 = new Task(111, "Task 1");
        Task task2 = new Task(123, "Task 2");
        Task task3 = new Task(323, "Task 3");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        // Вызываем метод search с поисковым запросом, который не совпадает ни с одной из задач
        Task[] result = todos.search("Task 4");

        // Проверяем, что результат пустой массив
        Task[] expected = {}; // Ожидаемый пустой массив
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearch_ReturnsAllTasks_WhenEmptyQuery() {

        Todos todos = new Todos();
        todos.add(new Task(1, "Task 1"));
        todos.add(new Task(2, "Task 2"));
        todos.add(new Task(3, "Task 3"));

        Task[] expected = {
                new Task(1, "Task 1"),
                new Task(2, "Task 2"),
                new Task(3, "Task 3")
        };

        Task[] result = todos.search("");

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchWithEmptyTodos() {
        Todos todos = new Todos();

        Task[] expected = {};

        Task[] result = todos.search("Task 1");

        assertArrayEquals(expected, result);
    }


}
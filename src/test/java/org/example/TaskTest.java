package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInTask() {
        Epic epic = new Epic(1, new String[]{"Task 1", "Task 2", "Task 3"});
        String query = "Task 5";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInTask() {
        String[] subtasks = {"Task 1", "Task 2", "Task 3"};
        Epic epic = new Epic(1, subtasks);
        String query = "Task 3";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "Unknown task");
        String query = "task";
        boolean expected = true; // ожидаемый результат, так как строка запроса содержится в названии задачи
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Unknown task");
        String query = "other";
        boolean expected = false; // ожидаемый результат, так как строка запроса не содержится в названии задачи
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Unknown topic", "Unknown project", "04-12-1992T:00:00Z");
        String query = "topic";
        boolean expected = true; // ожидаемый результат, так как строка запроса содержится в теме встречи
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Unknown topic", "Unknown project", "04-12-1992T:00:00Z");
        String query = "project";
        boolean expected = true; // ожидаемый результат, так как строка запроса содержится в проекте, к которому относится встреча
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInTopicOrProject() {
        Meeting meeting = new Meeting(1, "Unknown topic", "Unknown project", "04-12-1992T:00:00Z");
        String query = "other";
        boolean expected = false; // ожидаемый результат, так как строка запроса не содержится ни в теме встречи, ни в проекте
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }






}
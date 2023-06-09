package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
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

        Task[] expected = new Task[]{simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFirstSimpleTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(3, "Купить яйца"));
        todos.add(new Epic(4, new String[]{"Сделать уборку дома"}));
        Task[] expected = {};
        Task[] actual = todos.search("Помыть помуду");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addSecondSimpleTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(3, "Купить яйца"));
        todos.add(new Epic(4, new String[]{"Сделать уборку дома"}));
        Task[] expected = { new SimpleTask(3, "Купить яйца") };
        Task[] actual = todos.search("яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addThirdSimpleTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(3, "Купить яйца"));
        todos.add(new Epic(4, new String[]{"Сделать уборку дома"}));
        Task[] expected = { new SimpleTask(3, "Купить яйца"), new Epic(4, new String[]{"Сделать уборку дома"}) };
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }

}

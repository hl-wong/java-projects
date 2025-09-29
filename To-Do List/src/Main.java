import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();

        // As long the 'exit' is false, the program will keep running.
        boolean exit = false;

        while (!exit) {
            run();

            try {
                Scanner input = new Scanner(System.in);
                // User select the choice
                System.out.print("\nPlease enter the choice: ");
                int choice = Integer.parseInt(input.nextLine());

                Task task;

                switch (choice) {
                    case 1:
                        // Add task
                        System.out.print("\nPlease enter the task name: ");
                        String task_name = input.nextLine();

                        task = new Task(task_name, false, tasks);
                        task.addTask(task);
                        break;
                    case 2:
                        // Update task
                        task = new Task(tasks);
                        if (task.getTaskSize() == 0) {
                            System.out.println("\nThere are no tasks in the ArrayList\n");
                            break;
                        }
                        task.viewTasks();

                        try {
                            System.out.print("Please enter the choice to update task: ");
                            int index = Integer.parseInt(input.nextLine());
                            task.updateTask(index);
                        } catch (Exception e) {
                            System.out.println("Please enter a number\n");
                        }
                        break;
                    case 3:
                        // Delete task
                        task = new Task(tasks);
                        if (task.getTaskSize() == 0) {
                            System.out.println("\nThere are no tasks in the ArrayList\n");
                            break;
                        }
                        task.viewTasks();

                        try {
                            System.out.print("Please enter the choice to delete task: ");
                            int index = Integer.parseInt(input.nextLine());
                            task.deleteTask(index);
                        }
                        catch (Exception e) {
                            System.out.println("Please enter a number\n");
                        }
                        break;
                    case 4:
                        // View tasks
                        task = new Task(tasks);
                        task.viewTasks();
                        break;
                    case 5:
                        // Exit
                        exit = true;
                        System.out.println("Exit program");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Please enter a number\n");
            }
        }

    }

    static void run() {
        System.out.println("To-Do List");
        System.out.println("==========");
        System.out.println("[1] Add Task");
        System.out.println("[2] Update Task");
        System.out.println("[3] Delete Task");
        System.out.println("[4] View Tasks");
        System.out.println("[5] Exit");
    }
}
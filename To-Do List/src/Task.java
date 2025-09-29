import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    private String task_name;
    private boolean task_status;
    private ArrayList<Task> tasks;

    public Task(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task(String task_name, boolean task_status, ArrayList<Task> tasks) {
        this.task_name = task_name;
        this.task_status = task_status;
        this.tasks = tasks;
    }

    public String getTaskName() {
        return task_name;
    }

    public boolean getTaskStatus() {
        return task_status;
    }

    public int getTaskSize() {
        return tasks.size();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task have been added to the ArrayList\n");
    }

    public void updateTask(int index) {
        if (index > 0 && index <= tasks.size()) {
            Scanner input = new Scanner(System.in);

            System.out.println("\nTask Name");
            System.out.println("=========");
            System.out.print("Please enter the task name (empty is possible): ");
            String task_name = input.nextLine();

            if (task_name == "") {
                task_name = tasks.get(index - 1).task_name;
            }

            try {
                System.out.println("\nTask Status");
                System.out.println("===========");
                System.out.println("[1] Not Complete");
                System.out.println("[2] Complete");
                System.out.print("\nPlease enter the choice: ");
                int task_status = Integer.parseInt(input.nextLine());

                if (task_status == 2) {
                    tasks.set(index - 1, new Task(task_name, true, tasks));
                }
                else {
                    tasks.set(index - 1, new Task(task_name, false, tasks));
                }
                System.out.println("Task has been updated in the ArrayList\n");
            }
            catch (Exception e) {
                System.out.println("Please enter a number\n");
            }
        }
        else {
            System.out.println("Index out of bounds\n");
        }
    }

    public void deleteTask(int index) {
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Task has been deleted from the ArrayList\n");
        }
        else {
            System.out.println("Index out of bounds\n");
        }
    }

    public void viewTasks() {
        if (tasks.size() == 0) {
            System.out.println("\nThere are no tasks in the ArrayList");
        }
        else {
            System.out.println("\nTasks");
            System.out.println("=======");
            for (int i = 0; i < tasks.size(); i++) {
                String task_name = tasks.get(i).task_name;
                boolean task_status = tasks.get(i).task_status;

                if (task_status == true) {
                    System.out.println("[" + (i + 1) + "] " +  task_name + " / Complete");
                }
                else {
                    System.out.println("[" + (i + 1) + "] " +  task_name + " / Not Complete");
                }
            }
            System.out.print("\n");
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Taskmanager {
	private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nTask Management System");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();

        tasks.add(new Task(name, description, dueDate));
        System.out.println("Task added successfully!");
    }

    private static void removeTask() {
        System.out.print("Enter task name to remove: ");
        String nameToRemove = scanner.nextLine();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(nameToRemove)) {
                tasks.remove(i);
                System.out.println("Task removed successfully!");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nTask List:");
        for (Task task : tasks) {
            System.out.println("Name: " + task.getName());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println();
        }
    }
}


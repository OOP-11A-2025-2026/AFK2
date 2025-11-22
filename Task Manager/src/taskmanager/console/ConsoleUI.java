package taskmanager.console;

import java.util.Scanner;
import taskmanager.exceptions.InvalidCommandException;
// import taskmanager.services.TaskService;

public class ConsoleUI {
    // private final TaskService taskService;
    private final CommandParser commandParser;
    private final Scanner scanner;

    public ConsoleUI() {
        // this.taskService = new TaskService();
        this.commandParser = new CommandParser();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to Task Manager!");
        System.out.println("Type 'help' to see available commands.");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                // commandParser.execute(input, taskService, scanner);
                commandParser.execute(input, scanner);
            } catch (InvalidCommandException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace();
            }
        }
    }
}

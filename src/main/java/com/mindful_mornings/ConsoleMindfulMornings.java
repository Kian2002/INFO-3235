package com.mindful_mornings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleMindfulMornings {
    private Scanner scanner;
    private String currentMenu;
    private List<String> morningRoutine;
    private List<String> gratitudeEntries;

    public ConsoleMindfulMornings() {
        scanner = new Scanner(System.in);
        currentMenu = "Main Menu";
        morningRoutine = new ArrayList<>();
        gratitudeEntries = new ArrayList<>();
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            String option = scanner.nextLine();
            switch (currentMenu) {
                case "Main Menu":
                    handleMainMenu(option);
                    break;
                case "Morning Routine":
                    handleMorningRoutineMenu(option);
                    break;
                case "View Morning Routine":
                    viewMorningRoutine();
                    break;
                case "View Gratitude Entries":
                    viewGratitudeEntries();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("Current Menu: " + currentMenu);
        switch (currentMenu) {
            case "Main Menu":
                System.out.println("1. Create Morning Routine");
                System.out.println("2. Start Meditation Session");
                System.out.println("3. Record Gratitude Entry");
                System.out.println("4. View Morning Routine");
                System.out.println("5. View Gratitude Entries");
                break;
            case "Morning Routine":
                System.out.println("Enter tasks for your morning routine (type 'done' to finish):");
                break;
            default:
                System.out.println("Invalid menu.");
        }
        System.out.println("Enter your choice:");
    }

    void handleMainMenu(String option) {
        switch (option) {
            case "1":
                currentMenu = "Morning Routine";
                break;
            case "2":
                startMeditationSession();
                break;
            case "3":
                recordGratitudeEntry("Feeling grateful for nature.");
                break;
            case "4":
                currentMenu = "View Morning Routine";
                viewMorningRoutine();
                break;
            case "5":
                currentMenu = "View Gratitude Entries";
                viewGratitudeEntries();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    void handleMorningRoutineMenu(String option) {
        if (Objects.equals(option, "")) {
            System.out.println("Task cannot be empty. Please enter a valid task.");
        } else if (option.equals("done")) {
            currentMenu = "Main Menu";
            System.out.println("Morning routine saved: " + morningRoutine);
        } else {
            morningRoutine.add(option);
        }
    }

    void startMeditationSession() {
        // Simulate a meditation session with a timer countdown
        System.out.println("Starting meditation session...");
        for (int i = 10; i > 0; i--) {
            System.out.println("Remaining time: " + i + " minutes");
            try {
                Thread.sleep(1000); // Simulate 1 minute interval
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Meditation session completed.");
    }

    void recordGratitudeEntry(String entry) {
        System.out.println("Enter your gratitude entry:");
        if (entry.isEmpty()) entry = scanner.nextLine();
        gratitudeEntries.add(entry);
        System.out.println("Gratitude entry recorded: " + entry);
    }

    private void viewMorningRoutine() {
        System.out.println("Morning Routine:");
        if (morningRoutine.isEmpty()) {
            System.out.println("No tasks added yet.");
        } else {
            for (int i = 0; i < morningRoutine.size(); i++) {
                System.out.println((i + 1) + ". " + morningRoutine.get(i));
            }
        }
        currentMenu = "Main Menu";
    }

    private void viewGratitudeEntries() {
        System.out.println("Gratitude Entries:");
        if (gratitudeEntries.isEmpty()) {
            System.out.println("No entries recorded yet.");
        } else {
            for (String entry : gratitudeEntries) {
                System.out.println("- " + entry);
            }
        }
        currentMenu = "Main Menu";
    }

    public String getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(String morningRoutine) {
        this.currentMenu = morningRoutine;
    }

    public List<String> getMorningRoutine() {
        return morningRoutine;
    }

    public List<String> getGratitudeEntries() {
        return gratitudeEntries;
    }
}

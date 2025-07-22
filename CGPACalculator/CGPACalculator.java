package CGPACalculator;
import java.util.*;

public class CGPACalculator {
    private static Scanner sc = new Scanner(System.in);

    // Validates input credits and grades
    private static boolean validate(int[] credits, char[] grades, int numCourses) {
        for (int i = 0; i < numCourses; i++) {
            if (credits[i] <= 0 || credits[i] > 5) {
                return false;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            char ele = grades[i];
            if ("SABCED".indexOf(ele) == -1) {
                return false;
            }
        }
        return true;
    }

    // Converts grade character to numeric value
    public static int getGrade(char c) {
        switch (c) {
            case 'S': return 10;
            case 'A': return 9;
            case 'B': return 8;
            case 'C': return 7;
            case 'D': return 6;
            case 'E': return 5;
            default: return -1;
        }
    }

    // Calculates CGPA
    public static double getCGPA(int[] credits, char[] grades, int numCourses) {
        double totalPoints = 0, totalCredits = 0;
        for (int i = 0; i < numCourses; i++) {
            int gradePoint = getGrade(grades[i]);
            totalPoints += credits[i] * gradePoint;
            totalCredits += credits[i];
        }
        return totalPoints / totalCredits;
    }

    // Collects input from user
    public static void getInputs() {
        String choice = "";
        do {
            int numCourses = 0;
            try {
                System.out.print("Enter number of subjects: ");
                numCourses = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine(); // clear buffer
                continue;
            }

            int[] credits = new int[numCourses];
            char[] grades = new char[numCourses];

            for (int i = 0; i < numCourses; i++) {
                System.out.println("---- Subject " + (i + 1) + " ----");
                try {
                    System.out.print("Credits (1-5): ");
                    credits[i] = sc.nextInt();
                    System.out.print("Grade (S/A/B/C/D/E): ");
                    grades[i] = sc.next().toUpperCase().charAt(0);
                } catch (Exception e) {
                    System.out.println("Invalid input. Restarting...");
                    return;
                }
            }

            if (validate(credits, grades, numCourses)) {
                System.out.println("\n------ Result Summary ------");
                System.out.printf("%-10s%-10s%-10s\n", "Subject", "Credits", "Grade");
                for (int i = 0; i < numCourses; i++) {
                    System.out.printf("%-10d%-10d%-10c\n", (i + 1), credits[i], grades[i]);
                }
                System.out.printf("Your CGPA: %.2f\n", getCGPA(credits, grades, numCourses));
            } else {
                System.out.println("Invalid data entered. Try again.");
            }

            System.out.print("Do you want to calculate again? (yes/no): ");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("yes"));
    }

    public static void main(String[] args) {
        getInputs();
        String name = "Thanks for using our application :)";
        for(int i = 0;i < name.length();i++)
        {
            try
            {
                System.out.print(name.charAt(i));
                Thread.sleep(200);
            }
            catch(Exception e)
            {
                System.out.println("Interupted");
            }
        }
    }
}

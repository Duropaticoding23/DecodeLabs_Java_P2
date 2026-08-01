import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Phase I: Input - The Gatekeeper (Using Scanner with safe buffer handling)
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("       DECODELABS: GRADE CALCULATOR       ");
        System.out.println("==========================================");

        System.out.print("Enter the number of subjects: ");
        int numSubjects = Integer.parseInt(sc.nextLine());

        int totalMarks = 0;

        // Phase II: Process - Accumulator Loop & Defensive Programming
        for (int i = 1; i <= numSubjects; i++) {
            int currentMark;
            while (true) {
                System.out.print("Enter marks for subject " + i + " (out of 100): ");
                currentMark = Integer.parseInt(sc.nextLine());

                // Defensive Programming: Validate input bounds (0 to 100)
                if (currentMark >= 0 && currentMark <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input! Marks must be between 0 and 100. Try again.");
                }
            }
            // Accumulating total marks
            totalMarks += currentMark;
        }

        // Phase II: Type Casting to prevent integer division truncation
        double averagePercentage = (double) totalMarks / numSubjects;

        // Phase II: The Logic Ladder (Grade Assignment)
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Phase III: Output - Presentation Layer (Formatted Print)
        System.out.println("\n==========================================");
        System.out.println("       ACADEMIC PERFORMANCE REPORT        ");
        System.out.println("==========================================");
        System.out.println("Total Subjects  : " + numSubjects);
        System.out.println("Total Marks     : " + totalMarks + " / " + (numSubjects * 100));
        
        // Formatted float output with literal percentage sign[cite: 1]
        System.out.printf("Average Per.    : %.2f%%\n", averagePercentage);
        System.out.println("Assigned Grade  : " + grade);
        System.out.println("==========================================");

        sc.close();
    }
}

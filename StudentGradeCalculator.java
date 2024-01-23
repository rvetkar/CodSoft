import java.util.Scanner;

public class StudentGradeCalculator 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of subjects: ");
        int subjects = sc.nextInt();

        double[] Scores = new double[subjects];

        for (int i = 0; i < subjects; i++) 
        {
            System.out.println("Enter score for subject " + (i+1) + ": ");
            Scores[i] = sc.nextDouble();
        }

        System.out.println("\nSubject scores: ");
        for (int i = 0; i < subjects; i++) 
        {
            System.out.println("Subject " + (i + 1) + ": " + Scores[i]);
        }

        double total = 0;
        for (int i = 0; i < subjects; i++) 
        {
            total += Scores[i];
        }
        System.out.println("\nTotal: "+total);

        double average = total / subjects;
        System.out.println("\nAverage Percentage: " + average+" %");

        System.out.println("\nGrade: ");
        if (average >= 90)
        {
            System.out.println("Grade A");
        } else if (average >= 80) 
        {
            System.out.println("Grade B");
        } else if (average >= 70) 
        {
            System.out.println("Grade C");
        } else if (average >= 60) 
        {
            System.out.println("Grade D");
        } else 
        {
            System.out.println("Grade F");
        }

        sc.close();
    }
}
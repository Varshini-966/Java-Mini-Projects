package QuizApp;
import java.util.*;
public class QuizApp {
    private static Scanner sc = new Scanner(System.in);
    public static void getQuestions(int n,String[] questions)
    {
        for(int i = 0;i < n;i++)
        {
            questions[i] = sc.nextLine();
        }
    }
    public static void getKey(int n,String[] key)
    {
        for(int i = 0;i < n;i++)
        {
            key[i] = sc.nextLine();
        }
    }

    public static void takeTest(String[] question,int n,String[] ans)
    {
        for(int i = 0;i < n;i++)
        {
            System.out.printf("Q%d) %s%n",(i+1),question[i]);
            ans[i] = sc.nextLine();
        }
    }

    public static int getMarks(String[] ans,String[] key,int n)
    {
        int marks = 0;
        for(int i = 0;i < n;i++)
        {
            if(key[i].equalsIgnoreCase(ans[i]))
            {
                marks+= 10;
            }
        }
        return marks;
    }
    public static char getGrade(int marks,int n)
    {
        int total = n*10;

        int grade = (int)(((double)marks / total) * 100);

        if(grade < 50)
        {
            return 'D';
        }
        else if(grade >= 50 && grade <= 65)
        {
            return 'C';
        }
        else if(grade > 65 && grade <= 80)
        {
            return 'B';
        }
        else if(grade > 80 && grade < 90)
        {
            return 'A';
        }
        else if(grade >= 91)
        {
            return 'O';
        }
        return 'Z';
    }

    public static void getAnswers(String[] questions,String[] ans,String[] key,int n)
    {
        for(int i = 0;i < n;i++)
        {
            System.out.println("---------------------------------------------------------------------------");
            System.out.printf("Q%d) %s %n",i+1,questions[i]);
            if(ans[i].equalsIgnoreCase(key[i]))
            {
                System.out.println(key[i]+"(Correct Answer)");
            }
            else
            {
                System.out.println(ans[i]+"(Incorrect Answer)");
                System.out.println("Correct Answer : "+key[i]);
            }
        }
    }
    public static void getDefaultQuestions(String[] questions)
    {
        questions[0] = "What is the full form of JVM?";
        questions[1] = "Which keyword represents the current object reference?";
        questions[2] = "How many types of polymorphisms are there?";
        questions[3] = "Which keyword is used to inherit an interface?";
        questions[4] = "Arithmetic Exception is built-in or user-defined exception(built/user)?";
    }
    public static void getDefaultKey(String[] key)
    {
        key[0] = "java virtual machine";
        key[1] = "this";
        key[2] = "2";
        key[3] = "implements";
        key[4] = "built";
    }
    public static void takeTestUtil()
    {
        int done = 0;
        String[] questions = new String[0];
        String[] key = new String[0];
        String[] ans = new String[0];
        int n = 0;
        System.out.println("Do you want default questions (yes/no) :");
        String choice = sc.next();
        sc.nextLine();
        if(choice.equalsIgnoreCase("yes"))
        {
            questions = new String[5];
            key = new String[5];
            ans = new String[5];
            n = 5;
            getDefaultQuestions(questions);
            getDefaultKey(key);
        }
        else
        {
            System.out.print("Enter no of questions :");
            n = sc.nextInt();
            sc.nextLine();
            questions = new String[n];
            key = new String[n];
            ans = new String[n];
            getQuestions(n, questions);
            getKey(n, key);
        }
        takeTest(questions, n, ans);
        System.out.println("Quiz Completed !");
        System.out.print("Do you want results(yes/no):");

        String c = sc.next();
        int marks = 0;
        if(c.equalsIgnoreCase("yes"))
        {
            marks = getMarks(ans, key, n);
            System.out.println("Your marks :"+marks);
        }
        else
        {
            return;
        }
        System.out.println("Do you want to check grade(yes/no):");
        c = sc.next();
        if(c.equalsIgnoreCase("yes"))
        {
            System.out.println("Grade Obtained :"+getGrade(marks, n));
        }
        else
        {
            return;
        }
        System.out.println("Do you want key(yes/no):");
        c = sc.next();
        if(c.equalsIgnoreCase("yes"))
        {
            getAnswers(questions, ans, key, n);
        }
        else
        {
            return;
        }
    }
    public static void main(String[] args) {

        String name = "Welcome to our Quiz Application!";

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
        System.out.println();
        takeTestUtil();
    }
}

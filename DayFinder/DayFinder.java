package DayFinder;
import java.util.*;
class DayFinder
{
    public static int getMonthCode(int month)
    {
        int[] codes = {0,3,3,6,1,4,6,2,5,0,3,5};
        return codes[month-1];
    }
    public static String getDay(int code)
    {
        String dayName = "";
        switch(code)
        {
            case 0:
                dayName = "Sunday";
                break;
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            default:
                dayName = "Wrong day";
        }
        return dayName;
    }
    public static int getYearCode(int year)
    {
        int century = year/100;
        century = century%4;
        int code = 0;
        switch(century)
        {
            case 0:
                code = 6;
                break;
            case 1:
                code = 4;
                break;
            case 2:
                code = 2;
                break;
            case 3:
                code = 0;
                break;
            default:
                code = -1;
        }
        return code;
    }
    public static boolean isLeapYear(int year)
    {
        if(year%4 == 0 && year%100 != 0 || year%400 == 0)
        {
            return true;
        }
        return false;
    }
    public static boolean validate(int date,int month,int year)
    {
        if(date <= 0 || date >= 32)
        {
            return false;
        }
        if(month <= 0 || month >= 13)
        {
            return false;
        }
        if(year < 1000 || year > 9999)
        {
            return false;
        }
        if(date == 29 && month == 2 && !isLeapYear(year))
        {
            return false;
        }
        if(date == 31 && (month != 1 && month != 3 && month != 5 && month != 7 && month != 8 && month != 10 && month != 12))
        {
            return false;
        }
        return true;
    }
    public static String getDayName(int date,int month,int year)
    {
        int completedYears = year%100;
        int leapYears = completedYears/4;
        int monthCode = getMonthCode(month);
        int centuryCode = getYearCode(year);
        int total = completedYears+leapYears+monthCode+centuryCode+date;
        total = total%7;
        String dayName = getDay(total);
        return dayName;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi,Please enter your name below!");
        System.out.print("Name : ");
        String name = sc.nextLine();
        String n = "Welcome to our DayFinder Application!\nPlease fill the form below :)";

        for(int i = 0;i < n.length();i++)
        {
            try
            {
                System.out.print(n.charAt(i));
                Thread.sleep(200);
            }
            catch(Exception e)
            {
                System.out.println("Interupted");
            }
        }
        System.out.println();
        String choice = "";
        do
        {
            int day,month,year = 0;
            try
            {
                System.out.print("Date:");
                day = sc.nextInt();
                System.out.print("Month:");
                month = sc.nextInt();
                System.out.print("Year:");
                year = sc.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("Invalid inputs given :(");
                sc.nextLine(); // To refresh the inputs.
                continue;
            }

            if(!validate(day, month, year))
            {
                System.out.println("Invalid dates given :(,Please try again!");
            }
            else
            {
                String dayName = getDayName(day, month, year);
                System.out.printf("%d/%d/%d is %s%n",day,month,year,dayName);
            }
            System.out.print("Do you want to try again (yes/no):");
            choice = sc.next();
        }while(choice.equalsIgnoreCase("yes"));
        System.out.printf("Thanks %s for choosing our application! Have a good day :)",name);
        sc.close();
    }
}
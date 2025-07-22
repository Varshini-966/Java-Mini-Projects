package BMICalculator;
import java.util.*;
public class BMICalculator
{
    public static double getBMI(double weight,double height)
    {
        double bmi = weight/(height*height);
        return bmi;
    }
    public static boolean validate(double height,double weight)
    {
        return height > 0 && weight > 0;
    }
    public static void suggestFood(String category) {
    System.out.println("\n--- Food Recommendations for " + category + " ---");

    switch(category.toLowerCase()) {
        case "underweight":
            System.out.println("Goal: Gain healthy weight");
            System.out.println("✔ Include high-calorie healthy foods: nuts, seeds, peanut butter, avocados, whole milk");
            System.out.println("✔ Eat protein-rich foods: eggs, paneer, legumes, tofu, chicken, fish");
            System.out.println("✔ Add healthy carbs: brown rice, oats, potatoes, sweet potatoes");
            System.out.println("✔ Snack on dried fruits like dates and raisins, and drink banana milk smoothies");
            System.out.println("❌ Avoid: Junk food and sugary snacks (they add fat, not nutrition)");
            break;

        case "normal":
            System.out.println("Goal: Maintain current weight");
            System.out.println("✔ Eat a balanced diet: whole grains, vegetables, fruits, dairy, and lean protein");
            System.out.println("✔ Include healthy fats: olive oil, nuts, seeds");
            System.out.println("✔ Drink 2–3L water per day");
            System.out.println("✔ Follow portion control and regular meal timings");
            System.out.println("❌ Avoid: Processed foods, excessive sugar, and skipping meals");
            break;

        case "overweight":
            System.out.println("Goal: Lose weight gradually");
            System.out.println("✔ Eat high-fiber foods: oats, brown rice, fruits like apples and pears, vegetables");
            System.out.println("✔ Add lean proteins: lentils, beans, egg whites, grilled chicken/fish");
            System.out.println("✔ Switch to low-fat dairy: skimmed milk, curd");
            System.out.println("✔ Snack healthy: sprouts, boiled chana, fruit salads");
            System.out.println("❌ Avoid: Sugary drinks, fried foods, processed carbs, fast food");
            break;

        case "obese":
            System.out.println("Goal: Weight loss & reduce health risks");
            System.out.println("✔ Focus on low-calorie, high-nutrition foods: cabbage, cucumber, spinach, carrots");
            System.out.println("✔ Start meals with soups and salads to reduce intake");
            System.out.println("✔ Eat whole grains in small portions, avoid white rice/bread");
            System.out.println("✔ Eat small, frequent meals and drink warm lemon or jeera water");
            System.out.println("❌ Strictly avoid: Bakery items, sweets, fried snacks, sugary drinks, soda");
            break;

        default:
            System.out.println("Invalid category. Please enter: underweight, normal, overweight, or obese.");
    }

    System.out.println(); // Empty line for spacing
}

    public static String getResult(double bmi)
    {
        if(bmi < 18.5)
        {
            System.out.println("You are UnderWeight :(");
            return "underweight";
        }
        else if(bmi >= 18.5 && bmi <= 24.9)
        {
            System.out.println("You are having Normal Weight :)");
            return "Normal";
        }
        else if(bmi >= 25 && bmi <= 29.9)
        {
            System.out.println("You are Overweight :(");
            return "overweight";
        }
        else
        {
            System.out.println("You are obese :(");
            return "obese";
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        String name = "Welcome to our BMI Calculator!";

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
        String choice = "";
        do
        {
            double weight = 0;
            double height = 0;
            try
            {
            System.out.print("Enter your weight here(in kilograms):");
            weight = sc.nextDouble();
            System.out.print("Enter height here(in metres):");
            height = sc.nextDouble();
            }
            catch(Exception e)
            {
                System.out.println("Invalid Inputs :( Please enter numbers.");
                sc.nextLine();
                continue;
            }
            if(validate(height, weight))
            {
                double bmi = getBMI(weight, height);
                System.out.printf("Your BMI Index is %2f%n",bmi);
                String res = getResult(bmi);
                suggestFood(res);
            }
            else
            {
                System.out.println("Height and weight must be positive");
            }
            System.out.print("Do you want to try again(yes/no):");
            choice = sc.next();
        }while(choice.equalsIgnoreCase("yes"));
        System.out.println("Thanks for using our application :)");
    }
}
package ContactBook;
import java.util.*;

class User {
    String name;
    String password;

    User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String toString() {
        return name + " " + password;
    }
}

class ContactDetails {
    String name;
    String mobile;

    ContactDetails(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String toString() {
        return name + " " + mobile;
    }
}

public class ContactBook {
    private static Scanner sc = new Scanner(System.in);
    private static HashSet<User> userInfo = new HashSet<>();
    private static HashSet<String> userNames = new HashSet<>();
    private static HashMap<String, String> loginData = new HashMap<>();
    private static HashMap<String, HashSet<ContactDetails>> userData = new HashMap<>();

    public static boolean findUser(String userName) {
        return userNames.contains(userName);
    }

    public static boolean validatePassword(String userName, String pass) {
        if (findUser(userName)) {
            String password = loginData.get(userName);
            return password.equals(pass);
        }
        return false;
    }

    public static void addNewUser(User user) {
        userNames.add(user.name);
        userInfo.add(user);
        loginData.put(user.name, user.password);
    }

    public static void signUp() {
        String choice = "";
        do {
            System.out.println();
            System.out.println("Sign in to the application");
            System.out.print("Email ID: ");
            String email = sc.next();
            System.out.print("Password: ");
            String password = sc.next();

            if (findUser(email)) {
                System.out.println("User already exists");
            } else {
                User user = new User(email, password);
                addNewUser(user);
                userData.put(email, new HashSet<>());
                return;
            }

            System.out.print("Want to try again (yes/no): ");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("yes"));
    }

    public static String login() {
        System.out.println();
        System.out.println("Login to the application");
        System.out.print("User Name: ");
        String userName = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        if (validatePassword(userName, password)) {
            return userName;
        }
        return "notFound";
    }

    public static void add(ContactDetails contact, String userName) {
        userData.get(userName).add(contact);
    }

    public static void addContacts(String userName) {
        System.out.println();
        System.out.println("No of users to be added?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("-------------------");
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Mobile number: ");
            String mobile = sc.next();

            ContactDetails contact = new ContactDetails(name, mobile);
            add(contact, userName);
        }
    }

    public static void getAllContacts(String userName) {
        HashSet<ContactDetails> hset = userData.get(userName);
        System.out.println("Contact Details");
        System.out.println("--------------------------------------");
        System.out.println(String.format("%-14s%-14s", "Name", "Contact Number"));

        for (ContactDetails contact : hset) {
            System.out.println(String.format("%-14s%-14s", contact.name, contact.mobile));
        }
    }

    public static void getContact(String userName, String name) {
        HashSet<ContactDetails> hset = userData.get(userName);
        System.out.println("-----------------------------------------------------------");

        for (ContactDetails contact : hset) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.println(name + "\t:\t" + contact.mobile);
                return;
            }
        }
        System.out.println("Not found");
    }

    public static void operationUtil(int choice, String userName) {
        switch (choice) {
            case 1:
                addContacts(userName);
                break;
            case 2:
                getAllContacts(userName);
                break;
            case 3:
                System.out.println();
                System.out.print("Enter name: ");
                String name = sc.next();
                getContact(userName, name);
                break;
            case 4:
                String logOut = "Logging out...";
                for(int i = 0;i < logOut.length();i++)
                {
                    try {
                        System.out.print(logOut.charAt(i));
                        Thread.sleep(150);
                    } catch(Exception e) {
                        System.out.println("Interupted Exception");
                    }
                }
                System.out.println();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void loginUser() {
        String userName = login();

        if (!userName.equals("notFound")) {
            String logout = "";

            do {
                System.out.println();
                System.out.println("Kindly follow the following instructions");
                System.out.println();
                System.out.println("1. Add a new contact");
                System.out.println("2. Get all contact list");
                System.out.println("3. Get contact number");
                System.out.println("4. Exit");

                System.out.println();
                System.out.print("Type here: ");
                try {
                    int choice = sc.nextInt();
                    operationUtil(choice, userName);
                } catch (Exception e) {
                    System.out.println("Invalid choice");
                    sc.next(); // clear buffer
                    continue;
                }

                System.out.println("-----------------------------------------------------------");
                System.out.print("Logout (yes/no): ");
                logout = sc.next();
            } while (logout.equalsIgnoreCase("no"));
        }
    }

    public static void multiLogin() {
        String userSwitch = "";
        do {
            loginUser();
            System.out.println("-----------------------------------------------------------");
            System.out.print("Try another login (yes/no)? ");
            userSwitch = sc.next();
        } while (userSwitch.equalsIgnoreCase("yes"));
    }

    public static void multiSignUp() {
        String signSwitch = "";
        do {
            System.out.println();
            System.out.println("Follow these Instructions");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");

            System.out.println();
            System.out.print("Type Here: ");
            int id = 0;
            try {
                id = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice");
                sc.next(); // clear buffer
                continue;
            }

            if (id == 1) {
                signUp();
                multiLogin();
            } else if (id == 2) {
                multiLogin();
            } else {
                System.out.println();
                System.out.println("Invalid Choice");
            }

            System.out.println("-----------------------------------------------------------");
            System.out.print("Sign Up with a new Account? (yes/no): ");
            signSwitch = sc.next();
        } while (signSwitch.equalsIgnoreCase("yes"));
    }

    public static void contactBook() {
        String welcome = "Welcome to our Contact Book Application";
        int n = welcome.length();

        for (int i = 0; i < n; i++) {
            try {
                System.out.print(welcome.charAt(i));
                Thread.sleep(150);
            } catch (Exception e) {
                System.out.println("Interrupted Exception");
            }
        }
        System.out.println();
        multiSignUp();
    }

    public static void main(String[] args) {
        contactBook();
        System.out.println();
        System.out.println("Thanks for using our application");
    }
}

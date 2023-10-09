import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class DriverCode {
    public static void main(String[] args) {
        char ch = 'y';
        Scanner sc = new Scanner(System.in);
        int options;

        do {
            System.out.println("Welcome to the world of Dark-Connections");
            System.out.println("1. Add Dark-Connection");
            System.out.println("2. Delete Dark-Connection");
            System.out.println("3. See Dark-Connections");
            System.out.println("4. Search Dark-Connection");
            System.out.println("5. Update a Dark Connection");
            System.out.println("Please Enter your Option");
            options = sc.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Enter the Name of Connection");
                    String Name = sc.next();
                    System.out.println("Enter the Phone Number of the connection");
                    String Num = sc.next();
                    PhoneBook.add_contact(Name, new LinkedList<>(Arrays.asList(Num)));
                    PhoneBook.writeContactsToFile("contact.txt");

                    break;
                case 2:
                    System.out.println("Enter the Name with whom you want to Disconnect (Except your Ex)");
                    String name = sc.next();
                    PhoneBook.delete_contact(name);
                    break;
                case 3:
                    System.out.println("Your Connections are");
                    PhoneBook.view_all_contacts();
                    break;
                case 4:
                    System.out.println("Enter the name");
                    String N = sc.next();
                    LinkedList<String> numbers = PhoneBook.SearchEle(N);
                    if (!numbers.isEmpty()) {
                        System.out.println("Phone numbers for " + N + ": " + numbers);
                    } else {
                        System.out.println(N + " not found in the Dark-Connections.");
                    }
                    break;
                case 5:
                    System.out.println("Enter the name you want to update");
                    String s = sc.next();
                    System.out.println("Enter the new number");
                    String New_Num = sc.next();
                    PhoneBook.update_contact(s, new LinkedList<>(Arrays.asList(New_Num)));
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }

            System.out.println("Do you want to Continue? (Y for Yes and N for No)");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');

        sc.close();
    }
}

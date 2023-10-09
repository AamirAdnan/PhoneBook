import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBook {
    static HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
    static LinkedList<String> ls = new LinkedList<>();

    public static void add_contact(String S, LinkedList<String> Numbers) {
        if (!map.containsKey(S)) {
            map.put(S, Numbers); // For a new contact to be saved in the contact book
        } else { // For an existing contact, we can store them in a contact book using a linked list
            LinkedList<String> existingContact = map.get(S);
            existingContact.addAll(Numbers);
        }
    }

    public static void delete_contact(String S) {
        boolean temp = map.containsKey(S);
        if (temp) {
            map.remove(S);
            System.out.println("Element removed successfully");
        } else {
            System.out.println("No such element present");
        }
    }

    public static LinkedList<String> SearchEle(String S) {
        boolean temp = map.containsKey(S);

        if (temp) {
            LinkedList<String> Numbers = map.get(S);
            return Numbers;
        } else {
            throw new RuntimeException("Number not present in the contact");
        }
    }

    public static void update_contact(String S, LinkedList<String> newNumbers) {
        if (map.containsKey(S)) {
            LinkedList<String> contactNumbers = map.get(S);
            contactNumbers.clear(); // Remove all existing numbers for the contact
            contactNumbers.addAll(newNumbers); // Add the new numbers
        } else {
            throw new RuntimeException("Contact not found in the phone book");
        }
    }

    public static void view_all_contacts() {
        for (String contact : map.keySet()) {
            LinkedList<String> phoneNumbers = map.get(contact);

            if (phoneNumbers.isEmpty()) {
                System.out.println(contact + " = No phone numbers associated with this contact.");
            } else {
                for (String phoneNumber : phoneNumbers) {
                    System.out.println(contact + " = " + phoneNumber);
                }
            }
        }
    }
    public static void writeContactsToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String contact : map.keySet()) {
                LinkedList<String> phoneNumbers = map.get(contact);

                if (!phoneNumbers.isEmpty()) {
                    for (String phoneNumber : phoneNumbers) {
                        writer.write(contact + " = " + phoneNumber);
                        writer.newLine();
                    }
                }
            }
            System.out.println("Contacts have been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

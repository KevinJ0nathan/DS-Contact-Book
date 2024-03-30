import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    // Method to add Contacts
    public static Contact addContact(Scanner scanner){
        String name, phoneNumber, email;

        do {
            System.out.println("Please enter name:");
            name = scanner.nextLine().trim();
        } while (name.isEmpty());

        do {
            System.out.println("Please enter phone number:");
            phoneNumber = scanner.nextLine().trim();
        } while (phoneNumber.isEmpty());

        do {
            System.out.println("Please enter email:");
            email = scanner.nextLine().trim();
        } while (email.isEmpty());

        // Creates a new contact object with the given name, phone number, and email
        Contact contact = new Contact(name, phoneNumber, email);
        return contact;
    }

    // Method to delete Contacts
    public static void deleteContact(LinkedList<Contact> contactBook, String contactName){
        Iterator<Contact> iterator = contactBook.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(contactName)) {
                iterator.remove();
                System.out.println("Contact is removed.");
                return;
            }
        } System.out.println("Contact not found");
    }

    // Method to search a contact from the contact book
    public static void searchContact(LinkedList<Contact> contactBook, String contactName){
        for(Contact cont : contactBook){
            if(cont.getName().equalsIgnoreCase(contactName)){
                System.out.println(cont);
                return;
            }
        } System.out.println("Contact not found");
    }

    // Method to search a contact from an email
    public static void searchEmail(LinkedList<Contact> contactBook, String contactEmail){
        for(Contact cont : contactBook){
            if(cont.getEmail().equalsIgnoreCase(contactEmail)){
                System.out.println(cont);
                return;
            }
        } System.out.println("Contact not found");
    }

    public static void main(String[] args) {
        // Initialize the contact book linked list
        LinkedList<Contact> contactBook = new LinkedList<>();
        Scanner inputChoice = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("*************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("*************************");
            System.out.print("Please Enter a command: ");
            char menuOption = inputChoice.nextLine().charAt(0);
            switch (Character.toLowerCase(menuOption)) {
                // if user input choice was the character 'a' then add a contact
                case 'a':
                    System.out.println("Add an entry");
                    contactBook.add(addContact(inputChoice));
                    break;
                // if user input choice was the character 'd' then delete a contact
                case 'd':
                    System.out.println("Delete an entry");
                    System.out.println("Please enter name:");
                    String contact = inputChoice.nextLine();
                    deleteContact(contactBook, contact);
                    break;
                // if user input choice was the character 'e' then search a contact from an email
                case 'e':
                    System.out.println("Search an email entry");
                    System.out.println("Please enter email:");
                    String contactEmail = inputChoice.nextLine();
                    searchEmail(contactBook, contactEmail);
                    break;
                // if user input choice was the character 'p' then print out the contact book
                case 'p':
                    if(contactBook.isEmpty()){
                        System.out.println("Contact Book is Empty");
                    } else {
                        int index = 1;
                        System.out.println("Printing Contact Book");
                        for (Contact contactItem : contactBook) {
                            System.out.println("Index: " + index++);
                            System.out.println(contactItem);
                            System.out.println();
                        }
                    }
                    break;
                // if user input choice was the character 's' then search a contact from a name
                case 's':
                    System.out.println("Search an entry");
                    String contactSearched = inputChoice.nextLine();
                    searchContact(contactBook, contactSearched);
                    break;
                // if user input choice was the character 'q' then terminate the program
                case 'q':
                    System.out.println("Program Terminated");
                    running = false;
                    break;
                // if user input choice was not in the list of options of character
                default:
                    System.out.println("Unknown entry");
            }
            // Closes the scanner
        } inputChoice.close();
    }
}

// class for contact
class Contact{
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Name:" + name + "\nPhone Number:" + phoneNumber + "\nEmail:" + email;
    }
}
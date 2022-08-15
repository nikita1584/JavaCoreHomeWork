package homework11;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("+79151234567", "Медведев");
        phoneBook.addContact("+79151245567", "Александров");
        phoneBook.addContact("+79107654321", "Медведев");
        phoneBook.addContact("+79263214567", "Кузнецов");
        phoneBook.addContact("+79851234567", "Кузнецов");
        phoneBook.addContact("+79031234567", "Кузнецов");
        System.out.println(phoneBook.getNumber("Медведев"));
        System.out.println(phoneBook.getNumber("Кузнецов"));
    }
}

package homework11;

import java.util.*;

public class PhoneBook {
    private Map<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String number, String surname) {
        phoneBook.put(number, surname);
    }

    public Map<String, String> getNumber(String surname) {
        Map<String, String> result = new HashMap<>();
        Set<Map.Entry<String, String>> entries = phoneBook.entrySet();
        for (Map.Entry<String, String> pair: entries) {
            if(pair.getValue() == surname)
                result.put(pair.getKey(), pair.getValue());
        }
        return result;
    }
}

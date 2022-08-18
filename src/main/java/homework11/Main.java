package homework11;

import java.util.*;

/**
 * String[] stringArray = {...};
 * 1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
 * вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово. <string, count>
 * Использовать коллекции и Map!
 *
 * 2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
 * телефонных номеров. В этот телефонный справочник с помощью метода add() можно
 * добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
 * учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 *
 * class PhoneBook {
 *
 *     void add(number, surname)
 *
 *     number get(surname)
 *
 * }
 **/

public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"123", "", "   ", "  ", "123", "123", "a", "a", "c", "c", "c", "cafe", "babe", "beef",
                "aaa", "bb", "cbab", "x", "y", "z"};
        System.out.println("Изначальный массив строк:");
        System.out.println(Arrays.toString(stringArray));
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, stringArray);

        Set<String> strings = new HashSet<>();
        Collections.addAll(strings, stringArray);
        System.out.println("Неповторяющиеся строки массива:");
        System.out.println(strings);
        System.out.println("\nЧисло неповторяющихся строк массива:");
        System.out.println(strings.size());

        Iterator<String> iterator = strings.iterator();
        Map<String, Integer> stringMap = new TreeMap<>();
        for (String s: stringArray) {
            stringMap.put(s, Collections.frequency(stringList, s));
        }
        System.out.println("\nЧисло повторов строк в исходном массиве:");
        System.out.println(stringMap);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("+79151234567", "Медведев");
        phoneBook.addContact("+79151245567", "Александров");
        phoneBook.addContact("+79107654321", "Медведев");
        phoneBook.addContact("+79263214567", "Кузнецов");
        phoneBook.addContact("+79851234567", "Кузнецов");
        phoneBook.addContact("+79031234567", "Кузнецов");
        System.out.println("\nНомера телефонов по фамилии Медведев:");
        System.out.println(phoneBook.getNumber("Медведев"));
        System.out.println("\nНомера телефонов по фамилии Кузнецов:");
        System.out.println(phoneBook.getNumber("Кузнецов"));
    }
}

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
        System.out.println(Arrays.toString(stringArray));
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, stringArray);

        Set<String> strings = new HashSet<>();
        Collections.addAll(strings, stringArray);
        System.out.println(strings);
        System.out.println(strings.size());

        Iterator<String> iterator = strings.iterator();
        Map<String, Integer> stringMap = new TreeMap<>();
        for (String s: stringArray) {
            stringMap.put(s, Collections.frequency(stringList, s));
        }
        System.out.println(stringMap);
    }

}

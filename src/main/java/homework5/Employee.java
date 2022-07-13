package homework5;

public class Employee {
    private String name;
    private String family;
    private String patronymic;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;
    public static int count;

    public static void main(String[] args) {
        Employee []empArray = new Employee[5];
        empArray[0] = new Employee("Сергей", "Карлин", "Иванович", "serg@mail.ru",
                "+79153125897", 40000, 57);
        empArray[1] = new Employee("Сергей", "Дмитриев", "Евгеньевич", "dmitry@mail.ru",
                "+79153335497", 55000, 37);
        empArray[2] = new Employee("Святослав", "Козлов", "Никитич", "slava@gmail.ru",
                "+79153335497", 0, 7);
        empArray[3] = new Employee("Арина", "Козлова", "Никитична", "arina@gmail.ru",
                "+79153359497", 0, 2);
        empArray[4] = new Employee("Сергей", "Кузнецов", "Львович", "kuznecov@mail.ru",
                "+79146135497", 100000, 63);

        for (int i = 0; i < count; i++) {
            if(empArray[i].getAge() > 39)
                empArray[i].printInfo();
        }
    }

    public Employee(String name, String family, String patronymic, String email, String phoneNumber, int salary,
                    int age) {
        this.name = name;
        this.family = family;
        this.patronymic = patronymic;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        count++;
    }

    public void printInfo() {
        System.out.println("ФИО: " + family + " " + name + " " + patronymic);
        System.out.println("Электронная почта: " + email);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}

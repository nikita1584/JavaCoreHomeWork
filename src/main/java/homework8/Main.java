package homework8;

public class Main {
    public static void main(String[] args) {
        Cat []cats = new Cat[3];
        Human []humans = new Human[2];
        Robot []robots = new Robot[2];
        cats[0] = new Cat("Барсик", 2, 200);
        cats[1] = new Cat("Мусик", 3, 150);
        cats[2] = new Cat("Тефтелька", 1, 100);
        humans[0] = new Human("Никифор", 3, 10000);
        humans[1] = new Human("Елена", 5, 5000);
        robots[0] = new Robot("Астафий", 500, 10);
        robots[1] = new Robot("Евграфий", 0, 30000);

        Challange challange = new Challange();

        System.out.println("//////////////// Соревнование кошек ////////////////");
        for (Cat cat: cats) {
            challange.getChellange(cat, cat);
        }
        System.out.println("//////////////// Соревнование людей ////////////////");
        for (Human human: humans) {
            challange.getChellange(human, human);
        }
        System.out.println("//////////////// Соревнование роботов ////////////////");
        for (Robot robot: robots) {
            challange.getChellange(robot, robot);
        }
    }
}

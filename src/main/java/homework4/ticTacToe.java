package homework4;

import java.util.Random;
import java.util.Scanner;

public class ticTacToe {
    public static int SIZE = 6;
    public static final int DOTS_TO_WIN = (SIZE > 2 && SIZE < 7)? 3:
                                        (SIZE < 6 && SIZE < 11)? 4:
                                        (SIZE > 10)? 5 : 3;
    //public static int turnsCount;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int lastX;
    public static int lastY;

    public static void main(String[] args) {
        do {
            System.out.println("Игра началась");
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                aiTurn();
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("Победил Искуственный Интеллект");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
        } while (isContinueGame());
        System.out.println("Игра закончена");
    }

    public static boolean dummyCheckWin(char symb) {
        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return
                true;
        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return
                true;
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return
                true;
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return
                true;
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return
                true;
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return
                true;
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return
                true;
        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return
                true;
        return false;
    }

    public static boolean checkWin(char symb){
        int sum = 0, startX = 0, startY = 0;

        //check horizontal
        for(int i = 0; i < SIZE; i++) {
            if (map[lastY][i] == symb)
                sum++;
            else
                sum = 0;
            if(sum == DOTS_TO_WIN)
                return true;
        }

        sum = 0;
        //check vertical
        for(int i = 0; i < SIZE; i++) {
            if (map[i][lastX] == symb)
                sum++;
            else
                sum = 0;
            if(sum == DOTS_TO_WIN)
                return true;
        }
        sum = 0;

        //find left bottom X, Y:
        for (int x = lastX, y = lastY; x >= 0 && y < SIZE; x--, y++){
            startX = x;
            startY = y;
        }

        for (int x = startX, y = startY; x < SIZE && y >= 0; x++, y--){
            if (map[y][x] == symb)
                sum++;
            else
                sum = 0;
            if(sum == DOTS_TO_WIN)
                return true;
        }
        sum = 0;

        //find left top X, Y:
        for (int x = lastX, y = lastY; x >= 0 && y >= 0; x--, y--){
            startX = x;
            startY = y;
        }

        for (int x = startX, y = startY; x < SIZE && y < SIZE; x++, y++){
            if (map[y][x] == symb)
                sum++;
            else
                sum = 0;
            if(sum == DOTS_TO_WIN)
                return true;
        }

        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y +
                1));
        map[y][x] = DOT_O;
        lastX = x;
        lastY = y;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
        lastX = x;
        lastY = y;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            return false;
        if (map[y][x] == DOT_EMPTY)
            return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (sc.next()){
            case "y", "yes", "д", "да", "+" -> true;
            default -> false;
        };
    }
}

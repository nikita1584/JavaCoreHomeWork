package homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayTest {
/*
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Тестирование началось");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("Тест окончен");
    }
*/
    @DisplayName("Проверка штатной работы метода arrayAfterLast4")
    @ParameterizedTest
    @MethodSource("arrayAfterLast4gen")
    void arrayAfterLast4normal(int []expected, int[]inputArray) {
        Assertions.assertArrayEquals(expected, IntArray.ArrayAfterLast4(inputArray));
    }

    static Stream<Arguments> arrayAfterLast4gen() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(new int[]{3, 5, 1, 7}, new int[]{1, 2, 4, 4, 4, 3, 5, 1, 7}),
                Arguments.arguments(new int[]{2, 7, 9, 2, 3, 0, 1, 7}, new int[]{4, 2, 7, 9, 2, 3, 0, 1, 7})
        );
    }

    @DisplayName("Проверка исключений метода arrayAfterLast4")
    @Test
    void arrayAfterLast4exception() {
        Assertions.assertThrows(RuntimeException.class,
                () -> IntArray.ArrayAfterLast4(new int[]{1, 2, 6, 7, 2, 3, 5, 1, 7}));
    }

    @DisplayName("Проверка метода arrayOf4and1")
    @ParameterizedTest
    @MethodSource("arrayOf4and1gen")
    void arrayOf4and1(boolean expected, int[] inputArray) {
    }

    static Stream<Arguments> arrayOf4and1gen() {
        return Stream.of(
                Arguments.arguments(true, new int[]{1, 1, 1, 4, 4, 1, 4, 4 }),
                Arguments.arguments(true, new int[]{1, 1, 1, 1, 1, 1, 1, 1}),
                Arguments.arguments(true, new int[]{4, 4, 4, 4, 4}),
                Arguments.arguments(true, new int[]{1, 1, 1, 4, 4, 1, 4, 3})
        );
    }
}
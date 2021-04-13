package ru.geekbrains.sklyarov;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.sklyarov.sklyarov.MainApp;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MainAppTest {
    @Test
    public void getArray1TestEmpty() {
        assertThrows(IllegalArgumentException.class, () -> MainApp.getArray1(new Integer[]{}));
    }
    @Test
    public void getArray1TestNotFound4() {
        assertThrows(RuntimeException.class, () -> MainApp.getArray1(new Integer[]{0,3,3,5,5,5,6,7,8}));
    }
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public void getArray1Test(Integer[] arrTask, Integer[] arrResult) {
        Assertions.assertArrayEquals(MainApp.getArray1(arrTask), arrResult);
    }


    static Stream<Arguments> arrayProvider(){
        return Stream.of(
                Arguments.arguments(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[]{1,7}),
                Arguments.arguments(new Integer[]{3,3,5,4,6}, new Integer[]{6}),
                Arguments.arguments(new Integer[]{1,2,4,5,6}, new Integer[]{5,6})
        );
    }

    @ParameterizedTest
    @MethodSource("forCheckArrayProvider")
    public void checkArrayTest(Integer[] arrTask, boolean arrResult) {
        Assertions.assertEquals(MainApp.checkArray(arrTask), arrResult);
    }
    static Stream<Arguments> forCheckArrayProvider(){
        return Stream.of(
                Arguments.arguments(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, false),
                Arguments.arguments(new Integer[]{1,1,4,4,1}, true),
                Arguments.arguments(new Integer[]{1,1,1,1,1}, false),
                Arguments.arguments(new Integer[]{4,4,4,4,4}, false)
        );
    }
}

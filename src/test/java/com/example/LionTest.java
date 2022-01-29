package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {
    private static final String EXEPTION_MSG = "Используйте допустимые значения пола животного - самец или самка";
    private final String MALE = "Самец";
    private final String sex;
    private final boolean expected;

    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] createDifferentLion() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
                { "Test", false},
        };
    }

    @Test
    public void getKittens() throws Exception {
        int expected = 1;
        Lion lion = new Lion(MALE);
        int actual = lion.getKittens();
        assertEquals("Кол-во различается", expected, actual);
    }

    @Test
    public void doesHaveMane() throws Exception {
        if (sex.equals("Test")) {
            Exception exception = assertThrows(Exception.class, () -> new Lion("Test"));
            assertEquals(EXEPTION_MSG, exception.getMessage());
        } else {
            Lion lion = new Lion(sex);
            boolean actual = lion.doesHaveMane();
            assertEquals("Пол отличается", expected, actual);
        }
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(MALE);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = lion.getFood();
        assertEquals("Содержимое списка отличается", expectedList, actualList);
    }
}
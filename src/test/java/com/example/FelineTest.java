package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    private final Feline FELINE = new Feline();

    @Test
    public void eatMeat() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = FELINE.eatMeat();
        assertEquals("Содержимое списка отличается", expectedList, actualList);
    }

    @Test
    public void getFamily() {
        String expected = "Кошачьи";
        String actual = FELINE.getFamily();
        assertEquals("Семейство отличается", expected, actual);
    }

    @Test
    public void getKittens() {
        int expected = 1;
        int actual = FELINE.getKittens();
        assertEquals("Кол-во отличается", expected, actual);
    }

    @Test
    public void getKittensWithCount() {
        int expected = 2;
        int actual = FELINE.getKittens(2);
        assertEquals("Кол-во отличается", expected, actual);
    }
}
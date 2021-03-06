package pro.sky.homework2_14.IntegerListClassHW16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.homework2_14.IntegerListClassHW16.exceptions.AbsentElementException;
import pro.sky.homework2_14.IntegerListClassHW16.exceptions.EmptyArrayException;
import pro.sky.homework2_14.IntegerListClassHW16.exceptions.IndexOutOfArrayException;
import pro.sky.homework2_14.IntegerListClassHW16.services.IntegerListImpl;

import static pro.sky.homework2_14.IntegerListClassHW16.IntegerListTestConstants.*;

@SpringBootTest
class IntegerListTests {
    private IntegerListImpl integerList;

    @BeforeEach
    void setup() {
        integerList = new IntegerListImpl();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(0);
        integerList.add(4);
    }

    @Test
    void shouldReturnAllElementsOfArray() {
        Integer[] actual = integerList.getAll();
        Assertions.assertArrayEquals(ARRAY_LIST, actual);
    }

    @Test
    void shouldReturnRightArrayAfterAddingElement() {
        integerList.add(111);
        Integer[] actual = integerList.getAll();
        Assertions.assertArrayEquals(LIST_AFTER_ADD, actual);
    }

    @Test
    void shouldReturnExceptionIfOutOfRange() {
        Assertions.assertThrows(IndexOutOfArrayException.class,
                () -> integerList.add(10, 10000));
    }

    @Test
    void shouldReturnRightArrayAfterAddingElementByIndex() {
        integerList.add(2, 555);
        Integer[] actual = integerList.getAll();
        Assertions.assertArrayEquals(LIST_AFTER_ADD_BY_INDEX, actual);
    }

    @Test
    void shouldReturnRightArrayAfterSettingOfElement() {
        integerList.set(2, 82);
        Integer[] actual = integerList.getAll();
        Assertions.assertArrayEquals(LIST_AFTER_SET, actual);
    }

    @Test
    void shouldReturnExceptionIfArrayIsEmptyByRemoving() {
        integerList.clear();
        Assertions.assertThrows(EmptyArrayException.class,
                () -> integerList.remove(1000000));
    }

    @Test
    void shouldReturnRightArrayAfterRemovingOfElement() {
        integerList.remove(1);
        Integer[] actual = integerList.getAll();
        Assertions.assertArrayEquals(LIST_AFTER_REMOVE, actual);
    }

    @Test
    void shouldReturnExceptionIfElementIsAbsentByRemoving() {
        Assertions.assertThrows(AbsentElementException.class,
                () -> integerList.remove(1000000));
    }


    @Test
    void shouldReturnExceptionIfArrayIsOutOfRangeByRemovingByIndex() {
        Assertions.assertThrows(IndexOutOfArrayException.class,
                () -> integerList.removeId(10));
    }

    @Test
    void shouldReturnRightArrayAfterRemovingOfElementByIndex() {
        integerList.remove(1);
        Integer[] actual = integerList.getAll();
        Assertions.assertArrayEquals(LIST_AFTER_REMOVE, actual);
    }

    @Test
    void shouldReturnTrueIfElementIsExist() {
        boolean actual = integerList.contains(1);
        Assertions.assertTrue(actual);
    }

    @Test
    void shouldReturnFalseIfElementIsNotExist() {
        boolean actual = integerList.contains(1000000);
        Assertions.assertFalse(actual);
    }

// =====================   ???????????????????? ???????????????? ???????????????????? ?????????????????? ==============
    @Test
    void testSpeedOfSortTheFirst() {
        // ---- ???????????????? ?? ?????????????????????? ?????????? ?????????????????? ?????? ?????????????????? ?????????????? ?????????????????? ??????????
        integerList = new IntegerListImpl(100_000);
        Integer[] sortedArray = integerList.sortArrayTheFirst();
//        boolean actual = integerList.contains(1);
//        Assertions.assertTrue(actual);
    }



    @Test
    void shouldReturnMinusOneIfElementIsNotExistByIndexOf() {
        int actual = integerList.indexOf(1000000);
        Assertions.assertEquals(-1, actual);
    }

    @Test
    void shouldReturnRightIndexOfElement() {
        int actual = integerList.indexOf(2);
        Assertions.assertEquals(2, actual);
    }

    @Test
    void shouldReturnRightIndexOfLastElement() {
        int actual = integerList.lastIndexOf(0);
        Assertions.assertEquals(4, actual);
    }

    @Test
    void shouldReturnExceptionIfArrayIsOutOfRangeByGettingByIndex() {
        Assertions.assertThrows(IndexOutOfArrayException.class,
                () -> integerList.get(10));
    }

    @Test
    void shouldReturnRightElementByGettingByIndex() {
        Integer actual = integerList.get(2);
        Assertions.assertEquals(ELEMENT, actual);
    }

    @Test
    void shouldReturnTrueIfListsAreEquals() {
        IntegerListImpl otherList = new IntegerListImpl();
        otherList.add(0);
        otherList.add(1);
        otherList.add(2);
        otherList.add(3);
        otherList.add(0);
        otherList.add(4);
        System.out.println(otherList);
        boolean actual = integerList.equals(otherList);
        Assertions.assertTrue(actual);
    }

    @Test
    void shouldReturnExceptionIfArrayIsNullByEquals() {
        Assertions.assertThrows(EmptyArrayException.class,
                () -> integerList.equals(null));
    }

    @Test
    void shouldReturnSizeOfArray() {
        int actual = integerList.size();
        Assertions.assertEquals(ARRAY_LIST_LENGTH, actual);
    }

    @Test
    void shouldReturnTrueIfArrayIsEmpty() {
        integerList.clear();
        boolean actual = integerList.isEmpty();
        Assertions.assertTrue(actual);
    }

    @Test
    void shouldReturnFalseIfArrayIsNotEmpty() {
        boolean actual = integerList.isEmpty();
        Assertions.assertFalse(actual);
    }

    @Test
    void shouldReturnEmptyArrayAfterClearing() {
        integerList.clear();
        int sizeOfList = integerList.size();
        Assertions.assertEquals(0, sizeOfList);
    }

    @Test
    void shouldReturnNewArray() {
        Integer[] actual = integerList.toArray();
//        Integer actual = integerList.(actualIntegerList);
//        Integer expected = integerList.toString(ARRAY_LIST);
        Assertions.assertArrayEquals(ARRAY_LIST, actual);
    }


}

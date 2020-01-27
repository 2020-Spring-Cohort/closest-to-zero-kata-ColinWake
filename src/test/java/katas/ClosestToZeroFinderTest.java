package katas;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class ClosestToZeroFinderTest {

    private List<Integer> intList;

    private static ClosestToZeroFinder underTest;

    @BeforeAll
    public static void preSetUp() {
        underTest = new ClosestToZeroFinder();
    }

    @BeforeEach
    public void setUp() {
        intList = new ArrayList<>();
    }

    @Test
    public void givenAListWithOneAndTwo_ReturnsOne() throws Exception {
        //Arrange
        intList = Arrays.asList(1, 2);
        //Act
        int result = underTest.findClosestToZero(intList);
        //Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void anEmptyListShouldThrowException() throws RuntimeException {
        assertThatThrownBy(() -> underTest.findClosestToZero(intList)).isInstanceOf(RuntimeException.class).hasMessageMatching("List may not be empty!");
    }

    @Test
    public void aListThatIsNotEmptyShouldNotThrow() {
        intList = List.of(1);

        assertThatCode(() -> underTest.findClosestToZero(intList)).doesNotThrowAnyException();
    }

    @Test
    public void aListContainingThreeHasDistanceOfThreeFromZero() {
        intList = List.of(3);

        int result = underTest.findClosestToZero(intList);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void aListOfThreeAndTwoShouldHaveDistanceOfTwo() {
        intList = List.of(3, 2);

        int result = underTest.findClosestToZero(intList);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void aListOfDifferentIntsAndZeroShouldHaveDistanceOfZero() {
        intList = List.of(10, 4, 3, 0, 14, 2);

        int result = underTest.findClosestToZero(intList);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void aListOfNegativeTwoAndTwoShouldHaveDistanceTwo() {
        intList = List.of(-2, 2);

        int result = underTest.findClosestToZero(intList);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void aListOfNegativeOneAndThreeShouldHaveDistanceNegativeOne() {
        intList = List.of(-1, 3);

        int result = underTest.findClosestToZero(intList);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void aListOfMaxAndMinShouldReturnMax() {
        intList = List.of(Integer.MAX_VALUE, Integer.MIN_VALUE);

        int result = underTest.findClosestToZero(intList);

        assertThat(result).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void aListOfMinShouldReturnMin() {
        intList = List.of(Integer.MIN_VALUE);

        int result = underTest.findClosestToZero(intList);

        assertThat(result).isEqualTo(Integer.MIN_VALUE);
    }
}

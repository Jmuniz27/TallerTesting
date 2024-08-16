package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import espol.Calculation;

class TestCalculation {
	@Test
	void testFindMax() {
        
        int[] arr = {1, 3, 4, 2};
        int expected = 4;
        int actual = Calculation.findMax(arr);
        assertEquals(expected, actual);

        int[] arr3 = {2};
        expected = 2;
        actual = Calculation.findMax(arr3);
        assertEquals(expected, actual);

        int[] arr4 = {-1, -3, -4, -2};
        expected = -1;
        actual = Calculation.findMax(arr4);
        assertEquals(expected, actual);

        int[] arr5 = {2, -3, -4, -2, 0, 1, 5};
        expected = 5;
        actual = Calculation.findMax(arr5);
        assertEquals(expected, actual);
        
	}

}
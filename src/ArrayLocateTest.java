import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayLocateTest {

    private static final Integer TWO = 2;

    @Test
    public void testWillReturnNullWhenMatchNotFound() {
        assertNull(ArrayLocate.findStartIndexOfMatchingSubArray(intArray(2,3,4,5), intArray(6)));
    }

    @Test
    public void testWillReturnNullWhenOnlyAPartialMatchFound() {
        assertNull(ArrayLocate.findStartIndexOfMatchingSubArray(intArray(2,3,4,5), intArray(2,4)));
    }

    @Test
    public void testWillReturnIndexOfMatchWhenMatchFoundWithSimpleData() {
        assertEquals(TWO, ArrayLocate.findStartIndexOfMatchingSubArray(intArray(2,3,4,5), intArray(4,5)));
    }

    @Test
    public void testWillReturnIndexOfMatchWhenMatchFoundWithPartialMatchingData() {
        assertEquals(Integer.valueOf(3), ArrayLocate.findStartIndexOfMatchingSubArray(intArray(2, 3, 4, 4, 5), intArray(4,5)));
    }

    @Test
    public void testWillReturnIndexOfFirstMatchWhenPresentMoreThanOnce() {
        assertEquals(TWO, ArrayLocate.findStartIndexOfMatchingSubArray(intArray(2, 3, 4, 5, 4, 5), intArray(4,5)));
    }

    @Test
    public void testCopesWithNullArrays() {
        Integer[] NON_EMPTY_ARRAY = new Integer[]{1};
        assertNull(ArrayLocate.findStartIndexOfMatchingSubArray(NON_EMPTY_ARRAY, null));
        assertNull(ArrayLocate.findStartIndexOfMatchingSubArray(null, NON_EMPTY_ARRAY));
        assertNull(ArrayLocate.findStartIndexOfMatchingSubArray(null, null));
    }

    @Test
    public void testCopesWithNullArrayEntries() {
        assertEquals(TWO, ArrayLocate.findStartIndexOfMatchingSubArray(intArray(1, null, 1, 2), intArray(1, 2)));
        assertEquals(Integer.valueOf(0), ArrayLocate.findStartIndexOfMatchingSubArray(intArray(1, null, 1, 2), intArray(1, null, 1)));
        assertNull(ArrayLocate.findStartIndexOfMatchingSubArray(intArray(1, 2), intArray(1, null)));
    }

    @Test
    public void testCopesIfSearchArrayIsLongerThanArrayToSearchIn() {
        assertNull(ArrayLocate.findStartIndexOfMatchingSubArray(intArray(1, 2), intArray(1, 2, 3)));
    }

    private Integer[] intArray(Integer... integers) {
        return integers;
    }

}

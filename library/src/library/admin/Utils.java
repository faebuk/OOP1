package library.admin;

import java.util.List;

import library.data.Item;

public class Utils {

    public static long[] addNumber(long[] numbers, long newNumber) {
	if (numbers == null) {
	    numbers = new long[1];
	    numbers[0] = newNumber;
	    return numbers;
	}
	long[] newNumbers = new long[numbers.length + 1];
	System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
	newNumbers[numbers.length] = newNumber;
	return newNumbers;
    }

    public static long[] addNumbers(long[] array1, long[] array2) {
	if (array1 == null || array1.length < 1)
	    return array2;
	if (array2 == null || array2.length < 1)
	    return array1;
	long[] newNumbers = new long[array1.length + array2.length];
	System.arraycopy(array1, 0, newNumbers, 0, array1.length);
	System.arraycopy(array2, array1.length, newNumbers, 0, array2.length);
	return newNumbers;
    }

    public static Item[] concat(Item[]... arrays) {
	int length = 0;
	for (Item[] array : arrays) {
	    length += array.length;
	}
	Item[] result = new Item[length];
	int pos = 0;
	for (Item[] array : arrays) {
	    for (Item element : array) {
		result[pos] = element;
		pos++;
	    }
	}
	return result;
    }

    public static long[] concat(long[]... arrays) {
	int length = 0;
	for (long[] array : arrays) {
	    if (array != null) {
		length += array.length;
	    }
	}
	long[] result = new long[length];
	int pos = 0;
	for (long[] array : arrays) {
	    if (array == null) {
		continue;
	    }

	    for (long element : array) {
		result[pos] = element;
		pos++;
	    }
	}
	return result;
    }

    public static long[] convertToArray(List<Long> list) {
	long[] longIds = new long[list.size()];
	int counter = 0;
	for (Long id : list) {
	    longIds[counter] = id;
	    counter++;
	}

	return longIds;
    }

}

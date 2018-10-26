package library.util;

import library.data.Item;

public class Util {
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
}

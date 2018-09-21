package ch.faebuk;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println("----- Array Methods -----");
		System.out.println("isEqual" + isEqual(new double[]{1, 2, 3}, new double[]{3, 2, 1}));
		System.out.println("addLast" + Arrays.toString(addLast(new double[] {1, 2, 3, 4}, 5)));
		System.out.println("addFirst" + Arrays.toString(addFirst(new double[] {4, 3, 2, 1}, 5)));
		System.out.println("insert" + Arrays.toString(insert(new double[] {1, 3, 4, 5}, 2, 1)));
		System.out.println("removeFirst" + Arrays.toString(removeFirst(new double[] {1, 2, 3, 4, 5})));
		System.out.println("removeLast" + Arrays.toString(removeLast(new double[] {1, 2, 3, 4, 5})));
		System.out.println("remove" + Arrays.toString(remove(new double[] {1, 2, 6, 3, 4, 5}, 2)));
		System.out.println("swap" + Arrays.toString(swap(new double[] {1, 2, 4, 3, 5}, 2, 3)));
		System.out.println("bubbleSort" + Arrays.toString(bubbleSort(new double[] {1, 6, 2, 5, 10, 7, 100, 60, 23})));
		System.out.println("vectorLength " + vectorLength(new double[] {4, 6, 2}));
	}
	
	public static boolean isEqual(double[] arr1, double[] arr2) {
		if(arr1.length != arr2.length) {
			return false;
		}
		
		for(int i=0;i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static double[] addLast(double[] list, double a) {
		double[] newArray = new double[list.length + 1];
		
		for(int i=0; i < list.length; i++) {
			newArray[i] = list[i];
		}
		
		newArray[newArray.length - 1] = a;
		
		return newArray;
	}	
	
	public static double[] addFirst(double[] list, double a) {
		double[] newArray = new double[list.length + 1];
				
		newArray[0] = a;
		
		for(int i=1; i < list.length; i++) {
			newArray[i] = list[i];
		}
		
		return newArray;
	}
	
	public static double[] insert(double[] list, double a, int index) {
		double[] newArray = new double[list.length + 1];
		boolean itemInserted = false;
		
		for(int i=0; i < newArray.length; i++) {
			if(i == index) {
				newArray[i] = a;
				itemInserted = true;
			} else if(itemInserted) {
				newArray[i] = list[i - 1];
			} else {
				newArray[i] = list[i];
			}
		}
		
		return newArray;
	}
	
	public static double getLast(double[] list) {
		return list[list.length -1];
	}
	
	public static double getFirst(double[] list) {
		return list[0];
	}
	
	public static double[] removeFirst(double[] list) {
		double[] newArray = new double[list.length - 1];
		
		for(int i = 1; i < list.length; i++) {
			newArray[i - 1] = list[i];
		}
		
		return newArray;
	}
	
	public static double[] removeLast(double[] list) {
		double[] newArray = new double[list.length - 1];
		
		for(int i = 0; i < list.length - 1; i++) {
			newArray[i] = list[i];
		}
		
		return newArray;
	}
	
	public static double[] remove(double[] list, int index) {
		double[] newArray = new double[list.length - 1];
		boolean removed = false;
		
		for(int i=0; i < list.length; i++) {
			if(i != index && !removed) {
				newArray[i] = list[i];
			} else if(i != index && removed) {
				newArray[i - 1] = list[i];
			} else {
				removed = true;
			}
		}
		
		return newArray;
	}
	
	public static double[] swap(double[] list, int index1, int index2) {
		double[] newArray = new double[list.length];
				
		for(int i=0; i < newArray.length; i++) {
			if(i == index1) {
				newArray[i] = list[index2];
			} else if (i == index2) {
				newArray[i] = list[index1];
			} else {
				newArray[i] = list[i];
			}
		}
		
		return newArray;
	}
	
	public static double[] bubbleSort(double[] list) {
		for(int n = list.length; n > 1; --n) {
			for(int i = 0; i < n -1; ++i) {
				if(list[i] > list[i + 1]) {
					list = swap(list, i, i + 1);
				}
			}
		}
		
		return list;
	}
	
	public static double vectorLength(double[] list) {
		double res = 0;
		double length = 0;
		
		for(int i = 0; i < list.length; i++) {
			res += list[i] * list[i];
		}
		
		length = Math.sqrt(res);
		
		return length;
	}
	
	public static double[] minVector(double[][] vectors) {
		double[] minVector = null;
		double minLength = 0;
		
		for(int i = 0; i < vectors.length; i++) {
			double vectorLength = vectorLength(vectors[i]);
			
			if(vectorLength < minLength || minLength == 0) {
				minLength = vectorLength;
				minVector = vectors[i];
			}
		}
		
		return minVector;
	}

}

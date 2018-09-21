package ch.faebuk;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.print(isEqual(new double[]{1, 2, 3}, new double[]{3, 2, 1}));
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
		return new double[]{1, 1};
	}

}

package ch.faebuk;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(min(4, 2, 3));
		
		//square("4");
		
		change(10.35);
		
		//sinValue(-2);
		//sinValue(4.1);
		//sinValue(2.34);
		
		//pyramide(8);
		int[] arr = {2, 3, 4, 6, 8};
		
		//System.out.println(findPair(arr,9)[0] + " " + findPair(arr, 9)[1]);
		
		//System.out.println(reverse("abc", "xyz"));
	}
	
	public static long min(long a, long b, long c) {
		if(a < b && a < c) {
			return a;
		} else if(b < a && b < c) {
			return b;
		} else {
			return c;
		}
	}
	
	public static void square(String s) {
		int numb = Integer.parseInt(s);
		
		JOptionPane.showMessageDialog(null, numb * numb);
	}
	
	public static void change(double d) {
		int leftCashRp = (int) (d * 100);
		
		int[][] muenzen = {
				{500, 0},
				{200, 0},
				{100, 0},
				{50, 0},
				{20, 0},
				{10, 0},
				{5, 0}
		};
				
		while(leftCashRp > 0) {
			if(leftCashRp / 500 >= 1) {
				muenzen[0][1] += (int) leftCashRp / 500;
				leftCashRp = leftCashRp % 500;
			} else if(leftCashRp / 200 >= 1) {
				muenzen[1][1] += (int) leftCashRp / 200;
				leftCashRp = leftCashRp % 200;
			} else if(leftCashRp / 100 >= 1) {
				muenzen[2][1] += (int) leftCashRp / 100;
				leftCashRp = leftCashRp % 100;
			} else if(leftCashRp / 50 >= 1) {
				muenzen[3][1] += (int) leftCashRp / 50;
				leftCashRp = leftCashRp % 50;
			} else if(leftCashRp / 20 >= 1) {
				muenzen[4][1] += (int) leftCashRp / 20;
				leftCashRp = leftCashRp % 20;
			} else if(leftCashRp / 10 >= 1) {
				muenzen[5][1] += (int) leftCashRp / 10;
				leftCashRp = leftCashRp % 10;
			} else if(leftCashRp / 5 >= 1) {
				muenzen[6][1] += (int) leftCashRp / 5;
				leftCashRp = leftCashRp % 5;
			} else {
				JOptionPane.showMessageDialog(null, "Kann nicht getauscht werden");
				break;
			}
		}
		
		if(leftCashRp == 0) {
			JOptionPane.showMessageDialog(null, String.format("5CHF x %s \n2CHF x %s \n1CHF x %s \n50Rp x %s \n20Rp x %s \n10Rp x %s \n5Rp x %s", muenzen[0][1], muenzen[1][1], muenzen[2][1], muenzen[3][1], muenzen[4][1], muenzen[5][1], muenzen[6][1]));
		}
	}
	
	
	public static void sinValue(double d) {
		if(d < 0) {
			JOptionPane.showMessageDialog(null, "Ungültige Eingabe, Wert negativ");
		} else if(Math.sin(d) < 0) {
			JOptionPane.showMessageDialog(null, "Ungültige Eingabe, Sinuswert negativ");
		} else {
			JOptionPane.showMessageDialog(null, "Sinuswert: " + Math.sin(d));
		}		
	}
	
	public static void pyramide(int val) {
		if(val > 10) {
			return;
		}
		
		for(int i = 1; i <= val;i++) {
			//spacing
			for(int x = 0; x < val - i; x++) {
				System.out.print(" ");
			}
			
			for(int y = 0; y < i;y++) {
				System.out.print(i + " ");
			}
			
			System.out.println();
		}
	}
	
	public static int[] findPair(int[] array, int target) {
		int[] res = {-1, -1};
		
		for(int x=0; x < array.length; x++) {
			for(int y= x; y < array.length; y++) {
				if((array[x] + array[y]) == target) {
					res[0] = array[x];
					res[1] = array[y];
					
					return res;
				}
			}
		}
		
		return res;
	}
	
	public static String reverse(String s, String t) {
		String finalString = t;
		
		for(int i = s.length(); i >= 1; i--) {
			finalString += s.charAt(i - 1);
		}
		
		return finalString;
	}

}

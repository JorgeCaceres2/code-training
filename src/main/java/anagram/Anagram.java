package anagram;

import java.util.List;

public class Anagram {

	public static List<String> check (String [] arr) {
		// test = 2 t - 1e - 1s
		//e s t + e1s1t2


		//tset
		//est -> e1s1t2

		//map string, list<String>

		for (int i = 0; i < arr.length; i++) {



		}
	}

	public static boolean isAnagram (String input) {
		 char ch[] = input.toCharArray();
		 int start = 0;
		 int end = ch.length - 1;
		while (start > end) {
			if (ch[start] != ch[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {

	}

}

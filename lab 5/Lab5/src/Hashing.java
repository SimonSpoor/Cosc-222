import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Hashing {

	int n;
	
	//Provided for comparison only; feel free not to use
	long hashJava(String s) {
		return s.hashCode();
	}
	
	long hashPolynomial(String s, int a) {
		int x = 0;
		int k = s.length() - 1;
		for(char c: s.toCharArray()){
			x += c * Math.pow(a, k);
			k--;
		}
		return x;
	}
	
	long compressionMAD(long i, int a, int b, int p, int m) {
		return ((a * i + b) % p) % m;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		File wordListFile = new File("Lab5/src/WordList.dat");
		Integer[] hashcodes = new Integer[]{1};
		Scanner sc = new Scanner(wordListFile);
		Hashing h = new Hashing();

		while (sc.hasNext()){
			String s = sc.nextLine();
			for (int i: hashcodes){
				long a = h.hashPolynomial(s,31);
			}
		}
	}

}

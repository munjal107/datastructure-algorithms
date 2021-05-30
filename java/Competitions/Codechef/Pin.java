//url= https://www.codechef.com/problems/PINS

//bigInteger
import java.util.Scanner;

class Pin{
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		int[] calc = new int[t];
		for(int i=0;i<t;i++){
			calc[i] = sc.nextInt();
		}
		for(int i:calc)
			solve(i);
	}
	static void solve(int calc){
		int a = (int)Math.ceil(calc/2.0);
		long p = (long)Math.pow(10,calc);
		long q = (long)Math.pow(10,a) ;
		long gcd = findGCD(p,q);
		System.out.println(q/gcd+ " " + p/gcd);
	}
	static long findGCD(long a,long b){
		while(a!=b){
			if(a>b)
				a-=b;
			else
				b-=a;
		}
		return a;
	}
}
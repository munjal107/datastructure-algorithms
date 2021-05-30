// https://www.codechef.com/problems/CLFIBD

import java.io.*;
import java.util.*;
class FibString{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			final String in = br.readLine();
			solve(in);
		}
	}
	static void solve(String in){
		int[] a = new int[26];
		for(int i=0;i<in.length();i++){
			if(in.charAt(i)>=97 && in.charAt(i)<=122)
				a[in.charAt(i)-97]++;
		}
		//Arrays.sort(a,Collections.reverseOrder());
		//System.out.println("Count: " + Arrays.toString(a));
		Arrays.sort(a);
		int n=0,j=0;
		for(int i=0;i<a.length;i++){
			if(a[i]>0)
				n++;
			if(n==1)
				j=i;
		}
		//System.out.println("Count: " + n);
		if(n<3){
			System.out.println("Dynamic");
			return;
		}
		int[] count = new int[n];
		System.arraycopy(a,j,count,0,n);
		//System.out.println("Count: " + Arrays.toString(count));
		for(int i=2;i<count.length;i++){
			if(count[i]==count[i-1]+count[i-2]){
				System.out.println("Dynamic");
				return;
			}
		}
		System.out.println("Not");
	}
}

/* test case
3
aaaabccc
aabbcc
ppppmmnnoooopp

1
aabbcc


*/
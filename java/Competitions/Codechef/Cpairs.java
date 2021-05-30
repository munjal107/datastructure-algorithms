//  https://www.codechef.com/problems/CPAIRS


import java.util.*;
import java.io.*;

 class Cpairs{

	public static void main(String[] args)  throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++){


			int n = Integer.parseInt(br.readLine());
			int[] arr=new int[n];
			final String[] in = br.readLine().split(" ");
			for(int j=0;j<n;j++){
				arr[j]=Integer.parseInt(in[j]);
			}
			solve(arr,n);
			
		}

	}


	static void solve(int[] arr,int n){
		int c,e;
		c=e=0;
			for(int k=0;k<n;k++){
				if(arr[k]%2==0){
					e++;
				}
				else{
					c=c+e;
				}
			}
			System.out.println(c);
	}
}

/*
1
4
1 2 1 3

1
5
5 4 1 2 3


2
4
1 2 1 3
5
5 4 1 2 3


*/
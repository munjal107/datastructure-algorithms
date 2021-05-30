//  https://www.codechef.com/problems/CPAIRS


import java.util.*;


 class Cpairs{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int[] arr=new int[n];

			for(int j=0;j<n;j++){
				arr[j]=sc.nextInt();
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
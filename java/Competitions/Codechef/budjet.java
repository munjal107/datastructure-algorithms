/* 
You are developing a smartphone app. You have a list of potential customers for your app. Each customer has a budget and will buy the app at your declared price if and only if the price is less than or equal to the customer's budget.


You want to fix a price so that the revenue you earn from the app is maximized. Find this maximum possible revenue.


For instance, suppose you have 4 potential customers and their budgets are 30, 20, 53 and 14. In this case, the maximum revenue you can get is 60.


Input format
Line 1 : N, the total number of potential customers.

Lines 2 to N+1: Each line has the budget of a potential customer.


Output format
The output consists of a single integer, the maximum possible revenue you can earn from selling your app.


Sample Input 1
4
30
20
53
14

Sample Output 1
60

Sample Input 2
5
40
3
65
33
21

Sample Output 2
99
**/

import java.util.Scanner;
import java.util.Arrays;
class budjet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long[] arr = new long[(int)n];
		long sum = 0;
		for(int i=0;i<n;i++){
			arr[i]=sc.nextLong();
		}
		Arrays.sort(arr);
		long temp;
		for(int i=0;i<n;i++){
			temp=arr[i]*(n-i);
			if(temp>sum){
				sum=temp;
			}
 
		}
		System.out.println(sum);
	}
}  




/*
import java.util.Scanner;
import java.util.Arrays;
class Budjet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long[] arr = new long[(int)n];
		long temp = Long.MAX_VALUE;
		int count = 0,sum=0;
		for(int i=0;i<n;i++){
			arr[i]=sc.nextLong();
			sum+=arr[i];
		}
		long avg = sum/n;
		for(int i=0;i<n;i++){
			if(arr[i] >= avg){
            	if(temp > arr[i])
                	temp = arr[i];
            	count++;
        }
		}
		System.out.println(count*temp);
		/*
		Arrays.sort(arr);
		long temp;
		for(int i=0;i<n;i++){
			temp=arr[i]*(n-i);
			if(temp>sum){
				sum=temp;
			}
 
		}*/
	/*	//System.out.println(Long.MAX_VALUE+ " "+Double.MAX_VALUE);
	}
} */
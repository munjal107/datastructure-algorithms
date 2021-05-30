import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintStream;
class Budget2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		double sum = 0L;
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		double temp; 
		for(int i=0;i<n;i++){
			temp=arr[i]*(n-i);
			if(temp>sum){
				sum=temp;
			}

		}
		System.out.format("%.0f",sum);
	}
}
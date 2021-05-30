/*  
Given a sequence of distinct numbers a1, a2, ….. an, an inversion occurs if there are indices i<j such that ai > aj .

For example, in the sequence 2 1 4 3 there are 2 inversions (2 1) and (4 3).

The input will be a main sequence of N positive integers. From this sequence, a Derived derived sequence will be o
btained using the following rule. The output is the number of inversions in the derived sequence.

Rule for forming derived sequence

The derived sequence is formed by counting the number of 1s bits in the binary representation of the corresponding 
number in the input sequence.

Thus, if the input is 3,4,8, the binary representation of the numbers are 11,100 and 1000. The derived sequence is the 
number of 1sin the binary representation of the numbers in the input sequence, and is 2,1,1

Constraints
N <= 50

Integers in sequence <= 107

Input Format
The first line of the input will have a single integer, which will give N.

The next line will consist of a comma separated string of N integers, which is the main sequence

Output
The number of inversions in the derived sequence formed from the main sequence.

Explanation
Example 1

Input

5

55, 53, 88, 27, 33

Output

8

Explanation

The number of integers is 5, as specified in the first line. The given sequence is 55, 53, 88, 27, 33.

The binary representation is 110111, 110101, 1011000, 11011, 100001and 100001 . The derived sequence 
is 5,4,3,4,2, 4,3,4,2 (corresponding to the number of 1s bits). The number of inversions in this is 8, namely 
(5,4),(5,3),(5,4),(5,2),(4,3),(4,2),(3,2),(4,2). Hence the output is 8.

Example 2
Input
8
120,21,47,64,72,35,18,98
Output
15

*/

import java.io.*;

class Inversion{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int[] arr = new int[n];
		String[] str = input.split(",");
		for(int i=0;i<str.length;i++){
			arr[i]=Integer.parseInt(str[i]);
		}
		solvee(arr);
	}

	public static void solvee(int[] input){
		int[] count = new int[input.length];
		int inverse=0;
		for(int i=0;i<input.length;i++){
			count[i] = getCount(input[i]);

		}
		for(int i=0;i<count.length;i++){
			for(int j=i+1;j<count.length;j++){
				if(count[i]>count[j]){
					inverse++;
				}
			}
		}
		System.out.println(inverse);
	}
	public static int getCount(int a){
		int c=0;
		while(a>0){
			if(a%2==1){
				c++;
			}
			a=a/2;
		}
		return c;
	}
}


/*
5
55,53,88,27,33

8
120,21,47,64,72,35,18,98
*/

/*codevita 18

Given a sequence of distinct numbers a1, a2, ….. an, an inversion occurs if there are indices i<j such that ai > aj

For example, in the sequence 2 1 4 3 there are 2 inversions (2 1) and (4 3).

The input will be a main sequence of N positive integers. From this sequence, a Derived Sequence will be obtained 
using the following rule. The output is the number of inversions in the derived sequence.

Rule for forming derived sequence

An integer may be represented in base 6 notation. In base 6, 10305 is 1x64 + 3x62 + 5 =1409. Note that none of the 
igits in that representation will be more than 5.

The sum of digits in a base 6 representation is the sum of all the digits at the various positions in the 
representation. Thus for the number 1409, the representation is 10305, and the sum of digits is 1+0+3+0+5=9.
The sum of digits may be done in the decimal system, and does not need to be in base 6

The derived sequence is the sum of the digits when the corresponding integer is represented in the base 6 form 
number will be expressed in base 6, and the derived sequence is the sum of the digits of the number in the base 6 
representation.

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
2
Explanation
The number of integers is 5, as specified in the first line. The given sequence is 55, 53, 88, 27, 33.
The base 6 representation is 131, 125, 224, 43, 53 The derived sequence is 5,8,8,7,8 (corresponding to the sum of digits). The number of inversions in this is 2, namely (8, 7), (8, 7)
*/
import java.io.*;

class Inverse6{
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
			count[i] = getbase6(input[i]);

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
	public static int getbase6(int a){
		int c=0,b;
		while(a>0){
			b=a%6;
			c=c+b;
			a=a/6;
		}		
		return c;
	}
}

/*  Test Cases
5
55,53,88,27,33


8
120,21,47,64,72,35,18,98
*/


import java.math.BigInteger;
import java.util.Scanner;

class Fib1{
        static BigInteger []arr = new BigInteger[1000000];
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        BigInteger mo = BigInteger.valueOf(1000000007);
        int i , k , n , t;
        t=kb.nextInt();
        while(t-- > 0){

        n = kb.nextInt();
        k = kb.nextInt();

        BigInteger temp = BigInteger.ONE;
        BigInteger ans = BigInteger.ONE;
        BigInteger ini = BigInteger.ONE;
        for(i = 0 ; i < k ; i++){
            arr[i] = kb.nextBigInteger();
            temp = temp.multiply(arr[i]);
        }
        ans=temp;
        int c=0;
        for( ; i < n ; i++){
            arr[i] = ans;
            temp = temp.multiply(ans);
            ini = ini.multiply(arr[c++]);
            ans = temp.divide(ini);
        }
        System.out.println(arr[i-1].mod(mo));
        }
    }
}
/*
As we know in Fibonacci series every number after the first two is the
sum of the two preceding ones.

Instead of adding two preceding numbers, multiply them and print the
result modulo 10^9+7.

Since this is easy, let’'s make it bit difficult. Let'’s say there are
K numbers to begin with.

You have to find nth number, where nth number will be product of k
previous numbers modulo 10^9+7.

Constraints
1<=t<=10

1<=n<=10^6

1<=k<=10

1<=k[i]<=100

Input Format
First line contains T number of test case,

In each test case

First line contains two integers n, k delimited by space

Second line contains k integers delimited by space

Output
T lines, each line contains modified Fibonacci number modulo 109+7


Explanation
Example 1

Input

1
4 3
1 2 3

Output

6

Explanation

4th modified Fibonacci number will be 1*2*3=6

Example 2

Input

1
10 3
1 2 3

2
10 3
1 2 3
4 3
1 2 3

Output

845114970

Explanation

4th , 5th , 6th modified Fibonacci numbers are 6 , 36 , 648 respectively

Similarly 10th modified Fibonacci number will be 845114970



1
7 4
2 3 4 5
*/
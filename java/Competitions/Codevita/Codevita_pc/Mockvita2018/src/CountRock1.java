import java.util.Scanner;

class CountRock1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int r = sc.nextInt();
        int[] sample = new int[s];
        int[] range = new int[r*2];
        for(int i=0;i<s;i++)
            sample[i]=sc.nextInt();
        for(int i=0;i<r*2;i++)
            range[i]=sc.nextInt();
        solve(s,r,sample,range);
    }
    static void solve(int s,int r,int[] sample,int[] range){
        int count=0;
        for(int i=0;i<range.length;i=i+2){
            count=0;
            for(int j=0;j<sample.length;j++){
                if(sample[j]>=range[i] && sample[j]<=range[i+1]){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
/*
20 3
921 107 270 631 926 543 589 520 595 93 873 424 759 537 458 614 725 842 575 195
1 100
50 600
1 1000
*/
/*Juan Marquinho is a geologist and he needs to count rock samples in order to send it to chemical laboratory. He has a problem: The laboratory only accepts rock samples by a range of its size in ppm (parts per million).

Juan Marquinho receives the rock samples one by one and he classifies the rock samples according the range of the laboratory. This process is very hard because the rock samples may be in millions.

Juan Marquinho needs your help, your task is develop a program to get the number of rocks of a given range of size.

Constraints
10 <= S <= 10000

1 <= R <= 1000000

1<=size of Sample <= 1000

Input Format
An positive Integer S (the number of rock samples) separated by a blank space, and a positive Integer R (the number of ranges of the laboratory);

A list of the sizes of S samples (in ppm), as positive integers separated by space

R lines where ith line containing two positive integers, space separated, indicating the minimum size and maximum size respectively of the ith range.

Output
R lines where ith line containing a single non-negative integer indicating the number of samples in the ith range.


Explanation
Example 1

Input

10 2 345 604 321 433 704 470 808 718 517 811 300 350 400 700

Output

2

4

Explanation

There are 10 sampes (S) and 2 ranges ( R ). The samples are 345, 604,…811. The ranges are 300-350 and 400-700. There are 2 samples in the first range (345 and 321) and 4 samples in the second range (604, 433, 470, 517). Hence the two lines of the output are 2 and 4.

Example 2

Input

20 3

921 107 270 631 926 543 589 520 595 93 873 424 759 537 458 614 725 842 575 195

1 100

50 600

1 1000

Output

1
12
20 */

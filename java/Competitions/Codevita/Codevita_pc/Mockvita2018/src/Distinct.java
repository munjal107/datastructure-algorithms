import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Distinct {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(",");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        solve(n,k);
    }
    static void solve(int n,int k){
        int count=0;
        int sum=0;
        int a=1;
        for(int i=1;i<15;i++){
            for(int j=i+1;j<15;j++){
                sum = i*i+j*j;
                if(sum<n){
                    System.out.println(i+" "+j+" "+sum);
                    final boolean b = getResult((n-sum),(k-2),i,j,a);
                    if(b)
                        count++;
                }
            }
        }
        System.out.println(count);
    }
    static boolean getResult(int sum,int k,int i,int j,int a){
        if(sum==0){
            if(k==0)
                return true;
        }
        if(k==0&& sum!=0){
            return false;
        }
        if(a!=i && a!=j){
            System.out.println("a:"+a+" "+i+" "+j+" "+sum);
            return getResult((sum-a),(k-1),i,j,(a=a+1));
        }
        else {
            return getResult(sum,k,i,j,a=a+1);
        }
    }
}
/* Among the several path breaking contributions to Number theory by the famous Indian mathematician Srinivasa Ramanujan,
his contribution to partitions is extensive and deep. A partition of a positive integer n, also called an integer partition,
is a way of writing n as a sum of positive integers. Two sums that differ only in the order of their summands are considered
the same partition. For example, 4 can be expressed as a sum of positive integers in the following ways: 1+1+1+1, 1+1+2, 1+3,
 2+2, 4. Of these, only 1+3 and 4 use non repeating summands. Partitions using non repeating summands are called distinct
 partitions of n. There is no general formula for the number of partitions of an integer n and it is known that the
 partitions grow rapidly with n.

A k-distinct-partition of a number n is a set of k distinct positive integers that add up to n. For example, 3-distinct
partitions of 10 are 1+2+7, 1+3+6,1+4+5 and 2+3+5

The objective is to count all k-distinct partitions of a number that have at least two perfect squares in the elements
of the partition. Note that 1 is considered a perfect square.

Constraints
k<N<200, so that at least one k-distinct partition exists.

Input Format
The input consists of one line containing of N and k separated by a comma.

Output
One number denoting the number of k-distinct partitions of N that have at least two perfect squares in the elements of
the partition.


Explanation
Example 1

Input

10, 3

Output

1

Explanation: The input asks for 3-distinct-partitions of 10. There are 4 of them
(1+2+7, 1+3+6, 1+4+5 and 2+3+5). Of these, only 1 has at least two perfect squares in the partition (1+4+5).

Example 2

Input

12, 3

Output

2

Explanation

The input asks for 3-distinct partitions of 12. There are 7 of them (9+2+1, 8+3+1,7+4+1,7+3+2,6+5+1, 6+4+2, 5+4+3).
 Of these, two, (9+4+1, 7+4+1) have two perfect squares. Hence, the output is 2.

 //This is The Coding Area
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Distinct {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(",");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        solve(n,k);
    }
    static void solve(int n,int k){
        int count=0;
        int sum=0;
        int a=1;
        for(int i=1;i<15;i++){
            for(int j=i+1;j<15;j++){
                sum = i*i+j*j;
                if(sum<n){
                    final boolean b = getResult((n-sum),(k-2),i,j,a);
                    if(b)
                        count++;
                }
            }
        }
        System.out.println(count);
    }
    static boolean getResult(int sum,int k,int i,int j,int a){
        if(sum==0){
            if(k==0)
                return true;
        }
        if(k==0&& sum!=0){
            return false;
        }
        if(a!=i && a!=j){
            getResult((sum-a),(k-1),i,j,(a=a+1));
        }
        else {
            getResult(sum,k,i,j,a=a+1);
        }
        return true;
    }
}


 */
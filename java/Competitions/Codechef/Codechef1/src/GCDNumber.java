// https://www.codechef.com/LTIME62B/problems/GCDSUM

import java.util.Scanner;

class GCDNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] input = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                input[i][j] = scanner.nextInt();
            }
        }
        solve(input);
    }
    static void solve(int[][] a){
        long sum=0;
        int n = a.length;
        int m = a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=i+1;k<n;k++){
                    for(int l=0;l<m;l++){
                      //  System.out.println("GCD: "+a[i][j]+" "+a[k][l] + " " + gcd(a[i][j],a[k][l]));
                        sum =sum + gcd(a[i][j],a[k][l]);
                    }
                }
            }
        }
        //System.out.println(sum);
        System.out.println((long)(sum%(Math.pow(10,9)+7)));
    }
    static int gcd(int a,int b){
        return (b==0)?a:gcd(b,a%b);
    }
}

/* Test Case

2 3
5 15 8
3 12 10

output: 25

*/
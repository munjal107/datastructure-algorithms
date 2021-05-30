//url= https://www.codechef.com/problems/PINS

//bigInteger
import java.math.BigInteger;
import java.util.Scanner;

class Pin{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int i=0;i<t;i++){
            final int calc = sc.nextInt();
            solve(calc);
        }
        /*
        int[] calc = new int[t];
        for(int i=0;i<t;i++){
            calc[i] = sc.nextInt();
        }
        for(int i:calc)
            solve(i);*/
    }
    static void solve(int c){
        int a = (int)Math.ceil(c/2.0);
        StringBuilder sb = new StringBuilder("1");
        for(int i=0;i<(c-a);i++){
            sb.append("0");
        }
        System.out.println(1 + " " + sb);
    }

    /*
    static void solve(int calc){
        int a = (int)Math.ceil(calc/2.0);
        BigInteger p = new BigInteger(String.valueOf(Math.pow(10,calc)).split("\\.")[0]);
        BigInteger q = new BigInteger(String.valueOf(Math.pow(10,a)).split("\\.")[0]);
        BigInteger gcd = p.gcd(q);
        System.out.println(q.divide(gcd)+" " + p.divide(gcd));
    }*/

    /*static void solve(int calc){
        int a = (int)Math.ceil(calc/2.0);
        long p = (long)Math.pow(10,calc);
        long q = (long)Math.pow(10,a) ;
        long gcd = findGCD(p,q);
        System.out.println(q/gcd+ " " + p/gcd);
    }*/
    /*
    static long findGCD(long a,long b){
        while(a!=b){
            if(a>b)
                a-=b;
            else
                b-=a;
        }
        return a;
    }*/
}
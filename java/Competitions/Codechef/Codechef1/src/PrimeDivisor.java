// https://www.codechef.com/LTIME62B/problems/PRMDIV


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class PrimeDivisor {
    static int max = 1000000;
    static boolean[] prime = new boolean[max+1];
    static long[] su = new long[max+1];

    static {
        //by default all are false and a after staic block false indicate prime number
       // long startTime = System.nanoTime();
        //System.out.println("init");
        prime[0]=prime[1]=true;
        for(int p = 2; p*p <=max; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(!prime[p])
            {
                su[p]+=p;
                // Update all multiples of p
                for(int i = p*2; i <= max; i += p) {
                    prime[i] = true;
                    su[i]+=p;
                }

            }
        }
      // long endTime = System.nanoTime();
       // System.out.println("Took "+(endTime - startTime) + " ns");

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            final int n = Integer.parseInt(br.readLine());
            final String[] in = br.readLine().split(" ");
            solve(in,n);
        }
    }
    static void solve(String[] in,int n){
        int count=0;
        int[] input = new int[n];
        //long sum[] = new long[n];
        for(int i=0;i<n;i++){
            input[i]=Integer.parseInt(in[i]);
        }
        Arrays.sort(input);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //if(i!=j && input[j]%input[i]==0 && su[input[j]]%su[input[i]]==0){
                   // System.out.println(input[j]+" "+input[i]+" "+ su[input[j]]+" "+su[input[i]]);
                if(input[i]==input[j])
                    count+=2;
                else if(input[j]%input[i]==0 && su[input[j]]%su[input[i]]==0)
                    count++;
                //}
            }
        }
        System.out.println(count);

    }
}
/* tEst cases
2
5
2 30 2 4 3
5
2 30 2 4 3

1
5
2 30 2 4 3

1
6
2 30 2 4 30 3

1
6
2 30 2 4 3 3

static void solve(String[] in,int n){
        print();
        int count=0;
        int[] input = new int[n];
       long sum[] = new long[n];
        for(int i=0;i<n;i++){
            input[i]=Integer.parseInt(in[i]);
            sum[i] = getSum(input[i]);
            //System.out.println(input[i]+" ");//;+prime[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && input[j]%input[i]==0 && sum[j]%sum[i]==0)
                        count++;
                }
            }
        System.out.println(count);
    }
    static long getSum(int n){
        long sum=0;
        for(int i = 2; i <= n; i++)
        {
            if(n%i==0 && !prime[i])
                sum+=i;
        }
        return sum;
    }
    static void print(){
        for(int i=1;i<=30;i++)
            System.out.println(i+" "+su[i]);
    }
    //different
static long getSum(int n){
        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime,true);
        long sum=0;
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p])
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] && n%i==0)
                sum+=i;
        }
        return sum;
    }

    //logic 2

    static long getSum(int n){
        long sum=0;
        if(n%2==0)
            sum+=2;
        for(int i=3;i<=n/2;i+=2){
            if(n%i==0)
                sum+=chkPrime(i);
        }
        if(n!=2)
            sum+=chkPrime(n);
        return sum;
    }
    static int chkPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return 0;
        }
        return n;
    }
 */
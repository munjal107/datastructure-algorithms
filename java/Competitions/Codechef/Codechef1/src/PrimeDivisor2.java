import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.TreeSet;

class PrimeDivisor2 {
    final static int max = 1000000;
    static boolean[] prime = new boolean[max+1];
    static long[] sum = new long[max+1];

    static {
        //by default all are false and a after staic block false indicate prime number
        // long startTime = System.nanoTime();
        //System.out.println("init");
        prime[0]=prime[1]=true;
        sum[0]=sum[1]=1;
        for(int p = 2; p<=max; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(!prime[p])
            {
                sum[p]+=p;
                // Update all multiples of p
                for(int i = p*2; i <= max; i += p) {
                    prime[i] = true;
                    sum[i]+=p;
                }

            }
        }
        for(int i=2;i<=max;i++){
            if(sum[i]==0)
                System.out.println(i);
        }

        /*for(int i=2;i<=max;i++){
            if(sum[i]==0 && !prime[i]){
                sum[i]=i;
                for(int j=i*2;j<=max;j+=i)
                    sum[j]+=i;
            }
            // System.out.println(i+ " " +sum[i]);
        }*/
        // System.out.println(199999+ " " +sum[199999]); //999995 5

        // long endTime = System.nanoTime();
        // System.out.println("Took "+(endTime - startTime) + " ns");

    }


    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int t = ir.readInt();
       // System.out.println("TEst "+t);
        for(int i=0;i<t;i++){
            int n  = ir.readInt();
         //   System.out.println("N "+n);

            int[] input=new int[n];
            int[] freq = new int[max+1];
            int large = Integer.MIN_VALUE;
            TreeSet<Integer> ts = new TreeSet<Integer>();
            for(int j=0;j<n;j++){
                input[j]=ir.readInt();
               // System.out.println("i : "+input[i]);
                freq[input[j]]++;
                large = (input[j]>large)?input[j]:large;
                ts.add(input[j]);
            }

            solve(input,freq,ts,large);
        }
    }
    static void solve(int[] input,int[] freq,TreeSet<Integer> ts,int large){
        Iterator it = ts.iterator();
        long count=0;
        while(it.hasNext()){
            int x = (int)it.next();
            if(freq[x]>1)
                count+=((long)freq[x]*(long)(freq[x]-1));
            for(int i=2*x;i<=large;i+=x){
                if(freq[i]>0 && sum[i]%sum[x]==0)
                    count+=((long)freq[x]*(long)freq[i]);
            }
        }
        System.out.println(count);
        count=0;
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input.length;j++){
                if(i!=j && input[j]%input[i]==0 && sum[j]%sum[i]==0)
                    count++;
            }
        }
        System.out.println(count);
    }
}



class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new RuntimeException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String readString() {
        final StringBuilder stringBuilder = new StringBuilder();
        int c = read();
        while (isSpaceChar(c))
            c = read();
        do {
            stringBuilder.append(c);
            c = read();
        } while (!isSpaceChar(c));
        return stringBuilder.toString();
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1 || c == ',';
    }

}

/*
            PRIMEDIVSIOR3

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

class PrimeDivisor3 {
    final static int max = 1000000;
    static boolean[] prime = new boolean[max+1];
    static long[] sum = new long[max+1];

    static {
        prime[0]=prime[1]=true;
        sum[0]=sum[1]=1;
        for(int p = 2; p<=max; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(!prime[p])
            {
                sum[p]+=p;
                // Update all multiples of p
                for(int i = p*2; i <= max; i += p) {
                    prime[i] = true;
                    sum[i]+=p;
                }

            }
        }
        /*for(int i=2;i<=max;i++){
            if(sum[i]==0 && !prime[i]){
                sum[i]=i;
                for(int j=i*2;j<=max;j+=i)
                    sum[j]+=i;
            }
        }*/
//    }

/*
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
        int n  = sc.nextInt();
        int[] input=new int[n];
        int[] freq = new int[max+1];
        int large = Integer.MIN_VALUE;
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for(int j=0;j<n;j++){
        input[j]=sc.nextInt();
        freq[input[j]]++;
        large = (input[j]>large)?input[j]:large;
        ts.add(input[j]);
        }
        solve(input,freq,ts,large);
        }
        }
static void solve(int[] input,int[] freq,TreeSet<Integer> ts,int large){
        Iterator it = ts.iterator();
        long count=0;
        while(it.hasNext()){
        int x = (int)it.next();
        if(freq[x]>1)
        count+=((long)freq[x]*(long)(freq[x]-1));
        for(int i=2*x;i<=large;i+=x){
        if(freq[i]>0 && sum[i]%sum[x]==0)
        count+=((long)freq[x]*(long)freq[i]);
        }
        }
        /*int count=0;
        for(int i=0;i<input.length;i++){
            System.out.println(i+" "+ input[i]);
        }
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input.length;j++){
                System.out.println(input[i]+" "+input[j]+" "+sum[i]+" "+sum[j]);
                if(i!=j && input[j]%input[i]==0 && sum[j]%sum[i]==0)
                    count++;
            }
        }*//*
        System.out.println(count);
        }
        }

 */
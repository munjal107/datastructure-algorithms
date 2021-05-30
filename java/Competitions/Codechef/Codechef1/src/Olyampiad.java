//https://www.codechef.com/ZCOPRAC/problems/ZCO14003


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Olyampiad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[] arr = new long[(int)n];
        long sum = 0;
        for(long i=0;i<n;i++){
            arr[(int)i]=Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long temp;
        for(int i=0;i<n;i++){
            temp=arr[i]*(n-i);
            if(temp>sum){
                sum=temp;
            }

        }
        System.out.println((long)sum);
    }
}


/*
runtime 0.5sec
class Olyampiad {
    public static void main(String[] args){
        InputReader ir = new InputReader(System.in);
        long n = ir.readInt();
        long[] arr = new long[(int)n];
        long sum = 0;
        for(long i=0;i<n;i++){
            arr[(int)i]=ir.readLong();
        }
        Arrays.sort(arr);
        long temp;
        for(int i=0;i<n;i++){
            temp=arr[i]*(n-i);
            if(temp>sum){
                sum=temp;
            }

        }
        System.out.println((long)sum);
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

}*/
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.InputMismatchException;
    

class FastReader {
    private InputStream stream;
    private byte[] buf = new byte[8192];
    private int curChar;
    private int pnumChars;

    public FastReader(InputStream stream) {
        this.stream = stream;
    }

    private int pread() {
        if (pnumChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= pnumChars) {
            curChar = 0;
            try {
                pnumChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (pnumChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public String next() {
        return nextString();
    }

    private int peek() {
        if (pnumChars == -1) {
            return -1;
        }
        if (curChar >= pnumChars) {
            curChar = 0;
            try {
                pnumChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (pnumChars <= 0) {
                return -1;
            }
        }
        return buf[curChar];
    }

    public int nextInt() {
        int c = pread();
        while (isSpaceChar(c))
            c = pread();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = pread();
        }
        int res = 0;
        do {
            if (c == ',') {
                c = pread();
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = pread();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public int[][] nextIntMap(int n, int m) {
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) {
            array[i] = nextIntArray(m);
        }
        return array;
    }

    public long nextLong() {
        int c = pread();
        while (isSpaceChar(c))
            c = pread();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = pread();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = pread();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    public long[][] nextLongMap(int n, int m) {
        long[][] array = new long[n][];
        for (int i = 0; i < n; i++) {
            array[i] = nextLongArray(m);
        }
        return array;
    }

    public String nextString() {
        int c = pread();
        while (isSpaceChar(c))
            c = pread();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = pread();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public String nextLine() {
        int c = pread();
        while (isSpaceChar(c))
            c = pread();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = pread();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public BigInteger nextBigInteger() {
        try {
            return new BigInteger(nextString());
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public char nextCharacter() {
        int c = pread();
        while (isSpaceChar(c))
            c = pread();
        return (char) c;
    }

    public char[] nextCharacterArray(int n) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = nextCharacter();
        }
        return chars;
    }

    public char[][] nextCharacterMap(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = nextCharacterArray(m);
        }
        return map;
    }

    public double nextDouble() {
        int c = pread();
        while (isSpaceChar(c))
            c = pread();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = pread();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = pread();
        }
        if (c == '.') {
            c = pread();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = pread();
            }
        }
        return res * sgn;
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextDouble();
        }
        return array;
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextString();
        }
        return array;
    }

    public void nextIntArrays(int[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = nextInt();
            }
        }
    }

    public void nextLongArrays(long[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = nextLong();
            }
        }
    }

    public void nextDoubleArrays(double[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = nextDouble();
            }
        }
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1)
            pread();
        return value == -1;
    }
}

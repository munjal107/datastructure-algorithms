import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class StringRotation {
    static StringBuilder in;
    static StringBuilder out = new StringBuilder("");
    static final int MAX = 256;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         in = new StringBuilder(br.readLine());
        String str= in.toString();
        int q = Integer.parseInt(br.readLine());
        String [] ro = new String[q];
        int[] di = new int[q];
        for(int i=0;i<q;i++){
            final String st[] = br.readLine().split(" ");
            ro[i]=st[0];
            di[i]=Integer.parseInt(st[1]);
            if(ro[i].equals("L")){
                rotateLeft(di[i]);
            }
            else {
                rightRotate(di[i]);
            }
        }
        if(search(out.toString(),str)){
            System.out.print("YES");
        }
        else {
            System.out.print("NO");
        }
    }
    static void rotateLeft(int d){
            int n = in.length();
            int i,j,k;
            char temp;
            for(i=0;i<gcd(d,in.length());i++){
                temp = in.charAt(i);
                j=i;
                while (true){
                    k=j+d;
                    if (k >=n )
                        k = k - n;
                    if (k == i)
                        break;
                    in.setCharAt(j,in.charAt(k));
                    j=k;
                }
                in.setCharAt(j,temp);
            }
            out.append(in.charAt(0));
    }
    static void rightRotate(int d){
        for(int i=0;i<d;i++)
            rotateRight();
        out.append(in.charAt(0));
    }
    static void rotateRight(){
        int i;
        int n=in.length();
        char temp;
        temp = in.charAt(n-1);
        for(i=n-1;i>0;i--){
            in.setCharAt(i,in.charAt(i-1));
        }
        in.setCharAt(0,temp);
    }
    static int gcd(int a, int b)
    {
        return (b==0)?a:gcd(b,a%b);
    }
    static boolean compare(char arr1[], char arr2[])
    {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    static boolean search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];
        for (int i = 0; i < M; i++)
        {
            (countP[pat.charAt(i)])++;
            (countTW[txt.charAt(i)])++;
        }

        for (int i = M; i < N; i++)
        {

            if (compare(countP, countTW))
                return true;


            (countTW[txt.charAt(i)])++;


            countTW[txt.charAt(i-M)]--;
        }

        if (compare(countP, countTW))
            return true;
        return false;
    }
}


/*
Rotate a given String in specified direction by specified magnitude.

After each rotation make a note of first character of the rotated String, After all rotation are performed the accumulated
first character as noted previously will form another string, say FIRSTCHARSTRING.

Check If FIRSTCHARSTRING is an Anagram of any substring of the Original string.
If yes print "YES" otherwise "NO". Input

The first line contains the original string s. The second line contains a single integer q. The ith of the next q lines
contains character d[i] denoting direction and integer r[i] denoting the magnitude.

Constraints
1 <= Length of original string <= 30

1<= q <= 10

Output
YES or NO

Explanation
Example 1

Input
carrace
3
L 2
R 2
L 3

Output
NO

Explanation
After applying all the rotations the FIRSTCHARSTRING string will be "rcr" which is not anagram of any sub string of
original string "carrace".

*/
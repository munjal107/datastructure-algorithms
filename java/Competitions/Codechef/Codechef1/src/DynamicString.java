//https://www.codechef.com/problems/CLFIBD


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;


class DynamicString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            final String in = br.readLine();
            solve(in);
        }
    }
    static void solve(String str){
        int[] count= new int[26];
        for(int i=0;i<str.length();i++){
                count[str.charAt(i)-97]++;
        }
        Arrays.sort(count);
        System.out.println("NOT");
    }
}
/*
3
aaaabccc
aabbcc
ppppmmnnoooopp

1
aaaabccc
*/
//Codechef Problem  https://www.codechef.com/problems/TAEDITOR

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleEditor {
    public static void main(String[] args) throws IOException {
        int q;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        q = Integer.parseInt(bufferedReader.readLine());
        StringBuilder s = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i<q;i++){
            String str[] = bufferedReader.readLine().split(" ");
            if(str[0].equals("+")){
                final int start = Integer.parseInt(str[1]);
                final String sub = str[2];
                s.insert(start,sub);
            }
            else{
                final int start = Integer.parseInt(str[1])-1;
                final int len = Integer.parseInt(str[2]);
                final String sub = s.substring(start,len+start);
                ans.append(sub).append("\n");
            }
        }
        System.out.println(ans);
    }
}
/* Test Cases
5
+ 0 ab
+ 1 c
? 1 3
+ 2 dd
? 1 5


  * */
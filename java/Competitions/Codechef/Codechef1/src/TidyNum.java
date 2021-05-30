import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.io.*;

//codejam 2017 Tidy Number
class TidyNum {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("D:\\PC\\Competitions\\Codechef\\Codechef1\\src\\B-large-practice.in");
        FileOutputStream fout = new FileOutputStream("D:\\PC\\Competitions\\Codechef\\Codechef1\\src\\B-large-practice.out");

        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
        BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(fout));

        PrintWriter pw = new PrintWriter("D:\\PC\\Competitions\\Codechef\\Codechef1\\src\\B-large-practice1.out");

        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            final long input = Long.parseLong(br.readLine());
            final StringBuilder ch = new StringBuilder(String.valueOf(input));
            final String ans = "Case #"+i+": "+solve(ch)+"\n";

            pw.print(ans);
            pw.flush();

            System.out.print(ans);
            //fout.write(ans.getBytes());               //works correct
            bout.write(ans);
            bout.flush();
        }
    }
    static String solve(StringBuilder ch){
        for(int j=0;j<ch.length()-1;j++) {
            if (ch.charAt(j) > ch.charAt(j + 1)) {
                if (ch.charAt(j) == '1') {
                    ch.deleteCharAt(j + 1);
                    for (int k = j + 1; k < ch.length(); k++)
                        ch.setCharAt(k, '9');
                    for (int k = j; k >= 0; k--)
                        ch.setCharAt(k, decrement(ch.charAt(k)));
                } else {
                    ch.setCharAt(j, decrement(ch.charAt(j)));
                    for (int k = j + 1; k < ch.length(); k++)
                        ch.setCharAt(k, '9');
                   return solve(ch);                    // needs to check verify
                }
                break;
            }
        }
        return String.valueOf(ch);
    }
    static char decrement(char c){
        return c=='1'?'9':(char)(c-1);
    }
}
/*DataInputStream din = new DataInputStream(fin);
        while (din.available()>0)
             System.out.print((char)din.read());*/

        /*Scanner scanner = new Scanner(fin);
        while(scanner.hasNextLine())
            System.out.println(scanner.nextLine());*/
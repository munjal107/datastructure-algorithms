//https://www.codechef.com/problems/CHEFCHR

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
class ChefChar {
    public static void main(String[] args)throws IOException {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String str = br.readLine();
            solve(str);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    static void solve(String str){
        int count=0;
                
        char[] ch = str.toCharArray();
        int i;
        for(i=0;i<str.length()-3;i++){
            if(comp(ch[i],ch[i+3],ch[i+2],ch[i+1]))
                count++;
        }
        if(count==0)
            System.out.println("normal");
        else
            System.out.println("lovely "+count);
    }
    static boolean comp(char a,char b,char c,char d){
        char ch[] = {a,b,c,d};
        Arrays.sort(ch);
        return new String(ch).equals("cefh");
    }
}




 /*
class ChefChar {
    static int chk[]= new int[26];
    static {
        chk['c'-'a']++;
        chk['h'-'a']++;
        chk['e'-'a']++;
        chk['f'-'a']++;
    }
    public static void main(String[] args)throws IOException {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String str = br.readLine();
            solve(str);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    static void solve(String str){
        int count=0;
        int in[] = new int[26];
        for(int i=0;i<4;i++)
            in[str.charAt(i)-'a']++;
        for(int i=4;i<str.length();i++){
            if(comp(in))
                count++;
            in[str.charAt(i)-'a']++;
            in[str.charAt(i-4)-'a']--;
        }
        if(comp(in))
            count++;
        if(count==0)
            System.out.println("normal");
        else
            System.out.println("lovely "+count);
    }
    static boolean comp(int[] in){
        for(int i=0;i<26;i++){
            if(in[i]!=chk[i])
                return false;
        }
        return true;
    }
}






import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
class Test {
    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++){
            String str = sc.nextLine();
            solve(str);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    static void solve(String str){
        int count=0;
                
        char[] ch = str.toCharArray();
        int i=0;
        for(i=4;i<str.length();i++){
            if(comp(ch[i-4],ch[i-3],ch[i-2],ch[i-1]))
                count++;
        }
        if(comp(ch[i-4],ch[i-3],ch[i-2],ch[i-1]))
            count++;
        if(count==0)
            System.out.println("normal");
        else
            System.out.println("lovely "+count);
    }
    static boolean comp(char a,char b,char c,char d){
        char ch[] = {a,b,c,d};
        Arrays.sort(ch);
        return new String(ch).equals("cefh");
    }
}


/* 

5
ifchefisgoodforchess
fehcaskchefechohisvoice
hecfisaniceperson
letscallchefthefch
chooseaprogrammer



*/

/* 

5
ifchefisgoodforchess
fehcaskchefechohisvoice
hecfisaniceperson
letscallchefthefch
chooseaprogrammer



*/
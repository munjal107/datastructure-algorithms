//https://www.codechef.com/problems/NAICHEF


import java.util.Scanner;

class NavieChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //TreeSet<Integer> ts = new TreeSet<Integer>();
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int in;
            int counta=0,countb=0;
            for(int j=0;j<n;j++){
                in = sc.nextInt();
                if(in==a)
                    counta++;
                if(in==b)
                    countb++;
               // ts.add(in);
            }
            double ans = ((double)counta/n)*((double)countb/n);
            System.out.println(ans);
        }

    }
}
/*

2
5 1 1
1 1 1 1 1
2 1 1
1 2
 */
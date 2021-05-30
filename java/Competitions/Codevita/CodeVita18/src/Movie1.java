import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Movie1 {
    static int[][] sum = new int[4][4];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] movie = br.readLine().split(" ");
        String[] cat = br.readLine().split(" ");
        String[] pro = br.readLine().split(" ");
        StringBuilder out = new StringBuilder("");
        int[] profit = new int[pro.length];
        for(int i=0;i<pro.length;i++)
            profit[i]=Integer.parseInt(pro[i]);
        int aud = Integer.parseInt(br.readLine());
        int[] age = new int[aud];
        String[] ag = br.readLine().split(" ");
        for(int i=0;i<aud;i++)
            age[i]=Integer.parseInt(ag[i]);
        for(int i=0;i<4;i++){
            if(cat[i].equals("A")){
                getA(profit,age,i);
            }
            else if(cat[i].equals("B")){
                getB(profit,age,i);
            }
            else if(cat[i].equals("C")){
                getC(profit,age,i);
            }
            else if(cat[i].equals("D")){
                getD(profit,age,i);
            }
        }

        int max=0,total=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(j!=i){
                    for(int k=0;k<4;k++){
                        if(k!=i && k!=j){
                            for(int l=0;l<4;l++){
                                if(l!=i && l!=j && l!=k){
                                    total = sum[0][i]+sum[1][j]+sum[2][k]+sum[3][l];
                                    max = (total>max)?total:max;
                                }

                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(j!=i){
                    for(int k=0;k<4;k++){
                        if(k!=i && k!=j){
                            for(int l=0;l<4;l++){
                                if(l!=i && l!=j && l!=k){
                                    total = sum[0][i]+sum[1][j]+sum[2][k]+sum[3][l];
                                    if(total==max){
                                        for(int m=0;m<4;m++){
                                            if(m==i)
                                                System.out.print(movie[0]+ " ");
                                            else if(m==j)
                                                System.out.print(movie[1]+" ");
                                            else if(m==k)
                                                System.out.print(movie[2]+ " ");
                                            else
                                                System.out.print(movie[3]+ " ");
                                        }
                                        System.out.println();
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        System.out.print("Maximum Profit: "+max);
    }
    static void getA(int[] profit,int[] age,int i){

        for(int j=0;j<age.length;j++){
            int n = age[j];
            if(isA(n)){
                if(isMor(n)){
                    sum[i][0]+=profit[i];
                }
                if(isAfter(n)){
                    sum[i][1]+=profit[i];
                }
                if(isEve(n)){
                    sum[i][2]+=profit[i];
                }
                if(isNight(n)){
                    sum[i][3]+=profit[i];
                }
            }

        }
    }
    static void getB(int[] profit,int[] age,int i){


        for(int j=0;j<age.length;j++){
            int n = age[j];
            if(isB(n)){
                if(isMor(n)){
                    sum[i][0]+=profit[i];
                }
                if(isAfter(n)){
                    sum[i][1]+=profit[i];
                }
                if(isEve(n)){
                    sum[i][2]+=profit[i];
                }
                if(isNight(n)){
                    sum[i][3]+=profit[i];
                }
            }

        }
    }
    static void getC(int[] profit,int[] age,int i){


        for(int j=0;j<age.length;j++){
            int n = age[j];
            if(isC(n)){
                if(isMor(n)){
                    sum[i][0]+=profit[i];
                }
                if(isAfter(n)){
                    sum[i][1]+=profit[i];
                }
                if(isEve(n)){
                    sum[i][2]+=profit[i];
                }
                if(isNight(n)){
                    sum[i][3]+=profit[i];
                }
            }

        }
    }
    static void getD(int[] profit,int[] age,int i){


        for(int j=0;j<age.length;j++){
            int n = age[j];
            if(isD(n)){
                if(isMor(n)){
                    sum[i][0]+=profit[i];
                }
                if(isAfter(n)){
                    sum[i][1]+=profit[i];
                }
                if(isEve(n)){
                    sum[i][2]+=profit[i];
                }
                if(isNight(n)){
                    sum[i][3]+=profit[i];
                }
            }

        }
    }
    static boolean isMor(int age){
        return (age>=3 && age<=20)?false:true;
    }
    static boolean isAfter(int age){
        return (age>=21 && age<=40)?false:true;
    }
    static boolean isEve(int age){
        return (age>=41 && age<=49)?false:true;
    }
    static boolean isNight(int age){
        return (age>=50 && age<=70)?false:true;
    }
    static boolean isA(int age){
        return (age>=24 && age<=50)?true:false;
    }
    static boolean isB(int age){
        return (age>=15 && age<=25)?true:false;
    }
    static boolean isC(int age){
        return (age>=3 && age<=18)?true:false;
    }
    static boolean isD(int age){
        return (age>=45 && age<=70)?true:false;
    }
}
/*test cases


Movie1 Movie2 Movie3 Movie4
A B D C
10 20 15 5
11
23 43 6 7 1 0 45 4 6 7 24

**/
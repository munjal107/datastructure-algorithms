import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.useDelimiter("\\D");
        int[] arr = new int[n];
        int i=0;
        for(i = 0 ; i < n ; i++)
            arr[i] = kb.nextInt();
        kb.close();
        for(i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}

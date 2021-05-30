import java.io.*;
import java.util.Scanner;

class Test1{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		kb.useDelimiter("\\D");
		int[] arr = new int[n];
		int i=0;
		for(int i = 0 ; i < n ; i++)
			arr[i] = kb.nextInt();
		kb.close();
		for(i=0;i<n;i++){
			System.out.println(arr[i]);
		}


      /*// create a new scanner with the specified String Object
      Scanner scanner = new Scanner(System.in);
      scanner.useDelimiter("Wor");
      String s = scanner.nextLine();
      // print a line of the scanner


      // change the delimiter of this scanner
      

      // display the new delimiter
      System.out.println(s);

      // close the scanner
      scanner.close();*/
	}
}
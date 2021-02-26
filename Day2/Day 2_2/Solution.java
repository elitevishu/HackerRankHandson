import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String[] sArr = s.split(":");
        if(sArr[2].charAt(2)=='P'){
            if(Integer.parseInt(sArr[0])!=12)
            sArr[0]=Integer.toString((Integer.parseInt(sArr[0])+12));
        }
        if(sArr[2].charAt(2)=='A'){
            if(Integer.parseInt(sArr[0])==12)
            sArr[0]=Integer.toString((Integer.parseInt(sArr[0])-12))+"0";
        }
            sArr[2]=sArr[2].charAt(0)+""+sArr[2].charAt(1);
        
        return String.join(":",sArr[0],sArr[1],sArr[2]);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
            int[][] magicSquares = {
                
            {8,6,2,4,1,7,9,3},
            {6,2,4,8,7,9,3,1},
            {2,4,8,6,9,3,1,7},
            {4,8,6,2,3,1,7,9},
            {6,8,4,2,1,3,9,7},
            {2,6,8,4,7,1,3,9},
            {4,2,6,8,9,7,1,3},
            {8,4,2,6,3,9,7,1}
    };

            
            int min = Integer.MAX_VALUE;
            int sum=0;
            for(int i=0;i<8;i++){

                sum+= ((Math.abs(s[0][0]-magicSquares[i][0]))
                        +(Math.abs(s[0][2]-magicSquares[i][1]))
                        +(Math.abs(s[2][2]-magicSquares[i][2]))
                        +(Math.abs(s[2][0]-magicSquares[i][3]))
                        +(Math.abs(s[0][1]-magicSquares[i][4]))
                        +(Math.abs(s[1][2]-magicSquares[i][5]))
                        +(Math.abs(s[2][1]-magicSquares[i][6]))
                        +(Math.abs(s[1][0]-magicSquares[i][7])));
                if(sum<min){
                    min=sum;
                }
                sum=0;
            }
           
            if(s[1][1]!=5)
                min+=Math.abs(s[1][1]-5);
            return min;
            



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] queries = new int[n][2];

        for(int i=0;i<n;i++){
            queries[i][0]=sc.nextInt();
            if(queries[i][0]==1){
                queries[i][1]=sc.nextInt();
            }
        }
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        for(int i=0;i<n;i++){
            switch(queries[i][0]){
                case 1: s1.push(queries[i][1]);
                        break;
                
                case 2: if(!s2.empty()){
                            s2.pop();
                        }
                        else{
                        while(!s1.empty()){
                            s2.push(s1.pop());
                        }
                        s2.pop();
                        }
                        break;
                
                case 3: if(!s2.empty()){
                        System.out.println(s2.peek());
                        }
                        else{
                        while(!s1.empty()){
                            s2.push(s1.pop());
                        }
                        System.out.println(s2.peek());}
                        break;
                default : break;
            }
        }   
    }  
}

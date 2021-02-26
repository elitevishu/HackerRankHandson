import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the runningMedian function below.
     */
     public static void addNumber(int number, PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
         
         if(lowers.size()==0||number<lowers.peek()){
             lowers.add(number);
         }
         else{
             highers.add(number);
         }
         
     }
     
          
          public static void rebalance(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
              PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
              PriorityQueue<Integer> smallerHeap = lowers.size()>highers.size()?highers:lowers;
              if(biggerHeap.size()-smallerHeap.size()>=2){
                  smallerHeap.add(biggerHeap.poll());
              }
              
          }
          
           public static double getMedian(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
              PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
              PriorityQueue<Integer> smallerHeap = lowers.size()>highers.size()?highers:lowers;
              if(biggerHeap.size()==smallerHeap.size()){
                  return ((double)(biggerHeap.peek()+smallerHeap.peek()))/2;
              }
              else{
                  return biggerHeap.peek();
              }
          }
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
         PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(
             new Comparator<Integer>(){
                 public int compare(Integer a, Integer b){
                     return -1*a.compareTo(b);
                     
                 }
             }
             
         );
         PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
         
         double[] medians = new double[a.length];
         for(int i=0;i<a.length;i++){
             int number = a[i];
             addNumber(number,lowers,highers);
             rebalance(lowers,highers);
             medians[i] = getMedian(lowers,highers);
             
         }
         
        return medians; 
         
         

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

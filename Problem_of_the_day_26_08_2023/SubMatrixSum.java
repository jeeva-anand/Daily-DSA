package Problem_of_the_day_26_08_2023;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class SubMatrixSum {
    
    public static List<Integer> subMatrixSum(int arr[][],List<List<Integer>> query,List<List<String>> queryAxis){

        arr = subArrayRow(arr);        
        int len = arr.length;
        List<Integer> resultList = new ArrayList<>();
        
        // System.out.println(Arrays.deepToString(arr));
        
        /* T(n) = Q * R
         * 
         * 0 , 15
         */
        for(int i=0;i<query.size();i++){
            List<Integer> point = query.get(i);
            List<String> queryPoint = new ArrayList<>();
            int sum = 0;
            
            //left
            queryPoint.add("X1 : "+point.get(0)/len);
            queryPoint.add("Y1 : "+point.get(0)%len);
            queryAxis.add(new ArrayList<String>(queryPoint));
            queryPoint.clear();
            if(point.size() > 1){
                queryPoint.add("X2 : "+point.get(1)/len);
                queryPoint.add("Y2 : "+point.get(1)%len);
                queryAxis.add(new ArrayList<String>(queryPoint));
            }else{
                queryPoint.add("X1 : "+point.get(i)/len);
                queryPoint.add("Y1 : "+point.get(i)%len);
                queryAxis.add(new ArrayList<String>(queryPoint));
            }
            // System.out.println("Query Points : "+queryAxis);
            int k=0;
            for(int j = 0;j<=query.size();j++){
                
                int L = point.get(0)%len != 0 ? arr[((point.get(0)+k)%len)][((point.get(1)-1)%len)] : 0;
                int R = arr[((point.get(0)+k)%len)][(point.get(1)%len)];
                            
                sum += R - L;
                k++;
            }
                
            resultList.add(sum);
            
        }
        subArrayRowCol(arr);
        return resultList;
    }

    private static int[][] subArrayRow(int[][] arr) {
        
        // row sum
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                arr[i][j] = arr[i][j-1] + arr[i][j];
            }
        }
        System.out.println("Row Sum is: "+Arrays.deepToString(arr));
        return arr;
    }

    private static int[][] subArrayRowCol(int[][] arr) {
        
        // row sum
        // for(int i=0;i<arr.length;i++){
        //     for(int j=1;j<arr.length;j++){
        //         arr[i][j] = arr[i][j-1] + arr[i][j];
        //     }
        // }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=arr.length;j++){
                arr[i][j-1] = arr[i-1][j-1] + arr[i][j-1];
            }
        }

        System.out.println("Row & Col Sum is: "+Arrays.deepToString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //0,0,5,10
        //5,15,15,15
        List<Integer> x = Arrays.asList(15);
        List<Integer> y = Arrays.asList(15);
        List<List<Integer>> query = new ArrayList<>();
        for(int i =0;i<x.size();i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(x.get(i));
            temp.add(y.get(i));
            query.add(temp);
        }
        List<List<String>> queryAxis = new ArrayList<>();
        System.out.println("Query: "+query);
        List<Integer> res = subMatrixSum(arr, query,queryAxis);
        System.out.println("Result Sum is : "+res);
        System.out.println("Query Points : "+queryAxis);
    }
}

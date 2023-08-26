import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        List<List<Integer>> list = new ArrayList<>();
        if(r == 1){
            for(int[] i:mat){
                List<Integer> temp1 = new ArrayList<>();
                for(int j:i)
                    temp1.add(j);   
                list.add(temp1)       ;
            }
        }else{
            for(int i=0;i<mat.length;i++){
                List<Integer> temp2 = new ArrayList<>();  
                for(int j=0;j<r;j++)
                    temp2.add(j);  
                list.add(temp2);
            }
        }
        System.out.println(list);
        int res[][] = new int[r][c];
        int k = 0;
        // int 
        for(int i=0;i<r;i++){
            List<Integer> tp = list.get(i);
            for(int j=0;j<r;j++){
                res[i][j] = tp.get(j);
            }
               
        }

    return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
    int r = 1;
    int c = 4;
    
    int res[][] = matrixReshape(mat,r,c);
    System.out.println("Welcome");
    System.out.print(Arrays.toString(res));
    }
    
}

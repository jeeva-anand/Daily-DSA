import java.util.ArrayList;
import java.util.List;

public class DiviserOf3ThreeNumber {  
    public static List<Integer> diviserOfThreeNumber(int a,int b,int c,int k){
        List<Integer> list = new ArrayList<>();
        int p1=1,p2=1,p3=1;
        list.add(1);
        for(int i=0;i<k;i++){
            int x = a * list.get(p1-1);
            int y = b * list.get(p2-1);
            int z = c * list.get(p3-1);
            int min = Math.min(Math.min(x,y),z);
            list.add(min);

            if(x < y && x < z) p1++;
            else if(y < x && y < z) p2++;
            else p3++;
            
            if((x == y || x == z || y == z)){
                if(x == y && min == x){
                    p1++;
                    p2++;
                 }else if(y == z  && min == y){
                    p2++;
                  p3++;
                }else if(x == z  && min == z){
                  p1++;
                  p3++;
                }
            }
            
        }     
        return list;
    }

    public static void main(String[] args) {
        int a=2,b=3,c=5,k=20;
        List<Integer> result = diviserOfThreeNumber(a,b,c,k);
        System.out.println(result);
        
    }

    
}

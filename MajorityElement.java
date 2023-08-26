import java.util.Arrays;

public class MajorityElement {
    
    /*
     T(n) = o(n)
     S(n) = o(1)
     eg : 4,4,2,3,4,1,4
     */
    public static int majorityElement(int arr[]){
        int freq = 1;
        int majElement = arr[0];
        for(int i=1;i<arr.length;i++){
            if(i == majElement){
                freq++;
                continue;
            }                 
            freq--;
            if(freq <= 0){
                freq = 1;
                majElement = arr[i];  
            }             
        }        
        // return count >= arr.length/2 ? majEle : -1;
        return majElement;
    }

    public static void main(String[] args) {
        int arr[] = {4,4,2,3,4,1,4};
        System.out.println(majorityElement(arr));
    }
}

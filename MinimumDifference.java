public class MinimumDifference {
    
    /*
     T(n) = O(|A|+|B|+|c|)
     S(n) = O(1)
     */
    
    public static int minimumDifference(int a[],int b[],int c[]){
        int i=0,j=0,k=0;
        int diff = Integer.MAX_VALUE;
        for(int x=0;x<a.length;x++){          

            int min = Math.min(Math.min(a[i], b[j]),c[k]);
            int max = Math.max(Math.max(a[i], b[j]),c[k]);
            int curDiff = max - min;
            if(diff > curDiff){
                diff = curDiff;
            }
            if(a[i] < b[j] && a[i] < c[k]) i++;
            else if(b[j] < a[i] && b[j] < c[k]) j++;
            else k++;
        }
       return diff;
    }

    public static void main(String[] args) {
        int arr1[] = {1,4,5,8,10};
        int arr2[] = {6,9,15};
        int arr3[] = {2,3,6,6};
        System.out.println(minimumDifference(arr1,arr2,arr3));

    }
}

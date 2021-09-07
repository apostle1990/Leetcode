package BasicSorting;

public class InserSort {
    public static void sort(int[] arr){
        int i,j;
        for (i=1; i<arr.length;i++){
            int temp = arr[i];
            for (j=i; j>0 && temp < arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
}

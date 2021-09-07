package BasicSorting;

public class SelectSort {
    public static void sort(int arr[]){
        int temp = 0;
        for (int i=0; i< arr.length-1;i++){
            int minindex =i;
            for (int j=i+1; j< arr.length;j++){
                if (arr[j]<arr[minindex]){
                    minindex = j;
                }
            }
            if (i !=minindex){
                temp = arr[i];
                arr[i] = arr[minindex];
                arr[minindex] = temp;
            }
        }
    }
}

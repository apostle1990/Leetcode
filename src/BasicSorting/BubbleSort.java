package BasicSorting;

public class BubbleSort {
    public static void sort(int[] a){
        int temp=0;
        for (int i=0;i <a.length-1; ++i){
            for (int j=0; j<a.length-1;j++){
                if (a[j+1]<a[j]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    public static void sort2(int[] a){
        int temp =0;
        //增加符号位，减少循环
        for (int i=0; i<a.length-1; i++){
            int flag=0;
            for(int j=0; j<a.length-1; j++){
                if (a[j+1]<a[j]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag ==0){
                break;
            }
        }
    }
}

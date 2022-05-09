package Java_Extend.Functional_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stream_API_Syntax {

    public static void main(String[] args) {
//                                          блок создания и заполнения Массива и Листа

        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(Arrays.toString(arr));
        System.out.println(list);





    }






//                                          Методы по заполнению массива и листа

    static void fillArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
    }

    static void fillList(List<Integer> list){
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7 ,8 ,9, 10);
    }




}

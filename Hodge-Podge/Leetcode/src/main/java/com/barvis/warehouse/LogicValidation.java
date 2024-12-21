package com.barvis.warehouse;

import java.util.Arrays;

public class LogicValidation {
    public static void main(String[] args) {
        int[] test = {-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354};
        System.out.println(Arrays.toString(test));
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));

        boolean flag = true;
        for(int i=0; i<=test.length/2; i=i+2) {
            if(test[i] != test[i+1]) {
                System.out.println(test[i]);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(test[test.length - 1]);
        }

        for(int n: test) {
            System.out.println(n);
        }
    }
}

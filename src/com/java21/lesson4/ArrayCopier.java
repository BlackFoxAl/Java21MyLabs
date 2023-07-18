package com.java21.lesson4;

public class ArrayCopier {
    public ArrayCopier() {
    }

    public static void main(String[] var0) {
        int[] var1 = new int[]{7, 4, 8, 1, 4, 1, 4};
        float[] var2 = new float[var1.length];
        System.out.print("Array 1: [ ");

        int var3;
        for(var3 = 0; var3 < var1.length; ++var3) {
            System.out.print(var1[var3] + " ");
        }

        System.out.println("]");
        System.out.print("Array 2: [ ");
        var3 = 0;

        while(var3 < var1.length && var1[var3] != 1) {
            var2[var3] = (float)var1[var3];
            int var10002 = var3++;
            System.out.print(var2[var10002] + " ");
        }

        System.out.println("]");
    }
}

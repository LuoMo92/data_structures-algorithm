package com.atguigu.data_structures2.sparse_array;

/**
 * @author Liumei
 * @date 2020/5/20  0020
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] chess = new int[11][11];
        chess[1][2] = 1;
        chess[2][3] = 2;

        System.out.println("原始二维数组~~~");
        int sum = 0;
//        int[][]
        for (int[] row : chess) {
            for (int i : row) {
                if (i != 0) {
                    sum++;
                }
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        System.out.println("有效数字：" + sum);
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chess[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("稀疏数组~~~");
        for (int[] i : sparseArray) {
            System.out.printf("%d\t%d\t%d\t", i[0], i[1], i[2]);
            System.out.println();
        }
        //稀疏数组转二维数组
        int[][] newArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            int[] data = sparseArray[i];
            newArray[data[0]][data[1]] = data[2];
        }
        System.out.println("恢复后的二维数组~~~");
        for (int[] row : newArray) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

}

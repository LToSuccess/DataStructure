package com.hlx.sparsearray;

/**
 * 稀疏数组
 *
 * @author hlx
 * @create 2020-09-09 13:23
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        //遍历二维数组
        for (int[] row : chessArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        int sun = 0;
        int count = 0;
        //计算数组中有效的数据个数（不为0）
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sun++;
                }
            }
        }
        //创建稀疏数组
        int spar[][] = new int[sun + 1][3];
        spar[0][0] = 11;
        spar[0][1] = 11;
        spar[0][2] = sun;
        System.out.println();
        //把稀疏数组的值添加到二维数组中
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    spar[count][0] = i;
                    spar[count][1] = j;
                    spar[count][2] = chessArr[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("输出的稀疏数组为：");
        for (int i = 0; i < spar.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", spar[i][0], spar[i][1], spar[i][2]);
        }
        //创建新的二维数组进行恢复
        int chessArr2[][] = new int[spar[0][0]][spar[0][1]];
        for (int i = 1; i < spar.length; i++) {
            chessArr2[spar[i][0]][spar[i][1]] = spar[i][2];
        }
        System.out.println("恢复后的二维数组");
        for (int row[] : chessArr2) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println("");
        }
    }
}

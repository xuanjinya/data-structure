package com.huang.sparsearray;

import java.io.*;

/*
 * 稀疏数组
 * */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //创建一个原始的二维数组 11 * 11
        //0 标识没有棋子，1 标识黑子  2 标识篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始数组
        System.out.println("原始的二位数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //二维数组转换为稀疏数组
        //1.先遍历二维数组，得到非0的数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        int count = 0; //用来记录是第几个非0数字
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为--");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        //把稀疏数组转换为二维数组
        /*
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二位数数组，比如上面的 chessArr2[][] = int[11][11];
         * 2.在读取稀疏数组后几行，给二维数组赋值即可
         * */

        //1.读取稀疏数组的第一行，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //恢复后的二维数组
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //1.创建源
        File dest = new File("SpasreArray.data");
        //2.选择流:之所以选择字符流进行操作，主要由于其比字节流分割字符相比有分割方便的方法
        Writer os = null;
        os = new FileWriter(dest);
        //3.进行数据的拷贝,其中\t，即table符号，作为数字的分隔符（主要是数字的位数在此例中是不确定的）
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                os.write(sparseArr[i][j] + "\t");
            }
            os.write("\r\n");
        }
        //4.释放资源
        os.close();


        /**
         * 二、将本地文件map.data转换为稀疏数组
         */

        //1.创建源
        File src = new File("SpasreArray.data");
        //2.选择流
        BufferedReader in = new BufferedReader(new FileReader(src));
        //3.1进行数据的搬移，但是数组首要考虑的事情是数组要多大？
        int row = 0;//用于创建要创建的二维稀疏数组的大小确定
        String line; //一行数据
        //逐行读取，并将每个数组放入到数组中
        while ((line = in.readLine()) != null) {
            row++;
        }
        int sparseArr2[][] = new int[row][3];
        //3.2文本数据转移到稀疏数组中
        int rowtmp = 0;
        //由于读取完毕整个文本文档，所以不妨”重启“流
        in.close();
        in = new BufferedReader(new FileReader(src));
        while ((line = in.readLine()) != null) {
            String[] temp = line.split("\t");
            for (int j = 0; j < temp.length; j++) {
                sparseArr2[rowtmp][j] = Integer.parseInt(temp[j]);
            }
            rowtmp++;
        }
        //4.关闭流
        in.close();
        //验证文件读取是否正确
        System.out.println("文件读取数据");
        for (int[] temp1 : sparseArr2) {
            for (int temp2 : temp1) {
                System.out.printf("%d\t", temp2);
            }
            System.out.println();
        }

    }
}

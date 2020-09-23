package com.gdut.yim;

import java.io.*;


public class DuplicateCheck {

    public static void main(String[] args) {

        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);

        String source = splitString(args[0]);
        String target = splitString(args[1]);
        String savePath = null;
        float fl = LevenshteinDistance(source, target);
        try {
            savePath = args[2];
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("结果输出路径：" + savePath + "错误");
        }
        outputAnswerFile(savePath, fl);

    }


    /*
     * @method 核心算法 Levenshtein_Distance
     * @return float
     */
    public static float LevenshteinDistance(String source, String target){

        int[][] matrix;
        int source_len = source.length();
        int target_len = target.length();
        int i,j;
        int temp;

        if (source_len == 0 || target_len == 0){
            return 0;
        }

        matrix = new int[source_len + 1][target_len + 1];

        for (i = 0; i <= source_len; i++){//初始化第一行
            matrix[i][0] = i;
        }

        for (j = 0; j <= target_len; j++){//初始化第一列
            matrix[0][j] = j;
        }

        for (i = 1; i <= source_len; i++){//计算每一个格对应的值
            for (j = 1; j <= target_len; j++){
                if (source.charAt(i -1) == target.charAt(j - 1)){
                    temp = 0;
                }else {
                    temp = 1;
                }

                //通过判断该格的上、左、左上格的内容来决定该格的内容
                matrix[i][j] = Math.min(Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1), matrix[i - 1][j - 1] + temp);
            }
        }

        return (1 - (float) matrix[source_len][target_len] / Math.max(source.length(), target.length())) * 100F;
    }


    /*
     * @method 将文件中的内容整理成一个字符串
     * @return String
     */
    public static String splitString(String filePath){

        /*
            文件写入
         */
        StringBuilder buffer = new StringBuilder();
        BufferedReader bf;
        try {
            bf = new BufferedReader(new FileReader(filePath));
            String s;
            while((s = bf.readLine())!=null){
                buffer.append(s.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件: "+ filePath +"输入路径错误");
        }

        /*
            利用正则表达式把文章中的标点符号去除
         */
        String[] splitAddress = buffer.toString().split("[^0-9a-zA-Z\\u4e00-\\u9fa5]");
        StringBuilder sb = new StringBuilder();
        for (String address : splitAddress) {
            sb.append(address);
        }

        return  sb.toString();
    }

    /*
     * @method 输出答案文件
     * @return void
     */
    public static void outputAnswerFile(String filePath, float answer) {

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            String string = String.format("%.2f", answer);
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("答案文件: "+ filePath +"输入路径错误");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

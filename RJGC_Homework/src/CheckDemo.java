import java.io.*;

public class CheckDemo {

    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();

        String string1 = "string";
        String string2 = "string";

        float fl = Levenshtein_Distance(string1, string2);
        System.out.println(fl);

        getString();


        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }


    public static void getString() {


        String string = getD("G:\\RJGC\\test\\orig.txt");
        String string2 = getD("G:\\RJGC\\test\\orig_0.8_add.txt");
        float fl = Levenshtein_Distance(string, string2);
        System.out.println(fl);

    }



    public static float Levenshtein_Distance(String source, String target){

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

        for (i = 1; i <= source_len; i++){//
            for (j = 1; j <= target_len; j++){
                if (source.charAt(i -1) == target.charAt(j - 1)){
                    temp = 0;
                }else {
                    temp = 1;
                }

                matrix[i][j] = Math.min(Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1), matrix[i - 1][j - 1] + temp);
            }
        }

        return (1 - (float) matrix[source_len][target_len] / Math.max(source.length(), target.length())) * 100F;
    }


    public static String getD(String filePath){

        StringBuilder buffer = new StringBuilder();
        BufferedReader bf;
        try {
            bf = new BufferedReader(new FileReader(filePath));
            String s;
            while((s = bf.readLine())!=null){//使用readLine方法，一次读一行
                buffer.append(s.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] splitAddress=buffer.toString().split("[^0-9a-zA-Z\\u4e00-\\u9fa5]");
        StringBuilder sb = new StringBuilder();
        for (String address : splitAddress) {
            sb.append(address);
        }


        return  sb.toString();
    }

}

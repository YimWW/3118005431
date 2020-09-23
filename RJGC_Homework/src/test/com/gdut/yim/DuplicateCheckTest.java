package com.gdut.yim;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DuplicateCheckTest {

    @BeforeClass
    public static void beforeTest(){
        System.out.println("测试即将开始");
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("测试结束");
    }

    /*
     * @method 相同文件比较
     * @return void
     */
    @Test
    public void testSameFile() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\answer_1.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_add.txt 比较
     * @return void
     */
    @Test
    public void testAddFile() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_add.txt", "G:\\RJGC\\test1\\answer_1.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_del.txt 比较
     * @return void
     */
    @Test
    public void testDelFile() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_del.txt", "G:\\RJGC\\test1\\answer_3.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_dis_1.txt 比较
     * @return void
     */
    @Test
    public void testDis1() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_dis_1.txt", "G:\\RJGC\\test1\\answer_4.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_dis_3.txt 比较
     * @return void
     */
    @Test
    public void testDis3() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_dis_3.txt", "G:\\RJGC\\test1\\answer_5.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_dis_7.txt 比较
     * @return void
     */
    @Test
    public void testDis7() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_dis_7.txt", "G:\\RJGC\\test1\\answer_6.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_dis_10.txt 比较
     * @return void
     */
    @Test
    public void testDis10() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_dis_10.txt", "G:\\RJGC\\test1\\answer_7.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_dis_15.txt 比较
     * @return void
     */
    @Test
    public void testDis15() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_dis_15.txt", "G:\\RJGC\\test1\\answer_8.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_dis_mix.txt 比较
     * @return void
     */
    @Test
    public void testDisMix() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_dis_mix.txt", "G:\\RJGC\\test1\\answer_9.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 原文与 orig_0.8_dis_rep.txt 比较
     * @return void
     */
    @Test
    public void testDisRep() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_dis_rep.txt", "G:\\RJGC\\test1\\answer_10.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 输入路径错误
     * @return void
     */
    @Test
    public void testErrorIn() {
        String[] test = {"G:\\RJGC\\test1\\g.txt", "G:\\RJGC\\test1\\orig_0.8_add.txt", "G:\\RJGC\\test1\\answer_11.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 输入路径为空
     * @return void
     */
    @Test
    public void testEmptyIn() {
        String[] test = {"", "G:\\RJGC\\test1\\orig_0.8_add.txt", "G:\\RJGC\\test1\\answer_12.txt"};
        DuplicateCheck.main(test);
    }


    /*
     * @method 输出路径为空
     * @return void
     */
    @Test
    public void testEmptyOut() {
        String[] test = {"G:\\RJGC\\test1\\orig.txt", "G:\\RJGC\\test1\\orig_0.8_add.txt", ""};
        DuplicateCheck.main(test);
    }
}
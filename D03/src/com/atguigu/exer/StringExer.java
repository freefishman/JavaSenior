package com.atguigu.exer;

import org.junit.Test;

/**
 * @author q2Lin
 * @create 2020-08-27-15:48
 */
public class StringExer {
     //1. 模拟一个trim方法，去除字符串两端的空格。
    @Test
    public void test1(){
        String s1 = "  abc d ";

        char[] chars = s1.toCharArray();
        boolean flags = true;
        boolean flage = true;
        int start = 0;
        int end = 0;
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != ' ' && flags){
                start = i;
                flags = false;
            }
        }
        for (int i = chars.length-1; i > 0; i--) {
            if(chars[i] != ' ' && flage){
                end = i;
                flage = false;
            }
        }
        for (int i = start; i <= end; i++) {
            res = res + chars[i];
        }
        System.out.println(res);
    }

    //2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
    @Test
    public void test2(){
        String str = "abcdefg";
        int start = 2;
        int end = 5;
        String tmp = "";
        String res = "";
        char[] chars = str.toCharArray();
        for (int i = start; i <= end; i++) {
            tmp = chars[i] + tmp;
        }
        for (int i = 0; i < chars.length; i++) {
            if(i < start || i > end){
                res += chars[i];
            }
            if(i == start) {
                res += tmp;
            }
        }
        System.out.println(res);
    }

    //3. 获取一个字符串在另一个字符串中出现的次数。
    //   比如：获取“ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
    @Test
    public void test3(){
        String str = "abkkcadkabkebfkabkskab";
        String target = "ab";
        int count = 0;
        int k;
        char[] chars = str.toCharArray();
        k = str.indexOf(target);
        if(k >= 0){
            count++;
        }
        for (int i = k+1; i < chars.length; i++) {
            k = str.indexOf(target,k+1);
            if(k >= 0){
                count++;
            }
            if(k < 0){
                break;
            }
        }
        System.out.println(count);
    }
//  4.获取两个字符串中最大相同子串。比如：
//  str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
//  提示：将短的那个串进行长度依次递减的子串与较长的串比较。
//    思路：
//    第一步：在两个字符串中选取长度短的那个字符串为key，长的那个为str；转到第二步。
//    第二步：从左到右，在str中匹配key，如果成功，转第四步；否则，转第三步。
//    第三步：将key长度减一，得到多个长度相同的子串，每个子串依次执行第二步。当key为空串的时候，转到第五步。
//    第四步：匹配成功，结束匹配。
//    第五步：匹配失败。
    @Test
    public void test4(){
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        String str = (str1.length() >= str2.length())?str1:str2;
        String key = (str1.length() > str2.length())?str2:str1;
        for (int i = 0; i < key.length(); i++) {
            for(int j = 0, k = key.length() - i; k != key.length() + 1; j++, k++){
                String tmp = key.substring(j, k);
                if(str.indexOf(tmp) != -1){
                    System.out.println(tmp);
                    System.exit(0);
                }
            }
        }
        System.out.println("");
    }


//     5.对字符串中字符进行自然顺序排序。
//       提示：
//        1）字符串变成字符数组。
//        2）对数组排序，选择，冒泡，Arrays.sort();
//        3）将排序后的数组变成字符串。
    public void test5(){

    }
}

package com.company;
import java.util.*;

public class Main {

    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> qq = new LinkedList();
        HashSet<Character> hm = new HashSet();
        int max = 0;
        int curr = 0;

        for (int i=0; i<s.length(); i++){
            if (hm.contains(s.charAt(i))){
                char ch = s.charAt(i);
                if (curr > max) {
                    max = curr;
                }
                while (!qq.isEmpty() && qq.peek() != ch){
                    hm.remove(qq.peek());
                    qq.remove();
                    curr--;
                }

                if (!qq.isEmpty()){
                    hm.remove(qq.peek());
                    qq.remove();
                    curr--;
                }


                hm.add(ch);
                qq.add(ch);
                curr++;

            }else{
                curr++;
                hm.add(s.charAt(i));
                qq.add(s.charAt(i));
            }
        }
        if (curr > max) max = curr;
        return max;
    }

    public static void main(String[] args) {
        String s = "abcadgddddd";
        System.out.println(lengthOfLongestSubstring(s));
    }

}

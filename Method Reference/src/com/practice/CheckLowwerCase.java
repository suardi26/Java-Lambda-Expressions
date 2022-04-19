package com.practice;

public class CheckLowwerCase {
    public static boolean isLowwerCase(String value){
        for(char c : value.toCharArray()){
            if (!Character.isLowerCase(c)){
                return false;
            }
        }
        return true;
    }
}

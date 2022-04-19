package com.practice;

import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

/**
    - Kadang kita saat membuat lambda, isi lambda hanya mengakses method lain atau mengakses method yang ada di paramter method
      lambda-nya, Untuk itu kita bisa mempersingkat pembuatan lambda tersebut dengan method reference.
    - Ada beberapa method reference yang dapat digunakan pada saat membuat lambda :
        - Method Reference Lambda (Static Method).
        - Method Reference Lambda (Non Static Method, di Object yang sama).
        - Method Reference Lambda (Non Static Method, di Object yang berbeda).
        - Method Reference menggunakan Paramter Lambda.

*/
public class Main {
    public static void main(String[] args) {

    /** Method Reference Lambda (Static Method).*/
        System.out.println("========= Method Reference Lambda (Static Method) =========");

        // Pada saat menggunakan method reference (method static) pada Lambda maka perlu diperhatikan bahwa
        // parameter dari method static yang dibuat harus sama pada paramter dari lambda yang dibuat misalnya lambda yang
        // dibuat dari Interface Predicate maka Generic parameter typenya harus sesuai dengan paremeter dari method static yang
        // dibuat, sama berarti jumlah parameternya dan tipe data paremternya harus sama serta return valuenya harus sama,
        // misalnya method static yang dibuat memiliki return value boolean maka pada interface yang digunakan adalah 'Predicate'
        // yang memiliki return value boolean.

        //Predicate<String> lambdaPredicateStatic = value -> CheckLowwerCase.isLowwerCase(value);
        Predicate<String> lambdaPredicateStatic = CheckLowwerCase::isLowwerCase;

        String name1 = "suardi";
        String name2 = "Suardi";
        System.out.println("New Line : (Method Reference Lambda (Static Method) Apakah semua huruf pada '"+name1+"' " +
                "lowwer case ? : "+lambdaPredicateStatic.test(name1));
        System.out.println("New Line : (Method Reference Lambda (Static Method) Apakah semua huruf pada '"+name2+"' " +
                "lowwer case ? : "+lambdaPredicateStatic.test(name2));

    /** Method Reference Lambda (Non Static Method, di Object yang sama).*/
        System.out.println("\n========= Method Reference Lambda (Non Static Method, di Object yang sama) =========");

        // Pada saat menggunakan method reference (Non Static Method, di Object yang sama) pada Lambda maka perlu diperhatikan
        // bahwa parameter dari method non static yang dibuat harus sama pada paramter dari lambda yang dibuat misalnya lambda
        // yang dibuat dari Interface Predicate maka Generic parameter typenya harus sesuai dengan paremeter dari method non
        // static yang dibuat, sama berarti jumlah parameternya dan tipe data paremternya harus sama serta return valuenya harus
        // sama, misalnya method non static yang dibuat memiliki return value boolean maka pada interface yang digunakan adalah
        // 'Predicate' yang memiliki return value boolean.
        Main main1 = new Main();
        main1.runMethodReferenceNonStaticSameObject();

    /** Method Reference Lambda (Non Static Method, di Object yang Berbeda).*/
        System.out.println("\n========= Method Reference Lambda (Non Static Method, di Object yang Berbeda) =========");

        // Method Reference Lambda (Non Static Method, di Object yang Berbeda) hampir sama seperti dengan object yang sama hanya
        // keyword 'this' diganti dengan nama object dari class tempat method non static berasal.
        Main main2 = new Main();
        main2.runMethodReferenceNonStaticDiffrentObject();

    /** Method Reference menggunakan Paramter Lambda.*/
        System.out.println("\n========= Method Reference menggunakan Paramter Lambda  =========");

        // Method Reference menggunakan parameter Lambda digunakan ketika parameter memanggil method dari tipe data parameter
        // itu sendiri misalnya tipe data dari parameter adalah String dan memanggil method 'toUpperCase' yang ada pada
        // class String, untuk itu pembuatan lambda method reference menggunakan parameter Lambda dapat lebih singkat.
        // Namun ketika menggunakan Method Reference dengan parameter lambda digunakan untuk memanggil method dari tipe data
        // parameter lambda, maka method yang dapat dipanggil adalah method yang tidak memiliki parameter.

        // Function<String, String> lambdaFunction = (String value) -> value.toUpperCase();
        Function<String, String> lambdaFunction = String::toUpperCase;


        String word = "Lambda";
        System.out.println("Mengubah '"+word+"' menjadi UpperCase : "+lambdaFunction.apply(word));
    }

    public void runMethodReferenceNonStaticDiffrentObject(){
        Main main = new Main();
        // Predicate<String> lambdaPredicateNonStaticDiffrentObject = value -> main2.isUpperCase(value);
        Predicate<String> lambdaPredicateNonStaticDiffrentObject = main::isUpperCase;

        String tech1 = "Golang";
        String tech2 = "DART";
        System.out.println("New Line : (Method Reference Lambda (Non Static Method, di Object yang berbeda) " +
                "Apakah semua huruf pada '"+tech1+"' Upper case ? : "+lambdaPredicateNonStaticDiffrentObject.test(tech1));
        System.out.println("New Line : (Method Reference Lambda (Non Static Method, di Object yang berbeda) " +
                "Apakah semua huruf pada '"+tech2+"' Upper case ? : "+lambdaPredicateNonStaticDiffrentObject.test(tech2));
    }
    public void runMethodReferenceNonStaticSameObject(){
        //Predicate<String> lambdaPredicateNonStatic = value -> Main.this.isUpperCase(value);
        Predicate<String> lambdaPredicateNonStatic = this::isUpperCase;

        String tech1 = "JAVA";
        String tech2 = "Kotlin";
        System.out.println("New Line : (Method Reference Lambda (Non Static Method, di Object yang sama) " +
                "Apakah semua huruf pada '"+tech1+"' Upper case ? : "+lambdaPredicateNonStatic.test(tech1));
        System.out.println("New Line : (Method Reference Lambda (Non Static Method, di Object yang sama) " +
                "Apakah semua huruf pada '"+tech2+"' Upper case ? : "+lambdaPredicateNonStatic.test(tech2));

    }
    public boolean isUpperCase(String value){
        for(char c : value.toCharArray()){
            if (!Character.isUpperCase(c)){
                return false;
            }
        }
        return true;
    }
}

package com.practice;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
    - Saat java 8 keluar dengan fitur lambda, Java juga menyediakan sebuah package baru yaitu java.util.function
    - Package ini berisikan banyak sekali functional interface yang bisa kita gunakan untuk kebutuhan membuat lambda.
    - Dengan menggunakan interface-interface yang ada di package ini, kita mungkin tidak perlu lagi membuat sendiri functional
      interface secaara manual, dan semua interface-interface pada package java.util.function mayoritas generic jadi untuk
      penggunaan tipe datanya dapat bermacam-macam.
    - Ada beberapa interface yang sering digunakan untuk membuat lambda :
        - interface Consumer
          interface Consumer adalah interface yang generic dan memiliki method void dengan parameter namun tanpa return value.
        - interface Function
          interface Function adalah interface yang genreic dan memiliki 2 Generic parameter type dimana yang pertama digunakan
          untuk menjadi parameter method 'apply' dan yang kedua adalah return value dari method 'apply'.
        - interface Predicate
          interface Predicate adalah interface yang generic dan memiliki satu Generic parameter type digunakan untuk
          paramter method 'test' dan method test ini memiliki return value type data primitif yaitu 'boolean'.
        - interface Supplier
          interface Supplier adalah interface yang generic dan memiliki satu Generic paramter type digunakan untuk return value
          dari method 'get'.
        - Dan ada banyak sekali interface yang dapat digunakan pada Package 'java.util.function' untuk detail lengkapnya
          Silahkan buka Package 'java.util.function'.

 */
public class Main {
    public static void main(String[] args){

        // interface Consumer.
        Consumer<String> lambdaConsumer = value -> System.out.println("New Line : "+value);
        lambdaConsumer.accept("Membuat Lambda dengan interface Consumer");

        // interface Function.
        Function<String, Integer> lambdaFunction = value -> value.length();
        String data = "Lambda Interface Function";
        Integer length = lambdaFunction.apply(data);
        System.out.println("New Line : '"+data+"' memliki : "+length+" character.");

        // interface Predicate.
        Predicate<String> lambdaPredicate = value -> value.isBlank();
        String word = "Suardi";
        String blank = "";
        System.out.println("New Line : (Lambda Interface Predicate) Apakah kata '"+word+"' kosong ? : "+lambdaPredicate.test(word)+".");
        System.out.println("\t\t\t(Lambda Interface Predicate) Apakah kata '"+blank+"' kosong ? : "+lambdaPredicate.test(blank)+".");

        // interface Supplier
        Supplier<String> lambdaSupplier = () -> "Suardi Daud Manda";
        System.out.println("New Line : (Lambda Interface Supplier) : "+lambdaSupplier.get());
    }
}

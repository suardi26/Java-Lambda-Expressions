package com.practice;

import java.util.function.Supplier;

/**
    - Lambda Sebagai lazy parameter.
    - Java tidak memiliki fitur parameter lazy seperti di bahasa pemrograman seperti Scala.
    - Lazy parameter artinya, parameter tersebut hanya akan dieksekusi ketika diakses, dengan kata lain suatu argument dieksekusi
      ketika suatu kondisi memerlukan parameter tersebut, tapi ketika suatu kondisi tidak memerlukan parameter tersebut maka
      argument tersebut tidak akan dieksekusi/dipanggil.
    - Namun dengan menggunakan Lambda, kita bisa membuat parameter layaknya lazy parameter / behavior atau perilakunya seperti
      lazy parameter. jadi seakan-akan paremeter tersebut adalah lazy parameter akan tetapi itu adalah lambda.
 */
public class Main {
    public static void main(String[] args) {

        // Contoh Bukan lazy parameter.
        // Artinya parameter di java biarpun tidak digunakan akan tetap dieksekusi/dipanggil terlebih dahulu.
        // ketika nilai 65, itu kondisinya tidak lulus, dan tanpa memerlukan argument 'name' pada parameter method testScore
        // akan tetapi argument 'getName()' akan dipanggil/dieksekusi terlebih dahulu.
        System.out.println("++++++++ Contoh Bukan lazy parameter ++++++++");
        testScore(65, getName());

        // Contoh menggunakan fitur lambda expression (Menggunakan interface Supplier, method 'T get()' yang berada pada package
        // java.util.function) Yang perilakunya mirip dengan lazy parameter.
        // Artinya argument dieksekusi ketika suatu kondisi memerlukan parameter tersebut, tapi ketika suatu kondisi
        // tidak memerlukan parameter tersebut maka argument tersebut tidak akan dieksekusi/dipanggil.
        System.out.println("++++++++ Contoh menggunakan fitur lambda (interface Supplier) Yang perilakunya mirip dengan " +
                "lazy parameter ++++++++");
        testScoreWithLambdaExpression(78, Main::getName);

    }

    // Contoh Bukan lazy parameter.
        public static void testScore(int score, String name) {
            if (score > 75){
                System.out.println("Selamat "+name+", Anda Lulus.");
            }else{
                System.out.println("Coba Lagi Tahun Depan !!!");
            }
        }

        public static String getName(){
            System.out.println("Method getName() dipanggil !!!!");
            return "Edward";
        }

    // Contoh menggunakan fitur lambda expression (Menggunakan interface Supplier, method 'T get()' yang berada pada package
    // java.util.function) Yang perilakunya mirip dengan lazy parameter.
    public static void testScoreWithLambdaExpression(int score, Supplier<String> name){
        if (score > 75){
            System.out.println("Selamat "+name.get()+", Anda Lulus.");
        }else{
            System.out.println("Coba Lagi Tahun Depan !!!");
        }
    }
}

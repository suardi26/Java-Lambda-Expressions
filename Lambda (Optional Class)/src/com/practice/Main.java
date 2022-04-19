package com.practice;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
    - Pada java 8, java menyediakan sebuah class baru bernama Optional yang berada di package 'java.util'.
    - Class ini digunakan sebagai wrapper untuk value yang bisa bernilai null.
    - Class Optional didesain agar kita lebih mudah ketika beroprasi dengan object yang bisa bernilai null.
    - Dibanding menggunakan langsung sebuah object yang dibuat untuk operasi apapun itu, lebih baik menggunakan class Optional ini.
    - Karena NullPointerException adalah salah satu hal yang sering sekali ditemui oleh Programmer Java.
    - Dengan menggunakan Class Optional kita dapat menghindari error NullPointerException.
    - Class Optional memiliki beberapa method-method yang memanfaatkan fitur dari java Lambda, untuk detail lengkapnya silahkan buka class
      Optional.
 */
public class Main {
    public static void main(String[] args) {

        /** Problem NullPointerException.*/
            // sayHello("Suardi");
            // sayHello(null); // Error !!! NullPointerException.

        /** Menggunakan Class Optional yang generic terlebih dahulu sebelum melakukan operasi dari object. */


        sayHelloWithOptional("Suardi");

        sayHelloWithOptional(null);
    }

    // Problem NullPointerException.
    public static void sayHello(String name){
        String upperName = name.toUpperCase();
        System.out.println("HELLO "+upperName);
    }

    // Menggunakan Class Optional yang generic terlebih dahulu sebelum melakukan operasi dari object.
    public static void sayHelloWithOptional(String name){
        /** Optional yang manual.*/

            /** memasukan data/object 'name', dan data tersebut Optional artinya datanya bisa ada atau tidak (null).*/
            // Optional<String> optionalName = Optional.ofNullable(name);

            /** Dan Method 'map' yang ada pada class Optional digunakan untuk mengelolah data.*/
            // Optional<String> upperName = optionalName.map(String::toUpperCase);

            /** Dan Method 'ifPresent' yang ada pada class Optional digunakan untuk mengambil data object, dimana */
            /** lambda expression akan dipanggil jika datanya ada, dan tidak dipanggil jika datanya tidak ada.*/
            /** Namun ada juga Method 'ifPresentOrElse' dimana method ini akan tetap memanggil lamda expression yang lain ketika */
            /** datanya tidak ada, hal ini dikarenakan method 'ifPresentOrElse' memiliki 2 lambda expression yang pertama */
            /** dipanggil ketika datanya ada, dan lambda expression yang kedua dipanggil ketika datannya tidak ada (null). */
            // upperName.ifPresent(value -> System.out.println("HELLO "+value));
            // UpperName.ifPresentOrElse(value -> System.out.println("HELLO "+value),
            //                          (value -> System.out.println("HELLO"));



        /** Optional yang digabungkan dalam satu rantai skrip (Chain)*/
//            Optional.ofNullable(name)
//                    .map(String::toUpperCase) // method 'map' menggunakan parameter lambda expression.
//                    .ifPresentOrElse(
//                            value -> System.out.println("HELLO "+value),
//                            () -> System.out.println("HELLO") // method 'ifPresentOrElse' menggunakan 2 parameter lambda expression.
//                    );

        /** Namun ketika datanya tidak ada dan ingin mengganti dengan data yang lain dapat menggunakan method 'orElse' */
            String upperName = Optional.ofNullable(name)
                    .map(String::toUpperCase)
                    .orElse("PEOPLE");
            System.out.println("HELLO "+upperName);
    }
}

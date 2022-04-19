package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
    - Java Lambda Expressions.
    - Pada saat Lambda keluar di java 8, ada banyak sekali default method yang ditambahkan pada Java Collection, dan beberapa
      default method tersebut memanfaatkan fitur lambda.
    - lambda sama seperti object biasa yang dapat diparsing ke dalam parameter suatu method. atau jika ingin lebih simpel
      maka dapat membuat lambda langsung pada parameter saat pemanggilan suatu method.
    - Ada beberapa default method pada Java Collection yang memanfaatkan Lambda :
        - Method 'forEach' yang ada pada Interface Iterable, dimana method 'forEach' memiliki parameter interface Consumer, dan
          Consumer ini berada dalam Package java.util.function, sehingga parameter method 'forEach' ini dapat diisi oleh lambda.
          Method 'forEach' ini digunakan untuk mengambil seluruh data dari Collections.

        - Method 'removeIf' yang ada pada Interface Collection, dimana method ini memiliki parameter interface Predicate, dan
          Predicate ini berada dalam Package java.util.function, sehingga paramter method 'removeIf' ini dapat diisi oleh lambda.
          dimana interface predicate memiliki return value boolean yang digunakan pada method ini untuk mengecek data yang apakah
          perlu diremove atau tidak.

        - Method 'forEach' yang ada pada Interface Map, dimana method ini memiliki paramter interface BiConsumer. dan BiConsumer
          ini berada dalam package java.util.function, sehingga paramter method 'forEach' ini dapat diisi oleh lambda. method
          'forEach' ini digunakan untuk mengambil seluruh data dari Map namun bedanya dengan Interface Iterable, 'forEach' di
          interface Map ini memiliki 2 variable yaitu key dan value.

        - Masih banyak method-method pada java Collections yang menggunakan lambda Expressions, untuk detailnya silahkan buka
          interface Iterable, Collections dan juga interface Map. banyak framework java yang mendukung java lambda Expressions
          dan banyak teknologi java yang mendukung java lambda Expressions . Jadi java lambda Expressions adalah hal yang
          wajib dipahami pada saat belajar java.

 */
public class Main {
    public static void main(String[] args) {

        /** Lambda pada Collection (interface Iterable, method 'forEach').*/
            System.out.println("\n++++++ Lambda pada Collection (interface Iterable, method 'forEach') ++++++");
            List<String> products = List.of("Oreo","Beng-Beng","Fullo");

            // Lambda dengan membuat object terpisah dan dimasukan ke dalam parameter method 'forEach' yang menampung lambda.
            // Consumer<String> lambda = value -> System.out.println(value);
            // products.forEach(lambda);

            // Lambda yang sering digunakan.
            // products.forEach(product -> System.out.println(product));

            // Lambda menggunakan Method Reference (Object yang berbeda).
            products.forEach(System.out::println);

        /** Lambda pada Collection (interface Collection, method 'removeIf') */
            System.out.println("\n++++++ Lambda pada Collection (interface Collection, method 'removeIf') ++++++");

            // data collection-nya mutable karena akan dihapus beberapa.
            List<String> brands = new ArrayList<>();
            brands.addAll(List.of("Adidas","Nike","New Balance","Puma"));
            brands.forEach(System.out::println);
            System.out.println("- - - - - Data Setelah dihapus yang memiliki huruf lebih dari 5 : ");

            // Lambda.
            brands.removeIf(value -> value.length() > 5);

            brands.forEach(System.out::println);

        /** Lambda pada Map (interface Map, method 'forEach').*/
            System.out.println("\n++++++ Lambda pada Map (interface Map, method 'forEach') ++++++");

            Map<String, String> cars = new HashMap<>();
            cars.put("car1001","Pajero");
            cars.put("car1002","Avanza");
            cars.put("car1003","Fortuner");

            // Lambda.
            cars.forEach((key, value) -> System.out.println("Key : "+key+", Value : " +value));

    }
}

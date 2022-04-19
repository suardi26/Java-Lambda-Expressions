package com.practice;

/**
    - Lambda berasal dari lambda calculus, yang mengacu pada anonymous function ( function tanpa nama ).
    - Namun pada java, function atau method tidak dapat berdiri sendiri artinya function/method harus berada di dalam suatu
      class, sehingga anonymous function tidak terdapat pada java tapi yang ada adalah anonymous class.
    - Maka kemungkinan pada prakteknya, lambda di java dan di bahasa pemrograman lain akan berbeda.
    - Lambda di java adalah representasi sederhana dari anonymous class.
    - Di java kita hanya mengenal Anonymous Class.
    - Lambda di java sebenarnya adalah versi sederhana membuat sebuah anonymous class.
    - Syarat Lambda di java :
        - Berupa interface (harus membuat interface lambda terlebih dahulu).
        - Memiliki 1 method abstract (tidak boleh kosong interfacenya dan tidak boleh lebih dari 1 method abstract,
          jadi harus 1 method abstract).
        - Ditambahkan annotation @FunctionalInterface di Interface-nya.
        - Minimal menggunakan Java 8.
    - Ada beberapa cara membuat lambda di java.
 */
public class LambdaClass {
    public static void main(String[] args) {

        // Anonymous Class.
        InterfaceLambda caraAnonymousClass = new InterfaceLambda() {
            @Override
            public String action(String name) {
                return name;
            }
        };

        System.out.println("New Line : "+caraAnonymousClass.action("Suardi Daud Manda"));

        // Cara 1 membuat lambda di java.
        InterfaceLambda lambdaCara1 = (String variabel) -> {
            return variabel;
        };
        System.out.println("New Line : "+lambdaCara1.action("Java Developer"));

        // Cara 2 membuat lambda di java (tidak perlu menuliskan tipe datanya karena akan disesuaikan oleh parameter dari
        // abstract method yang ada pada interfaceLambda, dan juga nama variabel dari parameter abstract method tidak wajib sama).
        InterfaceLambda lambdaCara2 = (variabel) -> {
          return variabel;
        };
        System.out.println("New Line : "+lambdaCara2.action("Java Collections"));

        // Ketika membuat sebuah method dari interface lambda dan isinya hanya 1 baris maka dapat menggunakan lambda tanpa block
        // seperti Cara 3, Cara 4, Cara 5.

        // Cara 3 membuat lambda di java (Tanpa menambahkan keyword 'return').
        InterfaceLambda lambdaCara3 = (String name) -> "New Line : "+name;
        System.out.println(lambdaCara3.action("Java Generic"));

        // Cara 4 membuat lambda di java (Tanpa menambahkan keyword 'return' dan tidak menuliskan tipe data dari parameter).
        InterfaceLambda  lambdaCara4 = (name) -> "New Line : "+name;
        System.out.println(lambdaCara4.action("Spring"));

        // Cara 5 membuat lambda di java (ketika parameter dari method abstract cuma 1 maka tidak perlu menggunakan
        // symbol '(' & ')' sebelum dan sesudah penulisan variabel).
        InterfaceLambda  lambdaCara5 = name -> "New Line : "+name;
        System.out.println(lambdaCara5.action("Mobile Developer"));

    }
}

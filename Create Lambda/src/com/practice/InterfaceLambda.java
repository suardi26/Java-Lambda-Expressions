package com.practice;

@FunctionalInterface
public interface InterfaceLambda {

    String action(String name);

    // tidak boleh menambahkan lebih dari 1 method.
    // String action2() // error.
}

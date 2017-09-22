package com.desking;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("Please write name directory!!!");
        }
        else {
            new Application().run(args[0]);
        }

    }

}

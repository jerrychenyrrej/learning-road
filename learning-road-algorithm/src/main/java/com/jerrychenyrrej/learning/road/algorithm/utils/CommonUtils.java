package com.jerrychenyrrej.learning.road.algorithm.utils;

import com.jerrychenyrrej.learning.road.algorithm.model.LinkedListNode;

import java.util.Objects;
import java.util.Scanner;

/**
 * @description: common utils for algorithm
 * @author: jerrychenyrrej
 * @create: 2024-01-15 22:57
 **/
public class CommonUtils {

    public static int[] buildArrayFromInput(Scanner input) {
        String[] arrayStr = input.nextLine().split(" ");
        int[] arrInt = new int[arrayStr.length];
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = Integer.parseInt(arrayStr[i]);
        }

        return arrInt;
    }

    /**
     * print the linked list's data by order
     *
     * @param root root of the linked list
     */
    public static void printLinkedList(LinkedListNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        LinkedListNode pointer = root;
        while(Objects.nonNull(pointer.next)) {
            System.out.print(pointer.data + "-");
            pointer = pointer.next;
        }
        System.out.print(pointer.data);
    }
}

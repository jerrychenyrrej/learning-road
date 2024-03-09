package com.jerrychenyrrej.learning.road.algorithm.linkedlist;

import com.jerrychenyrrej.learning.road.algorithm.model.LinkedListNode;
import com.jerrychenyrrej.learning.road.algorithm.utils.CommonUtils;

import java.util.Scanner;

/**
 * @description: convert a given array to a linked list
 * @author: jerrychenyrrej
 * @create: 2024-01-15 22:41
 **/
public class ConvertAGivenArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int[] array = CommonUtils.buildArrayFromInput(input);
            process(array);
        }
    }

    public static void process(int[] array) {
        LinkedListNode root = new LinkedListNode();
        LinkedListNode pointer = root;
        for (int index = 0; index < array.length; index++) {
            pointer = insertNode(pointer, array[index]);
        }
        CommonUtils.printLinkedList(root.next);
    }

    public static LinkedListNode insertNode(LinkedListNode root, int data) {
        LinkedListNode current = new LinkedListNode(data, null, root);
        root.next = current;
        current.pre = root;

        return current;
    }
}

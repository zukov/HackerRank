package com.zukov.learning.hackerank.datastructures.mediumdificulty;

import com.zukov.learning.hackerank.datastructures.util.SinglyLinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {

    public static boolean hasCycle(SinglyLinkedListNode head) {
        return hashAlgo(head);
    }

    private static boolean hashAlgo(SinglyLinkedListNode head) {

        if (head.next == null) {
            return false;
        }

        Set<String> setStore = new HashSet<>();

        SinglyLinkedListNode currentNode = head.next;

        while (currentNode != null) {
            if (setStore.contains(currentNode.toString())) {
                return true;
            }
            setStore.add(currentNode.toString());
            currentNode = currentNode.next;
        }

        return false;
    }

    public static boolean twoPointerAlgo(SinglyLinkedListNode head) {

        if (head.next == null) {
            return false;
        }

        if (head.next.next == null) {
            return head.next.toString().equals(head.toString());
        }

        SinglyLinkedListNode slowPointer = head;
        SinglyLinkedListNode fastPointer = head.next;

        while(fastPointer != null) {
            if (slowPointer == fastPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next == null ? null : fastPointer.next.next;
        }
        return false;
    }
}

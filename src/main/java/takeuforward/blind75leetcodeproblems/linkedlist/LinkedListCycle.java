package takeuforward.blind75leetcodeproblems.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static boolean hasCycleOptimalSolution(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycleBruteSolution(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }



    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        //create a loop
        fifth.next = third;

        System.out.println("Optimal solution: " + hasCycleOptimalSolution(first));
        System.out.println("Brute solution: " + hasCycleBruteSolution(first));
    }
}

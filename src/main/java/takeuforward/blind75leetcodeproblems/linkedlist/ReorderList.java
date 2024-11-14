package takeuforward.blind75leetcodeproblems.linkedlist;

public class ReorderList {
    public static void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        //find the middle of the list
        Node p1 = head;
        Node p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //reverse the half after middle 1->2->3->4->5->6 to 1->2->3->6->5->4
        Node preMiddle = p1;
        Node preCurrent = p1.next;
        while (preCurrent.next != null) {
            Node current  = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        //start reorder
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original: " + head);
        reorderList(head);
        System.out.println("Result: " + head);
    }
}

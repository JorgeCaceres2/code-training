package takeuforward.blind75leetcodeproblems.linkedlist;

public class SortTwoSortedLinkedList {
    public static Node sortTwoLinkedList (Node node1, Node node2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }

        if (node1 != null) {
            temp.next = node1;
        } else {
            temp.next = node2;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        Node mergedList = sortTwoLinkedList(list1, list2);
        System.out.println("Merged List: " + mergedList);

    }
}

package takeuforward.blind75leetcodeproblems.linkedlist;

public class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }

        @Override
        public String toString() {
                //print the linked list;
                StringBuilder sb = new StringBuilder();
                Node temp = this;
                while (temp != null) {
                        sb.append(temp.val).append(" -> ");
                        temp = temp.next;
                }

                return sb.toString();
        }
}

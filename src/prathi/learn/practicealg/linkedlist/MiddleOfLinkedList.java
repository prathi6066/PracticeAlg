package prathi.learn.practicealg.linkedlist;

public class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);

       ListNode result = middleNode(node1);
       System.out.println(result.val);

    }

    private static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;

    }
}

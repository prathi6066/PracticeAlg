package prathi.learn.practicealg.linkedlist;

public class OddEvenLinkedList {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenList(node1);
        printLinkedList(result);

    }


    private static  ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;

    }

    private static void printLinkedList(ListNode currentHead) {

        while (currentHead != null) {
            System.out.println(currentHead.val);
            currentHead = currentHead.next;
        }
    }
}

package prathi.learn.practicealg.linkedlist;

public class RemoveNthNodeEnd {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(node1, 5);
        printLinkedList(result);

    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 0)
            return head;

        ListNode smartPointer = null;
        ListNode currentNode = head;
        int count = 0;

        while (currentNode != null) {
            count++;

            if (count >= n+1) {
                if (smartPointer == null)
                    smartPointer = head;
                else {
                    smartPointer = smartPointer.next;
                }
            }

            currentNode = currentNode.next;

        }

        if (smartPointer == null)
            head = head.next;
        else
            smartPointer.next = smartPointer.next.next;

        return head;

    }

    private static void printLinkedList(ListNode currentHead) {

        while (currentHead != null) {
            System.out.println(currentHead.val);
            currentHead = currentHead.next;
        }
    }
}

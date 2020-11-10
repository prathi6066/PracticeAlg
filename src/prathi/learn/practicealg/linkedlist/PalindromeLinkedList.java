package prathi.learn.practicealg.linkedlist;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(1);
        //node1.next.next.next.next.next = new ListNode(6);

        System.out.println(isPalindrome(node1));

    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode currentNode = head;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        ListNode middleNode = reverse(slowPtr);
        while (middleNode != null) {
            if (currentNode.val != middleNode.val) {
                return false;
            }
            middleNode = middleNode.next;
            currentNode = currentNode.next;
        }

        return true;

    }

    private static ListNode reverse(ListNode middleNode) {
        ListNode currentNode = middleNode, nextNode, prevNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }
}

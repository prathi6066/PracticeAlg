package prathi.learn.practicealg.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(9);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(node1, node2);
        printLinkedList(result);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultHead = null;
        int carry = 0;

        ListNode currentNode = resultHead;
        while (l1 != null && l2 != null) {
            int num1;
            int sum =l1.val + l2.val + carry;
            if (sum >= 10) {
                carry = sum / 10;
                num1 = sum - 10;
            } else {
                num1 = sum;
                carry = 0;
            }
            ListNode newNode = new ListNode(num1);
            newNode.next = null;
            if (resultHead == null) {
                currentNode = newNode;
                resultHead = currentNode;
            } else {
                currentNode.next = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
            currentNode = newNode;
        }

        while (l1 != null) {
            int num1;
            int sum =l1.val + carry;
            if (sum >= 10) {
                carry = sum / 10;
                num1 = sum - 10;
            } else {
                num1 = sum;
                carry = 0;
            }
            ListNode newNode = new ListNode(num1);
            newNode.next = null;
            if (resultHead == null) {
                currentNode = newNode;
                resultHead = currentNode;
            } else {
                currentNode.next = newNode;
            }

            currentNode = newNode;
            l1 = l1.next;
        }


        while (l2 != null) {
            int num1;
            int sum =l2.val + carry;
            if (sum >= 10) {
                carry = sum / 10;
                num1 = sum - 10;
            } else {
                num1 = sum;
                carry = 0;
            }
            ListNode newNode = new ListNode(num1);
            newNode.next = null;
            if (resultHead == null) {
                currentNode = newNode;
                resultHead = currentNode;
            } else {
                currentNode.next = newNode;
            }

            currentNode = newNode;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = null;
            currentNode.next = newNode;
        }

        return resultHead;

    }

    private static void printLinkedList(ListNode currentHead) {

        while (currentHead != null) {
            System.out.println(currentHead.val);
            currentHead = currentHead.next;
        }
    }
}

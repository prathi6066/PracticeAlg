package prathi.learn.practicealg.linkedlist;

public class Add2Nums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        ListNode newNode = null;
        int carry = 0;

        while(head1 != null && head2 != null) {
            int current = 0;
            int sum = head1.val + head2.val + carry;
            if (sum >= 10) {
                carry = sum/10;
                current =  sum - 10;
            } else {
                current = sum;
                carry = 0;
            }
            if (newNode == null)
                newNode = new ListNode(current);
            else {
                ListNode currentNode = new ListNode(current);
                currentNode.next = newNode;
                newNode = currentNode;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        while(head1 != null) {
            int sum = head1.val + carry;
            if (sum >= 10) {
                carry = sum/10;
                sum =  sum - 10;
            } else {
                carry = 0;
            }
            if (newNode == null)
                newNode = new ListNode(sum);
            else {
                ListNode currentNode = new ListNode(sum);
                currentNode.next = newNode;
                newNode = currentNode;
            }
            head1 = head1.next;
        }

        while(head2 != null) {
            int sum = head2.val + carry;
            if (sum >= 10) {
                carry = sum/10;
                sum =  sum - 10;
            } else {
                carry = 0;
            }
            if (newNode == null)
                newNode = new ListNode(sum);
            else {
                ListNode currentNode = new ListNode(sum);
                currentNode.next = newNode;
                newNode = currentNode;
            }
            head2 = head2.next;
        }

        if(carry != 0) {
            newNode.next = new ListNode(carry);
            newNode = newNode.next;
        }

        return newNode;

    }

    public static ListNode reverse(ListNode l1) {
        ListNode current = l1;
        ListNode prev = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

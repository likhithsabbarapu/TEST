import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }

    public static void main(String[] args) {
        // --- LOGIC 1: ADD TWO NUMBERS ---
        ListNode l1 = new ListNode(2); l1.next = new ListNode(4); l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5); l2.next = new ListNode(6); l2.next.next = new ListNode(4);

        ListNode sumResult = addTwoNumbers(l1, l2);
        System.out.print("Add Two Result: ");
        printList(sumResult);

        // --- LOGIC 2: VALID PARENTHESES ---
        String brackets = "{[()]}";
        System.out.println("Is '" + brackets + "' valid? " + isValid(brackets));
    }

    // NEW LOGIC: The Stack Method
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // Add to the "waiting room"
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop(); // Get the last one added
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty(); // If empty, all pairs matched!
    }

    // YOUR PREVIOUS LOGIC: Add Two Numbers
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }

    // Helper to print lists
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}
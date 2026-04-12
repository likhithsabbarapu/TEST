// Linked List Cycle
//
//Problem: Imagine you have a Linked List (a chain of nodes). Usually, the chain ends with a null. But sometimes, the last node points back to an earlier node, creating a loop or a "cycle." How do you detect if there is a loop without getting stuck in an infinite circle forever?
//
//    Input: A list like 3 -> 2 -> 0 -> -4 where -4 points back to 2.
//
//    Goal: Return true if there is a cycle, false if there isn't.
// Linked List Cycle
//
//Problem: Imagine you have a Linked List (a chain of nodes). Usually, the chain ends with a null. But sometimes, the last node points back to an earlier node, creating a loop or a "cycle." How do you detect if there is a loop without getting stuck in an infinite circle forever?
//
//    Input: A list like 3 -> 2 -> 0 -> -4 where -4 points back to 2.
//
//    Goal: Return true if there is a cycle, false if there isn't.

class Node {
    int val;
    Node next;
    Node(int x) {
        val = x;
        next = null;
    }
}

public class CycleDetector {
    public static void main(String[] args) {
        // Creating a list with a cycle: 3 -> 2 -> 0 -> -4 -> (back to 2)
        Node head = new Node(3);
        Node second = new Node(2);
        Node third = new Node(0);
        Node fourth = new Node(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating the loop

        System.out.println("Does the list have a cycle? " + hasCycle(head));
    }

    public static boolean hasCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Moves 1 step
            fast = fast.next.next;     // Moves 2 steps

            // If they meet, there's a cycle!
            if (slow == fast) {
                return true;
            }
        }

        return false; // Fast reached the end
    }
}
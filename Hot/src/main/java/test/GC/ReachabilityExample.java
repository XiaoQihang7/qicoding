package test.GC;

/**
 * 可达性分析
 */
public class ReachabilityExample {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.setNext(node2);
        node2.setNext(node3);

        node1 = null;
        node2 = null;

        // 进行可达性分析
        System.gc();
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
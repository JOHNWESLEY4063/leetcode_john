import java.util.*;

class AllOne {

    private Map<String, Integer> keyCount;
    private Map<Integer, Node> countBucket;
    private Node head, tail;

    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    public AllOne() {
        keyCount = new HashMap<>();
        countBucket = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    private void addNodeAfter(Node prevNode, Node newNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        int count = keyCount.getOrDefault(key, 0);
        keyCount.put(key, count + 1);

        Node currentBucket = countBucket.get(count);
        Node newBucket = countBucket.get(count + 1);

        if (newBucket == null) {
            newBucket = new Node(count + 1);
            countBucket.put(count + 1, newBucket);
            addNodeAfter(currentBucket == null ? head : currentBucket, newBucket);
        }

        newBucket.keys.add(key);

        if (currentBucket != null) {
            currentBucket.keys.remove(key);
            if (currentBucket.keys.isEmpty()) {
                removeNode(currentBucket);
                countBucket.remove(count);
            }
        }
    }

    public void dec(String key) {
        int count = keyCount.get(key);
        if (count == 1) {
            keyCount.remove(key);
        } else {
            keyCount.put(key, count - 1);
        }

        Node currentBucket = countBucket.get(count);
        Node newBucket = countBucket.get(count - 1);

        if (count > 1 && newBucket == null) {
            newBucket = new Node(count - 1);
            countBucket.put(count - 1, newBucket);
            addNodeAfter(currentBucket.prev, newBucket);
        }

        if (newBucket != null) {
            newBucket.keys.add(key);
        }

        currentBucket.keys.remove(key);
        if (currentBucket.keys.isEmpty()) {
            removeNode(currentBucket);
            countBucket.remove(count);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }
}

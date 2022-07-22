class HashMapNode {
    int data;
    int key;
    HashMapNode next;

    public HashMapNode(int key, int data) {
        this.key = key;
        this.data = data;
        this.next = null;
    }
}

// Time Complexity :- O(1) for Average Case(depends total upon the load factor of the numbers)
// Space Complexity :- O(N)
public class designHashMap {
    int size = 500;
    HashMapNode[] nodeHead;

    public designHashMap() {
        this.nodeHead = new HashMapNode[size];
    }

    public int hashValue(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hashValue(key);
        HashMapNode node = nodeHead[index];
        if (node == null) {
            nodeHead[index] = new HashMapNode(key, value);
            return;
        }
        HashMapNode prev = node;
        while (node != null) {
            if (node.key == key) {
                node.data = value;
                return;
            }
            prev = node;
            node = node.next;
        }
        prev.next = new HashMapNode(key, value);
    }

    public int get(int key) {
        int index = hashValue(key);
        HashMapNode node = nodeHead[index];
        while (node != null) {
            if (node.key == key) {
                return node.data;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hashValue(key);
        HashMapNode node = nodeHead[index];
        if (node == null) return;
        if (node.key == key) {
            nodeHead[index] = nodeHead[index].next;
            return;
        }
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
}

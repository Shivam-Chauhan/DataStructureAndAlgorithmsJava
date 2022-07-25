class trieNodeTwo {
    trieNodeTwo[] links;
    int endWith, countPrefix;

    public trieNodeTwo() {
        links = new trieNodeTwo[26];
        endWith = countPrefix = 0;
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, trieNodeTwo node) {
        links[ch - 'a'] = node;
    }

    trieNodeTwo get(char ch) {
        return links[ch - 'a'];
    }

    void incrementPrefix() {
        countPrefix++;
    }

    void incrementEndWith() {
        endWith++;
    }

    int getEnd() {
        return endWith;
    }

    int getPrefix() {
        return countPrefix;
    }

    void reducePrefix() {
        countPrefix--;
    }

    void reduceEndWith() {
        endWith--;
    }
}

// Time Complexity for inserting :- O(Log(N))
// Time Complexity for counting  :- O(Log(N))
// Time Complexity for erasing   :- O(Log(N))
public class implementATrieTwo {
    private static trieNodeTwo root;

    public implementATrieTwo() {
        root = new trieNodeTwo();
    }

    public void insert(String word) {
        trieNodeTwo node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new trieNodeTwo());
            }
            node = node.get(ch);
            node.incrementPrefix();
        }
        node.incrementEndWith();
    }

    public int countWordsEqualTo(String word) {
        trieNodeTwo node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        trieNodeTwo node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        trieNodeTwo node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.reduceEndWith();
    }

    public static void main(String[] args) {
        implementATrieTwo obj = new implementATrieTwo();
        obj.insert("apple");
        obj.insert("apply");
        obj.insert("apps");
        System.out.println(obj.countWordsEqualTo("apple"));
        System.out.println(obj.countWordsStartingWith("app"));
    }
}

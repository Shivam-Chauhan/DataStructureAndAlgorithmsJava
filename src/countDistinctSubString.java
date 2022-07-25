class countSubStringNode {
    countSubStringNode[] links;

    public countSubStringNode() {
        links = new countSubStringNode[26];
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public countSubStringNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, countSubStringNode node) {
        links[ch - 'a'] = node;
    }
}

public class countDistinctSubString {
    private static countSubStringNode root;

    public countDistinctSubString() {
        root = new countSubStringNode();
    }

    public int countDistinctSubStringCounter(String word) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            countSubStringNode node = root;
            for (int j = i; j < word.length(); j++) {
                if (!node.containsKey(word.charAt(j))) {
                    counter++;
                    node.put(word.charAt(j), new countSubStringNode());
                }
                node = node.get(word.charAt(j));
            }
        }
        return counter + 1;
    }

    public static void main(String[] args) {
        String s = "sds";
        countDistinctSubString obj = new countDistinctSubString();
        System.out.println(obj.countDistinctSubStringCounter(s));
    }
}

class trieLongestNode {
    trieLongestNode[] links;
    boolean isEnding;

    trieLongestNode() {
        links = new trieLongestNode[26];
        isEnding = false;
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, trieLongestNode node) {
        links[ch - 'a'] = node;
    }

    public trieLongestNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        isEnding = true;
    }

    public boolean isEnd() {
        return isEnding;
    }
}

// Time Complexity for inserting :- O(N*K) where N is the size of String and K is the length of Array
// Time Complexity for Finding  :- O(N)
public class longestWordWithAllPrefix {
    private static trieLongestNode root;

    public longestWordWithAllPrefix() {
        root = new trieLongestNode();
    }

    void insert(String word) {
        trieLongestNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new trieLongestNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean checkIfPrefixExists(String word) {
        trieLongestNode node = root;
        boolean flag=true;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
                flag=flag & node.isEnd();
            } else {
                return false;
            }
        }
//        System.out.println(word+ " "+flag);
        return flag;
    }

    public String completeString(int n, String[] array) {
        for (String string : array) {
            insert(string);
        }
        String longest = "";
        for (String string : array) {
            if (checkIfPrefixExists(string) == true) {
                if (string.length() > longest.length()) {
                    longest = new String(string);
                } else if (string.length() == longest.length() && string.compareTo(longest) < 0) {
                    longest = new String(string);
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String[] string = {"n","ni","nin","ninj","ninja","ninga"};
        longestWordWithAllPrefix obj = new longestWordWithAllPrefix();
        System.out.println(obj.completeString(string.length, string));
    }

}


class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Take the first string as reference
        String prefix = strs[0];

        // Compare it with every other string
        for (int i = 1; i < strs.length; i++) {

            // Reduce prefix until it matches the current string
            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                // If no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
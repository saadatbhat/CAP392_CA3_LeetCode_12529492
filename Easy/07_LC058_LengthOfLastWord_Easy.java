class Solution {
    public int lengthOfLastWord(String s) {

        // Remove spaces from the beginning and end
        s = s.trim();

        // Find the position of the last space
        int lastSpace = s.lastIndexOf(' ');

        // Return the length of the last word
        return s.length() - lastSpace - 1;
    }
}
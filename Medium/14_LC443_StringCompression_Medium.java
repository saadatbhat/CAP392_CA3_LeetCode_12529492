class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int write = 0;
        int read = 0;

        while (read < n) {

            char current = chars[read];
            int count = 0;

            // Count consecutive repeating characters
            while (read < n && chars[read] == current) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = current;

            // Write count if greater than 1
            if (count > 1) {

                String num = String.valueOf(count);

                for (int i = 0; i < num.length(); i++) {
                    chars[write++] = num.charAt(i);
                }
            }
        }

        return write;
    }
}
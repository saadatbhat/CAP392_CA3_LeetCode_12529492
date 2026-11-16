import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;
        int n = words.length;

        while (i < n) {

            int j = i;
            int lineLength = 0;

            // Find maximum words that can fit in one line
            while (j < n &&
                   lineLength + words[j].length() + (j - i) <= maxWidth) {

                lineLength += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // Last line or line with only one word
            if (j == n || gaps == 0) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                // Add remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Fully justify the line
                int totalSpaces = maxWidth - lineLength;
                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j - 1; k++) {

                    line.append(words[k]);

                    int spaces = spacesPerGap;

                    // Left gaps get extra spaces
                    if (k - i < extraSpaces) {
                        spaces++;
                    }

                    for (int s = 0; s < spaces; s++) {
                        line.append(" ");
                    }
                }

                line.append(words[j - 1]);
            }

            result.add(line.toString());

            // Move to the next line
            i = j;
        }

        return result;
    }
}
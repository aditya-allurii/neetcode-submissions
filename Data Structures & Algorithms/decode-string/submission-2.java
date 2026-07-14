class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int currentCount = 0;

        for (char c : s.toCharArray()) {

            // Build the number (handles multi-digit numbers)
            if (Character.isDigit(c)) {
                currentCount = currentCount * 10 + (c - '0');
            }

            // Build the current string
            else if (Character.isLetter(c)) {
                current.append(c);
            }

            // Enter a new block
            else if (c == '[') {
                countStack.push(currentCount);
                stringStack.push(current);

                currentCount = 0;
                current = new StringBuilder();
            }

            // Exit the current block
            else if (c == ']') {

                int count = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < count; i++) {
                    prev.append(current);
                }

                current = prev;
            }
        }

        return current.toString();
    }
}
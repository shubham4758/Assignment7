// 1. Solution


import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> sToTMap = new HashMap<>();
        HashMap<Character, Character> tToSMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (sToTMap.containsKey(charS)) {
                if (sToTMap.get(charS) != charT) {
                    return false;
                }
            } else {
                if (tToSMap.containsKey(charT) && tToSMap.get(charT) != charS) {
                    return false;
                }
                sToTMap.put(charS, charT);
                tToSMap.put(charT, charS);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();
        System.out.println(solution.isIsomorphic("egg", "add")); // Output: true
        System.out.println(solution.isIsomorphic("foo", "bar")); // Output: false
    }
}



// 2. Solution


import java.util.HashMap;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> strobogrammaticPairs = new HashMap<>();
        strobogrammaticPairs.put('0', '0');
        strobogrammaticPairs.put('1', '1');
        strobogrammaticPairs.put('6', '9');
        strobogrammaticPairs.put('8', '8');
        strobogrammaticPairs.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            if (!strobogrammaticPairs.containsKey(leftChar) || strobogrammaticPairs.get(leftChar) != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber solution = new StrobogrammaticNumber();
        System.out.println(solution.isStrobogrammatic("69")); // Output: true
        System.out.println(solution.isStrobogrammatic("88")); // Output: true
        System.out.println(solution.isStrobogrammatic("962")); // Output: false
    }
}



// 3. Solution


public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);

            i--;
            j--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        AddStrings solution = new AddStrings();
        System.out.println(solution.addStrings("11", "123")); // Output: "134"
        System.out.println(solution.addStrings("456", "77")); // Output: "533"
    }
}




// 4. Solution


public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(reverseWord(word)).append(" ");
        }

        return result.toString().trim();
    }

    private String reverseWord(String word) {
        StringBuilder reversedWord = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord.append(word.charAt(i));
        }
        return reversedWord.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
        // Output: "s'teL ekat edoCteeL tsetnoc"
    }
}



// 5. Solution



public class ReverseFirstKInEvery2K {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;

        for (int i = 0; i < n; i += 2 * k) {
            reverseSubstring(charArray, i, Math.min(i + k, n) - 1);
        }

        return new String(charArray);
    }

    private void reverseSubstring(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseFirstKInEvery2K solution = new ReverseFirstKInEvery2K();
        System.out.println(solution.reverseStr("abcdefg", 2));
        // Output: "bacdfeg"
    }
}




// 6. Solution


public class StringShifts {
    public boolean canTransform(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String concatenated = s + s;
        return concatenated.contains(goal);
    }

    public static void main(String[] args) {
        StringShifts solution = new StringShifts();
        System.out.println(solution.canTransform("abcde", "cdeab"));
        // Output: true
    }
}





// 7. Solution



import java.util.Stack;

public class BackspaceStrings {
    public boolean backspaceCompare(String s, String t) {
        return buildStringWithBackspace(s).equals(buildStringWithBackspace(t));
    }

    private String buildStringWithBackspace(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        BackspaceStrings solution = new BackspaceStrings();
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        // Output: true
    }
}




// 8. Solution


public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            
            // Check if the points are collinear by comparing slopes
            if ((y2 - y1) * (x - x1) != (y - y1) * (x2 - x1)) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        CheckStraightLine solution = new CheckStraightLine();
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(solution.checkStraightLine(coordinates));
        // Output: true
    }
}

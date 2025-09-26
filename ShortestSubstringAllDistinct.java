import java.util.*;

public class ShortestSubstringAllDistinct {
    
    public static int shortestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        int need = uniqueChars.size(); 
        Map<Character, Integer> window = new HashMap<>();
        int have = 0;  
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (window.get(ch) == 1) {
                have++;
            }
            while (have == need) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        String s1 = "dabbcabcd";
        System.out.println(shortestSubstring(s1));
    }
}

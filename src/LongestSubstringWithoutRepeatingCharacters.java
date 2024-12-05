import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        List<String> possibleSubstrings = new ArrayList<>();
        List<String> substringsWithRepeatingChars = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                possibleSubstrings.add(s.substring(i, j+1));
            }
        }

        for(String str : possibleSubstrings) {
            char[] charArr = str.toCharArray();
            for(int i = 0; i < charArr.length; i++) {
                for(int j = i+1; j < charArr.length; j++) {
                    if(charArr[i] == charArr[j]) {
                        substringsWithRepeatingChars.add(str);
                        break;
                    }
                }
            }
        }

        possibleSubstrings.removeAll(substringsWithRepeatingChars);

        return possibleSubstrings.stream().map(String::length).max(Integer::compare).orElse(0);
    }
}

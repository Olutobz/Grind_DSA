package javaVersion;

import java.util.*;

public class SynonymousSentences {

    /**
     * Given a list of pairs of equivalent words synonyms and a sentence text,
     * Return all possible synonymous sentences sorted lexicographically.
     * <p>
     * Input:
     * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
     * text = "I am happy today but was sad yesterday"
     * <p>
     * Output:
     * ["I am cheerful today but was sad yesterday",
     * "I am cheerful today but was sorrow yesterday",
     * "I am happy today but was sad yesterday",
     * "I am happy today but was sorrow yesterday",
     * "I am joy today but was sad yesterday",
     * "I am joy today but was sorrow yesterday"]
     */

    // TC -> O(N) + O(2^n * L) = O(2^n * L)
    // SC -> O(2^n * L)

    /* Approach : Union search, recursive enumeration
     * */

    // word => its similar words set
    Map<String, Set<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    //get all synonyms related to text
    // Use the union search to find the synonym group,
    // and then recursively enumerate and replace the synonym.
    public void getSynonyms(String text, Set<String> visitedStrings, List<String> choicesList) {
        choicesList.add(text);
        visitedStrings.add(text);
        for (String each : map.get(text)) {
            if (!visitedStrings.contains(each)) {
                // recursively find all other choices
                getSynonyms(each, visitedStrings, choicesList);
            }
        }
    }

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        //build graph.
        for (List<String> s : synonyms) {
            String a = s.get(0);
            String b = s.get(1);
            map.getOrDefault(a, new HashSet<>()).add(b);
            map.getOrDefault(b, new HashSet<>()).add(a);
        }

        // "\\W+" matches all characters except alphanumeric characters and
        String[] split = text.split("\\W+");
        helper(split, 0, "");

        Collections.sort(res);
        return res;
    }

    public void helper(String[] wordsArray, int index, String cur) {

        if (index == wordsArray.length) {
            res.add(cur);
            return;
        }

        if (map.containsKey(wordsArray[index])) {
            List<String> choices = new ArrayList<>();
            //find all synonyms related to text
            getSynonyms(wordsArray[index], new HashSet<>(), choices);

            //try to change word at index to every possible synonyms word
            for (String s : choices) {
                helper(wordsArray, index + 1, cur
                        + (index == wordsArray.length - 1 ? s : s + " "));
            }
        } else {
            //if the word at index has no synonyms, just go for next.
            helper(wordsArray, index + 1, cur
                    + (index == wordsArray.length - 1 ? wordsArray[index] : wordsArray[index] + " "));
        }
    }

}


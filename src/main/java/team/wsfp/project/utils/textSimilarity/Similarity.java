package team.wsfp.project.utils.textSimilarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Similarity {

    public static double cosine(List<String> originWord, List<String> targetWord) {

        Map<String, int[]> wordDict = new HashMap<>();
        originWord.forEach(word -> {
            if (!wordDict.containsKey(word)) {
                int[] value = new int[2];
                value[0] = 1;
                wordDict.put(word, value);
            } else {
                wordDict.get(word)[0] += 1;
            }
        });
        targetWord.forEach(word -> {
            if (!wordDict.containsKey(word)) {
                int[] value = new int[2];
                value[1] = 1;
                wordDict.put(word, value);
            } else {
                wordDict.get(word)[1] += 1;

            }
        });
        double dictNum = 0, originNum = 0, targetNum = 0;
        for (Map.Entry<String, int[]> entry : wordDict.entrySet()) {
            int origin = entry.getValue()[0];
            int des = entry.getValue()[1];
            originNum += origin * origin;
            targetNum += des * des;
            dictNum += origin * des;
        }
        return dictNum / Math.sqrt(originNum * targetNum);
    }
}

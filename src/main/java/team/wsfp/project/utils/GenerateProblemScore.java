package team.wsfp.project.utils;

import team.wsfp.project.utils.hashSimilarity.MySimHash;
import team.wsfp.project.utils.textSimilarity.TextSimilarity;

public class GenerateProblemScore {
    public static double useTextSim(String text, String target) {
        TextSimilarity textSimilarity = new TextSimilarity(text, target);
        double similarity = textSimilarity.compute();
//        return similarity * 100;
        return similarity;
    }

    public static double useHashSim(String text, String target) {
        MySimHash hash3 = new MySimHash(text, 64);
        MySimHash hash4 = new MySimHash(target, 64);
//        System.out.println("======================================");
//        System.out.println(hash4.hammingDistance(hash3));
//        System.out.println(hash3.getSemblance(hash4));
//        System.out.println("======================================");
        int hamming = hash3.hammingDistance(hash4);
        double similarity = hash3.getSemblance(hash4);
        return similarity;
    }
}

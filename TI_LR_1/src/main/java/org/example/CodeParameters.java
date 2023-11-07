package org.example;

import java.util.List;

public class CodeParameters {

    public static void printAllInfo(List<Node> nodes) {
        printNodes(nodes);
        System.out.println("Энтропия: " + String.format("%.4f", getEntropy(nodes)));
        System.out.println("Средняя длинна кода: " + String.format("%.4f", getAverageLength(nodes)));
        System.out.println("Коэффициент статистического сжатия: " + String.format("%.4f", getStatisticalCompressionRatio(nodes)));
        System.out.println("Коэффициент относительной эффективности: " + String.format("%.4f", getRelativeEfficiencyRatio(nodes)));
    }

    public static void printNodes(List<Node> nodes) {
        System.out.println("Символ\tВероятность\tКод");
        nodes.forEach(n -> System.out.println(n.getLetter() + "\t\t" + n.getChance() + "\t\t" + n.getCode()));
    }

    public static double getAverageLength(List<Node> nodes) {
        double average = 0;
        for (Node n : nodes)
            average += n.getCode().length() * n.getChance();
        return average;
    }

    public static double getEntropy(List<Node> nodes) {
        double entropy = 0;
        for (Node n : nodes) {
            entropy += n.getChance() * Math.log(n.getChance());
        }
        return -entropy;
    }

    public static double getRelativeEfficiencyRatio(List<Node> nodes) {
        return getEntropy(nodes) / getAverageLength(nodes);
    }

    public static double getStatisticalCompressionRatio(List<Node> nodes) {
        return 1 / getAverageLength(nodes);
    }
}

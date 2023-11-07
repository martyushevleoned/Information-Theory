package org.example;

import lombok.Getter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
public class ShennonFano {

    private final List<Node> nodes;

    public ShennonFano(List<Node> nodes) {
        this.nodes = nodes;
        nodes.sort(Collections.reverseOrder(Comparator.comparing(Node::getChance)));
    }

    public void generateCode(){
        cycle(getString());
    }

    private void cycle(String message) {

        int bestIndex = 1;
        double delta = 1;
        for (int i = 1; i < message.length(); i++) {

            String str1 = message.substring(0, i);
            String str2 = message.substring(i);
            double chance1 = chanceOfString(str1);
            double chance2 = chanceOfString(str2);

            if (Math.abs(chance1 - chance2) < delta) {
                delta = Math.abs(chance1 - chance2);
                bestIndex = i;
            }
        }

        String str1 = message.substring(0, bestIndex);
        String str2 = message.substring(bestIndex);

        for (Node n : nodes) {
            if (containsChar(str1, n.getLetter()))
                n.addCode("0");

            if (containsChar(str2, n.getLetter()))
                n.addCode("1");
        }

        if (str1.length() > 1)
            cycle(str1);

        if (str2.length() > 1)
            cycle(str2);
    }

    private static boolean containsChar(String s, char search) {
        if (s.isEmpty())
            return false;
        else
            return s.charAt(0) == search || containsChar(s.substring(1), search);
    }

    private double chanceOfString(String s) {
        double res = 0;
        for (int i = 0; i < s.length(); i++) {

            for (Node n : nodes) {
                if (s.charAt(i) == n.getLetter()) {
                    res += n.getChance();
                }
            }
        }
        return res;
    }

    private String getString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Node n : nodes) {
            stringBuilder.append(n.getLetter());
        }
        return stringBuilder.toString();
    }
}

package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Haffmen {

    @Getter
    private final List<Node> nodes;

    public Haffmen(List<Node> nodes) {
        this.nodes = nodes;
        nodes.sort(Collections.reverseOrder(Comparator.comparing(Node::getChance)));
    }

    public void generateCode() {
        List<String> strings = new ArrayList<>();
        for (Node n : nodes)
            strings.add(String.valueOf(n.getLetter()));

        cycle(strings);
    }

    private void cycle(List<String> strings) {

//        strings.forEach(s -> System.out.print(s + " "));
//        System.out.println();

        strings.sort((o1, o2) -> Double.compare(chanceOfString(o1), chanceOfString(o2)));

        for (Node n : nodes) {
            if (containsChar(strings.get(0), n.getLetter()))
                n.addCode("0");
            if (containsChar(strings.get(1), n.getLetter()))
                n.addCode("1");
        }

        strings.set(0, strings.get(0) + strings.get(1));
        strings.remove(1);

        if (strings.size() > 1)
            cycle(strings);
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
}

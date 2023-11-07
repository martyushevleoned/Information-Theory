package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nМетод Шеннона-Фано");
        ShennonFano shennonFano = new ShennonFano(variant_9_1());
        shennonFano.generateCode();
        CodeParameters.printAllInfo(shennonFano.getNodes());

        System.out.println("\nМетод Хаффмена");
        Haffmen haffmen = new Haffmen(variant_9_2());
        haffmen.generateCode();
        CodeParameters.printAllInfo(haffmen.getNodes());
    }

    private static List<Node> variant_9_1() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node('A', 0.224, ""));
        nodes.add(new Node('B', 0.203, ""));
        nodes.add(new Node('C', 0.131, ""));
        nodes.add(new Node('D', 0.130, ""));
        nodes.add(new Node('E', 0.124, ""));
        nodes.add(new Node('F', 0.094, ""));
        nodes.add(new Node('G', 0.089, ""));
        nodes.add(new Node('H', 0.005, ""));
        return nodes;
    }

    private static List<Node> variant_9_2() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node('A', 0.219, ""));
        nodes.add(new Node('B', 0.192, ""));
        nodes.add(new Node('C', 0.137, ""));
        nodes.add(new Node('D', 0.135, ""));
        nodes.add(new Node('E', 0.112, ""));
        nodes.add(new Node('F', 0.070, ""));
        nodes.add(new Node('G', 0.070, ""));
        nodes.add(new Node('H', 0.065, ""));
        return nodes;
    }
}
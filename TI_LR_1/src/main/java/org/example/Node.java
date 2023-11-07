package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Node {
    private char letter;
    private Double chance;
    private String code;

    public void addCode(String s){
        code += s;
    }
}

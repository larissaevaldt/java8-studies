package com.larissaevaldt.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Java8LambaActionListener {

    public static void main(String[] args) {

        // JAVA 8: FUNCOES LAMBDA - Outro exemplo
        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ola mundo!");
            }
        });

        //mesmo codigo, agora com LAMBDA
        JButton jButton2 = new JButton();
        jButton2.addActionListener(e -> System.out.println("Ola mundo!"));

        //como que o Java sabe que aquilo ali e um ActionListener, e o metodo que a gente ta implementado e o actionPerformed()?
    }
}

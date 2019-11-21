package Controller;

import Model.Pilula;
import Model.Pontinho;
import Model.Ponto;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Pontos {
    private ArrayList<Ponto> pontos;

    public Pontos() {
        pontos = new ArrayList<Ponto>();
        Collections.addAll(pontos,
                //id, x, y
                new Pontinho(40, 40, 40),
                new Pontinho(41, 110, 40),
                new Pontinho(42, 180, 40),
                new Pontinho(43, 250, 40),
                new Pontinho(44, 320, 40),
                new Pilula(45, 390, 40),
                new Pontinho(46, 460, 40),
                new Pontinho(47, 530, 40),
                new Pontinho(48, 590, 40),
                new Pontinho(49, 590, 110),
                new Pilula(50, 590, 180),
                new Pontinho(51, 590, 250),
                new Pontinho(52, 590, 320),
                new Pontinho(53, 590, 390),
                new Pontinho(54, 590, 440),
                new Pontinho(55, 40, 440),
                new Pontinho(56, 110, 440),
                new Pontinho(57, 180, 440),
                new Pontinho(58, 250, 440),
                new Pilula(59, 320, 440),
                new Pontinho(60, 390, 440),
                new Pontinho(61, 460, 440),
                new Pontinho(62, 530, 440),
                new Pontinho(63, 40, 40),
                new Pontinho(64, 40, 110),
                new Pontinho(65, 40, 180),
                new Pilula(66, 40, 250),
                new Pontinho(67, 40, 320),
                new Pontinho(68, 40, 390),
                new Pontinho(69, 40, 440));
    }

    public void desenharPontos(Graphics g) {
        try {
            for (Ponto p : pontos) {
                p.desenharPonto(g);
            }
        } catch (Exception e) {

        }
    }

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }
}

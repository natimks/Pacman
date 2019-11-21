package Controller;

import Model.Parede;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Labirinto {
    private ArrayList<Parede> paredes;
    private int largura_parede;
    private int altura_parede;
    private Color cor;

    public Labirinto(int largura_tela, int altura_tela) {
        // As paredes tem que ser formadas por retangulos (e nao linhas) para funcionar a colisao
        // Tem que ser uma matriz de varios retangulos
        paredes = new ArrayList<>();
        largura_parede = 20;
        altura_parede = 20;
        // ADICIONANDO AO ARRAY DE PAREDES CADA PAREDE
        Collections.addAll(paredes,
                // Retangulo parede exterma - lado esquerdo
                new Parede(0, 10, 10, largura_parede, altura_tela - 10),
                // Retangulo parede externa - lado direito
                new Parede(1, largura_tela - 20, 10, largura_parede, altura_tela - 10),
                // Retangulo parede esquerda interna
                new Parede(2, 80, 80, largura_parede, altura_tela - 140),
                // Retangulo parede direita interne
                new Parede(3, largura_tela - 80, 80, largura_parede, altura_tela - 140),
                // Retangulo parede interna interna esquerda
                new Parede(4, 150, 100, largura_parede, altura_tela - 160),
                // Retangulo parede interna interna direita
                new Parede(5, largura_tela - 150, 100, largura_parede, altura_tela - 160),
                // Retangulo parede externa - cima
                new Parede(6, 10 + largura_parede, 10, largura_tela - 20, altura_parede),
                // Retangulo parede externa - baixo
                new Parede(7, 10 + largura_parede, altura_tela - altura_parede, largura_tela - 20, altura_parede),
                // Retangulo parede interna cima
                new Parede(8, 130 + largura_parede, 80, largura_tela - 280, altura_parede),
                // Retangulo parede interna baixo-esquerda
                new Parede(9, 130 + largura_parede, altura_tela - altura_parede - 60, largura_tela - 500, altura_parede),
                // Retangulo parede interna baixo-esquerda
                new Parede(10, 350 + largura_parede, altura_tela - altura_parede - 60, largura_tela - 500, altura_parede)
        );
        cor = new Color(0, 0, 156);
    }

    public ArrayList<Parede> getParedes() {
        return paredes;
    }

    public void desenhaLabirinto(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.setColor(cor);
        for (Parede parede : paredes) {
            graficos.fillRect(parede.getX(), parede.getY(), parede.getWidth(), parede.getHeight());
        }
    }
}

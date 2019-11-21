package Controller;

import Model.Fantasma;

import java.awt.*;
import java.util.ArrayList;

public class Fantasmas {
    private ArrayList<Fantasma> fantasmas;

    public Fantasmas() {
        fantasmas = new ArrayList<Fantasma>();
        Fantasma fantasma = new Fantasma(20, 35, 35, 40, 40, Color.red, 'D');
        fantasma.setCorOriginal(Color.RED);
        Fantasma fantasma2 = new Fantasma(20, 35, 35, 40, 40, Color.BLUE, 'B');
        fantasma2.setCorOriginal(Color.BLUE);
        fantasmas.add(fantasma);
        fantasmas.add(fantasma2);
    }

    public void desenharFantasmas(Graphics g) {
        for (Fantasma f : fantasmas) {
            f.desenharFantasma(g);
        }
    }

    public void mudarParaClarinhoFantasmas() {
        for (Fantasma f : fantasmas) {
            f.setColor(Color.gray);
        }
    }

    public void mudarParaNormalFantasmas() {
        for (Fantasma f : fantasmas) {
            f.setColor(f.getCorOriginal());
        }
    }

    public void removerFantasma(Fantasma fantasma) {
        fantasmas.remove(fantasma);
    }

    public ArrayList<Fantasma> getFantasmas() {
        return fantasmas;
    }

    public void setFantasmas(ArrayList<Fantasma> fantasmas) {
        this.fantasmas = fantasmas;
    }

}

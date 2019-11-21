package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public abstract class Ponto extends ObjetoTela {

    public Ponto(int id, int x, int y, int largura, int altura, Color color ) {
        super(id, x, y, largura, altura);
        super.setColor(color);
    }

 
	public void desenharPonto(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graficos.setColor(getColor());
        graficos.fillArc(getX(), getY(), getWidth(), getHeight(), 360, 360);
    }
}

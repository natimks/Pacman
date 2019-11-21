package Model;

import Controller.Labirinto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;


public class Fantasma extends ObjetoMovel implements Colisivel {
	Color corOriginal;
	
    public Fantasma(int id, int x, int y, int width, int height, Color cor, char direcao) {
        super(id, x, y, width, height, direcao);
        super.setColor(cor);
    }

    public void desenharFantasma(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graficos.setColor(super.getColor());
        graficos.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void andar(Labirinto labirinto) {
        boolean fantasma_colidiu = false;
        for (int i = 0; i < labirinto.getParedes().size(); i++) {
            fantasma_colidiu = verificarColisaoFutura(labirinto.getParedes().get(i), getDirecao());
            if (fantasma_colidiu) {
                Random r = new Random();
                int j = 66 + r.nextInt(70 - 66);  // B=66 C =67 D=68 E=69
                char c = (char) j;
                this.setDirecao(c);
                break;
            }
        }
        if (!fantasma_colidiu) {
            mudarDirecao();
        }
    }

    @Override
    public boolean colidiu(ObjetoTela obj) {
        int objeto1_x2 = 0;
        int objeto1_y2 = 0;
        if (obj instanceof Pacman) {
            Pacman pacman = (Pacman) obj;
            objeto1_x2 = pacman.getX() + pacman.getRaio();
            objeto1_y2 = pacman.getY() + pacman.getRaio();
        } else if (obj instanceof Parede) {
            objeto1_x2 = obj.getX() + obj.getWidth();
            objeto1_y2 = obj.getY() + obj.getHeight();
        }
        boolean colidiu = false;
        int objeto1_x1 = obj.getX();
        int objeto1_y1 = obj.getY();

        int objeto2_x1 = this.getX();
        int objeto2_y1 = this.getY();
        int objeto2_x2 = this.getX() + this.getWidth();
        int objeto2_y2 = this.getY() + this.getHeight();

        if ((objeto1_x1 < objeto2_x2) && (objeto1_x2 > objeto2_x1)
                && (objeto1_y1 < objeto2_y2) && (objeto1_y2 > objeto2_y1)) {
            colidiu = true;
        }
        return colidiu;
    }

    public boolean verificarColisaoFutura(ObjetoTela obj, char direcao) {
        boolean colidiu = false;

        int objeto1_x2 = obj.getX() + obj.getWidth();
        int objeto1_y2 = obj.getY() + obj.getHeight();
        int objeto1_x1 = obj.getX();
        int objeto1_y1 = obj.getY();

        int objeto2_x1 = this.getX();
        int objeto2_y1 = this.getY();
        int objeto2_x2 = this.getX() + this.getWidth();
        int objeto2_y2 = this.getY() + this.getHeight();

        if (direcao == 'B') {
            objeto2_y1 = this.getY() + 1;
            objeto2_y2 = this.getY() + this.getHeight() + 1;
        } else if (direcao == 'C') {
            objeto2_y1 = this.getY() - 1;
            objeto2_y2 = this.getY() + this.getHeight() - 1;
        } else if (direcao == 'D') {
            objeto2_x1 = this.getX() + 1;
            objeto2_x2 = this.getX() + this.getWidth() + 1;
        } else if (direcao == 'E') {
            objeto2_x1 = this.getX() - 1;
            objeto2_x2 = this.getX() + this.getWidth() - 1;
        }

        if ((objeto1_x1 < objeto2_x2) && (objeto1_x2 > objeto2_x1)
                && (objeto1_y1 < objeto2_y2) && (objeto1_y2 > objeto2_y1)) {
            colidiu = true;
 
        }
        return colidiu;
    }

    public void mudarDirecao() {
        // Aqui tem q chamar o método que verifica a colisão, antes de incrementar
        if (getDirecao() == 'D') {
            this.setX(getX() + 1);
        } else if (getDirecao() == 'E') {
            this.setX(getX() - 1);
        } else if (getDirecao() == 'C') {
            this.setY(getY() - 1);
        } else if (getDirecao() == 'B') {
            this.setY(getY() + 1);
        }
    }

	public Color getCorOriginal() {
		return corOriginal;
	}
	
	public void setCorOriginal(Color blue) {
		this.corOriginal = corOriginal;
	}
    
}

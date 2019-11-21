package Model;

import Controller.ControleJogo;
import Controller.Labirinto;
import Controller.Pontos;

import java.awt.*;

public class Pacman extends ObjetoTela implements Colisivel {

    private int x;
    private int y;
    private int raio;
    private int angulo_boca;
    private Color cor;
    private char direcao;
    private int pontos;
    boolean invencivel = false;
    ControleJogo controleJogo;

    public Pacman(int largura_tela, int altura_tela, ControleJogo controle) {
        super(99, largura_tela, altura_tela, 80, 80);
        x = (int) largura_tela / 2;
        y = (int) altura_tela / 2;
        raio = 40;
        angulo_boca = (int) (20 * (Math.sin((x + y) * 2 * Math.PI / raio) + 1));
        cor = new Color(255, 255, 0);
        // Pacman comeca indo para a direita
        direcao = 'D';
        this.controleJogo = controle;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getRaio() {
        return raio;
    }

    public char getDirecao() {
        return direcao;
    }

    public void setDirecao(char direcao) {
        this.direcao = direcao;
    }


    public boolean isInvencivel() {
        return invencivel;
    }

    public void setInvencivel(boolean invencivel) {
        this.invencivel = invencivel;
    }

    @Override
    public boolean colidiu(ObjetoTela obj) {
        boolean colidiu = false;
        int objeto1_x1 = this.getX();
        int objeto1_y1 = this.getY();
        int objeto1_x2 = this.getX() + this.getRaio();
        int objeto1_y2 = this.getY() + this.getRaio();

        int objeto2_x1 = obj.getX();
        int objeto2_y1 = obj.getY();
        int objeto2_x2 = obj.getX() + obj.getWidth();
        int objeto2_y2 = obj.getY() + obj.getHeight();

        if ((objeto1_x1 <= objeto2_x2) && (objeto1_x2 >= objeto2_x1)
                && (objeto1_y1 <= objeto2_y2) && (objeto1_y2 >= objeto2_y1)) {
            colidiu = true;
            System.out.println("OBJETO COLIDIU COM A PAREDE: " + this.getId());
        }
        return colidiu;
    }

    public void desenhaPacman(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graficos.setColor(this.cor);
        if (direcao == 'D') {
            angulo_boca = (int) (20 * (Math.sin((x + y) * 2 * Math.PI / 50) + 1));
        } else if (direcao == 'E') {
            angulo_boca = (int) (20 * (Math.sin((x + y) * 2 * Math.PI / raio) + 1));
        } else if (direcao == 'C') {
            angulo_boca = (int) (20 * (Math.sin((x + y) * 2 * Math.PI / raio) + 1));
        } else if (direcao == 'B') {
            angulo_boca = (int) (20 * (Math.sin((x + y) * 2 * Math.PI / raio) + 1));
        }
        graficos.fillArc(this.x, this.y, this.raio, this.raio, this.angulo_boca / 2, 360 - this.angulo_boca);
    }

    public void comer(Pontos pontos) {
        for (int i = 0; i < pontos.getPontos().size(); i++) {
            if (verificarColisaoFutura(pontos.getPontos().get(i), direcao)) {
                if (pontos.getPontos().get(i) instanceof Pilula) {
                    invencivel = true;
                    controleJogo.pacmanComeuPilula();
                }
                pontos.getPontos().remove(i);
                this.pontos += 10;

            }
        }
    }

    public void andar(Labirinto labirinto) {
        boolean pacman_colidiu = false;
        for (int i = 0; i < labirinto.getParedes().size(); i++) {
            pacman_colidiu = verificarColisaoFutura(labirinto.getParedes().get(i), direcao);
            if (pacman_colidiu) {
                break;
            }
        }
        if (!pacman_colidiu) {
            mudarDirecaoPacman();
        }
    }

    public boolean verificarColisaoFutura(ObjetoTela obj, char direcao) {
        boolean colidiu = false;

        int objeto1_x2 = obj.getX() + obj.getWidth();
        int objeto1_y2 = obj.getY() + obj.getHeight();
        int objeto1_x1 = obj.getX();
        int objeto1_y1 = obj.getY();

        int objeto2_x1 = this.getX();
        int objeto2_y1 = this.getY();
        int objeto2_x2 = this.getX() + this.getRaio();
        int objeto2_y2 = this.getY() + this.getRaio();

        if (direcao == 'B') {
            objeto2_y1 = this.getY() + 1;
            objeto2_y2 = this.getY() + this.getRaio() + 1;
        } else if (direcao == 'C') {
            objeto2_y1 = this.getY() - 1;
            objeto2_y2 = this.getY() + this.getRaio() - 1;
        } else if (direcao == 'D') {
            objeto2_x1 = this.getX() + 1;
            objeto2_x2 = this.getX() + this.getRaio() + 1;
        } else if (direcao == 'E') {
            objeto2_x1 = this.getX() - 1;
            objeto2_x2 = this.getX() + this.getRaio() - 1;
        }

        if ((objeto1_x1 < objeto2_x2) && (objeto1_x2 > objeto2_x1)
                && (objeto1_y1 < objeto2_y2) && (objeto1_y2 > objeto2_y1)) {
            colidiu = true;
        }
        return colidiu;
    }

    public void mudarDirecaoPacman() {
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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}

package Controller;


import Model.Fantasma;
import Model.Pacman;
import View.Tela;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;


public class ControleJogo implements KeyListener {

    private int largura_tela;
    private int altura_tela;

    private Pacman pacman;
    private Labirinto labirinto;
    private Fantasmas fantasmas;
    private Pontos pontos;
    private Tela tela;

    public void iniciarJogo() {
        largura_tela = 640;
        altura_tela = 490;
        fantasmas = new Fantasmas();
        pacman = new Pacman(largura_tela, altura_tela, this);
        labirinto = new Labirinto(largura_tela, altura_tela);
        pontos = new Pontos();
        tela = new Tela(largura_tela, altura_tela, this, pacman, labirinto, fantasmas, pontos);
        boolean repetir = true;
        do {
            try {
                repetir = this.update();
                tela.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (repetir);
    }

    private boolean update() throws InterruptedException {
        pacman.andar(labirinto);
        pacman.comer(pontos);
        Thread.currentThread();
        boolean result = true;
        Fantasma fantasmaRemovido = null;
        for (int i = 0; i < fantasmas.getFantasmas().size(); i++) {
            Fantasma fantasma = fantasmas.getFantasmas().get(i);
            fantasma.andar(labirinto);
            if (pacman.verificarColisaoFutura(fantasma, pacman.getDirecao())) {
                if (pacman.isInvencivel()) {
                    fantasmaRemovido = fantasma;
                } else {
                    JOptionPane.showMessageDialog(tela, "GAME OVER");
                    result = false;
                    break;
                }
            }
        }
        if (Objects.nonNull(fantasmaRemovido)) {
            fantasmas.removerFantasma(fantasmaRemovido);
        }
        if (pontos.getPontos().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "PARABÉNS! VOCÊ GANHOU COM " + pacman.getPontos() + " PONTOS!");
            result = false;
        }
        Thread.sleep(5);
        return result;
    }

    public void pacmanComeuPilula() {
        ThreadFantasma thread = new ThreadFantasma(fantasmas);
        thread.start();
    }

    @Override
    public void keyPressed(KeyEvent tecla) {
        // TODO Auto-generated method stub
        if (tecla.getKeyCode() == KeyEvent.VK_RIGHT) {
            pacman.setDirecao('D');
        } else if (tecla.getKeyCode() == KeyEvent.VK_LEFT) {
            pacman.setDirecao('E');
        } else if (tecla.getKeyCode() == KeyEvent.VK_UP) {
            pacman.setDirecao('C');
        } else if (tecla.getKeyCode() == KeyEvent.VK_DOWN) {
            pacman.setDirecao('B');
        }
    }

    @Override
    public void keyReleased(KeyEvent tecla) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent tecla) {
        // TODO Auto-generated method stub
    }
}

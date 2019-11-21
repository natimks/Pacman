package View;
import Controller.Fantasmas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Labirinto;
import Controller.Pontos;
import Model.ObjetoTela;
import Model.Pacman;

import java.awt.Graphics;

public class Tela extends JPanel {

	private int largura_tela;
	private int altura_tela;
        private Pacman pacman;
        private Labirinto labirinto;
        private Fantasmas fantasmas;
        private Pontos pontos;

	public Tela(int largura_tela, int altura_tela,KeyListener k, Pacman pacman, Labirinto labirinto, Fantasmas fantasmas,Pontos pontos) {
		JFrame frame = new JFrame("Pacman");
		frame.add(this);
		frame.addKeyListener(k);
		frame.setSize(largura_tela,altura_tela);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.pacman=pacman;
                this.labirinto=labirinto;
                this.fantasmas=fantasmas;
                this.pontos=pontos;
                
	}

	public int getLarguraTela() {
		return this.largura_tela;
	}

	public int getAlturaTela() {
		return this.largura_tela;
	} 
        @Override
	public void paint(Graphics g) {
		super.paint(g);
                pontos.desenharPontos(g);
		pacman.desenhaPacman(g);
		labirinto.desenhaLabirinto(g);
                fantasmas.desenharFantasmas(g);
                
	}
}

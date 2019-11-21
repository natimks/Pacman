package Model;

/**
 * @author Natália Maria
 */
public class ObjetoMovel extends ObjetoTela implements Runnable {

    private char direcao;

    public ObjetoMovel(int id, int x, int y, int width, int height, char direcao) {
        super(id, x, y, width, height);
        this.direcao = direcao;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public char getDirecao() {
        return direcao;
    }

    public void setDirecao(char direcao) {
        this.direcao = direcao;
    }

}

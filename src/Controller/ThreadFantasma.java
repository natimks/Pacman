package Controller;

public class ThreadFantasma extends Thread {
    Fantasmas fantasmas;
    public ThreadFantasma(Fantasmas fantasmas) {
        this.fantasmas=fantasmas;
    }
    public void run(){
        try {
            System.out.println("INICIO 30 SEGUNODS");
            fantasmas.mudarParaClarinhoFantasmas();
            this.sleep(3 * 10000);
            System.out.println("DEU 30 SEGUNDOS ");
            fantasmas.mudarParaNormalFantasmas();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

import java.util.Random;

public class Positions {
    int x;
    int y;

    Positions(int x, int y) {
        super();
    }

    public Positions(Random x, Random y) {
        Random r = new Random();
        Positions bombPosition = new Positions(r.nextInt(80), r.nextInt(24));
    }
}

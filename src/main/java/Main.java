import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = defaultTerminalFactory.createTerminal();



        terminal.setCursorPosition(9, 1);
        terminal.putCharacter('A');

        terminal.setCursorPosition(20, 20);
        terminal.putCharacter('A');

        int x = 0;
        int y = 0;
        final char sleazer = '\u2588';
        boolean go = true;
        KeyStroke keyStroke;
        final char player = 'X';

        //lage sleazer (
        Positions positionSleazer1 = new Positions(70,6);
        Positions positionSleazer2 = new Positions(4,8);
        Positions positionSleazer3 = new Positions(50,40);
        Positions positionSleazer4 = new Positions(67,23);
        Positions positionSleazer5 = new Positions(4,33);
        Positions positionSleazer6 = new Positions(66,58);
        Positions positionSleazer7 = new Positions(15,6);


        terminal.setCursorPosition(1, 6);
        terminal.putCharacter(sleazer);

        ArrayList<Positions> map = new ArrayList<>();





        //setter startposisjon
        terminal.setCursorVisible(false);
        terminal.setCursorPosition(0, 0);
        terminal.putCharacter('X');

        terminal.flush();

        while(go) {
            do {
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
            }while (keyStroke == null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();



            if (c == Character.valueOf('Q')) {
                System.out.println("QUITTING");
                go = false;
                terminal.close();
            }

            int xOld = x;
            int yOld = y;



            switch (keyStroke.getKeyType()) {
                case ArrowDown:
                    y += 1;
                    break;
                case ArrowUp:
                    y -= 1;
                    break;
                case ArrowRight:
                    x += 1;
                    break;
                case ArrowLeft:
                    x -= 1;
                    break;
            }
            terminal.setCursorPosition(xOld, yOld); // move cursor to old position
            terminal.putCharacter(' '); // clean up by printing space on old position
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(player);

            terminal.flush();
        }
    }
}

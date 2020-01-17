import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

//ALS JE DIT LEEST IVO, PLS NEGEREN LOL

public class Window{
    JFrame game;
    Container con;
    JPanel titleNamePanel;

    public Window(){
        game = new JFrame();
        game.setSize(800, 600);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.getContentPane().setBackground(Color.blue);
        game.setLayout(null);
        game.setVisible(true);
        con = game.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.blue);
        titleNamePanel.setVisible(true);
        game.add(titleNamePanel);
        game.setVisible(true);
    }
}
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//ALS JE DIT LEEST IVO, PLS NEGEREN LOL

public class Window{
    JFrame game;
    Container con;
    JPanel titleNamePanel;
    JLabel pictureLabel;
    ImageIcon image;
    JTextArea textArea;

    public Window(){
        game = new JFrame();
        game.setSize(800, 600);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.getContentPane().setBackground(Color.black);
        game.setLayout(null);
        game.setVisible(true);
        con = game.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0, -5, 800, 300);
        titleNamePanel.setBackground(Color.black);
        titleNamePanel.setVisible(true);
        game.add(titleNamePanel);
        game.setVisible(true);

        pictureLabel = new JLabel();

        image = new ImageIcon("images/castle_entrance.png");

        pictureLabel.setIcon(image);
        titleNamePanel.add(pictureLabel);

        JTextArea textArea = new JTextArea(50, 10);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream);
        
        game.setVisible(true);
    }

    public class CustomOutputStream extends OutputStream {
        private JTextArea textArea;
    
        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }
    
        @Override
        public void write(int b) throws IOException {
            // redirects data to the text area
            textArea.append(String.valueOf((char)b));
            // scrolls the text area to the end of data
            textArea.setCaretPosition(textArea.getDocument().getLength());
            // keeps the textArea up to date
            textArea.update(textArea.getGraphics());
        }
    }
}   
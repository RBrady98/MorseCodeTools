import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * MainWindow
 */
public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
	JFrame frame;

    public MainWindow() {
        guiInit();
    }
    
    private void guiInit() {
        JButton encode = new JButton("Encode");
        JButton decode = new JButton("Decode");
        JButton play = new JButton("\u25B6");
        JTextArea input = new JTextArea();
        final JTextArea output = new JTextArea();
        encode.setBounds(90, 235, 100, 50);
        decode.setBounds(210, 235, 100, 50);
        play.setBounds(150, 300, 100, 50);
        input.setBounds(10, 10, 360, 100);
        input.setBackground(new Color(179, 203, 242));
        output.setBounds(10, 120, 360, 100);
        output.setBackground(new Color(179, 203, 242));
        output.setEditable(false);

        encode.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputString = input.getText();
                if(inputString.matches("[a-z ]{1,}")) {
                    String outputString = Morse.englishToMorse(inputString);
                    output.setText(outputString);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect input format");
                }
            }
        });

        decode.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputString = input.getText();
                if(inputString.matches("[\\.\\-\\/ ]{1,}")) {
                    String outputString = Morse.morseToEnglish(inputString);
                    output.setText(outputString);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect input format");
                }
            }
        });

        play.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                Morse.playMorseSequence(output.getText());
            }
        });

        add(encode);
        add(decode);
        add(play);
        add(input);
        add(output);
        setSize(400, 400);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
}
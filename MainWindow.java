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
        //Create buttons and text windows
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
                if(inputString.matches("[a-zA-Z ]{1,}")) {
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
                String morse = output.getText();
                if(morse.matches("[\\.\\-\\/ ]{1,}")) {
                    Morse.playMorseSequence(morse);
                } else {
                    JOptionPane.showMessageDialog(null, "Unable to play, incorrect format of morse sequence");
                }
            }
        });

        add(encode);
        add(decode);
        add(play);
        add(input);
        add(output);
        setSize(400, 400);
        getContentPane().setBackground(new Color(66, 155, 244));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
}
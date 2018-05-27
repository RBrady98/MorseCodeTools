import javax.swing.SwingUtilities;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){     
            @Override
            public void run() {
                MainWindow menu = new MainWindow();
                menu.setVisible(true);
            }
        });
    }
}
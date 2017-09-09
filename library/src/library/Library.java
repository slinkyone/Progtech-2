package library;

import gui.BooksFrame;
import javax.swing.SwingUtilities;

public class Library {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new BooksFrame().setVisible(true);
            }
        });
    }
}

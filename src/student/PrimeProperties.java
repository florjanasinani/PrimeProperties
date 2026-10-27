package student;

import javax.swing.SwingUtilities;

public class PrimeProperties {

    public static void main(String[] args) {
        // Kjo linje therret dritaren grafike te hapet ne ekran
        SwingUtilities.invokeLater(() -> {
            new PrimePropertiesGUI().setVisible(true);
        });
    }
}
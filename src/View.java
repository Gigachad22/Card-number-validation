import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View {
    Frame mainFrame;
    Model logic;
    public View(Frame f, Model m) {
        mainFrame = f;
        logic = m;
        mainFrame.setVisible(true);
    }
    public void Validate(){
        mainFrame.getButton().addActionListener(e ->{
            boolean result = logic.Luhn_algorithm(mainFrame.getCardNumber());
            JDialog dialog = new JDialog();
            JPanel mainDialogPanel = new JPanel(new FlowLayout());
            if (result){
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("check-mark-button_2705.png"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Image newImage = img.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
                mainDialogPanel.add(new JLabel(new ImageIcon(newImage)));
                mainDialogPanel.add(new JLabel("Credit card number is valid."));
            }
            else {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("cross-mark_274c.png"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Image newImage = img.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
                mainDialogPanel.add(new JLabel(new ImageIcon(newImage)));
                mainDialogPanel.add(new JLabel("Credit card number is NOT valid."));
            }
            dialog.add(mainDialogPanel);
            dialog.setSize(new Dimension(280, 100));
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });
    }
}

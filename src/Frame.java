import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class Frame extends JFrame {
    private JButton button;
    NumberField first_4_digits, second_4_digits,
                        third_4_digits, fourth_4_digits;
    LinkedList<NumberField> list = new LinkedList<>();

    public Frame() throws IOException {
        setTitle("Credit card validator");
        setSize(new Dimension(480, 200));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(243, 115, 247));
        setResizable(false);
        add(LayoutSetup());
        focusChanger();
    }

    private JPanel LayoutSetup() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(243, 115, 247));
        mainPanel.setLayout(new GridLayout(3, 1));
        JLabel text = new JLabel("Please enter your credit card number!");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(text);

        first_4_digits = new NumberField();
        first_4_digits.setPreferredSize(new Dimension(40, 20));
        second_4_digits = new NumberField();
        second_4_digits.setPreferredSize(new Dimension(40, 20));
        third_4_digits = new NumberField();
        third_4_digits.setPreferredSize(new Dimension(40, 20));
        fourth_4_digits = new NumberField();
        fourth_4_digits.setPreferredSize(new Dimension(40, 20));

        JPanel secondLine = new JPanel(new FlowLayout());
        secondLine.setBackground(new Color(243, 115, 247));
        secondLine.add(first_4_digits);
        secondLine.add(second_4_digits);
        secondLine.add(third_4_digits);
        secondLine.add(fourth_4_digits);
        mainPanel.add(secondLine);

        JPanel thirdLine = new JPanel(new FlowLayout());
        thirdLine.setBackground(new Color(243, 115, 247));
        button = new JButton("Verify");
        button.setPreferredSize(new Dimension(90, 23));
        thirdLine.add(button);
        mainPanel.add(thirdLine);
        list.add(first_4_digits);
        list.add(second_4_digits);
        list.add(third_4_digits);
        list.add(fourth_4_digits);
        return mainPanel;
    }
    public JButton getButton(){
        return button;
    }
    public String getCardNumber(){
        String cardNo;
        cardNo = first_4_digits.getText() + second_4_digits.getText()
                +third_4_digits.getText() + fourth_4_digits.getText();
        return cardNo;
    }
    private void focusChanger(){
        for (int i = 0; i < 3; i++){
            int finalI = i;
            list.get(i).getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    changeFocus();
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    changeFocus();
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    changeFocus();
                }
                private void changeFocus(){
                    if (list.get(finalI).getText().length() > 3){
                        list.get(finalI + 1).grabFocus();
                    }
                }
            });
        }
        list.get(3).getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changeFocus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeFocus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changeFocus();
            }
            private void changeFocus(){
                if(list.get(3).getText().length() > 3){
                    button.grabFocus();
                }
            }
        });
    }
}


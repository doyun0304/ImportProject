package render.panel;

import main.GameManager;
import render.Images;
import render.layout.linear.LinearConstraints;
import render.layout.linear.LinearLayout;
import render.layout.linear.LinearSpace;
import render.layout.linear.Orientation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AnswerPanel extends JPanel {
    GameManager gameManager;
    JButton enterButton;
    JButton hintButton;
    JTextField textField;

    public AnswerPanel(GameManager gameManager) {
        this.gameManager = gameManager;

        enterButton = new JButton(new ImageIcon(Images.enterImage));
        hintButton = new JButton(new ImageIcon(Images.hintImage));
        textField = new JTextField();

        enterButton.setContentAreaFilled(false);
        hintButton.setContentAreaFilled(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));

        enterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameManager.getGamePanel().getPuzzlePanel().getPuzzle().checkAnswer(textField.getText());
                if(gameManager.getGamePanel().getPuzzlePanel().getPuzzle().isSolved()) {
                    gameManager.getGamePanel().switchMode();
                }

                else {
                    textField.setText("Wrong Answer");
                }
            }
        });

        hintButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(gameManager.getGamePanel().getPuzzlePanel().getPuzzle().getHint().equals("") ? "There's no HINT for you" : gameManager.getGamePanel().getPuzzlePanel().getPuzzle().getHint());
            }
        });

        setLayout(new LinearLayout(Orientation.HORIZONTAL, 0));
        add(textField, new LinearConstraints().setWeight(19).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(enterButton, new LinearConstraints().setWeight(3).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(hintButton, new LinearConstraints().setWeight(3).setLinearSpace(LinearSpace.MATCH_PARENT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

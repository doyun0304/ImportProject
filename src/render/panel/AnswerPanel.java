package render.panel;

import main.GameManager;
import main.MainKeyListener;
import render.Images;
import render.layout.linear.LinearConstraints;
import render.layout.linear.LinearLayout;
import render.layout.linear.LinearSpace;
import render.layout.linear.Orientation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnswerPanel extends JPanel {
    private GameManager gameManager;
    private JButton enterButton;
    private JButton hintButton;
    protected JTextField textField;

    public AnswerPanel(GameManager gameManager) {
        this.gameManager = gameManager;

        enterButton = new JButton(new ImageIcon(Images.enterImage));
        hintButton = new JButton(new ImageIcon(Images.hintImage));
        textField = new JTextField();

        enterButton.setContentAreaFilled(false);
        hintButton.setContentAreaFilled(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                gameManager.getGamePanel().requestFocusInWindow();
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
                    gameManager.getGamePanel().setStagePanel();
                }
            }
        });

        enterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameManager.getGamePanel().getPuzzlePanel().getPuzzle().checkAnswer(textField.getText());
                if(gameManager.getGamePanel().getPuzzlePanel().getPuzzle().isSolved()) {
                    gameManager.getGamePanel().setStagePanel();
                }

                else {
                    textField.setText("Wrong Answer");
                }
            }
        });

        hintButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(gameManager.getGamePanel().getPuzzlePanel().getPuzzle().getHint().equals("") ? "There's no HINT for you" : "HINT : " + gameManager.getGamePanel().getPuzzlePanel().getPuzzle().getHint());
            }
        });

        setLayout(new LinearLayout(Orientation.HORIZONTAL, 0));
        add(textField, new LinearConstraints().setWeight(19).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(enterButton, new LinearConstraints().setWeight(3).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(hintButton, new LinearConstraints().setWeight(3).setLinearSpace(LinearSpace.MATCH_PARENT));
    }

    public void setFocus() {
        textField.requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

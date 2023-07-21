package render.panel;

import main.GameManager;
import render.Images;
import render.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static render.RenderUtil.tileSize;

public class StagePanel extends JPanel {
    private GameManager gameManager;
    private JButton soundButton;
    private Sound sound;

    public StagePanel(GameManager gameManager, Sound sound){
        this.gameManager = gameManager;
        this.sound = sound;

        setLayout(null);
        setPreferredSize(new Dimension(getWidth(), tileSize * 15));

        soundButton = new JButton(new ImageIcon(Images.soundOnImage));
        soundButton.setContentAreaFilled(false);
        soundButton.setBorderPainted(false);

        soundButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.mute();

                if(sound.isMuted()) soundButton.setIcon(new ImageIcon(Images.soundOffImage));

                else soundButton.setIcon(new ImageIcon(Images.soundOnImage));

                gameManager.getGamePanel().requestFocus();
            }
        });

        Insets insets = this.getInsets();
        soundButton.setBounds(insets.left, tileSize * 14 + insets.top, tileSize, tileSize);

        this.add(soundButton);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
        gameManager.getCurrentRoom().getBackgroundManager().draw(g2);
        gameManager.getPlayer().draw(g2);
        gameManager.getCurrentRoom().draw(g2);
    }
}

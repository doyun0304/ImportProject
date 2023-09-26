import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Particle {
    int x, y;
    Color color;
    double size;
    double speedX, speedY;
    double accelerationX, accelerationY;
    double life;
    LinkedList<Point> trail = new LinkedList<>();
    static final int TRAIL_LENGTH = 10; // Adjust the length of the trail

    Particle(int x, int y, Color color, double size, double speedX, double speedY, double life) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.speedX = speedX;
        this.speedY = speedY;
        this.life = life;
        this.accelerationX = 0;
        this.accelerationY = 0;
    }

    void update() {
        speedX += accelerationX;
        speedY += accelerationY;
        x += speedX;
        y += speedY;
        life -= 0.02;
        trail.add(new Point(x, y));
        if (trail.size() > TRAIL_LENGTH) {
            trail.removeFirst();
        }
    }

    boolean isAlive() {
        return life > 0;
    }
}

class Firework {
    int x, y;
    Color color;
    int size;
    double explosionSize;
    double explosionPower;
    ArrayList<Particle> particles = new ArrayList<>();
    boolean exploded = false;
    double launchAngle;

    Firework(int x, int y, Color color, int size, double explosionSize, double explosionPower, double launchAngle) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.explosionSize = explosionSize;
        this.explosionPower = explosionPower;
        this.launchAngle = launchAngle;
    }

    void explode() {
        Random rand = new Random();
        for (int i = 0; i < 6; i++) { // Create lines of particles in six directions
            for (int j = 0; j < 20; j++) { // Number of particles in each line
                Color particleColor = this.color; // Use the same color as the ball
                double angle = launchAngle + i * Math.PI / 3; // Calculate the angle based on launch direction
                double speed = rand.nextDouble() * explosionPower;
                double speedX = speed * Math.cos(angle);
                double speedY = speed * Math.sin(angle);
                particles.add(new Particle(x, y, particleColor, 2, speedX, speedY, rand.nextDouble() * 1.0 + 0.5)); // Smaller balls (size 2)
            }
        }
        exploded = true;
    }

    void update() {
        if (!exploded) {
            y -= 4; // Faster upward movement
            if (y < 300) {
                explode();
            }
        } else {
            ArrayList<Particle> particlesToRemove = new ArrayList<>();
            for (Particle particle : particles) {
                particle.accelerationY = 0.05; // Add gravity effect
                particle.update();
                if (!particle.isAlive()) {
                    particlesToRemove.add(particle);
                }
            }
            particles.removeAll(particlesToRemove);
        }
    }
}

public class FireworksAnimation extends JPanel implements ActionListener {
    private ArrayList<Firework> fireworks = new ArrayList<>();
    private Timer timer;

    public FireworksAnimation() {
        timer = new Timer(30, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        updateFireworks();
        repaint();
    }

    private void updateFireworks() {
        Random rand = new Random();
        if (rand.nextInt(100) < 5) {
            int x = rand.nextInt(getWidth());
            int y = getHeight();
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            int size = 2; // Smaller initial ball size
            double explosionSize = size * 6; // Adjusted explosion size
            double explosionPower = rand.nextDouble() * 5.0 + 5.0;
            double launchAngle = rand.nextDouble() * 2 * Math.PI; // Random launch angle
            fireworks.add(new Firework(x, y, color, size, explosionSize, explosionPower, launchAngle));
        }

        ArrayList<Firework> fireworksToRemove = new ArrayList<>();
        for (Firework firework : fireworks) {
            firework.update();
            if (firework.exploded && firework.particles.isEmpty()) {
                fireworksToRemove.add(firework);
            }
        }

        fireworks.removeAll(fireworksToRemove);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the background to black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        drawFireworks(g);
    }

    private void drawFireworks(Graphics g) {
        for (Firework firework : fireworks) {
            if (!firework.exploded) {
                g.setColor(firework.color);
                g.fillOval(firework.x - firework.size / 2, firework.y - firework.size / 2, firework.size, firework.size);
            } else {
                for (Particle particle : firework.particles) {
                    List<Point> trail = particle.trail;
                    for (int i = 0; i < trail.size(); i++) {
                        Point point = trail.get(i);
                        int alpha = (int) (255 * ((double) i / Particle.TRAIL_LENGTH)); // Decreasing opacity
                        g.setColor(new Color(particle.color.getRed(), particle.color.getGreen(), particle.color.getBlue(), alpha));
                        int particleSize = (int) particle.size;
                        g.fillOval(point.x - particleSize / 2, point.y - particleSize / 2, particleSize, particleSize);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fireworks Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FireworksAnimation fireworksAnimation = new FireworksAnimation();
        frame.add(fireworksAnimation);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

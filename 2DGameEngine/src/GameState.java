import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class GameState implements State {

    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_W) {
        }
        if (key.getKeyCode() == KeyEvent.VK_A) {
        }
        if (key.getKeyCode() == KeyEvent.VK_S) {
            GamePanel.setState(new MenuState());
        }
        if (key.getKeyCode() == KeyEvent.VK_D) {
        }
        if (key.getKeyCode() == KeyEvent.VK_UP) {
        }
        if (key.getKeyCode() == KeyEvent.VK_LEFT) {
        }
        if (key.getKeyCode() == KeyEvent.VK_DOWN) {
        }
        if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
        }
        System.out.println("Key Pressed in Game");
    }

    public void keyReleased(KeyEvent key) {
    }

    public void keyTyped(KeyEvent key) {
    }

    public void update() {
    }

    public void render(Graphics2D g) {
        FontMetrics fontMetrics = g.getFontMetrics();
        setFontSize(g, 2f);

        g.setColor(Color.white);
        g.fillRect(0, 0, 500, 500);

        Rectangle menuText = getStringBounds(g, "Game State!", 250 - fontMetrics.stringWidth("Game State!"), 100);

        double rotValue = (Math.sin((double) System.currentTimeMillis() / 1000)) * .5f;
        double rotX = menuText.x + menuText.width / 2;
        double rotY = menuText.y + menuText.height / 2;

        g.setColor(Color.black);

        g.rotate(rotValue, rotX, rotY);
        g.drawString("Game State!", 250 - fontMetrics.stringWidth("Game State!"), 100);
        g.rotate(-rotValue, rotX, rotY);

        setFontSize(g, 0.5f);
    }
    
        Rectangle getStringBounds(Graphics2D g2, String str, float x, float y) {
        FontRenderContext frc = g2.getFontRenderContext();
        GlyphVector gv = g2.getFont().createGlyphVector(frc, str);
        return gv.getPixelBounds(null, x, y);
    }

    void setFontSize(Graphics2D g, float size) {
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * size);
        g.setFont(newFont);
    }
}

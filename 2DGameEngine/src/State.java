import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public interface State {
    
    public void update();
    public void render(Graphics2D g);
    public void keyPressed(KeyEvent key);
    public void keyReleased(KeyEvent key);
    public void keyTyped(KeyEvent key);
}

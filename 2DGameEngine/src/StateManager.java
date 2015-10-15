import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class StateManager implements State {
    
    private State currentState;
    
    public void setState(State state) {
        this.currentState = state;
    }

    public State getState() {
        return this.currentState;
    }

    public void update() {
        this.currentState.update();
    }

    public void render(Graphics2D g) {
        this.currentState.render(g);
    }

    public void keyPressed(KeyEvent key) {
        this.currentState.keyPressed(key);
    }

    public void keyReleased(KeyEvent key) {
        this.currentState.keyPressed(key);
    }

    public void keyTyped(KeyEvent key) {
        this.currentState.keyPressed(key);
    }
}

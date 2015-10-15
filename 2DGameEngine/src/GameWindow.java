import javax.swing.JFrame;


public class GameWindow extends JFrame{
	GamePanel panel;
	
	public GameWindow(String title, int w, int h)
	{
		JFrame window = new JFrame(title);
		window.setSize(w, h);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		panel = new GamePanel();
		
		window.add(panel);
                panel.run();
	}
}

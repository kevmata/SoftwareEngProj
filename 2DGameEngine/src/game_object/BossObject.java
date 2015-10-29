package game_object;

import java.awt.Graphics2D;

public class BossObject extends GameObject{

	public BossObject(int x, int y, int width, int height) {
		super(x, y, width, height);
		type = GameObject.BOSS_TYPE;
		health = 100;
	}
	
	public void update(){
		if(health <= 0){
			isAlive = false;
		}
	}
	
	public void render(Graphics2D g){
		g.drawImage(image, x, y, width, height, null);
	}
	
	public void collisionDetected(int type){
		if(type == GameObject.PROJECTILE_TYPE){
			health -= 10;
		}
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {

	int speed;
	boolean left = true;
	public Alien(int x,int y,int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = 5;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	void update(){
		super.update();	
		
		y++;
		
		if (x<=0) {
			left = false;
		}
		if (x>=450) {
			left = true;
		}
		if (left){
			x= x-new Random().nextInt(7);
		}
		else {
			x= x+new Random().nextInt(7);
		}
		

		}
	void draw(Graphics g){
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);

	}
}

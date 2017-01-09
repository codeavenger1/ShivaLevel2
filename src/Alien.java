import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	int speed;
	public Alien(int x,int y,int width, int height) {
		// TODO Auto-generated constructor stub
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
		}
	void draw(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);

	}
}

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	public Rocketship(int x,int y,int width, int height) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = 5;
	}
	
void update(){
	super.update();	
	}
	
void moveRight(){
	x+=speed;
}
void moveLeft(){
	x-=speed;
}
void moveDown(){
	y+=speed;
}
void moveUp(){
	y-=speed;
}
	void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

}

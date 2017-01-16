import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font titleF;
	Rocketship rocket=new Rocketship(250, 700, 50, 50);
	ObjectManagerFile manager = new ObjectManagerFile();
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public GamePanel() {
		// TODO Auto-generated constructor stub
		this.timer = new Timer(1000 / 60, this);
		this.titleFont = new Font("Copperplate", Font.PLAIN , 48 );
		this.titleF = new Font("Optima", Font.PLAIN, 36);
		manager.addObject(rocket);
		
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
//		String fonts[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//		for (int i = 0; i < fonts.length; i++) {
//			System.out.println(fonts[i]);
//		}
	}
	void updateMenuState() {

	}
	
	void drawMenuState(Graphics g){
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.drawString("LEAGUE INVADERS!", 20, 250);
		g.setFont(titleF);
		g.setColor(Color.RED);
		g.drawString("Press ENTER to start", 20, 350);
		g.setColor(Color.RED);
		g.drawString("Press SPACE for instructions", 20, 450);
	}
	
	void updateGameState() {
	manager.update();
	manager.manageEnemies();
	manager.checkCollision();
	if (!rocket.isAlive) {
		currentState = END_STATE;
		manager.reset();
		rocket = new Rocketship(250, 700, 50, 50);
		manager.addObject(rocket);
	}
	}

    void drawGameState(Graphics g){
    	g.setColor(Color.black);
    	g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
    	manager.draw(g);
    	
	}
	
	void updateEndState() {
		
	}
	
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.CYAN);
		g.drawString("GAME OVER :(", 20, 250);
		g.setFont(titleF);
		g.setColor(Color.yellow);
		g.drawString("You killed " + manager.getScore()+ " aliens.", 20, 350);
		g.setColor(Color.yellow);
		g.drawString("Press BACKSPACE to restart", 20, 450);
	}
	
	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}
repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyPressed");
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if(currentState > END_STATE){
			currentState = MENU_STATE;
		}}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RightKeyPressed");
				rocket.moveRight();
		}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LeftKeyPressed");
					rocket.moveLeft();
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DownKeyPressed");
					rocket.moveDown();
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UpKeyPressed");
					rocket.moveUp();
			}
			else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				System.out.println("PEW PEW PEW!!");
			manager.addObject(new Projectile(rocket.x+20, rocket.y, 10, 10));
			}
			else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
				currentState = GAME_STATE;
	
			}
			else if(e.getKeyCode() == KeyEvent.VK_SPACE){
				currentState = MENU_STATE;
				JOptionPane.showMessageDialog(null, "OH NO! The Aliens are here! Help save the planet! \n Use the arrow keys to move the rocketship. Press space to fire and kill the Aliens. \n  Hurry...before time runs out!");
			}
		updateGameState();
					}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased");
	}

}

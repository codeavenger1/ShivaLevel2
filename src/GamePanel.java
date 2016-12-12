import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import sun.applet.Main;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font titleF;
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
		this.timer = new Timer(1000 / 60, this);
		this.titleFont = new Font("Copperplate", Font.PLAIN , 48 );
		this.titleF = new Font("Optima", Font.PLAIN, 36);
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

	}

    void drawGameState(Graphics g){
    	g.setColor(Color.black);
    	g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
    	
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
		g.drawString("You killed 0 aliens.", 20, 350);
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
		repaint();
		
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}

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
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if(currentState > END_STATE){
			currentState = MENU_STATE;
		}

		}
					}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased");
	}

}

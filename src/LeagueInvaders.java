import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	static int height = 800;
	static int width = 500;
	GamePanel gameP;
	public LeagueInvaders() {
		this.frame = new JFrame();
		this.gameP = new GamePanel();
		setup();
	}

	public static void main(String[] args) {
	LeagueInvaders invaders = new LeagueInvaders();
	}

	void setup() {
		frame.add(gameP);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameP.startGame();
		frame.addKeyListener(gameP);
	}
}

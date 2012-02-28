package logic;

public class Game {
	Player player;
	
	public Game() {
		player = new Player();
	}
	
	public void update(float dt) {
		player.move(dt);
	}

	public Player getPlayer() {
		return player;
	}
}

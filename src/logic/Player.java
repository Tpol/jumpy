package logic;

public class Player {
	float posx, posy;
	float vx, vy;
	
	public float getPosx() {
		return posx;
	}
	public void setPosx(float posx) {
		this.posx = posx;
	}
	public float getPosy() {
		return posy;
	}
	public void setPosy(float posy) {
		this.posy = posy;
	}
	public float getVx() {
		return vx;
	}
	public void setVx(float vx) {
		this.vx = vx;
	}
	public float getVy() {
		return vy;
	}
	public void setVy(float vy) {
		this.vy = vy;
	}
	
	public void jump() {
		if(posy < 20)
			vy = 70;
	}
	
	public void move(float dt) {
		posx += vx*dt;
		posy += vy*dt;
		
		vy -= 9.81*dt;
		
		vx *= 0.9f;
		
		if(posy < 0) {
			posy = 0;
			vy *= -0.7f;
		}
	}
}

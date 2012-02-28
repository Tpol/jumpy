package gui;

import logic.Game;

import org.lwjgl.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.*;

public class JumpyGUI {
	public static final int RESX = 800;
	public static final int RESY = 600;
	
	Game game = new Game();
	
	void input() {
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			game.getPlayer().setVx(-20);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			game.getPlayer().setVx(20);
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			game.getPlayer().jump();
	}
	
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(RESX, RESY));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		game.getPlayer().setPosx(200);
		game.getPlayer().setPosy(400);
		game.getPlayer().setVx(5);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, RESX, 0, RESY, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		while (!Display.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			GL11.glPushMatrix();
			GL11.glTranslatef(game.getPlayer().getPosx(), game.getPlayer().getPosy(), 0);
			GL11.glScalef(20,20,1);
			
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex3f(-0.5f,-0.5f,0);
			GL11.glVertex3f(-0.5f,0.5f,0);
			GL11.glVertex3f(0.5f,0.5f,0);
			GL11.glVertex3f(0.5f,-0.5f,0);
			GL11.glEnd();
			
			GL11.glPopMatrix();
			
			Display.update();
			game.update(0.0056f);
			
			input();
		}

		Display.destroy();
	}

	public static void main(String[] args) {
		JumpyGUI gui = new JumpyGUI();
		gui.start();
	}
}
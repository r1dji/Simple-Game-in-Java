package lab3v1;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	
	protected int x, y;
	protected Color boja;
	
	public Objekat(int x, int y, Color boja) {
		this.x = x;
		this.y = y;
		this.boja = boja;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void pomeriX(int pomeraj) {
		this.x += pomeraj;
	}
	
	public void pomeriY(int pomeraj) {
		this.y += pomeraj;
	}
	
	public abstract void crtaj(Graphics g);
}

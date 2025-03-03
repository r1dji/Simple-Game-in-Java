package lab3v1;

import java.awt.Color;
import java.awt.Graphics;

public abstract class NebeskoTelo extends Objekat {
	
	protected int poluprecnik;
	
	public NebeskoTelo(int x, int y, Color boja, int r) {
		super(x, y, boja);
		poluprecnik = r;
	}

	@Override
	public abstract void crtaj(Graphics g);

}

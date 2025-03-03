package lab3v1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Kometa extends NebeskoTelo {
	
	private static final int brTemena = 5;
	private static final Color bojaKomete = Color.GRAY;
	
	private int[] nizX = new int[brTemena];
	private int[] nizY = new int[brTemena];
	
	public Kometa(int x, int y, int r) {
		super(x, y, bojaKomete, r);
		int pomUgao = (int)(new Random().nextDouble(2 * Math.PI));
		for (int i = 0; i < brTemena; i++) {
			nizX[i] = (int)(Math.cos((2 * Math.PI) / 5 * i + pomUgao) * poluprecnik);
			nizY[i] = (int)(Math.sin((2 * Math.PI) / 5 * i + pomUgao) * poluprecnik);
		}
	}

	@Override
	public void crtaj(Graphics g) {
		Color pretBoja = g.getColor();
		g.setColor(boja);
		g.translate(x, y);
		g.fillPolygon(nizX, nizY, brTemena);
		g.setColor(pretBoja);
	}
}

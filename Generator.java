package lab3v1;

import java.awt.Color;

public class Generator extends Thread {
	
	private Svemir svemir;
	
	public Generator(Svemir s) {
		svemir = s;
	}
	
	@Override
	public void run() {
		try {
			while (!(this.interrupted())) {
				Thread.sleep(900);
				Kometa kom = new Kometa((int)(Math.random()*(200-0+1)+0), 0, 
						(int)(Math.random()*(30-10+1)+10));
				synchronized (svemir) {
					svemir.dodaj(kom);
					svemir.notifyAll();
				}
			}
		}catch(InterruptedException e) {}
	}
	
	public void pokreni() {
		this.start();
	}
	
	public void zaustavi() {
		this.interrupt();
	}
}

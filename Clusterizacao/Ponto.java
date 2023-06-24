package Clusterizacao;
import java.util.Random;

public class Ponto {

	private int x;
	private int y;
	
	public Ponto(int n) {
		Random r = new Random();
		x = r.nextInt(n) + 1;
		y = r.nextInt(n) + 1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getCoordenada() {
		return "("+x+","+y+")";
	}
}

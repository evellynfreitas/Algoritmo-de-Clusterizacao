package Clusterizacao;
import java.util.Random;

public class Ponto {

	public int x;
	public int y;
	
	public Ponto(int n) {
		Random r = new Random();
		x = r.nextInt(n) + 1;
		y = r.nextInt(n) + 1;
	}
	
	public String getCoordenada() {
		return "("+x+","+y+")";
	}
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

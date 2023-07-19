package Heap;

public class Cluster{


	public double somaX=0;
	public double somaY=0;
	public int n=0;
	public Arvbin arvore;
	public int id;
	
	public Cluster(Cluster a, Cluster b, int i) {
		n = a.n + b.n;
		somaX= a.somaX + b.somaX;
		somaY= a.somaY + b.somaY;
		arvore = new Arvbin(this);
		id=i;
	}
	
	public Cluster(Ponto p, int i) {
		n = 1;
		somaX = p.x;
		somaY = p.y;
		arvore = new Arvbin(this);
		id=i;
	}
	
	public String printCluster() {
		String soma1 = String.format("%.2f", (somaX/n));
		String soma2 = String.format("%.2f", (somaY/n));

		return "(" + (soma1) + ", " + (soma2) + ")";
	}
	

}


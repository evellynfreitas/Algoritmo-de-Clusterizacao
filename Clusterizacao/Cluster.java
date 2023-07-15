package Clusterizacao;

public class Cluster{

	public double somaX=0;
	public double somaY=0;
	public int n=0;
	
	public Cluster(Cluster a, Cluster b) {
		n = a.n + b.n;
		somaX= a.somaX + b.somaX;
		somaY= a.somaY + b.somaY;
	}
	
	public Cluster(Ponto p) {
		n = 1;
		somaX = p.x;
		somaY = p.y;
	}
	
	public String printCluster() {
		return "Cluster (" + (somaX/n) + ", " + (somaY/n) + ")";
	}

}

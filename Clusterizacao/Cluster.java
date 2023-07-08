package Clusterizacao;

public class Cluster {

	public Ponto[] pontos;
	public int somaX;
	public int somaY;
	public int n;
	
	public Cluster(int qtd, Ponto[] p) {
		n = qtd;
		pontos = new Ponto[n];
		somaX=0;
		somaY=0;
		
		for(int i=0; i<qtd; i++) {
			pontos[i] = p[i];
			somaX += pontos[i].x;
			somaY += pontos[i].y;
		}
	}
	
	public Cluster(Ponto p) {
		n = 1;
		pontos = new Ponto[1];
		somaX=0;
		somaY=0;
		
		pontos[0] = p;
		somaX += p.x;
		somaY += p.y;
		
	}
	
	public void printCluster() {
		System.out.print("\nCluster: ");
		for(int i=0; i<n; i++) System.out.print(pontos[i].getCoordenada() + " ");
	}
}

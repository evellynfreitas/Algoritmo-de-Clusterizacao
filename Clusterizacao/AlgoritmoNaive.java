package Clusterizacao;

public class AlgoritmoNaive {

	public Ponto[] pontos;
	public Cluster[] clusters;
	public int n;
	
	
	public AlgoritmoNaive(int qtd) {
		
		n = qtd;
		pontos = new Ponto[n];
		clusters = new Cluster[n];
		
		for(int i=0; i<n; i++) {
			pontos[i] = new Ponto(n);
			clusters[i] = new Cluster(pontos[i]);
		}
	}
	
	public Diferenca menor() {
		
		Diferenca menor = new Diferenca(clusters[0], 0, clusters[1], 1);
		for(int a=0; a<n-1; a++)
		{
			for(int b=a+1; b<n; b++)
			{
				Diferenca dif = new Diferenca(clusters[a], a, clusters[b], b);
				if(dif.diferenca < menor.diferenca)
					menor = dif;
			}
		}
		
		return menor;
	}
	
	public void clusterizacao() {
		for(int i=0; i<n; i++) clusters[i].printCluster();
		
		Diferenca menor = menor();
		
		System.out.println("\n\nMenor - Diferenca: " + menor.diferenca);
		menor.a.printCluster();
		menor.b.printCluster();
		
	}
	
	public static void main(String[] args) {
		AlgoritmoNaive teste = new AlgoritmoNaive(10);
		teste.clusterizacao();
	}
}

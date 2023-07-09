package Clusterizacao;

public class AlgoritmoNaive {

	public Ponto[] pontos;
	public Cluster[] clusters;
	public int n;
	public int tam;
	
	public AlgoritmoNaive(int qtd) {
		n = qtd;
		pontos = new Ponto[n];
		tam = n*2 -1;
		clusters = new Cluster[tam];
		
		for(int i=0; i<n; i++) {
			pontos[i] = new Ponto(n);
			clusters[i] = new Cluster(pontos[i]);
		}
	}
	
	public Diferenca menor() {
		
		Diferenca menor = new Diferenca();
		for(int a=0; a<n-1; a++)
		{
			if(clusters[a].ativo) {
				
				for(int b=a+1; b<n; b++)
				{
					if(clusters[b].ativo) {
						Diferenca dif = new Diferenca(clusters[a], a, clusters[b], b);
						if(dif.diferenca < menor.diferenca)
							menor = dif;
					}
				}
			}
			
		}
		
		return menor;
	}
	
	public void clusterizacao() {
		
		for(int i=0; i<n; i++) System.out.println(clusters[i].printCluster());
		
		while(n < tam) {
			Diferenca menor = menor();
			System.out.println("Menor - Diferenca: " + menor.diferenca + menor.a.printCluster() + menor.b.printCluster() );

			Cluster c = new Cluster(menor.a, menor.b);
			clusters[n] = c;
			clusters[menor.indiceA].ativo = false;
			clusters[menor.indiceB].ativo = false;
			System.out.println(c.printCluster());
			n++;
		}
		
		System.out.println("---------------------");
		System.out.println(clusters[n-1].printCluster());
	}
	
	public static void main(String[] args) {
		AlgoritmoNaive teste = new AlgoritmoNaive(10);
		teste.clusterizacao();
	}
}

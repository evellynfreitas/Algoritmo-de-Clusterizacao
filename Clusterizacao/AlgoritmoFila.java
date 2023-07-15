package Clusterizacao;

public class AlgoritmoFila {

	public Ponto[] pontos;
	public Cluster[] clusters;
	public int n;
	public HeapBinariaMinima fila;
	
	public AlgoritmoFila(int qtd) {
		n = qtd;
		pontos = new Ponto[n];
		clusters = new Cluster[n];
		fila = new HeapBinariaMinima(n);
				
		for(int i=0; i<n; i++) {
			pontos[i] = new Ponto(n);
			clusters[i] = new Cluster(pontos[i]);
		}
	}
	
	
	public void clusterizacao() {
		
		for(int i=0; i<n; i++){
			System.out.println(clusters[i].printCluster());
		}
		
		fila.constroiHeap(clusters,n);

		while(n > 1){
			
			Diferenca menor = fila.removeMin();
			Cluster c = new Cluster(menor.a, menor.b);
			c.arvore.esq = clusters[menor.indiceA].arvore;
			c.arvore.dir = clusters[menor.indiceB].arvore;
			
			if(menor.indiceA == n-1)
				clusters[menor.indiceB] = c;
			else if(menor.indiceB == n-1)
				clusters[menor.indiceA] = c;
			else {
				Cluster ult = clusters[n-1]; 	//pega a última posição
				clusters[menor.indiceA] = ult;	//joga o último para outra posição
				clusters[menor.indiceB] = c;	//joga o novo cluster para a outra posição
			}
			
			n--;
		}
		
		System.out.println(clusters[n-1].printCluster());
		System.out.println(clusters[n-1].arvore.contaNos());
		
	}
	
	public static void main(String[] args) {
		AlgoritmoFila teste = new AlgoritmoFila(10);
		teste.clusterizacao();
	}
}

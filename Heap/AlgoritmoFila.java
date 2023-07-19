package Heap;

public class AlgoritmoFila {

	public Ponto[] pontos;
	public Cluster[] clusters;
	public int n;
	public Heap fila;
	public int id=0;
	
	public AlgoritmoFila(int qtd) {
		n = qtd;
		pontos = new Ponto[n];
		clusters = new Cluster[n];
		
		for(int i=0; i<n; i++) {
			pontos[i] = new Ponto(n);
			clusters[i] = new Cluster(pontos[i],id++);
		}
	}
	
	
	public void clusterizacao() {
		long inicio = System.nanoTime();

		fila = new Heap(n, clusters);
		while(n > 1) {
			
			Diferenca menor = fila.vetor[1];
			Cluster novo = new Cluster(menor.a, menor.b, id++);
			novo.arvore.esq = menor.a.arvore;
			novo.arvore.dir = menor.b.arvore;
			
			Cluster aux[] = new Cluster[n-1];
			Diferenca difs[] = new Diferenca[n-2];
			
			aux[0] = novo;
			
			int indice=0;
			for(int i=0; i<n; i++) {
				
				if(!menor.contem(clusters[i])) {
					difs[indice] = new Diferenca(novo, clusters[i]);
					aux[++indice] = clusters[i];
				}
			}
			clusters = aux;
			n--;
			fila.recalculaDistancias(difs);
		}
		
		long fim = System.nanoTime();
		 
        // obtém a diferença entre os dois valores de tempo nano
        long tempo = fim - inicio;
        
        System.out.println("-------------------------------");
        System.out.println("Tempo em nanosegundos: " + tempo);
        System.out.println("Tempo em millisegundos: " + (tempo / 1000000));
		System.out.println("-------------------------------");
		
		
		System.out.println(clusters[n-1].printCluster());
	}
}

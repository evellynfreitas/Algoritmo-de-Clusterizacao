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
		
		Diferenca menor = new Diferenca();
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
		
		for(int i=0; i<n; i++) System.out.println(clusters[i].printCluster());
		long inicio = System.nanoTime();
		
		while(n > 1) {
			Diferenca menor = menor();
			//System.out.println("Menor - Diferenca: " + menor.diferenca + menor.a.printCluster() + menor.b.printCluster() );

			Cluster c = new Cluster(menor.a, menor.b);
			
			if(menor.indiceA == n-1)
				clusters[menor.indiceB] = c;
			else if(menor.indiceB == n-1)
				clusters[menor.indiceA] = c;
			else {
				Cluster ult = clusters[n-1]; 	//pega a última posição
				clusters[menor.indiceA] = ult;	//joga o último para outra posição
				clusters[menor.indiceB] = c;	//joga o novo cluster para a outra posição
			}
			
			n--; // passa a disconsiderar a última posição
			//System.out.println(c.printCluster());
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
	
	public static void main(String[] args) {
		AlgoritmoNaive teste = new AlgoritmoNaive(10);
		teste.clusterizacao();
	}
}

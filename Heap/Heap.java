package Heap;

public class Heap {

	public int n;
	public int tam;
	public Diferenca[] vetor;
	
	
	public Heap(int tamanho, Cluster[] c)
	{
		n = tamanho;
		constroiHeap(c, n);
	}
	
	public void constroiHeap(Cluster[] c, int n) {
		
		tam = (n * (n-1))/2;
		vetor = new Diferenca[tam + 1];
		
		int cont=1;
		
		for(int a=0; a<n-1; a++)
		{
			for(int b=a+1; b<n; b++)
			{
				
				Diferenca dif = new Diferenca(c[a],c[b]);
				vetor[cont] = dif;
				cont++;
			}
		}
		constroiHeap();
	}
	
	private void constroiHeap()
	{
		for( int i = tam / 2; i > 0; i-- )
			refaz(i);
	}

	private void refaz(int i)
	{
		Diferenca dif = vetor[ i ];

		while(2*i <= tam)
		{
			int filhoEsq, filhoDir, menorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o menor filho é o da esquerda. */
			menorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= tam)
			{
				 /* Em caso positivo, verifica se é menor que o filho esquerdo. */
				if(vetor[ filhoDir ].diferenca < vetor[ filhoEsq ].diferenca)
					menorFilho = filhoDir;
			}

			/* Compara o valor do menor dos filhos com x. */
			if(vetor[ menorFilho ].diferenca < dif.diferenca)
				vetor [ i ] = vetor[ menorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posição "i" desceu para o nível de baixo, a próxima
			 * iteração vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posição "menorFilho") com um de seus novos filhos. */
			i = menorFilho;
		}
		
		vetor[ i ] = dif;
	}

	
	
	public void recalculaDistancias(Diferenca[] d) {
		Diferenca menor = vetor[1];
		
		n--;
		tam -= n;
		
		int t = tam+1;
		Diferenca[] aux = new Diferenca[t];
		

		for(int i=0; i<d.length; i++) {
			aux[i+1] = d[i];
		}
		
		int indice = d.length;
		
		for(int i=1; i<vetor.length; i++) {
			Diferenca dif = vetor[i];
			
			if(!dif.contem(menor.a) && !dif.contem(menor.b)) {
				indice++;
				aux[indice] = vetor[i];
			}
		}
		vetor = aux;
		
		constroiHeap();
		
	}
	
}

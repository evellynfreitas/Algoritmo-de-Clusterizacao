package Clusterizacao;
public class HeapBinariaMinima
{
	public int n;
	public int tam;
	public Diferenca vetor[];
	
	
	public HeapBinariaMinima(int tamanho)
	{
		n = 0;
		tam = tamanho*tamanho;
		vetor = new Diferenca[tam+1];
	}

	public void constroiHeap(Cluster c[], int n) {
		for(int a=0; a<n-1; a++)
		{
			for(int b=a+1; b<n; b++)
			{
				Diferenca dif = new Diferenca(c[a], a, c[b], b);
				insere(dif);
			}
		}
	}
	
	public boolean vazia()
	{
		return n == 0;
	}

	public void fazVazia()
	{
		n = 0;
	}

	public void imprime()
	{
		System.out.print("Conteúdo da heap: ");
		
		for(int i = 1; i <= n; i++)
			System.out.print(vetor[i] + " ");

		System.out.println();
	}

	public Diferenca min()
	{
		return vetor[1];
	}

	public Diferenca removeMin()
	{
		Diferenca itemMin;

		itemMin = vetor[1];
		vetor[1] = vetor[n];
		n--;
		refaz(1);
		
		return itemMin;
	}

	private void refaz(int i)
	{
		Diferenca x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, menorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			menorFilho = filhoEsq;
			
			if(filhoDir <= n)
			{
				if(vetor[ filhoDir ].diferenca < vetor[ filhoEsq ].diferenca)
					menorFilho = filhoDir;
			}

			if(vetor[ menorFilho ].diferenca < x.diferenca)
				vetor [ i ] = vetor[ menorFilho ];
			else
				break;
			
			i = menorFilho;
		}
		
		vetor[ i ] = x;
	}

	public void insere(Diferenca x)
	{
		n++;
		int pos = n;
		
		vetor[0] = x;

		if(this.vazia())
			vetor[pos] = x;
		
		else {
			
			while(x.diferenca < vetor[pos/2].diferenca)
			{
				vetor[pos] = vetor[ pos/2 ];
				pos /= 2;
			}
			
			vetor[pos] = x;
		}
	}

}
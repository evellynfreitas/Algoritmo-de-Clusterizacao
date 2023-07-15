package Clusterizacao;

public class Arvbin
{
	public Cluster raiz;
	public Arvbin esq, dir;

	public Arvbin(Cluster no)
	{
		raiz = no;
		esq = null;
		dir = null;
	}

	public Arvbin(Cluster no, Arvbin arvEsq, Arvbin arvDir)
	{
		raiz = no;
		esq = arvEsq;
		dir = arvDir;
	}

	public Cluster retornaRaiz()
	{
		return raiz;
	}

	public Arvbin retornaEsq()
	{
		return esq;
	}

	public Arvbin retornaDir()
	{
		return dir;
	}

	public void defineRaiz(Cluster no)
	{
		raiz = no;
	}

	public void defineEsq(Arvbin filho)
	{
		esq = filho;
	} 

	public void defineDir(Arvbin filho)
	{
		dir = filho;
	}

	public void mostra()
	{
		System.out.print("[" + raiz.printCluster());
		if (esq != null)
			esq.mostra();
		if (dir != null)
			dir.mostra();
		System.out.print("]");
	}

	public int contaNos()
	{
		if((esq == null) && (dir == null))
			return 1;
		
		int nosEsq = 0, nosDir = 0;
		
		if(esq != null)
			nosEsq = esq.contaNos();
		
		if(dir != null)
			nosDir = dir.contaNos();
		
		return 1 + nosEsq + nosDir;
	}


}
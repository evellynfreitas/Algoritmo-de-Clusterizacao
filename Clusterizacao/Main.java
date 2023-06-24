package Clusterizacao;

public class Main {
	
	public static void main(String args[]) {
		
		int n = 10;
		Ponto[] pontos = new Ponto[n];
		for(int i=0; i<n; i++) pontos[i] = new Ponto(n);
		
		int i=0;
		for(int f=1; f<n; f++)
			i+=f;
		
		
		Diferenca[] diferencas = new Diferenca[i];
		int index = -1;
		
		for(int a=0; a<n-1; a++)
		{
			for(int b=a+1; b<n; b++)
			{
				index++;
				diferencas[index] = new Diferenca(pontos[a], pontos[b]);
				System.out.println("A: " + diferencas[index].getA() + " B: " + diferencas[index].getB() + " Dif: " + diferencas[index].getDiferenca());
			}
		}
	}

}

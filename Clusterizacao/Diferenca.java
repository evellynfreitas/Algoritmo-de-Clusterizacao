package Clusterizacao;
import java.lang.Math;

public class Diferenca {

	public Cluster a;
	public Cluster b;
	public double diferenca;
	public int indiceA;
	public int indiceB;
	
	public Diferenca(Cluster p1, int indiceP1, Cluster p2, int indiceP2) {
		a = p1;
		b = p2;
		indiceA = indiceP1;
		indiceB = indiceP2;
		
		Ponto centroA = new Ponto( (a.somaX / a.n), (a.somaY / a.n) );
		Ponto centroB = new Ponto( (b.somaX / b.n), (b.somaY / b.n) );

		diferenca = Math.pow(centroA.x - centroB.x, 2) + Math.pow(centroA.y - centroB.y, 2);
		diferenca = Math.sqrt(diferenca);
	}
	
	public Diferenca() {
		diferenca = Integer.MAX_VALUE;
	}
	
	public boolean contem(Cluster c) {
		if(c.somaX/c.n == a.somaX/a.n && c.somaY/c.n == a.somaY/a.n)
			return true;
		else if(c.somaX/c.n == b.somaX/b.n && c.somaY/c.n == b.somaY/b.n)
			return true;
		else
			return false;
	}
}
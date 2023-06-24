package Clusterizacao;
import java.lang.Math;

public class Diferenca {

	private Ponto a;
	private Ponto b;
	private double diferenca;
	
	public Diferenca(Ponto p1, Ponto p2) {
		a = p1;
		b = p2;
		diferenca = (a.getX() - b.getX()) + (a.getY() - b.getY());
		diferenca = Math.sqrt(Math.abs(diferenca));
	}
	
	public double getDiferenca() {
		return diferenca;
	}
	
	public String getA() {
		return a.getCoordenada();
	}
	
	public String getB() {
		return b.getCoordenada();
	}
}

package br.ufrn.imd.modelo;

public class Node {
	
	public int valor;
	public Node dir;
	public Node esq;
	public int numNodeDir;
	public int numNodeEsq;
	public int lvl;
	public int h;
	
	public Node(int v) {
		this.valor = v;
		dir = null;
		esq = null;
		numNodeDir = 0;
		numNodeEsq = 0;
		lvl = 1;
		h = 1;
	}

}

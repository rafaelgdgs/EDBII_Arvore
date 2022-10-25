package br.ufrn.imd.modelo;

public class Tree {

	public Node raiz;
	
	public Tree(Node r) {
		this.raiz = r;
	}
	
	public int enesimoElemento(int n) {
		return 0;
	}
	
	public int posicao(int x) {
		return 0;
	}
	
	public int mediana() {
		return 0;
	}
	
	public double media(int x) {
		return 0;
	}
	
	public boolean ehCheia() {
		return true;
	}
	
	public boolean ehCompleta() {
		return true;
	}
	
	public String pre_ordem() {
		String res = new String();
		res = pre_ordem_rec(raiz, res);
		return res;
	}
	
	static String pre_ordem_rec(Node n, String s) {
		s = s.concat(String.valueOf(n.valor) + " ");
		if (n.esq != null) {
			s = pre_ordem_rec(n.esq, s);
		}
		if (n.dir != null) {
			s = pre_ordem_rec(n.dir, s);
		}
		return s;
	}
	
	public void imprimeArvore(int s) {
		
	}

}

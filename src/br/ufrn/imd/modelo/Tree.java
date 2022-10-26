package br.ufrn.imd.modelo;

public class Tree {

	public Node raiz;
	
	public Tree(Node r) {
		this.raiz = r;
	}
	
	public int enesimoElemento(int n) {
		if (n > (raiz.numNodeEsq + raiz.numNodeDir + 1) || n < 1) {
			return -1;
		}
		Node current = raiz;
		int pos = current.numNodeEsq + 1;
		while(pos != n) {
			if (n < pos) {
				// current.esq == null?
				current = current.esq;
				pos -= current.numNodeDir+1;
			}
			else {
				current = current.dir;
				pos += current.numNodeEsq+1;
			}
		}
		return current.valor;
	}
	
	public int posicao(int x) {
		return posicaoRec(x, raiz, raiz.numNodeEsq+1);
	}
	
	static int posicaoRec(int x, Node n, int pos) {
		int xpos = -1;
		if (n.valor == x) {
			return pos;
		}
		if (n.esq != null && xpos == -1) {
			xpos = posicaoRec(x, n.esq, pos-n.esq.numNodeDir-1);
		}
		if (n.dir != null && xpos == -1) {
			xpos = posicaoRec(x, n.dir, pos+n.dir.numNodeEsq+1);
		}
		return xpos;
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
		//return (res == null || res.isEmpty()) ? res : (res.substring(0, res.length() - 1));
		return (res.endsWith(" ")) ? (res.substring(0, res.length() - 1)) : res;
	}
	
	static String pre_ordem_rec(Node n, String s) {
		s += String.valueOf(n.valor) + " ";
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

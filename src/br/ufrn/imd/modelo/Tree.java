package br.ufrn.imd.modelo;

public class Tree {

	public Node raiz;
	
	public Tree() {
		this.raiz = null;
	}
	
	public String simetrica() {
		String res = new String();
		res = simetricaRec(raiz, res);
		return (res.endsWith(" ")) ? (res.substring(0, res.length() - 1)) : res;
	}
	
	static String simetricaRec(Node n, String s) {
		if (n.esq != null) {
			s = simetricaRec(n.esq, s);
		}
		s += String.valueOf(n.valor) + " ";
		if (n.dir != null) {
			s = simetricaRec(n.dir, s);
		}
		return s;
	}
	
	public Node buscar(int x) {
		return (buscarRec(raiz, x));
	}
	
	static Node buscarRec(Node n, int x) {
		if (n == null || n.valor == x) {
			return n;
		}
		if (x < n.valor) {
			return buscarRec(n.esq, x);
		}
		return buscarRec(n.dir, x);
	}
	
	public void inserir(int v) {
		//alterar numNodeEsq e numNodeDir
		raiz = inserirRec(raiz, v);
	}
	
	static Node inserirRec(Node n, int x) {
		if (n == null) {
			n = new Node(x);
			return n;
		}
		else if (x < n.valor) {
			n.esq = inserirRec(n.esq, x);
			n.numNodeEsq++;
		}
		else if (x > n.valor) {
			n.dir = inserirRec(n.dir, x);
			n.numNodeDir++;
		}
		return n;
	}
	
	public void remover(int x) {
		
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
		return (medianaRec(raiz, 0, 0).valor);
	}
	
	static Node medianaRec(Node n, int esq, int dir) {
		if (n.numNodeEsq + esq == n.numNodeDir + dir) {
			return n;
		}
		else if (n.numNodeEsq + esq > n.numNodeDir + dir) {
			return medianaRec(n.esq, esq, n.numNodeDir+1 + dir);
		}
		else if (n.numNodeEsq + esq < n.numNodeDir + dir) {
			return medianaRec(n.dir, n.numNodeEsq+1 + esq, dir);
		}
		return null;
	}
	
	public double media(int x) {
		Node r = buscarRec(raiz, x);
		System.out.println("achou " + r.valor);
		return mediaNode(r)/(r.numNodeEsq + r.numNodeDir + 1);
	}
	
	static double mediaNode(Node n) {
		if (n == null) {
			return 0;
		}
		double v = 0;
		if (n.esq != null) {
			v += mediaNode(n.esq);
		}
		if (n.dir != null) {
			v += mediaNode(n.dir);
		}
		v += n.valor;
		return v;
	}
	
	public boolean ehCheia() {
		return ehCheiaRec(raiz);
	}
	
	static boolean ehCheiaRec(Node n) {
		if (n.numNodeEsq != n.numNodeDir) {
			return false;
		}
		if (n.numNodeEsq == 0) {
			return true;
		}
		if (!ehCheiaRec(n.esq)) {
			return false;
		}
		if (!ehCheiaRec(n.dir)) {
			return false;
		}
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

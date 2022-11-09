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
	
	public boolean inserir(int v) {
		if (raiz == null) {
			raiz = new Node(v);
			return true;
		}
		return inserirRec(raiz, v, 1);
	}
	
	static boolean inserirRec(Node n, int x, int h) {
		if (n.valor == x) {
			return false;
		}
		else if (x < n.valor) {
			if (n.esq == null) {
				n.esq = new Node(x);
				n.esq.lvl = h + 1;
				n.numNodeEsq++;
				if (n.dir == null) {
					n.h = 2;
				}
				else {
					n.h = n.dir.h + 1;
				}
				return true;
			}
			else if (inserirRec(n.esq, x, ++h)) {
				n.numNodeEsq++;
				if (n.dir == null) {
					n.h = n.esq.h + 1;
				}
				else {
					n.h = n.dir.h > n.esq.h ? n.dir.h + 1 : n.esq.h + 1;
				}
				return true;
			}
		}
		else if (x > n.valor) {
			if (n.dir == null) {
				n.dir = new Node(x);
				n.dir.lvl = h + 1;
				n.numNodeDir++;
				if (n.esq == null) {
					n.h = 2;
				}
				else {
					n.h = n.esq.h + 1;
				}
				return true;
			}
			else if (inserirRec(n.dir, x, ++h)) {
				n.numNodeDir++;
				if (n.esq == null) {
					n.h = n.dir.h + 1;
				}
				else {
					n.h = n.dir.h > n.esq.h ? n.dir.h + 1 : n.esq.h + 1;
				}
				return true;
			}
		}
		return false;
	}
	
	
	public boolean remover(int x) {
		int temp;
		temp = removerRec(raiz, x);
		if (temp == 2) {
			if (raiz.dir == null && raiz.esq == null) {
				raiz = null;
				return true;
			}
			else {
				if (raiz.esq == null) {
					raiz = raiz.dir;
					return true;
				}
				else if (raiz.dir == null) {
					raiz = raiz.esq;
					return true;
				}
				int va = raiz.esq.valor;
				Node no = raiz.esq;
				Node no1 = null;
				while (no.dir != null) {
					va = no.dir.valor;
					no.numNodeDir--;
					no1 = no;
					no = no.dir;
				}
				if (no.esq != null) {
					
				}
				raiz.valor = va;
				raiz.numNodeEsq--;
				if (no1 != null) {
					if (no.esq != null) {
						no1.dir = no.esq;
					}
					else {
						no1.dir = null;
					}
				}
				return true;
			}
		}
		else if (temp > 0) {
			return true;
		}
		return false;
	}
	
	static int removerRec(Node n, int x) {
		int temp;
		if ((x < n.valor && n.esq == null) || (x > n.valor && n.dir == null)) {
			return 0;
		}
		if (x < n.valor && (temp = removerRec(n.esq, x)) > 0) {
			n.numNodeEsq--;
			if (temp > 1) {
				remover3caso(n, 1);
			}
			return 1;
		}
		else if (x > n.valor && (temp = removerRec(n.dir, x)) > 0) {
			n.numNodeDir--;
			if (temp > 1) {
				remover3caso(n, 2);
			}
			return 1;
		}
		else if (x == n.valor){
			return 2;
		}
		return 0;
		
		
//		if (n == null) {
//			return n;
//		}
//		if (x < n.valor) {
//			n.esq = removerRec(n.esq, x);
//		}
//		else if (x > n.valor) {
//			n.dir = removerRec(n.dir, x);
//		}
//		else {
//			if (n.esq == null) {
//				return n.dir;
//			}
//			else if (n.dir == null) {
//				return n.esq;
//			}
//			
//			int va = n.dir.valor;
//			Node no = n.dir;
//			while (no.esq != null) {
//				va = no.esq.valor;
//				//no.numNodeEsq--;
//				no = no.esq;
//			}
//			n.valor = va;
//			//n.numNodeDir--;
//			n.dir = removerRec(n.dir, n.valor);
//			
//		}
//		return n;
	}
	
	static void remover3caso(Node n, int side) {
		if (side == 1) {
			if (n.esq.dir == null && n.esq.esq == null) {
				n.esq = null;
				return;
			}
			else if (n.esq.esq == null) {
				n.esq = n.esq.dir;
				return;
			}
			else if (n.esq.dir == null) {
				n.esq = n.esq.esq;
				return;
			}
			
			int va = n.esq.valor;
			Node no = n.esq;
			Node no1 = null;
			while (no.esq != null) {
				va = no.esq.valor;
				no.numNodeEsq--;
				no1 = no;
				no = no.esq;
			}
			n.esq.valor = va;
			if (no1 != null) {
				if (no.dir != null) {
					no1.esq = no.dir;
				}
				else {
					no1.esq = null;
				}
			}
			return;
		}
		else if (side == 2) {
			if (n.dir.dir == null && n.dir.esq == null) {
				n.dir = null;
				return;
			}
			else if (n.dir.esq == null) {
				n.dir = n.dir.dir;
				return;
			}
			else if (n.dir.dir == null) {
				n.dir = n.dir.esq;
				return;
			}
			int va = n.dir.valor;
			Node no = n.dir;
			Node no1 = null;
			while (no.esq != null) {
				va = no.esq.valor;
				no.numNodeEsq--;
				no1 = no;
				no = no.esq;
			}
			n.dir.valor = va;
			if (no1 != null) {
				if (no.dir != null) {
					no1.esq = no.dir;
				}
				else {
					no1.esq = null;
				}
			}
			return;
		}
		return;
	}
	
	public int enesimoElemento(int n) {
		if (n > (raiz.numNodeEsq + raiz.numNodeDir + 1) || n < 1 || raiz == null) {
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
//		return (medianaRec(raiz, 0, 0).valor);
		int total = raiz.numNodeDir + raiz.numNodeEsq + 1;
		return (total % 2 == 0) ? enesimoElemento(total/2) : enesimoElemento(total/2 + 1);
	}
	
//	static Node medianaRec(Node n, int esq, int dir) {
		
//		if (n.numNodeEsq + esq == n.numNodeDir + dir) {
//			return n;
//		}
//		else if (n.numNodeEsq + esq > n.numNodeDir + dir) {
//			return medianaRec(n.esq, esq, n.numNodeDir+1 + dir);
//		}
//		else if (n.numNodeEsq + esq < n.numNodeDir + dir) {
//			return medianaRec(n.dir, n.numNodeEsq+1 + esq, dir);
//		}
//		return null;
//	}S
	
	public double media(int x) {
		Node r = buscarRec(raiz, x);
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
		if (raiz == null) {
			return false;
		}
		return ehCompletaRec(raiz, raiz.h);
	}
	
	static boolean ehCompletaRec(Node n, int h) {
		if (n.esq != null && n.dir != null) {
			if (!ehCompletaRec(n.esq, h)) {
				return false;
			}
			if (!ehCompletaRec(n.dir, h)) {
				return false;
			}
		}
		else if (h - n.lvl > 1) {
			return false;
		}
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
		if (s == 1) {
			int spaceSize = 3;
			String spaceType = "-";
			int base = 10;
			if (raiz == null) {
				System.out.println("Arvore Vazia!");
				return;
			}
			imprimeArvore1Rec(raiz, spaceSize, spaceType, raiz.h, base);
		}
		else if (s == 2) {
			if (raiz == null) {
				System.out.println("Arvore Vazia!");
				return;
			}
			imprimeArvore2Rec(raiz);
			System.out.println();
		}
		return;
	}
	
	static void imprimeArvore1Rec(Node n, int s, String t, int startSize, int base) {
//		System.out.println(space.repeat(startSize * s - n.ih * s) + n.valor + t.repeat(n.ih * s + 5));
		//System.out.println(" ".repeat((n.lvl-1) * s) + n.valor + t.repeat((startSize - n.lvl) * s + base - String.valueOf(n.valor).length()));
		System.out.println(" ".repeat((n.lvl-1) * s) + n.valor + " " + n.numNodeEsq + " " + n.numNodeDir + t.repeat((startSize - n.lvl) * s + base - String.valueOf(n.valor).length()));
		if (n.esq != null) {
			imprimeArvore1Rec(n.esq, s, t, startSize, base);
		}
		if (n.dir != null) {
			imprimeArvore1Rec(n.dir, s, t, startSize, base);
		}
	}
	
	static void imprimeArvore2Rec(Node n) {
		System.out.print("(" + n.valor);
		if (n.esq != null) {
			imprimeArvore2Rec(n.esq);
		}
		if (n.dir != null) {
			imprimeArvore2Rec(n.dir);
		}
		System.out.print(")");
	}

}

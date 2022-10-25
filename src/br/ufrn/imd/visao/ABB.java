package br.ufrn.imd.visao;

import br.ufrn.imd.modelo.Node;
import br.ufrn.imd.modelo.Tree;

public class ABB {

	public static void main(String[] args) {
		Tree t = new Tree(new Node(10));
		t.raiz.esq = new Node(2);
		t.raiz.esq.esq = new Node(3);
		t.raiz.esq.esq.dir = new Node(4);
		t.raiz.esq.dir = new Node(5);
		t.raiz.dir = new Node(6);
		t.raiz.dir.esq = new Node(7);
		t.raiz.dir.dir = new Node(8);
		t.raiz.dir.dir.esq = new Node(9);
		
		System.out.println(t.pre_ordem());
	}

}

package br.ufrn.imd.visao;

import br.ufrn.imd.modelo.Node;
import br.ufrn.imd.modelo.Tree;

public class ABB {

	public static void main(String[] args) {
//		Tree t = new Tree(new Node(8));
//		t.raiz.esq = new Node(3);
//		t.raiz.esq.esq = new Node(1);
//		t.raiz.esq.dir = new Node(6);
//		t.raiz.esq.dir.esq = new Node(4);
//		t.raiz.esq.dir.dir = new Node(7);
//		t.raiz.dir = new Node(10);
//		t.raiz.dir.dir = new Node(14);
//		t.raiz.dir.dir.esq = new Node(13);
		
//		t.raiz.numNodeEsq = 5;
//		t.raiz.numNodeDir = 3;
//		t.raiz.esq.numNodeEsq = 1;
//		t.raiz.esq.numNodeDir = 3;
//		t.raiz.esq.esq.numNodeEsq = 0;
//		t.raiz.esq.esq.numNodeDir = 0;
//		t.raiz.esq.dir.numNodeEsq = 1;
//		t.raiz.esq.dir.numNodeDir = 1;
//		t.raiz.esq.dir.esq.numNodeEsq = 0;
//		t.raiz.esq.dir.esq.numNodeDir = 0;
//		t.raiz.esq.dir.dir.numNodeEsq = 0;
//		t.raiz.esq.dir.dir.numNodeDir = 0;
//		t.raiz.dir.numNodeEsq = 0;
//		t.raiz.dir.numNodeDir = 2;
//		t.raiz.dir.dir.numNodeEsq = 1;
//		t.raiz.dir.dir.numNodeDir = 0;
//		t.raiz.dir.dir.esq.numNodeEsq = 0;
//		t.raiz.dir.dir.esq.numNodeDir = 0;
		
		
//		System.out.println("pre_ordem: " + t.pre_ordem());
//		System.out.println("simetrica: " + t.simetrica());
//		System.out.println("enesimoElemento: " + t.enesimoElemento(5));
//		System.out.println("posicao: " + t.posicao(8));
//		System.out.println("buscar: " + t.buscar(10).valor);
//		//t.inserir(11);
//		System.out.println("nova simetrica: " + t.simetrica());
//		System.out.println("media: " + t.media(14));
//		System.out.println("mediana: " + t.mediana());
//		System.out.println("ehCheia: " + (t.ehCheia() ? "True" : "False"));
		
		Tree t = new Tree();
//		t.inserir(6);
//		t.inserir(5);
//		t.inserir(9);
//		t.inserir(2);
//		t.inserir(5);
//		t.inserir(4);
//		t.inserir(7);
//		t.inserir(3);
		
		t.inserir(5);
		t.inserir(3);
		t.inserir(2);
		t.inserir(4);
		t.inserir(8);
		t.inserir(6);
		t.inserir(9);
		t.inserir(15);
		t.inserir(1);
		
		
		//System.out.println("raiz = " + t.raiz.valor);
		//System.out.println("simetrica: " + t.simetrica());
		//System.out.println("enesimoElemento: " + t.enesimoElemento(4));
		//Node c = t.buscar(5);
		//System.out.println("Valor: " + c.valor + " ,  H: " + c.h + " , ih: " + c.ih);
		t.imprimeArvore(1);
		//t.imprimeArvore(2);
		//System.out.println("ehCheia: " + (t.ehCheia() ? "True" : "False"));
		//System.out.println("ehCompleta: " + (t.ehCompleta() ? "True" : "False"));
		t.remover(5);
		t.imprimeArvore(1);
	}

}

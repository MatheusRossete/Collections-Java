package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> catalogo;

    public CatalogoLivros() {
        this.catalogo = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        catalogo.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        if (!catalogo.isEmpty()){
            List<Livro> livroPorAutor = new ArrayList<>();
            for (Livro l : catalogo){
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livroPorAutor.add(l);
                }
            }
            return livroPorAutor;
        }else{
            throw new RuntimeException("O catálogo está vazio!");
        }
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        if (!catalogo.isEmpty()){
            List<Livro> livroPorIntervalo = new ArrayList<>();
            for (Livro l : catalogo){
                if (l.getAno() >= anoInicial && l.getAno() <= anoFinal){
                    livroPorIntervalo.add(l);
                }
            }
            return livroPorIntervalo;
        }else {
            throw new RuntimeException("O catálogo está vazio!");
        }
    }

    public List<Livro> pesquisarPorTitulo(String titulo){
        if (!catalogo.isEmpty()){
            List<Livro> livroPorTitulo = new ArrayList<>();
            for (Livro l : catalogo){
                if (l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo.add(l);
                }
            }
            return livroPorTitulo;
        }else {
            throw new RuntimeException("O catálogo está vazio!");
        }
    }

    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros();

        catalogo.adicionarLivro("Livro 1", "Autor 1", 2018);
        catalogo.adicionarLivro("Livro 2", "Autor 2", 2020);
        catalogo.adicionarLivro("Livro 3", "Autor 1", 2011);
        catalogo.adicionarLivro("Livro 4", "Autor 3", 2012);
        catalogo.adicionarLivro("Livro 5", "Autor 4", 2013);
        catalogo.adicionarLivro("Livro 6", "Autor 4", 2000);
        catalogo.adicionarLivro("Livro 7", "Autor 4", 2017);

        System.out.println(catalogo.pesquisarPorAutor("Autor 4"));

        System.out.println(catalogo.pesquisarPorIntervaloAnos(2010, 2015));

        System.out.println(catalogo.pesquisarPorTitulo("Livro 2"));
    }
}

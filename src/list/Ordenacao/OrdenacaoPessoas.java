package list.Ordenacao;

import java.util.*;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoasList;

    public OrdenacaoPessoas() {
        pessoasList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoasList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        if (!pessoasList.isEmpty()) {
            List<Pessoa> listaPorIdade = new ArrayList<>(pessoasList);
            Collections.sort(listaPorIdade);
            return listaPorIdade;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Pessoa> ordenarPorAltura() {
        if (!pessoasList.isEmpty()) {
            List<Pessoa> listaPorAltura = new ArrayList<>(pessoasList);
            Collections.sort(listaPorAltura, new Pessoa.CompararPorAltura());
            return listaPorAltura;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoPessoas lista = new OrdenacaoPessoas();

        lista.adicionarPessoa("Matheus", 20, 1.80);
        lista.adicionarPessoa("Luana", 24, 1.42);
        lista.adicionarPessoa("Rafael", 12, 1.67);
        lista.adicionarPessoa("Lucas", 32, 1.86);
        lista.adicionarPessoa("Fernando", 42, 1.45);
        lista.adicionarPessoa("José", 14, 1.75);
        lista.adicionarPessoa("Henrique", 3, 1.56);

        System.out.println(lista.ordenarPorIdade());

        System.out.println(lista.ordenarPorAltura());
    }
}

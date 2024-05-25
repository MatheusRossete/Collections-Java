package list.OperacoesBasicas.compras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> carrinho;

    public CarrinhoDeCompras() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        if (!carrinho.isEmpty()){
            List<Item> itensParaRemover = new ArrayList<>();
            for (Item i : carrinho){
                if (i.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(i);
                }
            }
            carrinho.removeAll(itensParaRemover);
        }else{
            System.out.println("O carrinho está vazio!");
        }
    }

    public void calcularValorTotal(){
        if (!carrinho.isEmpty()){
            double valorTotal = 0;
            for (Item i : carrinho){
                valorTotal += i.getPreco() * i.getQuantidade();
            }
            System.out.println("O valor total é: R$ " + valorTotal);
        }else{
            System.out.println("o carrinho está vazio!");
        }
    }

    public String exibirItens(){
        if (!carrinho.isEmpty()){
            return "Itens no carrinho: " + carrinho;
        }else{
            return "O carrinho está vazio!";
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Tenis", 200.00, 1);
        carrinho.adicionarItem("Camisa", 60.00, 3);
        carrinho.adicionarItem("Calça", 80.00, 1);

        carrinho.calcularValorTotal();

        System.out.println(carrinho.exibirItens());

        carrinho.removerItem("Tenis");

        carrinho.calcularValorTotal();

        System.out.println(carrinho.exibirItens());
    }
}

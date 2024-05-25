package list.OperacoesBasicas.tarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefaList;

    public ListaTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        //avalia se está vazia
        if (!tarefaList.isEmpty()){
            //cria lista para armazenar as tarefas a serem removidas
            List<Tarefa> tarefasParaRemover = new ArrayList<>();
            for (Tarefa t: tarefaList){
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefasParaRemover.add(t);
                }
            }
            //após armazenar todas as tarefas na lista temporária, as exclui na principal
            tarefaList.removeAll(tarefasParaRemover);
        }else{
            System.out.println("A lista está vazia");
        }
    }

    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public String obterDescricoesTarefas(){
        //avalia se está vazia
        if (!tarefaList.isEmpty()) {
            return tarefaList.toString();
        }else{
            return "lista vazia";
        }
    }

    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();

        lista.adicionarTarefa("TAREFA 1");
        lista.adicionarTarefa("TAREFA 1");
        lista.adicionarTarefa("TAREFA 2");
        lista.adicionarTarefa("TAREFA 3");
        lista.adicionarTarefa("TAREFA 4");

        System.out.println("Lista de tarefas: " + lista.obterDescricoesTarefas());

        lista.removerTarefa("TAREFA 1");

        System.out.println("Lista de tarefas: " + lista.obterDescricoesTarefas());
    }

}

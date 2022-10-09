package manipulacao;

import interfacesenum.Interacao;
import entidades.ItemEntretenimento;

import java.util.ArrayList;
import java.util.List;

public class AssistidosManipulacao implements Interacao {

    private ItemManipulacao itemManipulacao;
    private List<ItemEntretenimento> assistidosList;
    private List<ItemEntretenimento> indicacaoList;

    //Construtor:
    public AssistidosManipulacao(ItemManipulacao itemManipulacao){
        assistidosList = new ArrayList<>();
        indicacaoList = new ArrayList<>();
        this.itemManipulacao = itemManipulacao;
    }

    //GETTERS AND SETTER:
    public List<ItemEntretenimento> getAssistidos (){
        this.assistidosList = assistidosList;
        return assistidosList;
    }
    public List<ItemEntretenimento> getIndicacao (){
        this.indicacaoList = indicacaoList;
        return indicacaoList;
    }


    //Métodos:

    @Override
    public boolean marcarAssistido(Integer index) {
        ItemEntretenimento item = itemManipulacao.getEntretenimentoList().get(index);
        assistidosList.add(item);
        return true;
    }

    public boolean deletarAssistido(Integer index) {
        ItemEntretenimento item = itemManipulacao.getEntretenimentoList().get(index);

        if (item != null) {
            assistidosList.remove(item);
            System.out.println("Item removido!");
            return true;
        }
        System.out.println("Id não encontrado!");
        return  false;
    }

    public boolean listarAssistidos(){
        if (assistidosList != null){
            assistidosList.forEach(item -> item.imprimir());
            return true;
        }else{
            System.out.println("Lista vazia!");
            return false;
        }
    }

    @Override
    public boolean incluirIndicacao(ItemEntretenimento item) {
        indicacaoList.add(item);
        return true;
    }

}

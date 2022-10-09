package manipulacao;

import interfacesenum.Interacao;
import entidades.ItemEntretenimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AssistidosManipulacao implements Interacao {

    private ItemManipulacao itemManipulacao;
    private List<ItemEntretenimento> assistidos;
    private List<ItemEntretenimento> indicacao;

    //Construtor:

    public AssistidosManipulacao(ItemManipulacao itemManipulacao){
        this.assistidos = new ArrayList<>();
        this.indicacao = new ArrayList<>();
        this.itemManipulacao = itemManipulacao;
    }

    //GETTERS AND SETTER:
    public List<ItemEntretenimento> getAssistidos (){
        this.assistidos = assistidos;
        return assistidos;
    }
    public List<ItemEntretenimento> getIndicacao (){
        this.indicacao = indicacao;
        return indicacao;
    }


    //Métodos:

    @Override
    public boolean marcarAssistido(Integer index) {
        ItemEntretenimento item = itemManipulacao.getEntretenimentoList().get(index);
        assistidos.add(item);
        return true;
    }

    public boolean deletarAssistido(Integer index) {
        if (assistidos.get(index) != null){
            ItemEntretenimento itemEntretenimento = assistidos.get(index);
            assistidos.remove(itemEntretenimento);
            return true;
        }
        System.out.println("Index não encontrado");
        return false;
    }

    public boolean listarAssistidos(){
        if (assistidos != null){
            assistidos.forEach(item -> item.imprimir());
            return true;
        }else{
            System.out.println("Lista vazia!");
            return false;
        }
    }

    @Override
    public boolean incluirIndicacao(ItemEntretenimento item) {
        indicacao.add(item);
        return true;
    }

}

package manipulacao;

import interfacesenum.Interacao;
import entidades.ItemEntretenimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AssistidosManipulacao implements Interacao {
    private List<ItemEntretenimento> assistidos;
    private List<ItemEntretenimento> indicacao;

    //Construtor:
    public AssistidosManipulacao(){
        this.assistidos = new ArrayList<>();
        this.indicacao = new ArrayList<>();
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
    public boolean marcarAssistido(ItemEntretenimento item) {
        assistidos.add(item);
        return true;
    }

    public boolean deletarAssistido(Integer index) {
        Optional<ItemEntretenimento> itemEntretenimento = assistidos.stream()
                .filter(item -> item.getId().equals(index))
                .findFirst();

        if(itemEntretenimento.isPresent()){
            assistidos.remove(itemEntretenimento);
            return true;
        }else {
            return false;
        }
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

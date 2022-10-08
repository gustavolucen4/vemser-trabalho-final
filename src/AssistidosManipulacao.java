import java.util.ArrayList;
import java.util.List;

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
    public void marcarAssistido(ItemEntretenimento item) {
        assistidos.add(item);
    }

    public void deletarAssistido(ItemEntretenimento item) {
        indicacao.remove(item);
    }

    public void listarAssistidos(){
        assistidos.forEach(item -> item.imprimir());
    }

    @Override
    public void incluirIndicacao(ItemEntretenimento item) {
        indicacao.add(item);
    }

}

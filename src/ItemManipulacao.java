import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemManipulacao {

    private List<ItemEntretenimento> entretenimentoList;

    public ItemManipulacao(){
        this.entretenimentoList = new ArrayList<>();
    }

    public void criarItemEntretenimento(ItemEntretenimento itemEntretenimento){
        this.entretenimentoList.add(itemEntretenimento);
    }

    public void listarItemEntretenimento(){
        for (int i = 0; i < entretenimentoList.size()-1; i++){
            System.out.println(entretenimentoList.get(i));
        }
    }

    public void editarItemEntretenimento(Integer id, ItemEntretenimento itemProcurado){
        ItemEntretenimento itemEncontrado = entretenimentoList.get(id);

        if (itemProcurado.getNome() != null){
            itemEncontrado.setNome(itemProcurado.getNome());
        }

        if (itemProcurado.getGenero() != null) {
            itemEncontrado.setGenero(itemProcurado.getGenero());
        }

        if (itemProcurado.getSinopse() != null) {
            itemEncontrado.setSinopse(itemProcurado.getSinopse());
        }

        if (itemProcurado.getAnoLancamento() != null) {
            itemEncontrado.setAnoLancamento(itemProcurado.getAnoLancamento());
        }

        if (itemProcurado.getClassificacao() != null) {
            itemEncontrado.setClassificacao(itemProcurado.getClassificacao());
        }

        if (itemProcurado.getPlataforma() != null) {
            itemEncontrado.setPlataforma(itemProcurado.getPlataforma());
        }

        if (itemProcurado.getPlataforma() != null) {
            itemEncontrado.setPlataforma(itemProcurado.getPlataforma());
        }
    }

    public void removerItemEntretenimentoPorIndice(Integer index) {
        Optional<ItemEntretenimento> itemEntretenimento = entretenimentoList.stream()
                .filter(item -> item.getId().equals(index))
                .findFirst();

        if(itemEntretenimento.isPresent()){
            entretenimentoList.remove(itemEntretenimento);
        }

    }
}

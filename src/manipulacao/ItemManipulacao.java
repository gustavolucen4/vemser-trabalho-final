package manipulacao;

import entidades.Avaliacao;
import entidades.Filtro;
import entidades.ItemEntretenimento;

import java.util.ArrayList;
import java.util.List;

public class ItemManipulacao {

    private List<ItemEntretenimento> entretenimentoList;

    public ItemManipulacao(){
        this.entretenimentoList = new ArrayList<>();
    }

    public Double listarMediaAvaliacao(Integer index){
        ItemEntretenimento item = entretenimentoList.get(index);

        return item.getAvaliacoes().stream()
                    .mapToDouble(Avaliacao::getNota)
                    .average()
                    .getAsDouble();
    }

    public List<ItemEntretenimento> filtrarItemEntretenimento(Filtro filtro){
        if (filtro != null) {
            List<ItemEntretenimento> resultado = entretenimentoList.stream()
                    .filter(buscarTipo -> buscarTipo.getTipo().equals(filtro.getTipo().toLowerCase()))
                    .filter(buscarGenero -> buscarGenero.getGenero().equals(filtro.getGenero().toLowerCase()))
                    .filter(buscarClassificacao -> buscarClassificacao.getClassificacao()>=(filtro.getClassificacao()))
                    .toList();
            return resultado;
        }else {
            System.out.println("Pesquisa inválida!");
            return null;
        }
    }

    public boolean criarItemEntretenimento(ItemEntretenimento itemEntretenimento){
        this.entretenimentoList.add(itemEntretenimento);
        return true;
    }

    public  boolean listarItemEntretenimento(){
        if (entretenimentoList != null){
            entretenimentoList.forEach(itemEntretenimentoList -> itemEntretenimentoList.imprimir() );
            return true;
        }else {
            System.out.println("Lista de entretenimentos vazia!");
            return false;
        }
    }


    public boolean editarItemEntretenimento(Integer id, ItemEntretenimento itemProcurado){
        ItemEntretenimento itemEncontrado = entretenimentoList.get(id);

        if (itemProcurado.getNome() != null){
            itemEncontrado.setNome(itemProcurado.getNome());
            return true;
        }

        if (itemProcurado.getGenero() != null) {
            itemEncontrado.setGenero(itemProcurado.getGenero());
            return true;
        }

        if (itemProcurado.getSinopse() != null) {
            itemEncontrado.setSinopse(itemProcurado.getSinopse());
            return true;
        }

        if (itemProcurado.getAnoLancamento() != null) {
            itemEncontrado.setAnoLancamento(itemProcurado.getAnoLancamento());
            return true;
        }

        if (itemProcurado.getClassificacao() != null) {
            itemEncontrado.setClassificacao(itemProcurado.getClassificacao());
            return true;
        }

        if (itemProcurado.getPlataforma() != null) {
            itemEncontrado.setPlataforma(itemProcurado.getPlataforma());
            return true;
        }

        if (itemProcurado.getPlataforma() != null) {
            itemEncontrado.setPlataforma(itemProcurado.getPlataforma());
            return true;
        }
        return false;
    }

    public boolean deletarItemEntretenimentoPorIndice(Integer index) {

        if(entretenimentoList.get(index) != null){
            System.out.println("Item removido!");
            entretenimentoList.remove(index);
            return true;
        }else{
            System.out.println("Id não encontrado.");
            return false;
        }
    }
}

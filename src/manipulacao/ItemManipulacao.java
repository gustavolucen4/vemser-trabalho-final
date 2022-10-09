package manipulacao;

import entidades.Administrador;
import entidades.Avaliacao;
import entidades.Filtro;
import entidades.ItemEntretenimento;

import java.util.ArrayList;
import java.util.List;

public class ItemManipulacao {

    private List<ItemEntretenimento> entretenimentoList;

    public List<ItemEntretenimento> getEntretenimentoList() {
        return entretenimentoList;
    }

    public ItemManipulacao(){
        entretenimentoList = new ArrayList<>();
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
                    .filter(buscarTipo -> buscarTipo.getTipo().equalsIgnoreCase(filtro.getTipo()))
                    .filter(buscarGenero -> buscarGenero.getGenero().equalsIgnoreCase(filtro.getGenero()))
                    .filter(buscarClassificacao -> buscarClassificacao.getClassificacao()<=(filtro.getClassificacao()))
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


    public boolean editarItemEntretenimento(Integer index, ItemEntretenimento itemProcurado){
        //ItemEntretenimento itemEncontrado = entretenimentoList.get(id);
        if (entretenimentoList.get(index) != null){
            ItemEntretenimento itemEncontrado = entretenimentoList.get(index);

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
            return true;
        }
        System.out.println("Index não encontrado!");
        return false;
    }


    public boolean deletarItemEntretenimentoPorIndice(Integer index) {

        if(entretenimentoList.get(index) != null){
            entretenimentoList.remove(entretenimentoList.get(index));
            System.out.println("Item removido!");
            return true;
        }else{
            System.out.println("Id não encontrado.");
            return false;
        }
    }
}

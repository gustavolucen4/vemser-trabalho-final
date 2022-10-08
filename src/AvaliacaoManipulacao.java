import java.util.ArrayList;
import java.util.List;

public class AvaliacaoManipulacao {

    private List<Avaliacao> avaliacoesLista;

    //Construtor:
    public AvaliacaoManipulacao(){
        avaliacoesLista = new ArrayList<>();

    }

    //GETTER AND SETTER
    public List<Avaliacao> getAvaliacoes (){
        return avaliacoesLista;
    }


    //Métodos:
    public void adicionarAvaliacao(Avaliacao avaliacao){
        avaliacoesLista.add(avaliacao);
    }
    public  void listarAvaliacoes(){
        avaliacoesLista.forEach(avaliacao -> avaliacao.imprimir() );
    }
    public void editarAvaliacoes(Integer index, Avaliacao avaliacao){
        Avaliacao avaliacoes = avaliacoesLista.get(index);
        avaliacoes.setUsuario(avaliacao.getUsuario());
        avaliacoes.setItemEntretenimento(avaliacao.getItemEntretenimento());
        avaliacoes.setComentario(avaliacao.getComentario());
        avaliacoes.setNota(avaliacao.getNota());
    }
    public void deletarAvaliacoes(Integer index){
        avaliacoesLista.remove(index);
    }

}

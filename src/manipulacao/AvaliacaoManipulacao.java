package manipulacao;

import entidades.Avaliacao;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoManipulacao {

    private List<Avaliacao> avaliacoesList;

    //Construtor:
    public AvaliacaoManipulacao(){
        avaliacoesList = new ArrayList<>();
    }

    //GETTER AND SETTER
    public List<Avaliacao> getAvaliacoes (){
        return avaliacoesList;
    }


    //Métodos:
    public boolean criarAvaliacao(Avaliacao avaliacao){
        avaliacoesList.add(avaliacao);
        return true;
    }

    public  boolean listarAvaliacoes(){
        if (avaliacoesList != null){
            avaliacoesList.forEach(avaliacao -> avaliacao.imprimir() );
            return true;
        }else {
            System.out.println("Lista vazia!");
            return false;
        }
    }

    public boolean editarAvaliacoes(Integer index, Avaliacao avaliacao){

        if(avaliacoesList.get(index) != null){
            Avaliacao novaAvaliacoes = avaliacoesList.get(index);

            if (avaliacao.getUsuario() != null){
                novaAvaliacoes.setUsuario(avaliacao.getUsuario());
            }
            if (avaliacao.getItemEntretenimento() != null){
                novaAvaliacoes.setItemEntretenimento(avaliacao.getItemEntretenimento());
            }
            
            if (avaliacao.getComentario() != null){
                novaAvaliacoes.setComentario(avaliacao.getComentario());
            }
            
            if (avaliacao.getNota() != null){
                novaAvaliacoes.setNota(avaliacao.getNota());
            }

            return true;

        }else {
            System.out.println("Id não encontrado");
            return false;
        }

    }

    public boolean deletarAvaliacoes(Integer index){

        if (avaliacoesList.get(index) != null){
            avaliacoesList.remove(avaliacoesList.get(index));
            return true;
        }else {
            System.out.println("Id não encontrado");
            return false;
        }
    }

}

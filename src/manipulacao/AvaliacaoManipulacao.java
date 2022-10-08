package manipulacao;

import entidades.Avaliacao;

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
    public boolean adicionarAvaliacao(Avaliacao avaliacao){
        avaliacoesLista.add(avaliacao);
        return true;
    }

    public  boolean listarAvaliacoes(){
        if (avaliacoesLista != null){
            avaliacoesLista.forEach(avaliacao -> avaliacao.imprimir() );
            return true;
        }else {
            System.out.println("Lista vazia!");
            return false;
        }
    }

    public boolean editarAvaliacoes(Integer index, Avaliacao avaliacao){

        if(avaliacoesLista.get(index) != null){
            Avaliacao novaAvaliacoes = avaliacoesLista.get(index);

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

        if (avaliacoesLista.get(index) != null){
            avaliacoesLista.remove(index);
            return true;
        }else {
            System.out.println("Id não encontrado");
            return false;
        }
    }

}

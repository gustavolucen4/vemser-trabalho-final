package entidades;

import interfacesenum.Impressao;

public class Avaliacao implements Impressao {

    private static Integer contadorId = 0;

    private Integer id;
    private Usuario usuario;
    private ItemEntretenimento itemEntretenimento;
    private Double nota;
    private String comentario;


    //Construtores
    public Avaliacao() {
        id = contadorId++;
    }

    public Avaliacao(Usuario usuario, ItemEntretenimento itemEntretenimento, Double nota, String comentario) {
        this.usuario = usuario;
        this.itemEntretenimento = itemEntretenimento;
        this.nota = nota;
        this.comentario = comentario;
        id = contadorId++;
    }

    //GETTERS AND SETTERS
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ItemEntretenimento getItemEntretenimento() {
        return itemEntretenimento;
    }

    public void setItemEntretenimento(ItemEntretenimento itemEntretenimento) {
        this.itemEntretenimento = itemEntretenimento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public void imprimir() {
        System.out.println("-------------------------\n" +
                "Avaliacao{" +
                "usuario=" + usuario.getEmail() +
                ", id avaliação=" + id +
                ", itemEntretenimento=" + itemEntretenimento.getNome() +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}' +
                "\n-------------------------");
    }

}

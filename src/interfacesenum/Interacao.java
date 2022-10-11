package interfacesenum;

import entidades.ItemEntretenimento;
import manipulacao.ItemManipulacao;

public interface Interacao {
    public boolean marcarAssistido(Integer index);
    public boolean incluirIndicacao(ItemEntretenimento item);
    public boolean deletarAssistido(Integer index);
    public boolean listarAssistidos();
}

package br.com.solution.imi.warp_gate.domain.enums;

public enum TipoDocumentoEnum {
    CPF("CPF"),
    RG("RG"),
    CNH("CNH"),
    PASSAPORTE("Passaporte");

    private String descricao;

    TipoDocumentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}

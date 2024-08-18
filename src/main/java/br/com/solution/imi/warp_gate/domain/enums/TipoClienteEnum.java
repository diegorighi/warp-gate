package br.com.solution.imi.warp_gate.domain.enums;

public enum TipoClienteEnum {

    PF("Pessoa Física"),
    PJ("Pessoa Jurídica");

    private String descricao;

    TipoClienteEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}

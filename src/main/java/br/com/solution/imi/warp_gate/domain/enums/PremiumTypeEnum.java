package br.com.solution.imi.warp_gate.domain.enums;

public enum PremiumTypeEnum {
    
    FREE("Free"),
    BASIC("Basic"),
    PREMIUM("Premium"),
    BLACK("Black");

    private String description;

    PremiumTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
}

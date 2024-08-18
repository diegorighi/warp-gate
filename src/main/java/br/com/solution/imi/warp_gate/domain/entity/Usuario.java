package br.com.solution.imi.warp_gate.domain.entity;

import br.com.solution.imi.warp_gate.domain.enums.PremiumTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    private Long id;
    
    private String login;

    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_premium", nullable = false)
    private PremiumTypeEnum premiumType;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @Deprecated
    protected Usuario() {}

    public Usuario(String login, String senha, PremiumTypeEnum premiumType, Cliente cliente) {
        this.login = login;
        this.senha = senha;
        this.premiumType = premiumType;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PremiumTypeEnum getPremiumType() {
        return premiumType;
    }

    public void setPremiumType(PremiumTypeEnum premiumType) {
        this.premiumType = premiumType;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        if (cliente != null && cliente.getUsuario() != this) {
            cliente.setUsuario(this);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        result = prime * result + ((premiumType == null) ? 0 : premiumType.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        if (premiumType != other.premiumType)
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        return true;
    }

}

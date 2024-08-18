package br.com.solution.imi.warp_gate.domain.entity;

import java.time.LocalDateTime;

import br.com.solution.imi.warp_gate.domain.enums.TipoClienteEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
public class Cliente extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    private Long id;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Usuario usuario;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false)
    private TipoClienteEnum tipoCliente;

    @Deprecated
    protected Cliente() {}

    public Cliente(
        String primeiroNome, 
        String nomeMeio, 
        String sobrenome, 
        Documentos documentos, 
        Endereco endereco, 
        Contato contato, 
        Usuario usuario,
        LocalDateTime dataCadastro, 
        LocalDateTime dataAtualizacao,
        TipoClienteEnum tipoCliente
        ) {
        super(primeiroNome, nomeMeio, sobrenome, documentos, endereco, contato);
        this.usuario = usuario;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.tipoCliente = tipoCliente;
    }

	@Override
    public void setDocumentos(Documentos documentos) {
        super.setDocumentos(documentos);
        if (documentos != null) {
            documentos.setCliente(this);
        }
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null && usuario.getCliente() != this) {
            usuario.setCliente(this);
        }
    }    

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public TipoClienteEnum getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoClienteEnum tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
        result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
        result = prime * result + ((tipoCliente == null) ? 0 : tipoCliente.hashCode());
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
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (dataCadastro == null) {
            if (other.dataCadastro != null)
                return false;
        } else if (!dataCadastro.equals(other.dataCadastro))
            return false;
        if (dataAtualizacao == null) {
            if (other.dataAtualizacao != null)
                return false;
        } else if (!dataAtualizacao.equals(other.dataAtualizacao))
            return false;
        if (tipoCliente != other.tipoCliente)
            return false;
        return true;
    }

    
	
}

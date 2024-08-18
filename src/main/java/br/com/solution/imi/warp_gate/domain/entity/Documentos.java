package br.com.solution.imi.warp_gate.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.solution.imi.warp_gate.domain.enums.TipoDocumentoEnum;
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
@Table(name = "documentos")
@SequenceGenerator(name = "documentos_seq", sequenceName = "documentos_seq", allocationSize = 1)
public class Documentos implements Serializable { 

    private static final long serialVersionUID = 7622437515689997703L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documentos_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    private final TipoDocumentoEnum tipoDocumento;

    @Column(name = "numero_documento")
    private final String numeroDocumento;

    @Column(name = "orgao_expedidor")
    private final String orgaoExpedidor;

    @Column(name = "data_expedicao")
    private final LocalDateTime dataExpedicao;

    @Column(name = "data_validade")
    private final LocalDateTime dataValidade;
    
    @OneToOne(mappedBy = "documentos")
    private Cliente cliente;

    /*
     * Este construtor é necessário para a JPA
     * Não deve ser utilizado e por isto ele é protected
     */
    @Deprecated
    protected Documentos() {
        this.tipoDocumento = null;
        this.numeroDocumento = null;
        this.orgaoExpedidor = null;
        this.dataExpedicao = null;
        this.dataValidade = null;
    }

    public Documentos(
        TipoDocumentoEnum tipoDocumento, 
        String numeroDocumento, 
        String orgaoExpedidor, 
        LocalDateTime dataExpedicao, 
        LocalDateTime dataValidade
    ) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.orgaoExpedidor = orgaoExpedidor;
        this.dataExpedicao = dataExpedicao;
        this.dataValidade = dataValidade;
    }

    public Long getId() {
        return id;
    }

    public TipoDocumentoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public LocalDateTime getDataExpedicao() {
        return dataExpedicao;
    }

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataExpedicao, dataValidade, id, numeroDocumento, orgaoExpedidor, tipoDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documentos other = (Documentos) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataExpedicao, other.dataExpedicao)
				&& Objects.equals(dataValidade, other.dataValidade) && Objects.equals(id, other.id)
				&& Objects.equals(numeroDocumento, other.numeroDocumento)
				&& Objects.equals(orgaoExpedidor, other.orgaoExpedidor) && tipoDocumento == other.tipoDocumento;
	}
    
    

}

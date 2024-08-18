package br.com.solution.imi.warp_gate.domain.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@MappedSuperclass
public abstract class Person {
    
    @Column(name = "primeiro_nome", nullable = false)
    private String primeiroNome;

    @Column(name = "nome_meio")
    private String nomeMeio;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documentos_id", referencedColumnName = "id")
    private Documentos documentos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    private Contato contato;

    @Deprecated
    protected Person() {}

    public Person(String primeiroNome, String nomeMeio, String sobrenome, Documentos documentos, Endereco endereco, Contato contato) {
        this.primeiroNome = primeiroNome;
        this.nomeMeio = nomeMeio;
        this.sobrenome = sobrenome;
        this.documentos = documentos;
        this.endereco = endereco;
        this.contato = contato;
    }


    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomeMeio() {
        return nomeMeio;
    }

    public void setNomeMeio(String nomeMeio) {
        this.nomeMeio = nomeMeio;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Documentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}

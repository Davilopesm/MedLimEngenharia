package model;


public class Paciente {
    private String nome;
    private float CPF;
    private float RG;
    private String endereço;
    private float telefone;

    public Paciente(String nome, float CPF, float RG, String endereço, float telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.endereço = endereço;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCPF() {
        return CPF;
    }

    public void setCPF(float CPF) {
        this.CPF = CPF;
    }

    public float getRG() {
        return RG;
    }

    public void setRG(float RG) {
        this.RG = RG;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public float getTelefone() {
        return telefone;
    }

    public void setTelefone(float telefone) {
        this.telefone = telefone;
    }   
    
       
    
    
}

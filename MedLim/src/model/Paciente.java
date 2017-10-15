package model;


public class Paciente {
    private String nome;
    private float CPF;
    private float RG;
    private String endereco;
    private float telefone;

    public Paciente(String nome, float CPF, float RG, String endereco, float telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public float getRG() {
        return RG;
    }
    
    public void setNome(float RG) {
        this.RG = RG;
    }

    

    public float getCPF() {
        return CPF;
    }

    public void setCPF(float CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getTelefone() {
        return telefone;
    }

    public void setTelefone(float telefone) {
        this.telefone = telefone;
    }

    


    
}

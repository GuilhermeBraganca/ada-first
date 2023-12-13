package br.com.ada.ifome.entregador;

public class Veiculo {

    private Long id;
    private String TipoVeiculoEnum;
    private String marca;
    private String placa;

    private String cor;
    private String renavam;
    private boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoVeiculoEnum() {
        return TipoVeiculoEnum;
    }

    public void setTipoVeiculoEnum(String tipoVeiculoEnum) {
        TipoVeiculoEnum = tipoVeiculoEnum;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

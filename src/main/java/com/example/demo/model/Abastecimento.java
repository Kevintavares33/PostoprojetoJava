import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePosto;
    private double valorLitro;
    private double quantidadeLitros;
    private double totalPago;
    private double imposto;

    public Abastecimento() {
    }

    public Abastecimento(String nomePosto, double valorLitro, double quantidadeLitros, double totalPago) {
        this.nomePosto = nomePosto;
        this.valorLitro = valorLitro;
        this.quantidadeLitros = quantidadeLitros;
        this.totalPago = totalPago;
    }

    // getters e setters

    public double calcularImposto() {
        double valorAbastecido = this.valorLitro * this.quantidadeLitros;
        this.imposto = valorAbastecido * 0.13; // 13% de imposto
        return this.imposto;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", nomePosto='" + nomePosto + '\'' +
                ", valorLitro=" + valorLitro +
                ", quantidadeLitros=" + quantidadeLitros +
                ", totalPago=" + totalPago +
                ", imposto=" + imposto +
                '}';
    }
}

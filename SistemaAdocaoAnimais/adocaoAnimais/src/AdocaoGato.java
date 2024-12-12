import java.util.Date;

public class AdocaoGato extends Adocao{
    public Gato gatoAdotado;

    public AdocaoGato(Date dA, int id, Tutor t, Gato g) {
        super(dA, id, t);
        this.gatoAdotado=g;
    }
    @Override
    public void listarDados(){
        System.out.println("Data da Adoção: " + dataAdocao);
        System.out.println("ID: " + id);
        System.out.println("Tutor: " + tutor.nome);
        gatoAdotado.listarDados();


    }; 

}

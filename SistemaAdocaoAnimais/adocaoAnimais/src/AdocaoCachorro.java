
import java.util.Date;

public class AdocaoCachorro extends Adocao {
    public Cachorro cachorroAdotado;

    public AdocaoCachorro(Date dA, int id, Tutor t, Cachorro c) {
        super(dA, id, t);
        this.cachorroAdotado=c;
    }
    @Override
    public void listarDados(){
        System.out.println("Data da Adoção: " + dataAdocao);
        System.out.println("ID: " + id);
        System.out.println("Tutor: " + tutor.nome);
        cachorroAdotado.listarDados();
    };
}

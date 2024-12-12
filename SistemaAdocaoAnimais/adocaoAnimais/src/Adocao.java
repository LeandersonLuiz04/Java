
import java.util.Date;

public abstract class Adocao {
    public Date dataAdocao;
    public int id;
    public Tutor tutor;
    
    public Adocao(Date dA, int id, Tutor t){
        this.dataAdocao=dA;
        this.id=id;
        this.tutor=t;
    }
    public abstract void listarDados();


}

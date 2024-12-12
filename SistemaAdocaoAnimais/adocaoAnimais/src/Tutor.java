import java.util.ArrayList;

public class Tutor extends Pessoa implements IConsultaDados {

    ArrayList<Gato> gatos= new ArrayList<>();
    ArrayList<Cachorro> caes= new ArrayList<>();

    public Tutor(String n, int i, String t,int id, String e, ArrayList<Gato> g, ArrayList<Cachorro> c){
        super(n,i,t);   
        this.id=id;
        this.endereco=e;
        this.gatos=g;
        this.caes=c;
    }
    @Override
    public void listarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("ID: " + id);
    
        if (gatos.isEmpty() && caes.isEmpty()) {
            System.out.println("Não possui animais no momento.");
        } else {
            System.out.println("Animais sob responsabilidade:");
            if (!gatos.isEmpty()) {
                System.out.println("Gatos:");
                for (Gato gato : gatos) {
                    System.out.println(" - " + gato.nome + " (ID: " + gato.id + ")");
                }
            }
            if (!caes.isEmpty()) {
                System.out.println("Cachorros:");
                for (Cachorro cachorro : caes) {
                    System.out.println(" - " + cachorro.nome + " (ID: " + cachorro.id + ")");
                }
            }
        }
    }

    


}

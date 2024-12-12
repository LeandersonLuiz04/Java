public class Cachorro extends Animal implements IConsultaDados{
    public String raca;
    public String porte;
    public String nivelAdestramento;

    public Cachorro(String n, int i,String o,String e, boolean s, String r, String p, String nA, int id){
        super(n,i,o,e);
        this.sociavel=s;
        this.raca=r;
        this.porte=p;
        this.nivelAdestramento=nA;
        this.id=id;
    }
    @Override
    public void listarDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Origem: " + origem);
        System.out.println("Sociável: " + (sociavel ? "Sim" : "Não"));
        System.out.println("Raça: " + raca);
        System.out.println("Porte: " + porte);
        System.out.println("Nivel de Adestramento: " + nivelAdestramento);
        System.out.println("ID: " + id);
    };




}

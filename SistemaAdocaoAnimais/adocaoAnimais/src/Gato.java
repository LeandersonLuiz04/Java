public class Gato extends Animal implements IConsultaDados {
    public String padraoPelagem;
    public String comprimentoPelagem;
    public String preferenciaAmbiente;

    public Gato(String n, int i,String o,String e, boolean s, String pP, String cP, String pA, int id){
        super(n,i,o,e);
        this.sociavel=s;
        this.padraoPelagem=pP;
        this.comprimentoPelagem=cP;
        this.preferenciaAmbiente=pA;
        this.id=id;
    }
    @Override
    public void listarDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Origem: " + origem);
        System.out.println("Sociável: " + (sociavel ? "Sim" : "Não"));
        System.out.println("Padrão da Pelagem: " + padraoPelagem);
        System.out.println("Comprimento da Pelagem: " + comprimentoPelagem);
        System.out.println("Preferência de Ambiente: " + preferenciaAmbiente);
        System.out.println("ID: " + id);
    };




}

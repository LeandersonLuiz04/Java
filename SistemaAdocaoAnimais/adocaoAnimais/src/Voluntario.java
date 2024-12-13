public class Voluntario extends Pessoa implements IConsultaDados {
    public String especialidade;


    public Voluntario(String n, int i, String t, int id, String e, String esp){
        super(n,i,t);   
        this.id=id;
        this.endereco=e;
        this.especialidade=esp;
    }

    @Override
    public void listarDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("ID: " + id);
        System.out.println("Especialidade: " + especialidade);

    };


}

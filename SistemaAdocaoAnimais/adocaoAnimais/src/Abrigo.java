import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Abrigo {
    public String nome;
    public String CNPJ;
    public String telefone;
    public String endereco;
    public static ArrayList<Adocao> adocoes = new ArrayList<>();
    public static ArrayList<Voluntario> voluntarios = new ArrayList<>();
    public static ArrayList<Tutor> tutores = new ArrayList<>();
    public static ArrayList<Cachorro> caes = new ArrayList<>();
    public static ArrayList<Gato> gatos = new ArrayList<>();

    public Abrigo(){
        this.nome="PetLovers";
        this.CNPJ="00.873.924/0001-47";
        this.telefone="47 93321-8075";
        this.endereco="Rua das Palmeiras, Blumenau-SC";
    }



    //PARTE DO CADASTRO DE VOLUNTÁRIOS(PESSOAS QUE TRABALHAM NO ABRIGO) E CADASTRO DE ANIMAL 
    public void cadastrarVoluntario(Scanner reader) {
    try {
        System.out.println("================CADASTRO DE VOLUNTÁRIO================");
        System.out.println("Nome: ");
        String nome = reader.nextLine();
        if(nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio.");
        System.out.println("Idade: ");
        int idade = reader.nextInt();
        if (idade<15) throw new IllegalArgumentException("Voluntario não deve ter idade menor de 15 anos.");
        reader.nextLine(); 
        System.out.println("Telefone: ");
        String telefone = reader.nextLine();
        if (telefone.isEmpty()) throw new IllegalArgumentException("Telefone não deve ser vazio.");
        int id = voluntarios.size() + 1;
        System.out.println("Endereço: ");
        String endereco = reader.nextLine();
        if (endereco.isEmpty()) throw new IllegalArgumentException("Endereço não pode ser vazio.");
        System.out.println("Especialidade(Função dentro do Abrigo): ");
        String especialidade = reader.next();
        if (especialidade.isEmpty()) throw new IllegalArgumentException("A especialidade não pode ser vazio.");

        Voluntario v = new Voluntario(nome, idade, telefone, id, endereco, especialidade);
        voluntarios.add(v);
        System.out.println("Voluntário cadastrado com sucesso.");
    } catch (InputMismatchException e) { //É LANÇADA PELO SCANNER QUANDO O TIPO DE DADO FORNECIDO NO CONSOLE NÃO É O QUE SE ESPERA
            System.out.println("Erro: Entrada inválida. Por favor, insira os dados corretamente.");
            reader.nextLine(); 
    } catch (Exception e) {
        System.out.println("Erro inesperado: " + e.getMessage()); //PARA ALGUM ERRO INESPERADO
    } 
    
}
    public void cadastrarAnimal(Scanner reader) {
        try{
            System.out.println("==================Cadastrar Novo Animal==================");
        
            System.out.print("Nome do animal: ");
            String nome = reader.nextLine();
            if (nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio.");
            System.out.print("Idade do animal: ");
            int idade = reader.nextInt();
            if (idade<0) throw new IllegalArgumentException("Idade não pode ser menor que 0.");
            reader.nextLine(); 
            System.out.print("Origem do animal: ");
            String origem = reader.nextLine();
            if (origem.isEmpty()) throw new IllegalArgumentException("Origem não pode ser vazio.");
            System.out.print("Temperamento (true para amigável, false para agressivo): ");
            boolean temperamento = reader.nextBoolean();
            if (temperamento!=true && temperamento!=false) throw new IllegalArgumentException("Você digitou algo diferente de true ou false.");
            reader.nextLine(); 
            System.out.print("Especificações: ");
            String especificacoes = reader.nextLine();
            
            System.out.print("Tipo de animal (gato/cachorro): ");
            String tipo = reader.nextLine().toLowerCase();
            
            if (tipo.equals("gato")) {
                System.out.print("Padrão de pelagem: ");
                String padraoPelagem = reader.nextLine();
                System.out.print("Comprimento da pelagem: ");
                String comprimentoPelagem = reader.nextLine();
                System.out.print("Preferência de ambiente: ");
                String preferenciaAmbiente = reader.nextLine();
                int id=gatos.size()+1;
                // CRIAR E ADICIONAR GATO
                Gato gato = new Gato(nome, idade, origem, especificacoes, temperamento,padraoPelagem,comprimentoPelagem,preferenciaAmbiente,id);
                gatos.add(gato); 
        
                System.out.println("Gato cadastrado com sucesso!");
        
            } else if (tipo.equals("cachorro")) {
                System.out.print("Raça: ");
                String raca = reader.nextLine();
                System.out.print("Porte: ");
                String porte = reader.nextLine();
                System.out.println("Nivel de Adestramento: ");
                String nivelAdestramento=reader.nextLine();        
                int id = caes.size() + 1;
                // CRIAR E ADICIONAR CACHORRO
                Cachorro cachorro = new Cachorro(nome, idade, origem, especificacoes, temperamento,raca,porte,nivelAdestramento, id);
                caes.add(cachorro);
        
                System.out.println("Cachorro cadastrado com sucesso!");
        
            } else {
                System.out.println("Tipo de animal inválido. Cadastro cancelado.");
            }
        } catch(InputMismatchException e){  //É LANÇADA PELO SCANNER QUANDO O TIPO DE DADO FORNECIDO NO CONSOLE NÃO É O QUE SE ESPERA
            System.out.println("Erro: Entrada inválida. Por favor, insira os dados corretamente.");
            reader.nextLine(); 
        
        } catch (IllegalArgumentException e) {  
            System.out.println("Erro: " + e.getMessage());
        } catch(Exception e){ //ERRO INESPERADO
            System.out.println("Erro inesperado: " + e.getMessage());
        } 
    }
    
    //PARTE DE REALIZAR ADOÇÃO
    public void realizarAdocao(Abrigo sistema, Scanner reader) {
        try{
            System.out.println("==================REALIZAR ADOÇÃO==================");
            System.out.print("Digite o nome do adotante: ");
            String nome = reader.nextLine();
            if (nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio.");

            System.out.print("Digite a idade do adotante: ");
            int idade = reader.nextInt();
            if (idade < 18) throw new IllegalArgumentException("Adotante deve ter pelo menos 18 anos.");
            reader.nextLine();

            System.out.print("Digite o telefone do adotante: ");
            String telefone = reader.nextLine();
            if (telefone.isEmpty()) throw new IllegalArgumentException("Telefone não pode ser vazio.");

            System.out.print("Digite o endereço do adotante: ");
            String endereco = reader.nextLine();
            if (endereco.isEmpty()) throw new IllegalArgumentException("Endereço não pode ser vazio.");

            
            Tutor tutor = new Tutor(nome, idade, telefone, sistema.tutores.size() + 1,endereco, new ArrayList<>(), new ArrayList<>());
            sistema.tutores.add(tutor);

            System.out.println("Selecione o tipo de animal para adoção:");
            System.out.println("[1] Gato");
            System.out.println("[2] Cachorro");
            int escolha = reader.nextInt();
            reader.nextLine();

            if (escolha == 1) {
                if (sistema.gatos.isEmpty()) {
                    System.out.println("Nenhum gato disponível para adoção.");
                    return;
                }

                System.out.println("Lista de gatos disponíveis:");
                for (Gato gato : sistema.gatos) {
                    System.out.println("ID: " + gato.id + " | Nome: " + gato.nome);
                }

                System.out.print("Digite o ID do gato que deseja adotar: ");
                int gatoId = reader.nextInt();
                reader.nextLine();

                Gato gato = sistema.getGatoById(gatoId);
                if (gato != null) {
                    sistema.gatos.remove(gato);
                    AdocaoGato adocao = new AdocaoGato(new Date(), adocoes.size() + 1, tutor, gato);
                    adocoes.add(adocao);
                    tutor.gatos.add(gato);

                    System.out.println("Adoção realizada com sucesso! Gato " + gato.nome + " agora pertence a " + tutor.nome + ".");
                } else {
                    System.out.println("Gato não encontrado.");
                }
            } else if (escolha == 2) {
                if (sistema.caes.isEmpty()) {
                    System.out.println("Nenhum cachorro disponível para adoção.");
                    return;
                }

                System.out.println("Lista de cachorros disponíveis:");
                for (Cachorro cachorro : sistema.caes) {
                    System.out.println("ID: " + cachorro.id + " | Nome: " + cachorro.nome);
                }

                System.out.print("Digite o ID do cachorro que deseja adotar: ");
                int cachorroId = reader.nextInt();
                reader.nextLine();

                Cachorro cachorro = sistema.getCachorroById(cachorroId);
                if (cachorro != null) {
                    sistema.caes.remove(cachorro);
                    AdocaoCachorro adocao = new AdocaoCachorro(new Date(), adocoes.size() + 1, tutor, cachorro);
                    adocoes.add(adocao);
                    tutor.caes.add(cachorro);

                    System.out.println("Adoção realizada com sucesso! Cachorro " + cachorro.nome + " agora pertence a " + tutor.nome + ".");
                } else {
                    System.out.println("Cachorro não encontrado.");
                }
            } else {
                System.out.println("Opção inválida.");
            }
     } catch (InputMismatchException e) {
        System.out.println("Erro: Entrada inválida. Por favor, insira os dados corretamente.");
        reader.nextLine(); 
        }
    catch (IllegalArgumentException e) { 
        System.out.println("Erro: " + e.getMessage());
        }
    catch (Exception e) {  //PARA ALGUM ERRO INESPERADO
        System.out.println("Erro inesperado: " + e.getMessage()); 
        }
    }
    //MOSTRAR AS LISTAS DE ANIMAIS, VOLUNTARIOS E TUTORES NO CONSOLE
    public void listarAnimaisAdotados() {
        System.out.println("========== Animais Adotados ==========");
        if (adocoes.isEmpty()) {
            System.out.println("Nenhum animal foi adotado até o momento.");
        } else {
            for (Adocao adocao : adocoes) {
                adocao.listarDados();
                System.out.println();
            }
        }
    }
    public void listarVoluntarios() { //PERCORRE COM UM FOR E MOSTRA OS VOLUNTÁRIOS
        System.out.println("==========Lista de Voluntários==========");
        if (voluntarios.isEmpty()){
            System.out.println("Nenhum Voluntário cadastrado.");
            return;
        }
        for (Voluntario voluntario : voluntarios) {
            voluntario.listarDados();
            System.out.println();
        }
    }
    public void listarAnimais() {
        System.out.println("==========Lista de Animais==========");
        if (caes.isEmpty() && gatos.isEmpty()) {        //SE LISTA DE caes e gatos ESTÁ VAZIA
            System.out.println("Nenhum animal cadastrado.");
        }
        else {
            for (Cachorro cachorro : caes) { //LISTAR DADOS DE CADA CACHORRO EM caes
                cachorro.listarDados();
                System.out.println();
            }
            for (Gato g: gatos){ //LISTAR DADOS DE CADA GATO EM gatos
                g.listarDados();
                System.out.println();
            }

        }

    }
    public void listarTutores(){  //LISTAGEM DE TODOS OS TUTORES
        System.out.println("==========Lista de Tutores==========");
        if (tutores.isEmpty()) {
            System.out.println("Nenhum Tutor cadastrado.");
            return;
        }
        for (Tutor tutor:tutores){
            tutor.listarDados();
            System.out.println();
        }

    }
    public void listarDadosAbrigo(){
        System.out.println("Nome do Abrigo: " + nome);
        System.out.println("CNPJ: " + CNPJ);
        System.out.println("Telefone do Abrigo: " + telefone);
        System.out.println("Endereço: " + endereco);
    }

    //PARTE DE PROCURAR POR ID ALGUM GATO, CACHORRO OU TUTOR
    /*A lista gatos,caes e tutores são transformadas em um stream.
    O stream é filtrado para conter apenas o gato,cão e tutor cujo id é igual ao valor da variável id.
    Se um gato,cão ou tutor correspondente for encontrado, ele será retornado.
    Caso contrário, retorna null 
    1 Filtra os gatos,cães e tutores com ID igual ao procurado
    2 Pega o primeiro resultado encontrado
    3 Retorna null caso não encontre
    */
    public Gato getGatoById(int id) { 
        
        Gato gato = gatos.stream().filter(g -> g.id == id).findFirst().orElse(null);
        if (gato != null) {
            System.out.println("Informações do Gato:");
            gato.listarDados();
        } else {
            System.out.println("Gato com ID " + id + " não encontrado.");
        }
        return gato;
    }
    public Cachorro getCachorroById(int id) {
        Cachorro cachorro = caes.stream().filter(c -> c.id == id).findFirst().orElse(null);
        if (cachorro != null) {
            System.out.println("Informações do Cachorro:");
            cachorro.listarDados();
        } else {
            System.out.println("Cachorro com ID " + id + " não encontrado.");
        }
        return cachorro;
    }
    public Tutor getTutorById(int id) {
        Tutor tutor = tutores.stream().filter(t -> t.id == id).findFirst().orElse(null);
        if (tutor != null) {
            System.out.println("Informações do Tutor:");
            tutor.listarDados();
        } else {
            System.out.println("Tutor com ID " + id + " não encontrado.");
        }
        return tutor;
    }
    public Voluntario getVoluntarioById(int id){
        Voluntario voluntario = voluntarios.stream().filter(v -> v.id == id).findFirst().orElse(null);
        if (voluntario != null) {
            System.out.println("Informações do Tutor:");
            voluntario.listarDados();
        } else {
            System.out.println("Tutor com ID " + id + " não encontrado.");
        }
        return voluntario;
    }
   
   
    //PARTE QUE POSSIBILITA A REMOÇÃO DE ALGUM VOLUNTÁRIO OU ANIMAL
    public void removerVoluntario(Scanner reader) {
        try {
            System.out.println("ID do Voluntário: ");
            if (!reader.hasNextInt()) { //SE NÃO É VERDADE QUE O PRÓXIMO VALOR É UM INTEIRO
                throw new InputMismatchException("Entrada inválida. Por favor, insira um número inteiro.");
            }
            int id = reader.nextInt();
            reader.nextLine(); 
            Voluntario voluntario = voluntarios.stream().filter(v -> v.id == id).findFirst().orElse(null);
    
            if (voluntario != null) {
                voluntarios.remove(voluntario);
                System.out.println("Voluntário removido com sucesso.");
            } else {
                System.out.println("Voluntário não encontrado.");
            }
        } catch (InputMismatchException e) {
            // PARA TRATAR O CASO EM QUE O USUARIO DIGITAR ALGO DIFERENTE DE UM INTEIRO(ID) 
            System.err.println("Erro: " + e.getMessage());
            reader.nextLine(); 
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        } 
    }   
    public void removerAnimal(Scanner reader) {
        try {
            System.out.println("ID do Animal: ");
            // VERIFICA SE O ID É INTEIRO
            if (!reader.hasNextInt()) {
                throw new InputMismatchException("Entrada inválida para o ID. Por favor, insira um número inteiro.");
            }
            int id = reader.nextInt();
            reader.nextLine();  
    
            System.out.println("Tipo do Animal: ");
            System.out.println("[1] Gato");
            System.out.println("[2] Cachorro");
    
            // VERIFICA SE A escolha É UM INTEIRO
            if (!reader.hasNextInt()) {
                throw new InputMismatchException("Entrada inválida para o tipo do animal. Por favor, insira um número.");
            }
            int escolha = reader.nextInt();
            reader.nextLine(); 
    
            String tipo;
            switch (escolha) {
                case 1:
                    tipo = "gato";
                    break;
                case 2:
                    tipo = "cachorro";
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    return;  
            }
    
            // VERIFICA O TIPO DE ANIMAL E REALIZA A REMOÇÃO
            if ("gato".equalsIgnoreCase(tipo)) {
                Gato gato = getGatoById(id);
                if (gato != null) {
                    gatos.remove(gato);
                    System.out.println("Gato removido com sucesso.");
                } else {
                    System.out.println("Gato não encontrado.");
                }
            } else if ("cachorro".equalsIgnoreCase(tipo)) {
                Cachorro cachorro = getCachorroById(id);
                if (cachorro != null) {
                    caes.remove(cachorro);
                    System.out.println("Cachorro removido com sucesso.");
                } else {
                    System.out.println("Cachorro não encontrado.");
                }
            } else {
                System.out.println("Tipo de animal inválido.");
            }
    
        } catch (InputMismatchException e) { //PARA ENTRADAS INVALIDAS
            System.err.println("Erro: " + e.getMessage());
            reader.nextLine();  
        } catch (Exception e) { //PARA ERROS INESPERADOS
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        } 
    }
    
    
    //UM METODO PARA LIMPAR CONSOLE(EM JAVA NÃO TEM NADA PRONTO PARA SE USAR, POR ISSO É PRECISO IMPLEMENTAR)
    public static void limparConsole() {
        try {
            //limpar no terminal do Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // limpar no terminal de (Linux/Mac)
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar o console: " + e.getMessage());
        }
    }

}

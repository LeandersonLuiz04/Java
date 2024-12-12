
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Abrigo sistema = new Abrigo();
        Scanner reader = new Scanner(System.in);
        while(true){
            System.out.println("===============================================");
            System.out.println("                MENU PRINCIPAL                ");
            System.out.println("===============================================");
            System.out.println("[1] GERENCIAR PESSOAS");
            System.out.println("[2] GERENCIAR ANIMAIS");
            System.out.println("[3] REALIZAR ADOÇÃO");
            System.out.println("[4] LISTAR INFORMAÇÕES DO ABRIGO");
            System.out.println("[5] ENCERRAR SISTEMA");
            System.out.println("===============================================");
            
            int x=reader.nextInt();
            reader.nextLine();
            switch (x) {
                case 1:
                    gerenciarPessoas(sistema,reader);
                    break;
                case 2:
                    gerenciarAnimais(sistema,reader);
                    break;
                case 3:
                    sistema.realizarAdocao(sistema,reader);
                    break;
                case 4:
                    sistema.listarDadosAbrigo();
                    break;
                case 5:
                    reader.close();
                    return;
                default:
                    System.out.println("ENTRADA INVÁLIDA");
            }
        }
    }

    public static void gerenciarPessoas(Abrigo sistema, Scanner reader){
        while(true){
            
            System.out.println("===========================================================");
            System.out.println("                GERENCIAMENTO DE PESSOAS                ");
            System.out.println("===========================================================");
            System.out.println("[1] CADASTRAR VOLUNTÁRIO");
            System.out.println("[2] REMOVER VOLUNTÁRIO");
            System.out.println("[3] BUSCAR TUTOR");
            System.out.println("[4] LISTAR VOLUNTÁRIOS");
            System.out.println("[5] LISTAR TUTORES");
            System.out.println("[6] RETORNAR AO MENU PRINCIPAL");
            System.out.println("========================================================");
            int x=reader.nextInt();
            reader.nextLine();
            switch (x) {
                case 1:
                    sistema.cadastrarVoluntario(reader);
                    break;
                case 2:
                    sistema.removerVoluntario(reader);
                    break;
                case 3:
                    System.out.println("ID do Tutor: ");
                    int id=reader.nextInt();
                    reader.nextLine();
                    System.out.println(sistema.getTutorById(id));
                    break;
                case 4:
                    sistema.listarVoluntarios();
                    break;
                case 5:
                    sistema.listarTutores();
                    break;
                case 6:
                    sistema.limparConsole();
                    return;
                default:
                    System.out.println("ENTRADA INVÁLIDA");
            }
        }
    }
    public static void gerenciarAnimais(Abrigo sistema, Scanner reader){
        while(true){
            System.out.println("===========================================================");
            System.out.println("                GERENCIAMENTO DE ANIMAIS                ");
            System.out.println("===========================================================");
            System.out.println("[1] CADASTRAR ANIMAL");
            System.out.println("[2] REMOVER ANIMAL");
            System.out.println("[3] BUSCAR GATO");
            System.out.println("[4] BUSCAR CACHORRO");
            System.out.println("[5] MOSTRAR TODOS OS ANIMAIS DISPONÍVEIS");
            System.out.println("[6] MOSTRAR TODOS OS ANIMAIS ADOTADOS");
            System.out.println("[7] RETORNAR AO MENU PRINCIPAL");
            System.out.println("========================================================");
            int x=reader.nextInt();
            reader.nextLine();
            switch (x) {
                case 1:
                    sistema.cadastrarAnimal(reader);
                    break;
                case 2:
                    sistema.removerAnimal(reader);
                    break;
                case 3:
                    System.out.println("ID do Gato: ");
                    int id=reader.nextInt();
                    System.out.println(sistema.getGatoById(id));
                    break;
                case 4:
                    System.out.println("ID do Cachorro: ");
                    int ID=reader.nextInt();
                    System.out.println(sistema.getCachorroById(ID));
                    break;
                case 5:
                    sistema.listarAnimais();
                    break;
                case 6:
                    sistema.listarAnimaisAdotados();
                    break;                
                case 7:
                    sistema.limparConsole();
                    return;
                default:
                    System.out.println("ENTRADA INVÁLIDA");
            }
        }
    }
}

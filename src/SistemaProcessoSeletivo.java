import java.util.InputMismatchException;
import java.util.Scanner;
public class SistemaProcessoSeletivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("========= SISTEMA DE VALIDAÇÃO DE PROCESSO SELETIVO ===========");
            System.out.println("Quantos candidatos serão avaliados?");
            int numeroCandidatos = scanner.nextInt();

            for (int i= 1; i <= numeroCandidatos; i++) {
                avaliarCandidato(scanner, i);
            }
        } catch (Exception e) {
            System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
        } finally {
            scanner.close();
            System.out.println("Processo finalizado.");
        }
    }

    public static void avaliarCandidato(Scanner scanner, int numeroCandidato) {
         try {
             System.out.println("Digite a idade do condidato: ");
             int idade = scanner.nextInt();;

             System.out.println("Digite o tempo de experiência(Anos): ");
             int experiencia = scanner.nextInt();

             System.out.println("Digite a pontuação da prova técnica (0-100): ");
             int pontuacao = scanner.nextInt();
             //TODO: Validação dos registros
             if (idade < 18) {
                 throw  new IllegalArgumentException("Idade mínima não atingida(18 anos)");
             }
             if (experiencia < 2) {
                throw  new IllegalArgumentException("Esperiência mínima não atingida(2 anos)");
             }
             if (pontuacao < 70) {
                throw new IllegalArgumentException("Pontuação mínima não atingida (70 pontos)");
             }

             System.out.println("Candidato aprovado para a próxima fase!");

         }catch (InputMismatchException e) {
             System.out.println("Erro: Valor inválido. Digite apenas números.");
             scanner.next();
         }catch (IllegalArgumentException e) {
             System.out.println("REPROVADO: " + e.getMessage());
         }

    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Hamming ===");
        System.out.print("Digite a sequência binária de bits: ");
        
        String entrada = scanner.nextLine();

        boolean entradaValida = true;

        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);

            if (c != '0' && c != '1') {
                entradaValida = false;
                break;
            }
        }

        if (entradaValida && !entrada.isEmpty()) {
            System.out.println("Entrada correta, pode seguir. Você digitou: " + entrada);

            int m = entrada.length();
            int k = 1;

            // 1. Determinar a quantidade de bits de paridade (2^k >= k + m + 1)
            while (Math.pow(2, k) < (k + m + 1)) {
                k++;
            }
            
            int totalTamanho = m + k;
            System.out.println("Quantidade de bits de dados (m): " + m);
            System.out.println("Quantidade de bits de paridade necessários (k): " + k);
            System.out.println("Tamanho total da palavra codificada: " + totalTamanho);

            // 2. Posicionamento e Montagem da Palavra de Hamming
            int[] hamming = new int[totalTamanho + 1];
            int indiceDado = 0; 

            for (int i = 1; i <= totalTamanho; i++) {
                // Verifica se i é potência de 2 (1, 2, 4, 8...)
                if ((i & (i - 1)) == 0) {
                    hamming[i] = 0; // Posição de paridade temporária
                } else {
                    if (indiceDado < m) {
                        hamming[i] = entrada.charAt(indiceDado) - '0';
                        indiceDado++;
                    }
                }
            }

            // 3. Cálculo dos Bits de Paridade (Paridade Par)
            for (int i = 0; i < k; i++) {
                int posicaoParidade = (int) Math.pow(2, i);
                int soma = 0;

                for (int j = 1; j <= totalTamanho; j++) {
                    if ((j & posicaoParidade) != 0) {
                        soma += hamming[j];
                    }
                }

                // Paridade par: se a soma for ímpar, o bit de paridade deve ser 1; se par, 0.
                hamming[posicaoParidade] = soma % 2;
            }

            // Exibe a mensagem final codificada
            System.out.print("\nMensagem Final Codificada (Hamming): ");
            for (int i = 1; i <= totalTamanho; i++) {
                System.out.print(hamming[i] + " ");
            }
            System.out.println();

            // 4. Módulo de Simulação de Detecção e Correção de Erros
            System.out.print("\nDeseja simular a recepção de uma palavra para testar erros? (1-Sim / 0-Não): ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (opcao == 1) {
                System.out.print("Digite a palavra recebida (com " + totalTamanho + " bits separados por espaço ou grudados): ");
                String recebidaStr = scanner.nextLine().replace(" ", "");

                if (recebidaStr.length() == totalTamanho) {
                    int[] recebido = new int[totalTamanho + 1];
                    for (int i = 0; i < totalTamanho; i++) {
                        recebido[i + 1] = recebidaStr.charAt(i) - '0';
                    }

                    // Recalcula as paridades para achar a posição do erro
                    int posicaoErro = 0;

                    for (int i = 0; i < k; i++) {
                        int posicaoParidade = (int) Math.pow(2, i);
                        int soma = 0;

                        for (int j = 1; j <= totalTamanho; j++) {
                            if ((j & posicaoParidade) != 0) {
                                soma += recebido[j];
                            }
                        }

                        // Se a paridade falhou (soma ímpar), acumula no valor do erro
                        if (soma % 2 != 0) {
                            posicaoErro += posicaoParidade;
                        }
                    }

                    if (posicaoErro == 0) {
                        System.out.println("Nenhum erro detectado na transmissão!");
                    } else {
                        System.out.println("Erro detectado na posição: " + posicaoErro);
                        
                        // Correção do erro invertendo o bit
                        recebido[posicaoErro] = (recebido[posicaoErro] == 0) ? 1 : 0;

                        System.out.print("Palavra corrigida: ");
                        for (int i = 1; i <= totalTamanho; i++) {
                            System.out.print(recebido[i] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Tamanho da palavra recebida incorreto!");
                }
            }

        } else {
            System.out.println("Entrada incorreta! A sequência deve conter apenas 0s e 1s.");
        }

        scanner.close();
    }
}
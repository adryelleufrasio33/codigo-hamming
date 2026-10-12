Codificador e Corretor de Erros - Código de Hamming (7,4) em Java
Este projeto consiste em uma implementação em Java do Código de Hamming, desenvolvida para a disciplina de Arquitetura de Computadores no curso de Ciência da Computação.
O objetivo da aplicação é realizar a codificação de mensagens binárias com cálculo dinâmico de bits de paridade, além de permitir a simulação de erros de transmissão para demonstrar a capacidade do algoritmo de detectar e corrigir automaticamente alterações nos bits.

📌 Funcionalidades
Validação de Entrada: Garante que a entrada do usuário contenha estritamente dígitos binários (0 e 1).
Cálculo Dinâmico de Paridade (k): Determina automaticamente a quantidade necessária de bits de controle utilizando a regra: 2kk+m+1
Mapeamento de Hamming: Organiza os bits de paridade nas posições de potência de 2 ($1, 2, 4, 8 \dots$) e distribui os bits de dados nas posições restantes.
Enforcement de Paridade Par: Calcula e atribui o valor correto para cada bit de controle.
Simulação e Correção de Erros: Permite alterar voluntariamente um bit da sequência para demonstrar a localização exata da falha e a correção do dado corrompido em tempo de execução.

🛠️ Tecnologias e Conceitos Utilizados
Linguagem: Java (JDK 17+)
Estruturas de Dados: Arrays (Vetores)
Manipulação Numérica e Binária: Operadores Bitwise (&), Operações Matemáticas (Math.pow)
Controle de Fluxo: Laços aninhados (for, while), Estruturas condicionais (if/else)

🚀 Como Executar o Projeto
Pré-requisitos
Java Development Kit (JDK) instalado.
Terminal / Prompt de Comando ou uma IDE (VS Code, IntelliJ, Eclipse).
Passos
Clone o repositório:
git clone https://github.com/adryelleufrasio33/codigo-hamming.git
Acesse o diretório do projeto:
cd codigo-hamming
Compile o código Java:
javac Main.java
Execute a aplicação:
java Main

🧪 Exemplo de Uso
Digite a sequência binária (ex: 1100, 110, 10101):
110

Entrada correta, pode seguir. Você digitou: 110
Quantidade de bits de dados (m): 3
Quantidade de bits de paridade necessários (k): 3
Tamanho total da palavra codificada: 6

Mensagem Final Codificada (Hamming): 0 1 1 1 1 0

Deseja simular a recepção de uma palavra para testar erros? (1-Sim / 0-Não): 1
Digite a palavra recebida (com 6 bits):
011010

Erro detectado na posição: 4
Mensagem Corrigida: 0 1 1 1 1 0


✒️ Autor
Desenvolvido por Adryell Eufrasio
Estudante de Ciência da Computação | Graduado em ADS
GitHub: @adryelleufrasio33

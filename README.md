# Caixa Eletrônico em Kotlin

**Estudo de Caso: Caixa Eletrônico**
**Aluno:** Rafael

Este projeto simula a lógica de funcionamento de um caixa eletrônico, desenvolvido em Kotlin como atividade acadêmica. O sistema permite realizar operações bancárias básicas por meio de um menu interativo no terminal, utilizando conceitos de Programação Orientada a Objetos (POO), estruturas condicionais, laços de repetição e listas.

As principais funcionalidades são autenticação por senha, consulta de saldo, saque, depósito e consulta do extrato bancário.

## Estrutura do código

Todo o código está organizado no arquivo `src/Main.kt`:

* **`ContaBancaria`**: representa a conta bancária e concentra os dados e as operações financeiras do sistema. Possui atributos como titular, número da conta, senha, saldo e extrato.
* **`verificarSenha()`**: verifica se a senha informada corresponde à senha cadastrada para a conta.
* **`consultarSaldo()`**: exibe o saldo disponível na conta.
* **`depositar()`**: recebe um valor e realiza o depósito quando ele atende às regras de validação.
* **`sacar()`**: verifica se o valor do saque é válido e se existe saldo suficiente antes de efetuar a retirada.
* **`consultarExtrato()`**: apresenta o histórico das movimentações financeiras armazenadas durante a execução.
* **`main()`**: cria a conta bancária, controla as tentativas de autenticação e apresenta o menu para o usuário escolher as operações disponíveis.

## Regras de negócio

* **Autenticação:** o sistema solicita uma senha para permitir o acesso às operações bancárias. O usuário possui até três tentativas para informar a senha correta.
* **Consulta de saldo:** permite visualizar o saldo atual da conta sem alterar seu valor.
* **Saque:** o valor informado deve ser maior que zero e não pode ultrapassar o saldo disponível. Caso contrário, a operação não é realizada.
* **Depósito:** somente valores maiores que zero são aceitos. Quando o depósito é realizado, o saldo é atualizado.
* **Extrato bancário:** as movimentações são armazenadas em uma lista e podem ser consultadas pelo usuário.
* **Menu:** o programa permite escolher entre consultar saldo, sacar, depositar, consultar extrato ou encerrar o atendimento. O menu permanece em execução até que o usuário escolha a opção de saída.
* **Validação de entrada:** os valores numéricos são convertidos utilizando funções como `toIntOrNull()` e `toDoubleOrNull()`, permitindo identificar entradas que não correspondem ao formato esperado.

## Decisões de implementação

1. **Uso de uma classe para representar a conta:** a classe `ContaBancaria` reúne os dados e as operações relacionadas à conta, evitando que as regras financeiras fiquem espalhadas pelo programa.
2. **Encapsulamento dos dados:** atributos como saldo e senha são privados, impedindo seu acesso e alteração direta fora da classe. As operações são realizadas por meio dos métodos disponibilizados.
3. **Validação de saques e depósitos:** as operações verificam os valores informados antes de modificar o saldo, evitando saques superiores ao dinheiro disponível e movimentações com valores inválidos.
4. **Uso de listas no extrato:** uma lista mutável (`mutableListOf`) permite registrar novas movimentações durante a execução do programa e percorrer os registros para exibir o histórico.
5. **Estruturas condicionais:** o `if` e o `else` são utilizados para validar senhas, verificar valores e decidir se uma operação pode ser realizada. A estrutura `when` organiza as opções do menu.
6. **Estruturas de repetição:** os laços `while` e `do-while` controlam as tentativas de autenticação e a repetição do menu, permitindo que o usuário realize várias operações na mesma execução.
7. **Validação de entradas numéricas:** o uso de conversões seguras evita que entradas inválidas sejam tratadas diretamente como números, permitindo apresentar uma mensagem de erro ao usuário.

## Como rodar

1. Instale o Java JDK e o IntelliJ IDEA.
2. Clone este repositório ou baixe os arquivos do projeto.
3. Abra o projeto no IntelliJ IDEA.
4. Abra o arquivo `src/Main.kt`.
5. Execute a função `main()`.
6. Siga as instruções exibidas no terminal para acessar o caixa eletrônico e realizar as operações.

## Dados para teste

A conta utilizada para demonstrar o funcionamento do sistema possui os seguintes dados:

* **Titular:** Rafael Mendes
* **Número da conta:** 12345
* **Senha:** `1234`
* **Saldo inicial:** R$ 1.000,00

Esses dados são fictícios e utilizados somente para fins de demonstração.

## Limitações do sistema

O projeto é uma simulação acadêmica e não está conectado a um banco de dados ou a uma instituição financeira real. O saldo e as movimentações são mantidos em memória durante a execução do programa. Ao encerrar e executar novamente o sistema, os dados retornam aos valores iniciais definidos no código.

## Considerações finais

O desenvolvimento deste projeto permitiu aplicar conceitos fundamentais da programação em Kotlin, especialmente Programação Orientada a Objetos, encapsulamento, funções, estruturas condicionais, laços de repetição, listas e validação de entradas.

A implementação busca reproduzir o funcionamento básico de um caixa eletrônico, organizando as operações bancárias em métodos específicos e aplicando regras para manter a consistência das movimentações financeiras.

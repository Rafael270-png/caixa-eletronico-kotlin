
class ContaBancaria(
    val titular: String,
    val numeroConta: String,
    private val senha: String,
    saldoInicial: Double
) {
    private var saldo = saldoInicial
    private val extrato = mutableListOf<String>()

    // Confere se a senha digitada esta correta
    fun verificarSenha(senhaDigitada: String): Boolean {
        return senhaDigitada == senha
    }

    // Mostra o saldo da conta
    fun consultarSaldo() {
        println("Saldo atual: R$ %.2f".format(saldo))
    }

    // Realiza um deposito na conta
    fun depositar(valor: Double) {
        if (valor <= 0) {
            println("O valor do deposito deve ser maior que zero.")
        } else {
            saldo += valor
            extrato.add("Deposito: + R$ %.2f".format(valor))
            println("Deposito realizado com sucesso!")
            consultarSaldo()
        }
    }

    // Realiza um saque na conta
    fun sacar(valor: Double) {
        if (valor <= 0) {
            println("O valor do saque deve ser maior que zero.")
        } else if (valor > saldo) {
            println("Saldo insuficiente.")
        } else {
            saldo -= valor
            extrato.add("Saque: - R$ %.2f".format(valor))
            println("Saque realizado com sucesso!")
            consultarSaldo()
        }
    }

    // Mostra o historico de operacoes
    fun consultarExtrato() {
        println("\n===== EXTRATO BANCARIO =====")

        if (extrato.isEmpty()) {
            println("Nenhuma movimentacao realizada.")
        } else {
            for (operacao in extrato) {
                println(operacao)
            }
        }

        consultarSaldo()
    }
}

fun main() {
    // Criacao da conta para testar o sistema
    val conta = ContaBancaria(
        titular = "Rafael Mendes",
        numeroConta = "12345",
        senha = "1234",
        saldoInicial = 1000.0
    )

    println("================================")
    println("       CAIXA ELETRONICO")
    println("================================")
    println("Titular: ${conta.titular}")
    println("Numero da conta: ${conta.numeroConta}")

    // Login do usuario
    var tentativas = 3
    var acessoPermitido = false

    while (tentativas > 0 && !acessoPermitido) {
        print("Digite sua senha: ")
        val senhaDigitada = readLine() ?: ""

        if (conta.verificarSenha(senhaDigitada)) {
            acessoPermitido = true
            println("Acesso permitido!")
        } else {
            tentativas--
            println("Senha incorreta.")
            println("Tentativas restantes: $tentativas")
        }
    }

    if (!acessoPermitido) {
        println("Conta bloqueada para esta sessao.")
        return
    }

    var opcao: Int

    // Menu principal do caixa eletronico
    do {
        println("\n========== MENU ==========")
        println("1 - Consultar saldo")
        println("2 - Sacar dinheiro")
        println("3 - Depositar dinheiro")
        println("4 - Consultar extrato")
        println("0 - Sair")
        println("==========================")
        print("Escolha uma opcao: ")

        opcao = readLine()?.toIntOrNull() ?: -1

        when (opcao) {
            1 -> {
                conta.consultarSaldo()
            }

            2 -> {
                print("Digite o valor do saque: R$ ")
                val valor = readLine()?.toDoubleOrNull()

                if (valor == null) {
                    println("Digite um valor numerico valido.")
                } else {
                    conta.sacar(valor)
                }
            }

            3 -> {
                print("Digite o valor do deposito: R$ ")
                val valor = readLine()?.toDoubleOrNull()

                if (valor == null) {
                    println("Digite um valor numerico valido.")
                } else {
                    conta.depositar(valor)
                }
            }

            4 -> {
                conta.consultarExtrato()
            }

            0 -> {
                println("Obrigado por utilizar nosso caixa eletronico!")
            }

            else -> {
                println("Opcao invalida. Tente novamente.")
            }
        }

    } while (opcao != 0)
}
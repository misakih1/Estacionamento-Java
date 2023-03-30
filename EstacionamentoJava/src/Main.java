import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.Duration;

class Estacionamento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // Pedir ao usuário para inserir a placa do carro
        System.out.print("Insira a placa do carro: ");
        String placa = sc.nextLine();

        // Gerar código de entrada do veículo e salvar a data e hora de entrada
        LocalDateTime entrada = LocalDateTime.now();
        String codigoEntrada = "E-" + entrada.getYear() + entrada.getMonthValue() + entrada.getDayOfMonth() + entrada.getHour() + entrada.getMinute() + entrada.getSecond();
        System.out.println("Código de entrada: " + codigoEntrada);

        // Pedir ao usuário para inserir o código de entrada ao sair
        System.out.print("Insira o código de entrada para sair: ");
        String codigoSaida = sc.nextLine();

        // Verificar se o código de saída corresponde ao código de entrada
        if (!codigoSaida.equals(codigoEntrada)) {
            System.out.println("Código de saída inválido!");
            return;
        }

        // Calcular o tempo de estacionamento e o preço a pagar
        LocalDateTime saida = LocalDateTime.now();
        Duration duracao = Duration.between(entrada, saida);
        long minutos = duracao.toMinutes();
        double preco = minutos * (8.0/60);

        // Exibir o preço a pagar
        System.out.println("Placa: " + placa);
        System.out.println("Preço a pagar: R$" + df.format(preco));
    }
}
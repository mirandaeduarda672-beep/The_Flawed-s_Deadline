public class ArtUtils {

        //------- Método estático disponível para todo o projeto ----------

        // 1-texto é a frase a ser exibida
        // 2-velocidadeMs é o tempo de pausa (em milissegundos) entre cada letra.
        // texto.toCharArray(): Converte a frase (a String) array/lista de caracteres individuais.
        // exemplo: "Pai" vira ['P', 'a', 'i'].
        public static void imprimirLento(String texto, int velocidadeMs) {

            for (char c : texto.toCharArray()) {
                System.out.print(c);

                try {
                    Thread.sleep(velocidadeMs);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }//linha restaura o estado de interrupção da thread
                // garantindo que o Java saiba que a execução deve ser encerrada com segurança.
            }
            System.out.println("\n");
            //Após imprimir todas as letras do texto e sair do laço for, executa uma quebra de linha.
        }

    }


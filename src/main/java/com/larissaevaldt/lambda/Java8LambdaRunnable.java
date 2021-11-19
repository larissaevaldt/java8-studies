package com.larissaevaldt.lambda;

// JAVA 8: FUNCOES LAMBDA
public class Java8LambdaRunnable {

    public static void main(String[] args) {

        // Exemplo de codigo que nao e Java 8, ate o Java 7 a gente escrevia assim
        // cria um novo Runnable, implementando o metodo run(), e esse metodo run so imprime no console
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world!");
            }
        }).run();


        // Agora o mesmo codigo, utilizando funcoes LAMBDA
        new Thread(() -> System.out.println("Hello world!")).run();

        // Como que o Java sabe que aquilo e um Runnable? E que a gente esta implementando o metodo run()?

        // A primeira coisa que a gente tem que entender, pra entender como que o Java sabe isso
        // e o conceito SAM - Single Abstract Method
        // Qualquer interface que tenha apenas um metodo abstrato.
        // A interface Runnable tem somente um unico metodo abstrato que e o run()
        // entao se Runnable so tem um metodo, o system out que a gente passou so pode ser a implementacao desse metodo
        // O () antes de '->' e o parametro que aquela funcao recebe, nesse caso nenhum

        // FORMATO DE UMA FUNCAO LAMBDA
        // Primeira parte: sao os argumentos que a funcao recebe
        // Segunda parte: a implementacao de funcao

        // Pro Java esses dois tipos de escrever sao exatamente a mesma coisa, o comportamento e o mesmo
        // Como a interface segue esse padrao do SAM (Single Abstract Method)
        // O java consegue entender, quando escrevemos dessa forma menos explicita,
        // que voce ta criando un novo Runnable e implementando o metodo run()

        //A anotacao @FunctionalInterface obriga a interface a ter apenas 1 metodo abstrato
        //Ela nao e obrigatoria, podemos usar lambda em interfaces que nao tem essa anotacao
    }
}

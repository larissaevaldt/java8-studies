package com.larissaevaldt.interfacesfuncionais;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * JAVA 8 - Interfaces Funcionais que ja vem prontas dentro da JDK
 * Provavelmente uma das maiores dificuldades ao comecar a trabalhar com Streams e entender
 * os tipos das funcoes que aparecem escrito quando a gente vai chamar um metodo do stream
 * Ex: Predicate, Consumer, Supplier, Collector
 * Os metodos do stream() quase todos recebem como argumento esses tipos, que sao essas interfaces funcionais
 */
public class Java8BuiltinFunctionalInterfaces {

    public static void main(String[] args) {

        /* varios dos metodos do stream() recebem um tipo que e novo do Java 8
         * estamos acostumados a chamar metodo e passar pra esse metodo um objeto nosso, tipo um Cliente, um numero, uma String, etc.
         * mas aqui quase todos esses metodos recebem esses tipos que sao essas interfaces funcionais que ja vem prontas na jdk
         * Ex: forEach() recebe um Consumer, anyMatch() e allMatch() recebem um Predicate, o collect() recebe um Supplier e dois BiConsumer()
         */

        /**  SUPPLIER (fornecedor)
         * A classe Stream tem um metodo chamado generate, que recebe um Supplier
         * O supplier representa uma funcao que vai entregar alguma coisa
         * Ela nao recebe nenhum parametro, e ela vai entregar alguma coisa
         */
        Stream.generate(() -> new Random().nextInt()) //funcao lambda q nao recebe nada e retorna um numero aleatorio. A implementacao do metodo T get(); do Supplier
                .limit(5) //sem isso o stream fica criando numeros aleatorios e imprimindo pra sempre
                .forEach(System.out::println);

        /** CONSUMER (consumidor)
         * O oposto do Supplier, ele nao retorna nada mas ele recebe um valor.
         * Ex de Consumer que usamos toda hora e o forEach()
         * Recebe um valor, faz alguma coisa com ele, e nao retorna nada
         */
        Stream.generate(() -> new Random().nextInt()) //funcao lambda q nao recebe nada e retorna um numero aleatorio
                .limit(5) //sem isso o stream fica criando numeros aleatorios e imprimindo pra sempre
                .forEach((e) -> System.out.println(e)); // essa funcao lambda implementa o metodo accept(T t); do Consumer

        /** BICONSUMER (consumidor)
         * Uma funcao que recebe 2 valores.
         * Tambem e um Consumer, so o metodo accept dele recebe 2 argumentos. accept(T t, U u)
         * Recebe 2 valores, faz alguma coisa com ele, e nao retorna nada
         */

        /** PREDICATE E BIPREDICATE
         * Uma funcao que recebe um valor, e retorna um boolean.
         * Entao e basicamento uma comparacao, ele vai retornar o resultado de comparacao/operacao que seja verdadeiro ou falso.
         * BiPredicate funciona igual ao Predicate so que ele recebe 2 valores e ele faz um teste com esses 2 valores,
         * seja comparando um com o outro, seja vendo se pelo menos um dos dois atende a um criterio,
         * vai depender de como implementar a funcao lambda ai.
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
            .filter(e -> e % 2 != 0) //implementacao da funcao test(T t); do Predicate
                .forEach(System.out::println);

        /** FUNCTION e BIFUNCTION
         * A interface funcional mais generica de todas.
         * Recebe um valor e retorna um valor.
         * Ex: O map() recebe uma Function, o map recebe um valor, nesse caso o elemento do stream,
         * e retorna um outro valor, que pode ser o elemento do stream modificado, pode ser um outro tipo, nao importa
         * BiFunction() e a mesma coisa, porem recebe 2 argumentos, e reorna 1 valor.
         */
        list.stream()
                .filter(e -> e % 2 == 0) //implementacao da funcao test(T t); do Predicate
                .map(e -> e.doubleValue()) //implementacao da funcao R apply(T t); da Function
                .forEach(System.out::println);

        /** UnaryOperator e BinaryOperator
         * Esses dois sao Functions, a interface UnaryOperator extend Function
         * Porem Function tem dois tipos. Ex: Function<T, R> T-o argumento de entrada R-o retorno
         * O UnaryOperator estende Funcion colocando os 2 como sendo do mesmo tipo
         * tanto a entrada como a saida tem que ser do mesmo tipo
         * No caso do BinaryOperator os 2 argumentos de entrada mais o retorno, precisam ser os 3 do memso tipo
         * Exemplo de metodo que usa: reduce()
         */
        list.stream()
                .filter(e -> e % 2 == 0) //Predicate
                .map(e -> e.doubleValue()) //Function
                .reduce((e1, e2) -> e1 + e2) //BinaryOperator
                .ifPresent(System.out::println);
    }
}

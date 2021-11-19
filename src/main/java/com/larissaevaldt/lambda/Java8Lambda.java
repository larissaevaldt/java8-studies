package com.larissaevaldt.lambda;

import java.util.stream.IntStream;

/**
 * JAVA 8 - LAMBDA EXPRESSIONS - TIPOS DIFERENTES DE SE ESCREVER
 *
 */
public class Java8Lambda {

    public static void main(String[] args) {

        // PARENTESES
        IntStream.range(0, 5)
                //quando so temos um argumento, nao precisamos usar o parentes ()
                .filter(n -> n % 2 == 0) //filter recebe uma funcao lambda (Predicate)
                // se voce quiser declarar o tipo do argumento precisa por parenteses ()
                .filter((int n) -> n % 2 == 0)
                // quando temos mais de 1 argumento, o parentes tbm e obrigatorio
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        // Quando nao temos nenhum argumento, o parenteses tbm e obrigatorio
        Runnable runnable = () -> System.out.println("Hello World!");

        // CHAVES
        IntStream.range(0, 5)
                //perceba que nao tem chaves na implementacao (depois do ->)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // se quiser usar chave, precisa adicionar o RETURN e o ; (claro se a expressao lamba for uma expressao que retorna alguma coisa)
        IntStream.range(0, 5)
                .filter(n -> { return n % 2 == 0; })
                .forEach(System.out::println);

        // o interessante e que quando a gente usa chaves, a gente consegue ter + de 1 linha dentro da nossa funcao lambda
        IntStream.range(0, 5)
                .filter(n -> {
                    System.out.println("Hello world!");
                    return n % 2 == 0;
                })
                .forEach(System.out::println);
    }
}

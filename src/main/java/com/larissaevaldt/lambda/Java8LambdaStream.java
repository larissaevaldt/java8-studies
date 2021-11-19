package com.larissaevaldt.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

// JAVA 8: FUNCOES LAMBDA
public class Java8LambdaStream {

    // O Java trouxe isso pra gente poder usar a API DE STREAMS, tbm incluida no Java 8
    // stream - fluxo de dados

    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(1,2,3,4);

        // Como que a gente faria, antes do Java 8, pra imprimir essa lista?
        // voce provavelmente faria um for each, assim:
        for (Integer integer : asList ) {
            System.out.println(integer);
        }

        System.out.println();

        // Apartir do Java 8, a gente tem um novo metodo .stream() na List
        // esse metodo nos devolve um stream, que e um fluxo de dados
        // e pra imprimir agora, podemos fazer isso:
        asList.stream().forEach(e -> System.out.println(e)); //para cada elemento, pegue o elemento e imprima ele

        System.out.println();

        // O legal da interface de stream, e que ela tem MUITO mais coisa que o forEach
        // tem uma serie de metodos pra utilizar. Outro exemplo:
        asList.stream()
                .filter(e -> e % 2 == 0) //filtra somente numeros pares
                .forEach(e -> System.out.println((e)));

        // Veja como isso ficaria inviavel sem LAMBDA, o que teriamos que fazer caso lambda nao existisse:
        asList.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer e) {
                        return e % 2 == 0;
                    }
                }) //filtra somente numeros pares
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer e) {
                        System.out.println(e);
                    }
                });

        // Entao, as funcoes lambda vieram claro, pra ajudar a reduzir a quantidade de codigo, alem de outras coisas
        // Mas elas vieram principalmente pra VIABILIZAR a PROGRAMACAO FUNCIONAL
    }
}

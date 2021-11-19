package com.larissaevaldt.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

/* JAVA 8 -Optional (Pare de retornar null, use optional)
 * uma classe que representa que aquele valor pode existir ou nao
 * Isso e mto mais interessante pra quem esta chamando o seu metodo
 * Optional foi feito para usar como retorno de metodo que nem sempre vai retornar um valor
 */
public class Java8_Optional {

    public static void main(String[] args) {
        //String s="sauhhs";
        String s="1";
        Integer numero = converteEmNumero(s);
        System.out.println(numero);

        Optional<Integer> numero2 = converteEmNumero2(s); //isso e um objeto, que pode conter um inteiro, ou nao
        // usando optional
        System.out.println(numero2.isPresent()); //retorna se esse valor esta preenchido ou nao
        //System.out.println(numero2.get()); // se nao tiver um valor, o get() vai lancar Exception
        if(numero2.isPresent()) {
            System.out.println(numero2.get()); //nao e a mais interessante pq ainda temos que tratar a Excecao
        }
        // jeitos mais interessantes de pegar o valor do Optional: ifPresent, orElse, orElseGet, orElseThrow
        numero2.ifPresent(n -> System.out.println(n)); //recebe uma Expressao Lamba (Um Consumer) e so executa caso tenha um valor

        //perceba que estamos caminhando para uma programacao muito mais declarativa, e muito menos imperativa
        //estamos cada vez mais dizendo pro codigo o que fazer, e menos o como fazer
        converteEmNumero2(s).ifPresent(n -> System.out.println(n));

        Integer orElse = converteEmNumero2(s).orElse(2); //se consegue converter retorna o numero, se nao, retorna 2

        // orElseGet recebe uma funcao lambda (Supplier)
        // voce pode fazer uma operacao pesada sem ter medo de que isso va atrapalhar a performance do sistema
        // pq ele so vai executar aquilo ali se ele de fato nao receber um valor
        //Integer orElseGet = converteEmNumero2(s).orElseGet(() -> {return operacaoPesada();});

        // orElseThrow - lanca uma Exception caso o Optional esteja vazio - Receber uma funcao lambda (supplier)
        Integer numero3 = converteEmNumero2(s)
                .orElseThrow(() -> new NullPointerException("Valor Vazio."));

        // QUANDO VOCE ESTA USANDO STREAMS
        Optional<Integer> first = Stream.of(1, 2, 3)
                .findFirst(); //retuns an Optional describing the first element of this stream, or an empty optional if the stream is empty
        System.out.println(first.get());

        Stream.of(1, 2, 3)
                .findFirst() //retuns an Optional describing the first element of this stream, or an empty optional if the stream is empty
                //.ifPresent(n -> System.out.println(n));
                .ifPresent(System.out::println);
    }
    // exemplo de codigo ate o java 7
    public static Integer converteEmNumero(String numeroStr) {
        try {
            return Integer.valueOf(numeroStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    //usando optional do java 8
    public static Optional<Integer> converteEmNumero2(String numeroStr) {
        try {
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.of(integer);
        } catch (NumberFormatException e) {
            return Optional.empty();
            //return Optional.ofNullable(null); //mesma coisa que o de cima
            //return Optional.of(null);         //nao pode, lanca excecao
        }
    }

    // tipos primitivos - OptionalInt, OptionalDouble e OptionalLong
    public static OptionalInt converteEmNumero3(String numeroStr) {
        try {
            int integer = Integer.parseInt(numeroStr);
            return OptionalInt.of(integer);
        } catch (NumberFormatException e) {
            return OptionalInt.empty();
            //return Optional.ofNullable(null); //mesma coisa que o de cima
            //return Optional.of(null);         //nao pode, lanca excecao
        }
    }
}

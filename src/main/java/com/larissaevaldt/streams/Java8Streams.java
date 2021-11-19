package com.larissaevaldt.streams;

import java.util.*;
import java.util.stream.Collectors;

// JAVA 8: STREAMS
//https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo
public class Java8Streams {

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        // ITERANDO A LISTA: JAVA 4
        for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
            Integer integer = (Integer) iterator.next();
            System.out.println(integer);
        }

        // ITERANDO A LISTA: JAVA 5
        for (Integer integer : lista) {
            System.out.println(integer);
            //mais conciso porem, aqui temos a limitacao e nao conseguir mexer na lista enquanto iterando
        }

        // ITERANDO A LISTA: JAVA 8
        lista.stream().forEach(e -> System.out.println(e));

        // A grande diferenca e que estamos usando um 'stream'
        // O stream, e um pouco diferente, ele e como se fosse um fluxo de dados, onde
        // cada um desses dados e um numero da Lista, nesse exemplo
        // e esta percorrendo o stream

        System.out.println();

        // OPERACOES INTERMEDIARIAS - operacaoes que podemos fazer varias delas antes de fechar o stream
        // antes de fazer uma operacao final
        // O ideal e fazer operacoes de filtro primeiro, pois nao faz sentido transformar todos os items pra excluir depois
        lista.stream()
                .skip(2) //pula ou ignora os 2 primeiros dados do stream
                .limit(5) //processa apenas 5 elementos, e ignora o resto
                .distinct() //nao permite que o stream processe numeros repetidos (usa equals hashcode)
                .filter(e -> e % 2 == 0) //filtro personalizado, permite que implemente o filtro que quiser
                .map(e -> e * 2) //transformacao de dados
                .forEach(e -> System.out.println(e));

        // a lista original nao e modificada
        System.out.println(lista);  //imprime a lista de antes

        //OPERACOES FINAIS - fecha o stream, nao conseguimos fazer nenhuma outra operacao com ele
        long count = lista.stream()
                .filter(e -> e % 2 == 0)
                .count(); //retorna a qtd de itens que ficou nesse stream

        System.out.println(count);

        Optional<Integer> min = lista.stream()
                .filter(e -> e % 2 == 0)
                .min(Comparator.naturalOrder()); //tem .max() tbm

        System.out.println(min.get());

        // Caso precise de uma operacao final mais personalizada
        List<Integer> newList = lista.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(newList);
        //outro exemplo: Collectors.groupingBy() - cria um mapa por algum criterio que voce queira
        Map<Boolean, List<Integer>> mapa = lista.stream()
                .map(e -> e * 3)
                .collect(Collectors.groupingBy(e -> e % 2 == 0)); //agroupar entre numeros pares e impares

        System.out.println(mapa);
        // exemplo agrupando pelo resto da divisao por 3
        Map<Integer, List<Integer>> collect = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3)); //agroupar entre numeros pares e impares
        System.out.println(collect);
        //muito util para agrupar entidades, nesse caso estamos trabalando com numeros
        //mas pensa que voce tem uma lista de clientes e voce quer agrupar eles por idade, por exemplo, ou por endereco.
        //voce consegue agrupar aqui, por qualquer atributo da sua classe que voce queira!

        //outro exemplo: Collectors.joining() - so trabalha com Strings (agrupa)
        String collected = lista.stream()
                .map(e -> String.valueOf(e))
                //.collect(Collectors.joining()); // retorna a juncao de cada um daqueles numeros em uma unica string
                .collect(Collectors.joining(";")); //adiciona um ; entre os numeros
        System.out.println(collected);

        // Agora, pq usar streams ao inves de um loop, um for, ou while?
        // STREAMS basicamente sao LOOPS IMPLICITOS
        // for - while - do..while sao LOOPS EXPLICITOS
        // com o stream, nao e que voce nao tem um loop, claro que tem
        // so que voce nao sabe como esta sendo feito, nao e voce que precisa controlar
        // voce so passa os dados, diz que tipo de operacao que voce quer que seja feita, e o stream faz pra voce
        // alem disso, transformar o stream pra rodar em paralelo e extremamente facil
    }
}

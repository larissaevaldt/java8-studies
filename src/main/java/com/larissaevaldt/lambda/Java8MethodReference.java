package com.larissaevaldt.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/* JAVA 8 - Method Reference (Referencias a metodos)
 * Tem uma sintax nao muito complicada e
 * Ajuda muito em diminuir codigo quando vamos escrever funcoes lambda
 * Basicamente e uma outra forma da gente representar uma funcao lambda
 */
public class Java8MethodReference {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .forEach(System.out::println); //method reference
        list.stream()
                .forEach(e -> System.out.println(e)); // exatamente a mesma coisa, mas sem usar method reference

        // Existem 4 tipos diferentes de method reference:

        // 1 - metodos estaticos
        list.stream()
                //recebemos n como argumento, e passamos ele como argumento de outro metodo
                .map(n -> multipliquePorDois(n)) //sem method reference
                .forEach(System.out::println);
        list.stream()
                //aqui estamos usando method reference com o nome de uma Classe antes do ::
                .map(Java8MethodReference::multipliquePorDois) //com method reference
                .forEach(System.out::println);

        // 2 - construtores
        list.stream()
                // recebemos n como argumento e passamos ele para um construtor
                .map(n -> new BigDecimal(n)) //sem method reference
                .forEach(System.out::println);
        list.stream()
                //aqui estamos usando method reference com o construtor da classe BigDecimal
                .map(BigDecimal::new) //com method reference
                .forEach(System.out::println);

        // 3 - varias instancias
        list.stream()
                //recebemos n como argumento e estamos chamando o metodo do n
                .map(n -> n.doubleValue()) //sem method reference
                .forEach(System.out::println);
        list.stream()
                .map(Integer::doubleValue) //com method reference
                .forEach(System.out::println);

        // 4 - Uma unica instancia
        BigDecimal dois = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                //recebemos b como argumento e passamos com argumento de uma instancia que e sempre a mesma instancia
                .map((b) -> dois.multiply(b)) //sem method reference
                .forEach(System.out::println);
        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply) //chamando multiply diretamente no objeto
                .forEach(System.out::println);
    }

    private static Integer multipliquePorDois(Integer i) {
        return i * 2;
    }
}

package com.larissaevaldt.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Method reference e uma forma de escrever uma expressao lambda mas de forma reduzida
 * pra quando voce precisa apenas chamar um metodo ja existente
 */
public class Java8MethodReference2 {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Larissa", true, "123");
        Cliente c2 = new Cliente("Bruno", true, "456");
        List<Cliente> clientes = Arrays.asList(c1, c2);

        clientes.forEach(c -> System.out.println(c.getNome())); //lambda expression
        // vamos reescrever a linha de cima usando method reference
        // como o metodo getNome() ja existe e nos so estamos usando lambda para chamar ele,
        // a gente tem como escrever isso de uma forma um pouco mais enxuta:
        clientes.forEach(Cliente::getNome); //O tipo, os delimitadores ::, o nome do metodo que voce quer chamar, sem ()

        // utilizando referencia aos metodos de instancia
        //quero chamar o metodo getNome de um cliente especifico, exemplo: Cliente Ana
        Cliente c3 = new Cliente("Ana", false, "333");
        //A gente vai utilizar a interface Consumer. Lembrando que assim como as expressoes lambdas
        //nos so podemos usar o method reference em interfaces funcionais.
        Consumer<Cliente> consumidor1 = Cliente::getNome;
        //mas ainda esta generalizado, ele nao sabe qual cliente que a gente quer que mostre o nome
        //precisamos chamar o metodo accept() do Consumer e passar como argumento o Cliente que a gente quer mostrar o nome
        consumidor1.accept(c3);

        // exemplo com interface funcional que o metodo nao precisa de argumento, que o caso do Runnable
        Runnable r1 = c3::getNome; // a gente ja passa direto qual que a instancia que queremos que ele use
        r1.run();  // em seguida, chamamos o method run() pra que eeja invocado entao esse metodo getNome()

        Runnable r = () -> System.out.println("Hello world!"); //lambda expresiion
        new Thread(r).start();

    }
}

class Cliente {
    private String nome;
    private boolean status;
    private String senha;

    public Cliente(String nome, boolean status, String senha) {
        this.nome = nome;
        this.status = status;
        this.senha = senha;
    }

    public String getNome() {
        System.out.println(this.nome);
        return nome;
    }

    public boolean isStatus() {
        return status;
    }

    public String getSenha() {
        return senha;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treinadores;

import TiposDePokemon.*;
import pokedexf.*;
import Pokemons.*;
import java.util.Collection;
import java.util.Scanner;

/**
 * Interface de Criação interativa.
 *  Essa classe não pode ser abstrata, porque ela cria um novo Treinador.
 * @author Mathews
 */
public class Treinador
{
    protected String nome;
    protected int idade;
    protected String genero;
    protected int insignias;
    protected int numPokemons;
    protected int nivel;
    protected int xpT;
    protected Collection pokes;

    /**
     * Construtor de sobrecarga padrão para classe Treinador
     *
     * @author Mathews
     * @param name
     * @param id
     * @param gen
     * @param ins
     * @param num
     * @param niv
     * @param xptreinador
     */
    public Treinador(String name, int id, String gen, int ins, int num, int niv, int xptreinador)
    {
        this.nome = name;
        this.idade = id;
        this.genero = gen;
        this.insignias = ins;
        this.numPokemons = num;
        this.nivel = niv;
        this.xpT = xptreinador;
        

    }

    /**
     * Construtor "interativo" da classe Treinador Se não for passado parametro,
     * você criará um novo treinador do zero
     *
     * @author Mathews
     */
    public Treinador()
    {
        this.insignias = 0;
        this.numPokemons = 0;
        this.nivel = 1;
        this.xpT = 0;

        Scanner s = new Scanner(System.in);
        int x;

        System.out.println("========Bem vindo ao jogo, treinador!========");
        System.out.println("\nPor favor, diga-me alguns dados sobre você:");
        System.out.println("Qual é o seu nome? ");
        this.nome = s.next();

        int flag = 1;
        while (flag == 1)
        {
            try
            {
                System.out.println("Quantos anos você tem? ");
                x = Integer.parseInt(s.next());
                this.idade = x;
                flag = 0;
            }
            catch (NumberFormatException erro)
            {
                System.out.println("Idade Inválida, Tente Novamente!!");
            }
        }

        while (flag == 0)
        {
            try
            {
                System.out.println("Você é garoto(M) ou garota(F)?  ");
                String sexo = s.next();

                if ("M".equals(sexo) || "m".equals(sexo))
                {
                    this.genero = "Masculino";
                    flag = 1;
                }
                else if ("F".equals(sexo) || "f".equals(sexo))
                {
                    this.genero = "Feminino";
                    flag = 1;
                }
                else
                {
                    throw new erro("\nGênero inválido, tente novamente!");
                }
            }
            catch (erro erro)
            {
                System.out.println(erro);
            }
        }
    }

    void setpokemons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class erro extends Exception
    {
        private erro(String message)
        {
            super(message);
        }
    }

    /**
     * Exibe os todos os dados do Treinador
     *
     * @return 
     */
    public String apresentaTreinador()
    {
        return "<br> Treinador: " + getNome()+
        "<br> Idade: " + getIdade() +
        "<br> Gênero: " + getGenero()+
        "<br> Insignias: " + getInsignias() +
        "<br>Número de Pokemons: " + getNumPokemons()+
        "<br>Nivel do Treinador: " + getNivelAtual()+
        "<br> XP Atual: " + getXpT() + "\n";

    }

    /**
     * Quantos pokemons o treinador pode ganhar a cada vitoria?
     *
     * @param x
     */
    public void GanharPokemons(int x)
    {
        this.numPokemons = this.numPokemons + x;
    }
    

    /**
     * A cada 100 de xp, sobe de nivel. Essa classe funciona em conjunto com a
     * ganharXpT
     * @param n
     */
    protected void subirDeNivel(int n)                     //A cada 100 de xp, sobe de nivel
    {
        this.nivel = nivel + n;
    }

    /**
     * Ganhar um quantidade de XP Se a soma do xp atual e xp do parametro forem
     * maior que 100, Treinador sobe de nivel O valor de XP passado como
     * parâmetro deverá ser random entre 0 e 100
     *
     * @param xp
     */
    public void ganharXpT(int xp)
    {
        int soma = xpT + xp;
        if (soma < 100)
        {
            this.xpT = soma;
        }
        else
        {
            subirDeNivel(xp / 100);
            this.xpT = soma - 100;
            System.out.println("\n=>Você subiu de nivel!!!!");
            System.out.println("=>Xp Atual: " + getXpT());
            System.out.println("=>Level Atual: " + getNivelAtual());
        }

    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public int getInsignias()
    {
        return insignias;
    }

    public void setInsignias(int insignias)
    {
        this.insignias = insignias;
    }

    public int getNumPokemons()
    {
        return numPokemons;
    }

    public int getNivelAtual()
    {
        return nivel;
    }

    public int getXpT()
    {
        return xpT;
    }

}

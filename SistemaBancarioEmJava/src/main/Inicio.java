/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author Vinicius-Pamplona
 */
import service.Servicos;
import java.util.Scanner;
public class Inicio {
    public static void main(String[] args) {
        Servicos banco = new Servicos();
        banco.carregarContas();
        Scanner entrada = new Scanner(System.in);
        boolean verdade = true;
        while(verdade){
            System.out.println("########## Banco do Brasil ##########");
            System.out.println("ESCOLHA UMA OPÇÃO:");
            System.out.println("1 - Abrir nova conta.");
            System.out.println("2 - Depósito");
            System.out.println("3 - Saque");
            System.out.println("4 - Sair");
            
            int op = entrada.nextInt();
            if (op == 1){
                System.out.println("-> Abrir nova conta");
                System.out.println("Digite o numero da conta que deseja criar: ");
                int numero = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Digite o nome do titular da conta");
                String nome = entrada.nextLine();
                System.out.println("Digite o saldo da conta");
                double saldo = entrada.nextDouble();
                banco.novaConta(numero, nome, saldo);    
            }
            if(op == 2){
                System.out.println("-> Depósito");
                System.out.println("Digite o numero da conta que deseja Depositar: ");
                int numero = entrada.nextInt();
                System.out.println("Digite o Valor a ser Depositado: ");
                double valor = entrada.nextDouble();
                banco.depositar(numero, valor);
            }
            if(op == 3){
                System.out.println("-> Saque");
                System.out.println("Digite o numero da conta que deseja Sacar: ");
                int numero = entrada.nextInt();
                System.out.println("Digite o Valor a ser Sacado: ");
                double valor = entrada.nextDouble();
                banco.sacar(numero, valor);
            }
            if(op == 4){
                System.out.println("Fechando Banco....");
                verdade = false;
                System.out.println("Banco Fechado.");
                banco.salvarContas();
            }
            
            
            
            
            
            
            
        }
         
         
         
         
         
         
         
         
         
    }

}

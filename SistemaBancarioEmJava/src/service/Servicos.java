/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

/**
 *
 * @author Vinicius-Pamplona
 */
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.FileWriter;
import model.Conta;
import java.io.FileReader;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
public class Servicos {  
    private ArrayList<Conta> contas;

    public Servicos() {
        this.contas = new ArrayList<>();
    }
    public void novaConta(int numero, String nome, double saldo){

        Conta existe = validarConta(numero);

        if (existe != null){

            System.out.println("Conta Já Existe!");

            return;
        }

        Conta nova = new Conta(numero, nome, saldo);

        contas.add(nova);

        System.out.println("Conta criada com sucesso!");
    }
    
    public Conta validarConta(int numero){

        for(Conta conta : contas){

            if(conta.getNumero() == numero){
                return conta;
            }
        }
        return null;
} 
    
    public void depositar(int numero, double valor){
        Conta conta;
        conta = validarConta(numero);
        double saldo = conta.getSaldo();
        if (conta != null){
            saldo += valor;
            conta.setSaldo(saldo);
            System.out.println("Depositado com sucesso o valor de R$ " + valor);
        }
    }
    
    public void sacar(int numero, double valor){
        Conta conta;
        conta = validarConta(numero);
        
        if (conta != null){
            
            if(conta.getSaldo() < valor){
                System.out.println("Saldo insuficiente!");
            }
            else{
                Double saque = conta.getSaldo() - valor;
                conta.setSaldo(saque);
                System.out.println("Saque Realizado com sucesso no valor de R$ "+ valor);
            }
            
        }
        
    }
    public void salvarContas(){
        Gson gson = new Gson();
        String json = gson.toJson(contas);
        
        try {
            FileWriter writer = new FileWriter("dados/contas.json");
            writer.write(json);
            writer.close();
            System.out.println("Salvo com sucesso!");
            
        } catch (Exception e) {
            System.out.println("Erro ao salvar!");
            e.printStackTrace();
        }
        
    }
    public void carregarContas(){

        Gson gson = new Gson();

        try (FileReader reader = new FileReader("dados/contas.json")) {

            Type tipoLista = new TypeToken<ArrayList<Conta>>(){}.getType();

            contas = gson.fromJson(reader, tipoLista);

            if(contas == null){
                contas = new ArrayList<>();
            }

            System.out.println("Contas carregadas com sucesso!");

        } catch (Exception e) {

            contas = new ArrayList<>();

            System.out.println("Nenhum arquivo encontrado ou erro ao carregar.");

        }

    }

}

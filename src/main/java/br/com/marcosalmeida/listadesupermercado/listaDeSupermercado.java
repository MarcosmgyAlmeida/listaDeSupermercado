package br.com.marcosalmeida.listadesupermercado;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class listaDeSupermercado {

    String[] lista = new String[10];

    @GetMapping("supermercado/listar")
    public String[] lista() {

        return lista;

    }


    @GetMapping("supermercado/adicionar/{produto}")
    public String adicionarProduto(@PathVariable("produto") String produto) {

        String fraseRetorno = "";

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = produto;
                fraseRetorno = "Produto adicionado com sucesso";
                break;
            } else if (lista[i] != null) {
                fraseRetorno = "Espaço insuficiente";
            }
        }
        return fraseRetorno;
    }

    @GetMapping("supermercado/deletar/{produto}")
    public String deletarProduto(@PathVariable("produto") String produto) {
        String fraseRetorno = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(produto)) {
                lista[i] = null;
                fraseRetorno = "Produto deletado com sucesso";
                break;
            }
        }
        return fraseRetorno;
    }

    @GetMapping("supermercado/alterar/{produtoAntigo}/{produtoNovo}")
    public String alterarProduto(@PathVariable("produtoAntigo") String produtoAntigo, @PathVariable("produtoNovo") String produtoNovo) {
        String fraseRetorno = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(produtoAntigo)) {
                lista[i] = produtoNovo;
                fraseRetorno = "Produto alterado com sucesso";
                break;
            }
        }
        return fraseRetorno;
    }
}
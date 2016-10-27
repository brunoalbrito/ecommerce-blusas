//package br.com.lp2.testeproduto;
//
//import com.br.lp2.dao.ProdutoDAO;
//import com.br.lp2.model.javabeans.Produto;
//import java.util.ArrayList;
//
///**
// *
// * @author Bruno
// */
//public class Produtos {
//
//    public static void main(String[] args) {
//        
//        /**
//         * Teste de Cadastro de Produto
//         */
//        Produto p = new Produto();
//        p.setId_produto(1);
//        p.setCor("Vermelho");
//        p.setTamanho('M');
//        p.setPreco(111.50);
//        p.setDescricao("Blusão da FCI");
//        
//        ProdutoDAO pdao = new ProdutoDAO();
//        pdao.insert(p);
//        
//        
//        /**
//         * Teste Excluir
//         */
//        Produto excluir = new Produto();
//        excluir.setId_produto(0);
//        pdao.remove(excluir);
//        
//        /**
//         * Teste alterar
//         */
//        p.setId_produto(2);
//        p.setCor("Preto");
//        pdao.modify(p);
//        
//        
//        /**
//         * Lista todos os produtos
//         */
//        ArrayList<Produto> produtos = (ArrayList<Produto>) pdao.findAll();
//        for (Produto produto : produtos) {
//            System.out.println(produto);
//        }
//        
//        /**
//         * Listar por ID
//         */
//        p = pdao.findById(2);
//        System.out.println(p.toString());
//    }
//
//}

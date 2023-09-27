package br.com.luan.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.luan.model.Produto;
import br.com.luan.respitory.ProdutoRepository;

@Controller
@ResponseBody
public class ProdutoController {

	/*@GetMapping("/olamundo")
	public String olaMundo() {
		return "Olá Mundo";
	}*/
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/listarprodutos")
	public List<Produto> listarProdutos() {
		/*Produto p1 = new Produto("Celular sansuga", 35, 1299.99);
		Produto p2 = new Produto("Cafeteira arno", 10, 199.99);
		Produto p3 = new Produto("Rato sem fio", 150, 9.95);
		
		return Arrays.asList(p1, p2, p3);*/
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return produtoRepository.findById(id)
				.map(objetoGravado -> ResponseEntity.ok().body(objetoGravado))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
}

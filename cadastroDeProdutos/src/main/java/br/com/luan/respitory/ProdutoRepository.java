package br.com.luan.respitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luan.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

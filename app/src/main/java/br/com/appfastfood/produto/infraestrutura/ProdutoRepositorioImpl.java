package br.com.appfastfood.produto.infraestrutura;

import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.modelos.enums.CategoriaEnum;
import br.com.appfastfood.produto.dominio.repositorios.ProdutoRepositorio;
import br.com.appfastfood.produto.infraestrutura.entidades.ProdutoEntidade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositorioImpl implements ProdutoRepositorio {

    private final SpringDataProdutoRepository springDataProdutoRepository;

    public ProdutoRepositorioImpl(SpringDataProdutoRepository springDataProdutoRepository) {
        this.springDataProdutoRepository = springDataProdutoRepository;
    }

    @Override
    public void cadastrar(Produto produto) {
        ProdutoEntidade produtoSalvo = new ProdutoEntidade(
                produto.getNome().getNome(),
                produto.getPreco().getPreco(),
                produto.getUriImagem().getUriImagem(),
                produto.getCategoria().name(),
                produto.getDescricao().getDescricao()
        );

        this.springDataProdutoRepository.save(produtoSalvo);
    }

    @Override
    public void remover(Long id) {
       this.springDataProdutoRepository.deleteById(id);
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        ProdutoEntidade produtoSalvo = new ProdutoEntidade(
                produto.getNome().getNome(),
                produto.getPreco().getPreco(),
                produto.getUriImagem().getUriImagem(),
                produto.getCategoria().name(),
                produto.getDescricao().getDescricao()
        );

        this.springDataProdutoRepository.save(produtoSalvo);

        return produto;
    }

    @Override
    public Optional<List<Produto>> buscarPorCategoria(String categoria) {
        return Optional.empty();
    }
}
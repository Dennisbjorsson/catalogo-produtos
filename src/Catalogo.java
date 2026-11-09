import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Catalogo {

    public static void main(String[] args) {

        // Criando lista de produtos

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Notebook", 3500.00));
        produtos.add(new Produto("Mouse", 80.00));
        produtos.add(new Produto("Pendrive", 50.00));
        produtos.add(new Produto("Monitor", 1200.00));
        produtos.add(new Produto("Fone de ouvido", 95.00));
        produtos.add(new Produto("Webcam", 250.00));

        //   Filtrar produtos com preço maior que 100

        System.out.println("=== PRODUTOS COM PREÇO MAIOR QUE R$ 100 ===");

        List<Produto> produtosFiltrados = produtos.stream()
                  .filter(p -> p.getPreco() > 100)
                .collect(Collectors.toList());

        produtosFiltrados.forEach(System.out::println);



        System.out.println("\n=== PRODUTOS EM ORDEM ALFABÉTICA ===");

        List<Produto> produtosOrdenados = produtos.stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .collect(Collectors.toList());

        produtosOrdenados.forEach(System.out::println);


        System.out.println("\n=== BUSCAR PRODUTO ===");

        String nomeBusca = "Notebook";

          Optional<Produto> produtoEncontrado = produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nomeBusca))
                .findFirst();

        produtoEncontrado.ifPresentOrElse(
                produto -> System.out.println("Produto encontrado: " + produto.getNome() + " | Preço: R$ " + produto.getPreco()),
                () -> System.out.println("Produto não encontrado.")
        );
    }
}

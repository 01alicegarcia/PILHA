import java.util.*;

// Classe para representar a Pilha
public class Pilha {
    private ArrayList<Integer> elementos;

    // Construtor
    public Pilha() {
        elementos = new ArrayList<>();
    }

    // Método para empilhar um elemento
    public void empilhar(int elemento) {
        elementos.add(elemento);
    }

    // Método para desempilhar um elemento
    public int desempilhar() {
        if (elementos.isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    // Método para obter o topo da pilha
    public int topo() {
        if (elementos.isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }

    // Método para listar todos os elementos da pilha
    public void listar() {
        System.out.println("Elementos da pilha:");
        for (int i = elementos.size() - 1; i >= 0; i--) {
            System.out.println(elementos.get(i));
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Listar elementos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    int elementoInserir = scanner.nextInt();
                    pilha.empilhar(elementoInserir);
                    System.out.println("Elemento inserido com sucesso!");
                    break;
                case 2:
                    try {
                        int elementoRemovido = pilha.desempilhar();
                        System.out.println("Elemento removido: " + elementoRemovido);
                    } catch (EmptyStackException e) {
                        System.out.println("A pilha está vazia, não é possível remover elementos.");
                    }
                    break;
                case 3:
                    pilha.listar();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}


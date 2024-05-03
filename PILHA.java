import java.util.*;


public class Pilha {
    private ArrayList<Integer> elementos;

    
    public Pilha() {
        elementos = new ArrayList<>();
    }

    
    public void empilhar(int elemento) {
        elementos.add(elemento);
    }

    
    public int desempilhar() {
        if (elementos.isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    
    public int topo() {
        if (elementos.isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }

    
    public void listar() {
        System.out.println("Elementos da pilha:");
        for (int i = elementos.size() - 1; i >= 0; i--) {
            System.out.println(elementos.get(i));
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha();

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Listar elementos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opcao: ");
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
                        System.out.println("A pilha esta vazia, nao e possivel remover elementos.");
                    }
                    break;
                case 3:
                    pilha.listar();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}


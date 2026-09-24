public class Main {

    // Cada posicion se identifica con row = indice en NAMES (column no se usa en la traza).
    private static final String[] NAMES = {"A", "B", "C", "D", "E", "F", "G", "H"};

    private static Position pos(int id) {
        return new Position(id, 0);
    }

    /**
     * Un movimiento: addHead siempre; removeTail solo si no come.
     * Imprime una fila de la traza con todo el estado.
     */
    private static void move(Snake snake, String label, int headId, boolean eats) {
        int capBefore = snake.capacity();

        snake.addHead(pos(headId));
        boolean resized = snake.capacity() != capBefore;
        int transientSize = snake.size(); // size tras addHead, antes de removeTail

        if (!eats) {
            snake.removeTail();
        }

        System.out.printf("%-14s data=%-18s tail=%d head=%d size=%d (trans.=%d) capacity=%d resize=%s  logico=[%s]%n",
            label + (eats ? " (come)" : " (no come)"),
            snake.physicalString(NAMES),
            snake.tail(),
            snake.headIndex(),
            snake.size(),
            transientSize,
            snake.capacity(),
            resized ? "si (" + capBefore + "->" + snake.capacity() + ")" : "no",
            snake.logicalString(NAMES));
    }

    public static void main(String[] args) {
        Snake snake = new Snake(pos(0), pos(1)); // cola A, cabeza B

        System.out.printf("%-14s data=%-18s tail=%d head=%d size=%d capacity=%d%n",
            "inicial",
            snake.physicalString(NAMES),
            snake.tail(),
            snake.headIndex(),
            snake.size(),
            snake.capacity());

        move(snake, "N1", 2, false); // cabeza C
        move(snake, "N2", 3, true);  // cabeza D
        move(snake, "N3", 4, false); // cabeza E
        move(snake, "N4", 5, false); // cabeza F
        move(snake, "N5", 6, true);  // cabeza G
        move(snake, "N6", 7, false); // cabeza H
    }
}


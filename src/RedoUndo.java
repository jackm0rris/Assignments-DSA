
public class RedoUndo<T> {
    private class Node {
        private final T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    // undo
    public T undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("Undo not possible");
            return null;
        }
        currentState = currentState.prev;
        return currentState.state;
    }

    // start an operation
    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState != null) {
            newNode.prev = currentState;
            currentState.next = newNode;
        }
        currentState = newNode;
    }

    // redo
    public T redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("Redo not possible");
            return null;
        }
        currentState = currentState.next;
        return currentState.state;
    }

    public static void main(String[] args) {
        RedoUndo<Integer> manager = new RedoUndo<>();
        // states
        manager.addState(1);
        manager.addState(2);
        manager.addState(3);
        manager.addState(4);

        System.out.println("Undo: " + manager.undo()); // Should print 4
        System.out.println("Undo: " + manager.undo()); // Should print 3
        System.out.println("Redo: " + manager.redo()); // Should print 4
        System.out.println("Redo: " + manager.redo()); // Should print 5
    }
}


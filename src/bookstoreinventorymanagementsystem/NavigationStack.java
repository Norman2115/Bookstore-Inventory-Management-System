package bookstoreinventorymanagementsystem;

import java.util.Stack;

/**
 * The class represents a stack data structure that store page data history for
 * navigation purposes in a user interface.
 *
 * @author Teo Chung Henn
 * @param <T> the type of data stored in the navigation stack.
 */
public class NavigationStack<T> {

    private final Stack<T> navigationStack;

    /**
     * Constructs a new NavigationStack.
     */
    public NavigationStack() {
        navigationStack = new Stack<>();
    }

    /**
     * Pushes the specified page data onto the navigation stack.
     *
     * @param data the data to be pushed onto the stack.
     */
    public void pushPageData(T data) {
        navigationStack.push(data);
    }

    /**
     * Pops the page data from the top of the navigation stack.
     *
     * @return the data that was removed from the top of the stack.
     */
    public T popPageData() {
        return navigationStack.pop();
    }

    /**
     * Retrieves the page data from the top of the navigation stack without
     * removing it.
     *
     * @return the data on the top of the stack.
     */
    public T peekPageData() {
        return navigationStack.peek();
    }

    /**
     * Checks whether the navigation stack is empty.
     *
     * @return true if navigation stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return navigationStack.isEmpty();
    }
}

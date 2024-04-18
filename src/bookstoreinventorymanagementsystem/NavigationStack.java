package bookstoreinventorymanagementsystem;

import java.util.Stack;

/**
 *
 * @author Teo Chung Henn
 * @param <T>
 */
public class NavigationStack<T> {

    private final Stack<T> navigationStack;

    public NavigationStack() {
        navigationStack = new Stack<>();
    }

    public void pushPageData(T data) {
        navigationStack.push(data);
    }

    public T popPageData() {
        return navigationStack.pop();
    }

    public T peekPageData() {
        return navigationStack.peek();
    }

    public boolean isEmpty() {
        return navigationStack.isEmpty();
    }
}

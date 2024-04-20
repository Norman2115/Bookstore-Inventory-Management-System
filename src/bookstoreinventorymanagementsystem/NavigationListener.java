package bookstoreinventorymanagementsystem;

/**
 * The interface provides methods to handle navigation events between pages,
 * such as returning from the next page or proceeding to the next page.
 *
 * @author Teo Chung Henn
 */
public interface NavigationListener {

    /**
     * Called when returning from the next page. Implementations should handle
     * actions to be performed when navigating back to the current page.
     */
    void onReturnFromNextPage();

    /**
     * Called when proceeding to next page. Implements should handle actions to
     * be performed when navigating forward to the next page.
     */
    void onProceedToNextPage();
}

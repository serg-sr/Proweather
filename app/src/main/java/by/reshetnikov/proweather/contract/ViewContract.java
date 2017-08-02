package by.reshetnikov.proweather.contract;

/**
 * Created by SacRahl on 5/29/2017.
 */

public interface ViewContract<P extends PresenterContract> {

    void showMessage(String message);

    void onError(String message);
}

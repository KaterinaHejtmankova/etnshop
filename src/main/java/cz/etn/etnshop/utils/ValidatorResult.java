package cz.etn.etnshop.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 02.02.2017.
 */
public class ValidatorResult {

    private boolean valid = true;
    private List<String> errorMessages = new ArrayList<>();

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void addErrorMessage(String error) {
        this.errorMessages.add(error);
    }

    @Override
    public String toString() {
        return "ValidatorResult{" +
                "valid=" + valid +
                ", errorMessages=" + errorMessages +
                '}';
    }
}

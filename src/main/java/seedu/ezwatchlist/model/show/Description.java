package seedu.ezwatchlist.model.show;

import seedu.ezwatchlist.commons.util.AppUtil;

import static java.util.Objects.requireNonNull;
import static seedu.ezwatchlist.commons.util.AppUtil.checkArgument;

/**
 * Represents a Show's description in the watchlist.
 * Guarantees: immutable; is valid as declared in {@link #isValidDescription(String)}
 */
public class Description {
    public static final String MESSAGE_CONSTRAINTS =
            "Descriptions should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the show's description must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String fullDescription;

    /**
     * Constructs a {@code Name}.
     *
     * @param description A valid description.
     */
    public Description(String description) {
        requireNonNull(description);
        AppUtil.checkArgument(isValidDescription(description), MESSAGE_CONSTRAINTS);
        fullDescription = description;
    }

    /**
     * Returns true if a given string is a valid description.
     */
    public static boolean isValidDescription(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullDescription;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Description // instanceof handles nulls
                && fullDescription.equals(((Description) other).fullDescription)); // state check
    }

    @Override
    public int hashCode() {
        return fullDescription.hashCode();
    }
}
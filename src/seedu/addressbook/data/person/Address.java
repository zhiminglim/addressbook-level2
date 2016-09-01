package seedu.addressbook.data.person;

import java.util.regex.Pattern;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format \"a/Block, Street, Unit, Postal Code\"";
    public static final String ADDRESS_VALIDATION_REGEX = "[^,]+, [^,]+, [^,]+, [^,]+";
    public static final String ADDRESS_SPLIT_REGEX = ", ";
    public static final String ADDRESS_PRINT_REGEX = "%s, %s, %s, %s";

    // public final String value;
    private boolean isPrivate;
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException
     *             if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        Pattern p = Pattern.compile(ADDRESS_SPLIT_REGEX);
        String[] items = p.split(address);
        block = new Block(items[0]);
        street = new Street(items[1]);
        unit = new Unit(items[2]);
        postalCode = new PostalCode(items[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format(ADDRESS_PRINT_REGEX, block, street, unit, postalCode);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                        && this.toString().equals(((Address) other).toString())); // state
                                                                                  // check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
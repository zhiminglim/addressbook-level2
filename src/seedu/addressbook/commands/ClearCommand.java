package seedu.addressbook.commands;

import seedu.addressbook.common.Utils;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = "Clears address book permanently.\n" + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";

    public ClearCommand() {
    }

    @Override
    public CommandResult execute() {
        addressBook.clear();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

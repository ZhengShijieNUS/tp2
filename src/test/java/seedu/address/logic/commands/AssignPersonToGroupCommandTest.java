package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.group.Group;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

class AssignPersonToGroupCommandTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    
    @Test
    void execute_assign_success() {
        Person validPerson = model.getPerson(new Name("Alice Pauline"));
        Group validGroup = new Group();

        validGroup.setGroupName("Test");

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addGroup(validGroup);

        assertCommandSuccess(new AssignPersonToGroupCommand(validGroup, validPerson.getName()), model,
                String.format(
                        AssignPersonToGroupCommand.MESSAGE_SUCCESS, validPerson.getName(), validGroup), expectedModel);
    }
}

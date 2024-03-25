package Comands;

/*
 local класс и инициализатор
Map<String, Integer> rightHereMap = new HashMap<String, INeger>()
{
    {
        put("Key", "значение из enum")
        put("add", ADD)
        put("Key2", new AddCommand())
    }
}
*/

public enum CommandListArray {
    ADD("add"),
    ADD_IF_MAX("add_if_max"),
    CLEAR("clear"),
    COUNT_BY_WEAPON_TYPE("count_by_weapon_type"),
    COUNT_GREATER_THAN_SOUNDTRACK_NAME("count_greater_than_soundtrack_name"),
    EXECUTE_SCRIPT("execute_script"),
    EXIT("exit"),
    FILTER_LESS_THAN_MINUTES_OF_WAITING("filter_less_than_minutes_of_waiting"),
    HEAD("head"),
    HELP("help"),
    INFO("info"),
    REMOVE_BY_ID("remove_by_id"),
    REMOVE_LOWER("remove_lower"),
    SAVE("save"),
    SHOW("show"),
    UPDATE("update");

    private String command;
    CommandListArray(String command) {
        this.command = command;
    }
    public String getCommand() {
        return command;
    }
    public void setCommand(String newCommand) {
        command = newCommand;
    }
}

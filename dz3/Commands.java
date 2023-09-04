package exceptions_and_mistakes.dz3;

import exceptions_and_mistakes.dz3.exceptions.CommandEntryException;

public enum Commands {
    NONE,
    YES,
    NO,
    DATA,
    SELECT,
    BUY,
    EXIT;

    public static Commands findCommand(String message) throws CommandEntryException {
        //метод подбора разрешенной команды исходя из введенного сообщения пользователем с указанием на возможную
        //ошибку CommandEntryException для передачи по стэку выше
        Commands result = null;
        for (Commands commands : values()) {
            if (commands.name().equalsIgnoreCase(message)) {
                result = commands;
                break;
            }
        }
        //если сообщение не соответствует ни одной команде из enum Commands, то вызывается ошибка CommandEntryException
        if (result == null) throw new CommandEntryException("Такой команды не существует, введите снова.\n");
        return result;
    }

}



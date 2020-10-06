package business;

import java.util.ArrayList;
import java.util.List;

class Statements {

    private List<Statement> Statements;

    public Statements() {
        this.Statements = new ArrayList<>();
    }

    public void add(Statement statement) {
        Statements.add(statement);
    }

    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        for (Statement statement : Statements) {
            stringBuilder.append(newLine);
            stringBuilder.append(statement.show());
        }
        return stringBuilder.toString();
    }
}

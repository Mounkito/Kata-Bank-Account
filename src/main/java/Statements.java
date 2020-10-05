import java.util.ArrayList;
import java.util.List;

public class Statements {

    private List<statement> statements;

    public Statements() {
        this.statements = new ArrayList<>();
    }

    public void add(statement statement) {
        statements.add(statement);
    }

    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        for (statement statement : statements) {
            stringBuilder.append(newLine);
            stringBuilder.append(statement.show());
        }
        return stringBuilder.toString();
    }
}

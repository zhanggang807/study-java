package lang;

/**
 * 变量隐藏 和 影子变量
 * 其实就是 同名 成员变量和 局部变量 父子类同名成员变量问题
 */
public class VariableInParent {
    // Declaring instance variable with name `x`
    String x = "lang.VariableInParent`s Instance Variable";

    public void printInstanceVariable() {
        System.out.println(x);
    }

    public void printLocalVariable() {
        // Shadowing instance variable `x` with a local variable with the same name
        String x = "Local Variable";

        System.out.println(x);

        // If we still want to access the instance variable, we do that by using `this.x`
        System.out.println(this.x);
    }

    public static void main(String[] args) {
        VariableInParent parent = new VariableInParent();
        parent.printInstanceVariable();
        parent.printLocalVariable();
    }
}

class VariableInChild extends VariableInParent {
    // Hiding the lang.VariableInParent class's variable `x` by defining a variable in the child class with the same name.
    String x = "lang.VariableInChild`s Instance Variable";

    @Override
    public void printInstanceVariable() {
        System.out.print(x);

        // If we still want to access the variable from the super class, we do that by using `super.x`
        System.out.print(", " + super.x + "\n");
    }

    public static void main(String[] args) {
        VariableInChild child = new VariableInChild();
        child.printInstanceVariable();
    }
}

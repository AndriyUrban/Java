import java.util.ArrayList;
import java.util.List;

public class ElementBuffet {
    private int num;
    public List<Element> elements;

    public ElementBuffet(List<Element> elements) {
        this.elements = elements;
    }

    public Element next() {
        return elements.get(num++);
    }

    public void back() {
        num--;
    }

    public int getNum() {
        return num;
    }

    public static List<Element> checking(String input) {
        ArrayList<Element> elements = new ArrayList<>();
        int num = 0;
        while (num < input.length()) {
            char c = input.charAt(num);
            switch (c) {
                case '(':
                    elements.add(new Element(ElementType.LEFT_BRACKET, c));
                    num++;
                    continue;
                case ')':
                    elements.add(new Element(ElementType.RIGHT_BRACKET, c));
                    num++;
                    continue;
                case '+':
                    elements.add(new Element(ElementType.OP_PLUS, c));
                    num++;
                    continue;
                case '-':
                    elements.add(new Element(ElementType.OP_MINUS, c));
                    num++;
                    continue;
                case '*':
                    elements.add(new Element(ElementType.OP_MUL, c));
                    num++;
                    continue;
                case '/':
                    elements.add(new Element(ElementType.OP_DIV, c));
                    num++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            num++;
                            if (num >= input.length()) {
                                break;
                            }
                            c = input.charAt(num);
                        } while (c <= '9' && c >= '0');
                        elements.add(new Element(ElementType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Unexpected character: " + c);
                        }
                        num++;
                    }
            }
        }
        elements.add(new Element(ElementType.EOF, ""));
        return elements;
    }
    public static int expr(ElementBuffet elements) {
        Element element = elements.next();
        if (element.type == ElementType.EOF) {
            return 0;
        } else {
            elements.back();
            return plus_minus(elements);
        }
    }

    public static int plus_minus(ElementBuffet elements) {
        int value = mullet(elements);
        while (true) {
            Element element = elements.next();
            switch (element.type) {
                case OP_PLUS:
                    value += mullet(elements);
                    break;
                case OP_MINUS:
                    value -= mullet(elements);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                    elements.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + element.value);
            }
        }
    }

    public static int mullet(ElementBuffet elements) {
        int value = factor(elements);
        while (true) {
            Element element = elements.next();
            switch (element.type) {
                case OP_MUL:
                    value *= factor(elements);
                    break;
                case OP_DIV:
                    value /= factor(elements);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                    elements.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + element.value);
            }
        }
    }

    public static int factor(ElementBuffet elements) {
        Element element = elements.next();
        switch (element.type) {
            case NUMBER:
                return Integer.parseInt(element.value);
            case LEFT_BRACKET:
                int value = plus_minus(elements);
                element = elements.next();
                if (element.type != ElementType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + element.value);
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + element.value);
        }
    }
}

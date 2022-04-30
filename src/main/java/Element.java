import java.util.List;

public class Element {
        ElementType type;
        String value;
        int position;

        public Element (ElementType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Element(ElementType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }

        @Override
        public String toString() {
            return "Element{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
    }
}

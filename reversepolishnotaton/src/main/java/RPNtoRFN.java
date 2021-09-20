import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class RPNtoRFN {

    private RPNtoRFN() {
    }

    public static String process(String rpn) {
        Deque<String> stack = new ArrayDeque<>();
        Arrays.stream(rpn.split("\\s"))
                .forEach(symbol -> RPNtoRFNEnum.process(symbol, stack));
        return stack.pop();
    }

    enum RPNtoRFNEnum {

        UNARY_ADDITION("++", "++"::equals, x -> getUnaryBiConsumer(x).apply(x)),
        BINARY_ADDITION("+", "+"::equals, getBinaryBiConsumer()),
        BINARY_SUBTRACTION("-", "-"::equals, getBinaryBiConsumer());

        private String symbol;
        private Predicate<String> predicate;
        private Function<String, RPNtoRFNEnum> consumer;

        RPNtoRFNEnum(String symbol, Predicate<String> predicate, Function<String, RPNtoRFNEnum> consumer) {
            this.symbol = symbol;
            this.predicate = predicate;
            this.consumer = consumer;
        }

        public static void process(String symbol, Deque<String> stack) {
            Optional<RPNtoRFNEnum> optional = Arrays.stream(RPNtoRFNEnum.values())
                    .filter(operand -> operand.predicate.test(symbol))
                    .findFirst();
            if (optional.isPresent()) {
                RPNtoRFNEnum operand = optional.get();
                operand.consumer.accept(stack, operand);
            } else {
                stack.push(symbol);
            }
        }

        private static Function<String, RPNtoRFNEnum> getUnaryBiConsumer(String x) {
            return (stack, operand) -> {
                StringBuilder expressionBuilder = new StringBuilder();
                expressionBuilder.append("(");
                expressionBuilder.append(stack.pop());
                expressionBuilder.append(operand.symbol);
                expressionBuilder.append(")");
                stack.push(expressionBuilder.toString());
            };
        }

        private static BiConsumer<Deque<String>, RPNtoRFNEnum> getBinaryBiConsumer() {
            return (stack, operand) -> {
                StringBuilder expressionBuilder = new StringBuilder();
                expressionBuilder.append("(");
                String secondNumber = stack.pop();
                String firstNumber = stack.pop();
                expressionBuilder.append(firstNumber);
                expressionBuilder.append(operand.symbol);
                expressionBuilder.append(secondNumber);
                expressionBuilder.append(")");
                stack.push(expressionBuilder.toString());
            };
        }
    }
}
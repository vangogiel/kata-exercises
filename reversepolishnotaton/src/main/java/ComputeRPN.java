import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class ComputeRPN {

    public static BigDecimal compute(String expression) {
        Deque<BigDecimal> stack = new ArrayDeque<>();
        Arrays.stream(expression.split("\\s"))
                .forEach(argument -> Operation.process(argument, stack));
        return stack.pop().setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private enum Operation {

        ADDITION("+"::equals, (operation, stack) -> getBiConsumer(stack, (x, y) -> x.add(y))),
        SUBTRACTION("-"::equals, (operator, stack) -> getBiConsumer(stack, (x, y) -> y.subtract(x))),
        MULTIPLICATION("*"::equals, (operation, stack) -> getBiConsumer(stack, (x, y) -> x.multiply(y))),
        DIVISION("/"::equals, (operation, stack) -> getBiConsumer(stack, (x, y) -> y.divide(x)));

        private final Predicate<String> pattern;
        private final BiConsumer<String, Deque<BigDecimal>> consumer;

        Operation(Predicate<String> pattern, BiConsumer<String, Deque<BigDecimal>> consumer) {
            this.pattern = pattern;
            this.consumer = consumer;
        }

        public static void process(String argument, Deque<BigDecimal> stack) {
            Optional<Operation> optonal = Arrays.stream(Operation.values())
                    .filter(operation -> operation.pattern.test(argument))
                    .findAny();
            if (optonal.isPresent()) {
                optonal.get().consumer.accept(argument, stack);
            } else {
                stack.push(new BigDecimal(argument));
            }
        }

        private static void getBiConsumer(Deque<BigDecimal> stack, BinaryOperator<BigDecimal> operator) {
            stack.push(operator.apply(stack.pop(), stack.pop()));
        }
    }
}

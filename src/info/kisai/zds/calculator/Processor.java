package info.kisai.zds.calculator;

import java.util.Deque;
import java.util.Queue;

/**
 * Created by spacefox on 09/10/15.
 */
interface Processor {
    void process(Token token, Queue<Token> queue, Deque<Token> stack);
}

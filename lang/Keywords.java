package lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keywords {
    public static final List<String> keywords = new ArrayList<>(
            Arrays.asList(
                    "add",
                    "sub",
                    "mul",
                    "div",
                    "inp",
                    "print",
                    "ln",
                    "println",
                    "printstr",
                    "<",
                    ">",
                    "func",
                    "def",
                    "alias",
                    "as",
                    "if",
                    "call",
                    "mkfile",
                    "open",
                    "read",
                    "write",
                    "close",
                    "writestr",
                    "strequ",
                    "arr",
                    "at",
                    "index",
                    "delarr",
                    "len",
                    "set",
                    "exit",
                    "setstr"
            )
    );

    public static final List<Character> chars = new ArrayList<>(
            Arrays.asList(
                    '.',
                    ',',
                    '(',
                    ')',
                    '}',
                    '{',
                    '>',
                    '<',
                    '=',
                    '!',
                    '+',
                    '-',
                    '*',
                    '/',
                    '@',
                    '%',
                    '$',
                    '#',
                    '"'
            )
    );

    public static final List<String> vars = new ArrayList<>(
            Arrays.asList(
//                    "vec3",
//                    "vec2",
//                    "tex"
            )
    );
}

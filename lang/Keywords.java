package lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keywords {
    public static final List<String> keywords = new ArrayList<>(
            Arrays.asList(
                    "__main",
                    "__tex",
                    "con",
                    "jmp",
                    "sample",
                    "out"
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
                    '/'
            )
    );

    public static final List<String> vars = new ArrayList<>(
            Arrays.asList(
                    "vec3",
                    "vec2",
                    "tex"
            )
    );
}

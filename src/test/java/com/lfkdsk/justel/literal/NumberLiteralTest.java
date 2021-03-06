package com.lfkdsk.justel.literal;

import com.lfkdsk.justel.utils.logger.Logger;
import org.junit.jupiter.api.Test;

import static com.lfkdsk.justel.compile.generate.JavaCodeGeneratorTest.compiler;
import static com.lfkdsk.justel.parser.JustParserImplTest.runExpr;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by liufengkai on 2017/8/10.
 */
class NumberLiteralTest {

    @Test
    void numberEval() {
        runExpr("123333333L", true, null);
        runExpr("123333333.100000", true, null);
        runExpr("0.22222222", true, null);
    }

    @Test
    void numberCompile() {
        Logger.init();

        Logger.i(compiler("123333333L",null));
        Logger.i(compiler("123333333.100000",null));
        Logger.i(compiler("0.22222222",null));
    }
}
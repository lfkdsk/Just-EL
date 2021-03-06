/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lfkdsk.justel.ast.operators;

import com.lfkdsk.justel.ast.base.AstNode;
import com.lfkdsk.justel.ast.function.OperatorExpr;
import com.lfkdsk.justel.context.JustContext;
import com.lfkdsk.justel.token.SepToken;

import java.util.List;

import static com.lfkdsk.justel.utils.TypeUtils.*;

/**
 * == Operator
 * eq: expr == expr
 *
 * @author liufengkai
 *         Created by liufengkai on 2017/7/26.
 * @see OperatorExpr
 */
public class EqualOp extends OperatorExpr {

    public EqualOp(List<AstNode> children) {
        super(children, AstNode.EQUAL_OP);
    }

    @Override
    public String funcName() {
        return SepToken.EQUAL_TOKEN.getText();
    }

    @Override
    public Object eval(JustContext env) {
        Object left = leftChild().eval(env);
        Object right = rightChild().eval(env);

        // boolean == boolean
        if (isBoolean(left) && isBoolean(right)) {

            return left.equals(right);
        } else if (isNumber(left) && isNumber(right)) {

            // num == num
            return left.equals(right);
        } else if (isString(left) && isString(right)) {

            return left.equals(right);
        }

        return super.eval(env);
    }
}

/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lfkdsk.justel.ast.function;

import com.lfkdsk.justel.ast.tree.AstFuncArguments;
import com.lfkdsk.justel.ast.tree.AstFuncExpr;
import com.lfkdsk.justel.context.JustContext;
import com.lfkdsk.justel.eval.Evaluable;
import com.lfkdsk.justel.exception.EvalException;

/**
 * Created by liufengkai on 2017/8/3.
 */
public abstract class ExtendFunctionExpr implements Function, Evaluable {

    private AstFuncExpr astFuncNode;

    public void bindToAstFunc(AstFuncExpr astFuncNode) {
        this.astFuncNode = astFuncNode;
    }

    @Override
    public Object eval(JustContext env) {
        if (astFuncNode != null) {
            AstFuncArguments args = astFuncNode.funcArgs();
            int count = args.childCount();
            // compute new args
            Object[] newArgs = new Object[count];
            for (int i = 0; i < count; i++) {
                newArgs[i] = args.child(i).eval(env);
            }

            if (!paramsCheck(newArgs)) {
                throw new EvalException("didn't pass params check.");
            }

            return eval(newArgs);
        }

        throw new EvalException("Undefined eval func");
    }

    @Override
    public String functionName() {
        throw new EvalException("Undefined function name", astFuncNode);
    }

    public abstract Object eval(Object[] params);

    public boolean paramsCheck(Object[] params) {
        return true;
    }
}

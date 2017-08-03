/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lfkdsk.justel.eval;

import com.lfkdsk.justel.context.JustContext;
import com.lfkdsk.justel.exception.EvalException;

/**
 * Expression : Evaluable Expression.
 *
 * @author liufengkai
 *         Created by liufengkai on 2017/7/20.
 */
public interface Expression extends Evaluable {

    @Override
    default Object eval(JustContext context) {
        throw new EvalException("Use default eval in expression");
    }
}

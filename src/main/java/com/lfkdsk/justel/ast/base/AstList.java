/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lfkdsk.justel.ast.base;

import com.lfkdsk.justel.context.JustContext;
import com.lfkdsk.justel.exception.EvalException;

import java.util.Iterator;
import java.util.List;

/**
 * AST List
 *
 * @author liufengkai
 *         Created by liufengkai on 17/7/11.
 */
public class AstList extends AstNode {

    protected List<AstNode> children;

    public AstList(List<AstNode> children, int tag) {
        super(tag);
        this.children = children;
        this.computeAstLevel();
    }

    @Override
    public AstNode child(int index) {
        return children.get(index);
    }

    @Override
    public Iterator<AstNode> children() {
        return children.iterator();
    }

    public List<AstNode> getChildren() {
        return children;
    }

    @Override
    public int childCount() {
        return children.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append('(');

        String sep = "";

        for (AstNode node : children) {
            builder.append(sep);
            sep = " ";
            builder.append(node.toString());
        }

        return builder.append(')').toString();
    }

    @Override
    public String location() {
        for (AstNode n : children) {
            String s = n.location();
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    @Override
    public AstNode replaceChild(int index, AstNode node) {
        return children.set(index, node);
    }

    @Override
    public int computeAstLevel() {
        int maxLevel = 1;
        for (int i = 0; i < childCount(); i++) {
            AstNode child = child(i);
            maxLevel = Math.max(child.computeAstLevel(), maxLevel);
        }

        return astLevel = maxLevel + 1;
    }

    public Object eval(JustContext env) {
        throw new EvalException("can not eval : " + toString(), this);
    }

    @Override
    public String compile(JustContext env) {

        StringBuilder builder = new StringBuilder();

        builder.append('(');

        String sep = "";

        for (AstNode node : children) {
            builder.append(sep);
            sep = " ";
            builder.append(node.compile(env));
        }

        return builder.append(')').toString();
    }
}

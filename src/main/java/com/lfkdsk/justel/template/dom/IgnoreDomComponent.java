package com.lfkdsk.justel.template.dom;

import com.lfkdsk.justel.context.JustContext;

/**
 * Ignore Component.
 * just control generateCode code not about exchange Vars
 *
 * @author liufengkai
 *         Created by liufengkai on 2017/7/18.
 */
public class IgnoreDomComponent implements DomComponent {

    private String[] ignoreDomString;

    IgnoreDomComponent(String... ignoreDomString) {
        this.ignoreDomString = ignoreDomString;
    }

    @Override
    public StringBuilder generateCode(JustContext context, StringBuilder builder) {
        for (String ignore : ignoreDomString) {
            builder.append(ignore).append(" ");
        }
        return builder;
    }

    @Override
    public boolean isValidate(JustContext context) {
        return true;
    }
}

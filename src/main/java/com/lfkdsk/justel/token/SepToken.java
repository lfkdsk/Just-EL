package com.lfkdsk.justel.token;

/**
 * Token the lexer will skip & reuse.
 *
 * @author liufengkai
 *         Created by liufengkai on 2017/7/24.
 * @see com.lfkdsk.justel.token.Token
 * @see com.lfkdsk.justel.lexer.JustLexerImpl
 * @see com.lfkdsk.justel.parser.JustParserImpl
 */
public class SepToken extends Token {

    public final static SepToken AMPERSAND_TOKEN = new SepToken(Token.AMPERSAND, ReservedToken.AMPERSAND_TOKEN);
    public final static SepToken AND_TOKEN = new SepToken(Token.AND, ReservedToken.LOGICAL_AND_TOKEN);

    public final static SepToken BAR_TOKEN = new SepToken(Token.BAR, ReservedToken.BAR_TOKEN);
    public final static SepToken OR_TOKEN = new SepToken(Token.OR, ReservedToken.LOGICAL_OR_TOKEN);

    public final static SepToken LESS_TOKEN = new SepToken(Token.LESS_THAN, ReservedToken.LT_TOKEN);
    public final static SepToken LTE_TOKEN = new SepToken(Token.LESS_EQUAL_THAN, ReservedToken.LTE_TOKEN);

    public final static SepToken GREAT_TOKEN = new SepToken(Token.GREAT_THAN, ReservedToken.GT_TOKEN);
    public final static SepToken GTE_TOKEN = new SepToken(Token.GREAT_EQUAL_THAN, ReservedToken.GTE_TOKEN);

    public final static SepToken QUESTION_TOKEN = new SepToken(Token.QUESTION, ReservedToken.QUESTION_TOKEN);
    public final static SepToken COLON_TOKEN = new SepToken(Token.COLON, ReservedToken.COLON_TOKEN);

    public final static SepToken PLUS_TOKEN = new SepToken(Token.PLUS, ReservedToken.PLUS);
    public final static SepToken MINUS_TOKEN = new SepToken(Token.MINUS, ReservedToken.MINUS);

    public final static SepToken MULTIPLY_TOKEN = new SepToken(Token.MULTIPLY, ReservedToken.MUL);
    public final static SepToken DIVIDE_TOKEN = new SepToken(Token.DIVIDE, ReservedToken.DIV);

    public final static SepToken MOD_TOKEN = new SepToken(Token.MOD, ReservedToken.MOD);

    public final static SepToken EXCLAM_TOKEN = new SepToken(Token.EXCLAM, ReservedToken.LOGICAL_F_TOKEN);
    public final static SepToken NOT_EQUAL_TOKEN = new SepToken(Token.NOT_EQUAL, ReservedToken.UQ_TOKEN);
    public final static SepToken EQUAL_TOKEN = new SepToken(Token.EQUAL, ReservedToken.EQ_TOKEN);

    public final static SepToken DOT_TOKEN = new SepToken(Token.DOT, ReservedToken.DOT_TOKEN);
    public final static SepToken COLLECT_GET_LEFT_TOKEN = new SepToken(Token.COLLECT_GET_LEFT, ReservedToken.LM_TOKEN);
    public final static SepToken COLLECT_GET_RIGHT_TOKEN = new SepToken(Token.COLLECT_GET_RIGHT, ReservedToken.RM_TOKEN);

    public final static SepToken EOL_TOKEN = new SepToken(Token.EOL_TAG, Token.EOL);

    /**
     * Skip text.
     */
    private String text;

    public SepToken(int tag, String text) {
        this(-1, tag, text);
    }

    public SepToken(int lineNumber, int tag, String text) {
        super(lineNumber, tag);
        this.text = text;

        if (text.equals(Token.EOL)) {
            this.tag = Token.EOL_TAG;
        }
    }

    @Override
    public boolean isIdentifier() {
        return true;
    }

    @Override
    public int getTag() {
        return super.getTag();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "SepToken{" +
                "text='" + text + '\'' +
                ", lineNumber=" + lineNumber +
                ", tag=" + tag +
                '}';
    }
}

package com.gui.demo.thingInJava.strings;/**
 * @Classname replacements
 * @Description TODO
 * @Date 2021/4/16 15:42
 * @Created by gt136
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname replacements
 * @Description TODO
 * @Date 2021/4/16 15:42
 * @Created by gt136
 */
public class replacements {
    public static void main(String[] args) {
        String s = "/*! Here's a block of text to use as input to\n" +
                "    the regular expression matcher. Note that we'll\n" +
                "    first extract the block of text by looking for\n" +
                "    the special delimiters, then process the\n" +
                "    extracted block. !*/";
        // Match the specially commented block of text above:
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if(mInput.find())
            s = mInput.group(1); // Captured by parentheses
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");

        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements:
        while(m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        // Put in the remainder of the text:
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
/*输出
Here's a block of text to use as input to
the regular expression matcher. Note that we'll
first extract the block of text by looking for
the special delimiters, then process the
extracted block.
H(VOWEL1)rE's A blOck Of tExt tO UsE As InpUt tO
thE rEgUlAr ExprEssIOn mAtchEr. NOtE thAt wE'll
fIrst ExtrAct thE blOck Of tExt by lOOkIng fOr
thE spEcIAl dElImItErs, thEn prOcEss thE
ExtrActEd blOck.
 */

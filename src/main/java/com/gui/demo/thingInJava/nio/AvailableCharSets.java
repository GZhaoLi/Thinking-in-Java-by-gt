package com.gui.demo.thingInJava.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 缓冲区包含普通字节，为了将这些字节转换为字符，我们必须在输入时对这些字节进行编码，或者在输出时对它们解码。这个类
 * @Date 2021/12/10 15:09
 * @Created by gt136
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsetSortedMap = Charset.availableCharsets();
        charsetSortedMap.keySet().forEach(c->{
            System.out.print(c);
            Iterator<String> aliases = charsetSortedMap.get(c).aliases().iterator();
            if (aliases.hasNext()) {
                System.out.print(": ");
            }
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        });
    }
}
/*
outputs:
Big5: csBig5
Big5-HKSCS: big5-hkscs, big5hk, Big5_HKSCS, big5hkscs
CESU-8: CESU8, csCESU-8
EUC-JP: csEUCPkdFmtjapanese, x-euc-jp, eucjis, Extended_UNIX_Code_Packed_Format_for_Japanese, euc_jp, eucjp, x-eucjp
EUC-KR: ksc5601-1987, csEUCKR, ksc5601_1987, ksc5601, 5601, euc_kr, ksc_5601, ks_c_5601-1987, euckr
GB18030: gb18030-2000
GB2312: gb2312, euc-cn, x-EUC-CN, euccn, EUC_CN, gb2312-80, gb2312-1980
GBK: CP936, windows-936
IBM-Thai: ibm-838, ibm838, 838, cp838
    ......
 */
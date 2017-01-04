package com.gjiazhe.wavesidebar;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by Administrator on 2016/12/1.
 */
public class ListSort {


    public static String HanziToPinyin(String str) {
        char chineseCharacter = str.charAt(0);
        if (chineseCharacter >= 65 && chineseCharacter <= 90) {
            return chineseCharacter + "";
        }

        if (chineseCharacter >= 97 && chineseCharacter <= 122) {
            return (chineseCharacter + "").toUpperCase();
        }

        String[] pinyinArray = PinyinHelper
                .toHanyuPinyinStringArray(chineseCharacter);

        StringBuffer pinyinStrBuf = new StringBuffer();
        String outputString = "";
        if ((null != pinyinArray) && (pinyinArray.length > 0)) {
            pinyinStrBuf.append(pinyinArray[0]);
            outputString = ((pinyinStrBuf.charAt(0)) + "").toUpperCase();
        } else {
            outputString = "#";
        }

        return outputString;
    }


    public static void listSort(List<Contact> contacts) {
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                int value = o1.getIndex().compareTo(o2.getIndex());
                if (value > 0)
                    return 1;// 升序  返回-1为false
                if (value < 0)
                    return -1;
                return value;
            }
        });
    }
}

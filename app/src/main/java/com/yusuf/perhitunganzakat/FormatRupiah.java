package com.yusuf.perhitunganzakat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FormatRupiah {

    public static String formatCurrency(Double paramDouble){
        DecimalFormat kursIndonesia = new DecimalFormat("#,###");
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("");
        formatRp.setMonetaryDecimalSeparator(' ');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        kursIndonesia.format(paramDouble);
        return kursIndonesia.format(paramDouble);
    }

    public static String replaceDot(String var){
        String result = var.replaceAll("\\.", "");
        return result;
    }

    public static String replaceComma(String var){
        String totalResult = var.replace(",", ".");
        return totalResult;
    }

    public static String replaceCommaToEmpty(String var){
        String result = var.replaceAll("\\.", "");
        return result;
    }
}

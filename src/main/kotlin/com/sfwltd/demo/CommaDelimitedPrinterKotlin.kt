package com.sfwltd.demo

import com.sfwltd.demo.java8.CommaDelimitedPrinter

class CommaDelimitedPrinterKotlin : CommaDelimitedPrinter {
    override fun delimit(vararg tokens: String?) =
            tokens.filterNotNull()
                .filter { it.length > 1 }
                .sortedBy { it.length }
                .joinToString(",")

}

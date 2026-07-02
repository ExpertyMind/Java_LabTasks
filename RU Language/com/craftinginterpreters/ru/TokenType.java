package com.craftinginterpreters.ru;

public enum TokenType {
    // Single-character tokens.
    BAYA_QOS,    // (
    DAYA_QOS,    // )
    BAYA_QURLY,  // {
    DAYA_QURLY,  // }
    ALAG,       // ,
    NUQTA,       // .
    TAFREEK,       // -
    JAMA,        // +
    WAQFA,       // ;
    TAQSEEM,     // /
    ZARB,        // *

    // One or two character tokens.
    NAHI,        // !
    NAHI_BARABAR,// !=
    BARABAR,     // =
    BARABAR_HAI, // ==
    BARA,        // >
    BARA_BARABAR,// >=
    CHHOTA,      // <
    CHHOTA_BARABAR, // <=

    // Literals.
    NAAM,    // identifier
    JUMLA,    // string "hello"
    ADAD,    // number 123

    // Keywords.
    AUR,     // and
    JAMAAT,  // class
    WARNA,   // else
    JHOOT,   // false
    KAAM,     // fun (kaam = work/function)
    GHUMPHIR,    // for
    AGAR,    // if
    KHAALI,  // nil
    YA,      // or
    LIKHO,   // print
    LIKHOLN, // print new line
    WAPAS,   // return
    UPAR,    // super
    YEH,     // this
    SACH,    // true
    RAKHO,   // var
    JABTAK, // while
    KHATAM   // EOF
}
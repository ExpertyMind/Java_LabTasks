kaam wordle() {
    // 10-Word Bank (All 5-letter tech words for true Wordle feel)
    rakho w1 = "mouse";
    rakho w2 = "board";
    rakho w3 = "cloud";
    rakho w4 = "logic";
    rakho w5 = "bytes";
    rakho w6 = "array";
    rakho w7 = "loops";
    rakho w8 = "coder";
    rakho w9 = "pixel";
    rakho w10 = "linux";

    likholn "--- RU-LANG WORDLE ---";
    likholn "Word bank mein 10 lafz hain.";
    rakho pick = adad(darj("Khelne ke liye 1 se 10 tak koi number likho: "));

    rakho lafz = w1;
    agar (pick == 2) { lafz = w2; }
    warna agar (pick == 3) { lafz = w3; }
    warna agar (pick == 4) { lafz = w4; }
    warna agar (pick == 5) { lafz = w5; }
    warna agar (pick == 6) { lafz = w6; }
    warna agar (pick == 7) { lafz = w7; }
    warna agar (pick == 8) { lafz = w8; }
    warna agar (pick == 9) { lafz = w9; }
    warna agar (pick == 10) { lafz = w10; }
    warna {
        // Fallback in case they type something invalid
        likholn "Ghalat number! Default word (1) select ho gaya.";
    }

    rakho len = qad(lafz);
    rakho max_tries = 6;
    rakho tries = 0;
    rakho jeeta = jhoot;

    likholn "";
    likholn "Game Shuru! Lafz " + len + " harf lamba hai.";
    likholn "Nishanat: [x] = Sahi jagah, ?x? = Ghalat jagah, _x_ = Lafz mein nahi";

    jabtak (tries < max_tries) {
        likholn "";
        likholn "Tries baqi: " + (max_tries - tries);
        rakho guess = darj("Pura lafz guess karo: ");

        agar (qad(guess) != len) {
            likholn "Ghalat lambai! Tumhara guess " + len + " harf ka hona chahiye.";
        }
        warna agar (guess == lafz) {
            jeeta = sach;
            tries = max_tries;
        }
        warna {
            rakho feedback = "";
            rakho i = 0;

            jabtak (i < len) {
                rakho cg = harf(guess, i);
                rakho cl = harf(lafz, i);

                agar (cg == cl) {
                    feedback = feedback + "[" + cg + "] ";
                }
                warna {
                    rakho mila = jhoot;
                    rakho j = 0;
                    jabtak (j < len) {
                        agar (harf(lafz, j) == cg) {
                            mila = sach;
                        }
                        j = j + 1;
                    }

                    agar (mila) {
                        feedback = feedback + "?" + cg + "? ";
                    } warna {
                        feedback = feedback + "_" + cg + "_ ";
                    }
                }
                i = i + 1;
            }

            likholn "Natija: " + feedback;
            tries = tries + 1;
        }
    }

    likholn "";
    agar (jeeta) {
        likholn "Kamaal kardiya! Tum jeet gaye. Lafz tha: " + lafz;
    } warna {
        likholn "Game over! Sahi lafz tha: " + lafz;
    }
}

wordle();
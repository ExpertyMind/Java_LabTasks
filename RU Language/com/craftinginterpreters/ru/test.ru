kaam guessGame() {
    rakho secret = betarteeb(1, 50);
    rakho tries = 0;
    rakho guessed = jhoot;

    likholn "Number Guessing Game!";
    likholn "1 aur 100 ke darmiyan number socho.";
    likholn "";

    jabtak (!guessed) {
        likholn secret;
        rakho guess = adad(darj(">> "));
        tries = tries + 1;

        agar (guess == secret) {
            guessed = sach;
        } warna agar (guess < secret) {
            likholn "Aur bara!";
        } warna {
            likholn "Aur chhota!";
        }
    }

    likholn "Sahi! " + tries + " tries mein guess kiya!";
}

guessGame();

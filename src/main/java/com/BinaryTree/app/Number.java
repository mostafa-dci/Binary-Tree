package com.BinaryTree.app;

// Diese Klasse repräsentiert eine positive ganze Zahl mit maximal 8 Stellen
// im Dezimalsystem.
class Number {
    // Anzahl der Stellen
    public final static int nDigits = 8;
    private int[] digits = new int [nDigits];
    
    //TODO: Variable(n) deklarieren
    // Initialisiert dieses Objekt mit dem Wert 'n'.
    // Es gilt: 0 <= n && n < Math.pow(10,nDigits).
    public Number (int n) {
        for (int i = 0; i < this.digits.length; i++) {
            this.digits[i] = n % 10;
            n /= 10;
            if(n == 0) {
                break;
            }
        }
    }
    
    // Initialisiert dieses Objekt mit dem gleichen Wert wie 'n'.
    public Number (Number n) {
        this.digits = n.digits;
    }
    
    // Liefert eine lesbare Respräsentation dieses Objekts.
    public String toString() {
        //TODO: Methode implementieren
        String s = "";
        for (int i = 0; i < this.digits.length; i++) {
            s += this.digits[digits.length - i - 1];
        }
        return s;
    }
    
    // Liefert die Ziffer an der Stelle pos.
    // Es gilt: 0 <= pos && pos < nDigits.
    public int getDigit(int pos) {
        //TODO: Methode implementieren
        return this.digits[pos];
    }

    // Ersetzt die Ziffer an der Stelle 'pos' durch die Ziffer 'd'.
    // Es gilt: 0 <= pos && pos < nDigits und 0 <= d && d <= 9.
    public void setDigit(int pos, int d) {
        //TODO: Methode implementieren
        this.digits[pos] = d;
    }

    // Inkrementiert die durch dieses Objekt dargestellte Zahl. Wird dabei der Wertebereich überschritten,
    // das heißt, die Zahl bekommt dadurch mehr als 8 Stellen, werden vom Ergebnis nur die ersten 8 (niederwertigsten)
    // Stellen gespeichert und durch den zurückgegebenen Wert 'true' wird signalisiert, dass es einen Überlauf
    // gegeben hat. Ohne Überlauf wird 'false' zurückgegeben.
    public boolean increment() {
        //TODO: Methode implementieren
        // return false;
        boolean overflow = false;
        for (int i = 0; i < digits.length; i++) {
            if(digits[i] == 9) {
                if(i == digits.length - 1) {
                    for (int j = 0; j < digits.length; j++) {
                        this.digits[j] = 0;
                    }
                    overflow = true;
                    break;
                } else {
                    digits[i] = 0;
                }
            } else {
                digits[i]++;
                break;
            }            
        }
        return overflow;
    }
}
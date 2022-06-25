package com.BinaryTree.app;

// Die Klasse 'BigNumber' repräsentiert eine positive ganze Zahl mit beliebigem Betrag. Der Wertebereich beginnt
// bei 0 und kann sowohl Integer.MAX_VALUE als auch Long.MAX_VALUE überschreiten, ohne dass die Funktionalität
// beeinträchtigt wird. Dies wird dadurch erreicht, dass BigNumber intern eine verkette Liste von 'Number'-Objekten
// verwendet. z.B. wird 750000456123456789 dargestellt durch drei Knoten 23456789 -> 4561 -> 75 -> null.
class BigNumber {
    // Konstruktor: Initialisiert dieses Objekt mit 'n'.
    private BinaryTree root;

    private class BinaryTree{
        private Number number;
        private BinaryTree left;
        private BinaryTree right;
        
        public BinaryTree(Number number) {
            this.number = number;
            this.left = null;
            this.right = null;
        }

        private void addBranch(BinaryTree p ,Number n){
            if(p.right == null){
                p.right = new BinaryTree(n);
            } else {
                p.right.addBranch(p.right, n);
            }
        }
        private void increment(BinaryTree node){
            if(node != null)
            if(node.number.increment()){
                if(node.right != null)
                    node.right.increment(node.right);
            }
        }
    }

    public BigNumber(long n) {
        while(n>0){
            this.add((int)(n%100000000));
            n /= 100000000;
        }
    }

    private void add(int n){
        if(this.root == null){
            this.root = new BinaryTree(new Number(n));
        } else {
            root.addBranch(root,new Number(n));
        }
    }

    // Inkrementiert die Zahl.
    public void increment(){
        //TODO: Methode implementieren
        if(this.root != null)
            this.root.increment(this.root);
        // this.root.increment(this.root);
    }
    
    // Ersetzt die Ziffer an der Stelle 'pos' durch die Ziffer 'd'.
    // Es gilt: pos >= 0 und 0 <= d && d <= 9.
    public void setDigit(int pos, int d) {
        //TODO: Methode implementieren
        int pointer = pos/8;
        int offset = pos%8;
       // while(pointer > 0){
            // if(this.root.right == null){
            //     this.root.right = new BinaryTree(new Number(0));
            // }else{
            //     // this.root.right.addBranch(this.root.right,new Number(0));
            // }
            // // this.root.right.number.setDigit(offset, d);
            // pointer--;
            // offset = 0;
       // }
    }
    
    // Konstruktor: Initialisiert dieses Objekt mit der Zahl, die als String angegeben wird.
    // 's' sei ein String, der ausschließlich Ziffern enthält.
    public BigNumber(String s) {
        //TODO: Konstruktor implementieren
        String str = "";
        for(int i = 0; i < s.length(); i++){
            str = s.charAt(s.length() - 1 - i) + str;
            if(i % 8 == 0 && i != 0){
                this.add(Integer.parseInt(str));
                str = "";
            }
            if(i == s.length()-1){
                this.add(Integer.parseInt(str));
            }
            // this.add(s.charAt(i)-'0');
        }
    }
    
    // Liefert eine lesbare Repräsentation des Objekts (siehe Beispiele in 'main').
    public String toString() {
        //TODO: Methode implementieren
        String s = "";
        if(this.root != null){
            BinaryTree p = root;
            while(p != null){
                s = p.number.toString() +s;
                p = p.right;
            }
        }
        return s;
    }
    
    //TODO: Verkettete Liste implementieren (entweder in BigNumber oder außerhalb).
    //TODO: Diese verkettete Liste soll von BigNumber zur Speicherung von Zifferngruppen benutzt werden.
    //TODO: (Ein Knoten soll 8 Ziffern speichern.)
    }
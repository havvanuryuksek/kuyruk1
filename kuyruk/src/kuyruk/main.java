package kuyruk;

class Eleman<T> {

    T icerik;
    Eleman ileri;
    Eleman geri;

    Eleman(T icerik) {
        this.icerik = icerik;
        ileri = null;
        geri = null;
    }

}

class kuyruk<S> {

    Eleman<S> bas;
    Eleman<S> son;

    kuyruk() {
        bas = null;
        son = null;
    }

    void ekle(S icerik) {
        Eleman<S> tmp = new Eleman(icerik);
        if (bas == null) {
            bas = tmp;
            son = tmp;
        } else {
            son.ileri = tmp;
            tmp.geri = son;
            son = tmp;
        }
    }

    Eleman sil() {
        Eleman tmp = bas;
        if (bas == null) {
            return null;
        } else {
            bas = bas.ileri;

        }
        return tmp;
    }

    void bkSırala() {
        Eleman<S> tmp1, tmp2;
        S icerik;
        tmp1 = bas;
        while (tmp1 != null) {
            tmp2 = tmp1.ileri;
            while (tmp2 != null) {
                if ((int) (tmp1.icerik) < (int) (tmp2.icerik)) {
                    icerik = tmp1.icerik;
                    tmp1.icerik = tmp2.icerik;
                    tmp2.icerik = icerik;
                }
                tmp2 = tmp2.ileri;

            }
            tmp1 = tmp1.ileri;
        }

    }
    

    void print() {
        Eleman<S> tmp;
        tmp = bas;
        while (tmp != null) {
            System.out.print(tmp.icerik + "-> ");
            tmp = tmp.ileri;
        }
        System.out.println("");
    }
}

public class main {

    public static void main(String[] args) {
        kuyruk<Integer> k = new kuyruk();
        k.ekle(13);
        k.ekle(11);
        k.ekle(22);
        k.ekle(17);
        k.ekle(3);
        k.ekle(2);
        k.print();
        System.out.println("-----------");
        k.bkSırala();
        k.print();
       
    }

}

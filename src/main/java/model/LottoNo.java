package model;

import java.util.Objects;

public class LottoNo {
    private int number;

    public LottoNo(int number) {
        if (number < 1 || number > 45) throw new RuntimeException();
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}


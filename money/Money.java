abstract class Money {
    protected int amount;
    protected String currency;
    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
            && getClass().equals(money.getClass());
    }
    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }
    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }
    abstract Money times(int multiplier);
    String currency() {
        return currency;
    };

}

class Dollar extends Money {
    Dollar (int amount, String currency) {
        super(amount, currency);
    }
    Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }
}

class Franc extends Money {
    Franc (int amount, String currency) {
        super(amount, currency);
    }
    Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }
}

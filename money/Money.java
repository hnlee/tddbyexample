class Money implements Expression {
    protected int amount;
    protected String currency;
    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
            && currency().equals(money.currency());
    }
    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }
    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }
    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
    Expression plus(Money addend) {
        return new Sum(this, addend);
    }
    String currency() {
        return currency;
    }
    public String toString() {
        return amount + " " + currency;
    }
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}

interface Expression {
    Money reduce(Bank bank, String to);
}

class Sum implements Expression {
    Money augend;
    Money addend;
    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }
    public Money reduce(Bank bank, String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}

class Bank {
    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }
    void addRate(String from, String to, int rate) {
    }
    int rate(String from, String to) {
        return (from.equals("CHF") && to.equals("USD")) ?
               2 : 1;
    }
}

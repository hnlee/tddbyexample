import java.util.Hashtable;

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
    Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
    public Expression plus(Expression addend) {
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
    Expression plus(Expression addend);
}

class Sum implements Expression {
    Expression augend;
    Expression addend;
    Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }
    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount 
                   + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}

class Bank {
    private Hashtable<Pair, Integer> rates = new Hashtable<Pair, Integer>();
    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }
    void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), new Integer(rate));
    }
    int rate(String from, String to) {
        if (from.equals(to)) return 1;
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }
}

class Pair {
    private String from;
    private String to;
    Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }
    public boolean equals(Object object) {
        Pair pair = (Pair) object;
        return from.equals(pair.from) && to.equals(pair.to);
    }
    public int hashCode() {
        return 0;
    }
}

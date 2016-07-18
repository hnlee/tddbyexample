class Dollar {
    Dollar (int amount) {
        this.amount = amount;
    }
    int amount;
    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }
}

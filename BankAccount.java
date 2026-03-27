
    public class BankAccount {
        private int balance;

        public void deposit(int amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public int getBalance() {
            return balance;
        }
    }



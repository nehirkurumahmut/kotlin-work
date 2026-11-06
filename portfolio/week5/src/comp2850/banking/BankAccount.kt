// COMP2850 Portfolio: Week 5
// BankAccount class
// Student Name: Nehir Kurumahmut
// Student ID:201984143

package comp2850.banking

abstract class BankAccount(val holder: String) {
    init {
        require(holder.isNotBlank()) { "Account holder must not be blank" }
    }

    var balance = 0
        protected set(value) {
            field = value
        }

    fun deposit(amount: Int) {
        require(amount > 0) { "Deposit amount must be greater than 0" }
        balance += amount
    }

    abstract fun withdraw(amount: Int)
}
// StudentAccount should provide a custom setter for overdraft, which throws
// IllegalArgumentException on any attempt to set an overdraft outside the range 0 to 100.
// The default value of overdraft should be 0.
class StudentAccount(holder: String) : BankAccount(holder) {
    var overdraft: Int = 0
        set(value) {
            if(value !in 0..100) {
                throw IllegalArgumentException("Overdraft must be between 0 and 100")
        }   
            field = value 
        }
        // withdraw() should throw IllegalArgumentException if the specified amount is not greater
// than 0, with the exact message
    override fun withdraw(amount: Int) {
        if (amount <= 0){
            throw IllegalArgumentException("Withdrawal amount must be greater than 0") 
    }   if (balance - amount < -overdraft) {
            throw IllegalArgumentException("Insufficient funds for withdrawal")
    }   balance -= amount
        }
    // withdrawalsAllowed() should return true if further withdrawals are possible, false otherwise. = boolean
    fun withdrawalsAllowed(): Boolean {
        return balance > -overdraft
    }
    // toString() should return a string representation that includes holder, balance and overdraft.
It should have this format:
    // Account for Sarah, balance = 120 (overdraft = 50)
    override fun toString(): String {
        return "Account for $holder, balance = $balance (overdraft = $overdraft)"
    } }
                

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

class StudentAccount(holder: String) : BankAccount(holder) {
    var overdraft: Int = 0
        set(value) {
            if (value !in 0..100) {
                throw IllegalArgumentException("Overdraft must be between 0 and 100")
        }   
            field = value 
        }
        
    override fun withdraw(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("Withdrawal amount must be greater than 0") 
    }   
        if (balance - amount < -overdraft) {
            throw IllegalArgumentException("Insufficient funds for withdrawal")
    }   
        balance -= amount
     }
    // withdrawalsAllowed() should return true if further withdrawals are possible, false otherwise. = boolean
    fun withdrawalsAllowed(): Boolean {
        return balance > -overdraft
    }
    override fun toString(): String {
        return "Account for $holder, balance = $balance (overdraft = $overdraft)"
    } }
                

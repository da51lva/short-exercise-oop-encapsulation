# Lab Answers

---

## Q1

The `Main` class is trying to perform the same operations on a `DodgyBankAccount` instance and a `SecureBankAccount`
instance. The console is logging what is happening and outputting the result of the operations i.e. the change in the
class variable `accountBalance`.

---

## Q2

`DodgyBankAccount` is exposing class variables and methods that should be kept private, i.e. only accessed within the
class itself. Therefore, other classes can access these variables and methods and misuse them (as the `Main` class does).

---

## Q3

`SecureBankAccount` makes private variables and methods that do not need to be accessed outside the class.
`DodgyBankAccount` also has a method called `getAccountBalance` which prints the account balance to stdout. This
is inappropriately named as it suggests it will return the account balance not print it. `SecureAccountBalance`
corrects this and change the method name to `displayAccountBalance`.

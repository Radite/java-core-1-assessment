interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
  }
  
    class AccountServiceImpl implements AccountService{
        private Account[] accounts;

        public AccountServiceImpl(Account[] accounts){
            this.accounts = accounts;
        }

        @Override  
        public Account findAccountByOwnerId(long id){
            for (Account account: accounts){
                if (account.getOwner().getId() == id){
                    return account;
                }
            }
            return null;
        }

        @Override
        public long countAccountsWithBalanceGreaterThan(long balance){
            long count = 0;
            for (Account account: accounts){
                if (account.getBalance() > balance){
                    count++;
                }
            }
            return count;
        }
    }  
  class Account {
  
    private long id;
    private long balance;
    private User owner;
  
    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }
  
    public long getId() {
        return id;
    }
  
    public long getBalance() {
        return balance;
    }
  
    public User getOwner() {
        return owner;
    }
  }
  
  class User {
  
    private long id;
    private String firstName;
    private String lastName;
  
    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
  
    public long getId() {
        return id;
    }
  
    public String getFirstName() {
        return firstName;
    }
  
    public String getLastName() {
        return lastName;
    }
  }
  
  public class Main {

    public static void main(String[] args) {
        // Creating users
        User user1 = new User(1L, "John", "Doe");
        User user2 = new User(2L, "Jane", "Smith");
        User user3 = new User(3L, "Michael", "Johnson");

        // Creating accounts
        Account[] accounts = {
            new Account(1L, 1000L, user1),
            new Account(2L, 2000L, user1),
            new Account(3L, 1500L, user2),
            new Account(4L, 3000L, user2),
            new Account(5L, 2500L, user3)
        };

        // Creating service instance
        AccountService service = new AccountServiceImpl(accounts);

        // Test findAccountByOwnerId with existing owner id
        long ownerIdToFind = 3L;
        Account foundAccount = service.findAccountByOwnerId(ownerIdToFind);
        if (foundAccount != null) {
            System.out.println("Found account for owner id " + ownerIdToFind + ": " + foundAccount.getId());
        } else {
            System.out.println("Account not found for owner id " + ownerIdToFind);
        }

        // Test findAccountByOwnerId with non-existing owner id
        long nonExistingOwnerId = 6L;
        foundAccount = service.findAccountByOwnerId(nonExistingOwnerId);
        if (foundAccount != null) {
            System.out.println("Found account for owner id " + nonExistingOwnerId + ": " + foundAccount.getId());
        } else {
            System.out.println("Account not found for owner id " + nonExistingOwnerId);
        }

        // Test countAccountsWithBalanceGreaterThan
        long balanceToCompare = 2000L;
        long count = service.countAccountsWithBalanceGreaterThan(balanceToCompare);
        System.out.println("Number of accounts with balance greater than " + balanceToCompare + ": " + count);

        // Test countAccountsWithBalanceGreaterThan with zero balance
        long zeroBalanceToCompare = 0L;
        long countZeroBalance = service.countAccountsWithBalanceGreaterThan(zeroBalanceToCompare);
        System.out.println("Number of accounts with balance greater than " + zeroBalanceToCompare + ": " + countZeroBalance);
    }
}

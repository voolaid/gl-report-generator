import java.math.BigDecimal;

public class GLEntry {

    public enum AccountType { Asset, Liability, Revenue, Expense, Equity }
    public enum BalanceType { Debit, Credit }

    // GL account information
    private int account; // ex. 6210
    private String accountName; // ex. Basic salary (expense)
    private AccountType accountType;
    private BalanceType balanceType;

    // For grouping
    private String division;
    private String department;
    private String costCenter;

    // Entry balances
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;

    /**
     * Has to return absolute (always positive) value
     *
     * @return calculated balance
     */
    public BigDecimal getDisplayBalance() {

        if (balanceType == BalanceType.Debit) {
            return debitAmount.subtract(creditAmount);
        }

        if (balanceType == BalanceType.Credit) {
            return creditAmount.subtract(debitAmount);
        }

        return BigDecimal.ZERO;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }
}

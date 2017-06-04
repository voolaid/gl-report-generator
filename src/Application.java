import java.math.BigDecimal;
import java.sql.Date;

public class Application {

    public static void main(String[] args) {

        /**
         * Report definition
         */
        GLReport report = new GLReport();
        report.setReportTitle("Gross to Net (G2N)");
        report.setBeginDate(Date.valueOf("2017-05-01"));
        report.setEndDate(Date.valueOf("2017-05-31"));
        report.setCreateDate(Date.valueOf("2017-06-01"));
        report.addColumn("Department / Division", "$header"); // cost center, division or department
        report.addColumn("ENTITLEMENTS", "6210:6214");
        report.addColumn("GROSS", "SUM(6210:6214)");
        report.addColumn("DEDUCTIONS", "1210:1211");
        report.addColumn("TOTAL DEDUCTIONS", "SUM(1210:1211)");
        report.addColumn("NET", "SUM(6210:6214 + 1210:1211)");

        /**
         * Report data
         */
        GLEntry entry1DebitAccount = new GLEntry();
        entry1DebitAccount.setAccount(6210);
        entry1DebitAccount.setAccountName("Basic salary");
        entry1DebitAccount.setAccountType(GLEntry.AccountType.Expense);
        entry1DebitAccount.setBalanceType(GLEntry.BalanceType.Debit);
        entry1DebitAccount.setDivision("Division 1");
        entry1DebitAccount.setDepartment("IT");
        entry1DebitAccount.setCostCenter("CC0001");
        entry1DebitAccount.setDebitAmount(BigDecimal.valueOf(12000.00));
        entry1DebitAccount.setCreditAmount(BigDecimal.ZERO);

        GLEntry entry1CreditAccount = new GLEntry();
        entry1CreditAccount.setAccount(2610);
        entry1CreditAccount.setAccountName("Employee payables");
        entry1CreditAccount.setAccountType(GLEntry.AccountType.Liability);
        entry1CreditAccount.setBalanceType(GLEntry.BalanceType.Credit);
        entry1CreditAccount.setDivision("Division 1");
        entry1CreditAccount.setDepartment("IT");
        entry1CreditAccount.setCostCenter("CC0001");
        entry1CreditAccount.setDebitAmount(BigDecimal.ZERO);
        entry1CreditAccount.setCreditAmount(BigDecimal.valueOf(12000.00));
    }
}

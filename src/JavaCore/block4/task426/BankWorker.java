package JavaCore.block4.task426;

public class BankWorker {

    public boolean checkClientForCredit(BankClient bankClient){
        if (bankClient.history>0)        return true;
        else return false;
    }
}

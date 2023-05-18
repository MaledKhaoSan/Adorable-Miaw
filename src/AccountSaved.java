
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AccountSaved{
    private Account account;
    private File data;

    public AccountSaved() {
        data = new File("gameSaved.dat");
        try{
            data.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        account = load();
    }

    public Account load() {
        try (FileInputStream stream = new FileInputStream(data);
             ObjectInputStream inputStream = new ObjectInputStream(stream)) {
            account = (Account) inputStream.readObject();
        } catch (EOFException e) {
            // ignore, there are no more objects in the stream
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (account == null) {
            account = new Account();
        } else {
            account.setBalance(account.getBalance()); // set balance from loaded object
        }
        return account;
    }

    public void save() {
        FileOutputStream stream = null;
        ObjectOutputStream outputStream = null;
        try {
            stream = new FileOutputStream(data);
            outputStream = new ObjectOutputStream(stream);
            outputStream.writeObject(account);
        } catch (IOException er) {
            er.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}

